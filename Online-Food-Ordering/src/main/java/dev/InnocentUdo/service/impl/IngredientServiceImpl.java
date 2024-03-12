package dev.InnocentUdo.service.impl;

import dev.InnocentUdo.model.IngredientCategory;
import dev.InnocentUdo.model.IngredientsItems;
import dev.InnocentUdo.model.Restaurant;
import dev.InnocentUdo.repository.IngredientCategoryRepository;
import dev.InnocentUdo.repository.IngredientItemRepository;
import dev.InnocentUdo.service.IngredientsService;
import dev.InnocentUdo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientsService {
    private IngredientItemRepository ingredientItemRepository;
    private IngredientCategoryRepository ingredientCategoryRepository;
    private RestaurantService restaurantService;

    @Autowired
    public IngredientServiceImpl(IngredientItemRepository ingredientItemRepository,
                                 IngredientCategoryRepository ingredientCategoryRepository, RestaurantService restaurantService) {
        this.ingredientItemRepository = ingredientItemRepository;
        this.ingredientCategoryRepository = ingredientCategoryRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);

        IngredientCategory category = new IngredientCategory();
        category.setRestaurant(restaurant);
        category.setName(name);

        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngredientCategory> opt = ingredientCategoryRepository.findById(id);

        if(opt.isEmpty()){
            throw new Exception("Ingredient category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngredientsItems createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category = findIngredientCategoryById(categoryId);

        IngredientsItems item = new IngredientsItems();
        item.setName(ingredientName);
        item.setRestaurant(restaurant);
        item.setCategory(category);

        IngredientsItems ingredient = ingredientItemRepository.save(item);
        category.getIngredients().add(ingredient);
        return ingredient;
    }

    @Override
    public List<IngredientsItems> findRestaurantsIngredients(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItems updateStock(Long id) throws Exception {
        Optional<IngredientsItems> optionalIngredientsItems = ingredientItemRepository.findById(id);
        if(optionalIngredientsItems.isEmpty()){
            throw new Exception("Ingredient not found");
        }
        IngredientsItems ingredientsItems = optionalIngredientsItems.get();
        ingredientsItems.setInStoke(!ingredientsItems.isInStoke());
        return ingredientItemRepository.save(ingredientsItems);
    }
}
