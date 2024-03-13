package dev.InnocentUdo.service.impl;

import dev.InnocentUdo.DTO.request.AddCartItemRequest;
import dev.InnocentUdo.model.Cart;
import dev.InnocentUdo.model.CartItem;
import dev.InnocentUdo.model.Food;
import dev.InnocentUdo.model.User;
import dev.InnocentUdo.repository.CartItemRepository;
import dev.InnocentUdo.repository.CartRepository;
import dev.InnocentUdo.service.CartService;
import dev.InnocentUdo.service.FoodService;
import dev.InnocentUdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;
    private UserService userService;
    private CartItemRepository cartItemRepository;
    private FoodService foodService;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserService userService,
                           CartItemRepository cartItemRepository, FoodService foodService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.cartItemRepository = cartItemRepository;
        this.foodService = foodService;
    }

    @Override
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.findFoodById(req.getFoodId());
        Cart cart = cartRepository.findByCustomerId(user.getId());

        for(CartItem cartItem : cart.getItem()){
            if(cartItem.getFood().equals(food)){
                int newQuantity = cartItem.getQuantity() + req.getQuantity();
                return updateCartItemQuantity(cartItem.getId(), newQuantity);
            }
        }
        CartItem newCartItem = new CartItem();
        newCartItem.setFood(food);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setIngredients(req.getIngredient());
        newCartItem.setTotalPrice(req.getQuantity() * food.getPrice());

        CartItem savedCartItem = cartItemRepository.save(newCartItem);
        cart.getItem().add(savedCartItem);
        return savedCartItem;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart item not found");
        }
        CartItem item = cartItemOptional.get();
        item.setQuantity(quantity);

        // 5 * 100 = 500
        item.setTotalPrice(item.getFood().getPrice() * quantity);
        return cartItemRepository.save(item);
    }

    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = cartRepository.findByCustomerId(user.getId());

        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart item not found");
        }
        CartItem item = cartItemOptional.get();
        cart.getItem().remove(item);
        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        Long total = 0L;
        for(CartItem cartItem : cart.getItem()){
            total += cartItem.getFood().getPrice() * cartItem.getQuantity();
        }
        return total;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isEmpty()){
            throw new Exception("Cart not found with id " + id);
        }
        return optionalCart.get();
    }

    @Override
    public Cart findCartByUserId(String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        return cartRepository.findByCustomerId(user.getId());
    }

    @Override
    public Cart clearCart(String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = findCartByUserId(jwt);
        cart.getItem().clear();
        return cartRepository.save(cart);
    }
}
