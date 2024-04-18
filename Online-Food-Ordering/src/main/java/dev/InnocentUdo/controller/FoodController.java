package dev.InnocentUdo.controller;

import dev.InnocentUdo.model.Food;
import dev.InnocentUdo.model.User;
import dev.InnocentUdo.service.FoodService;
import dev.InnocentUdo.service.RestaurantService;
import dev.InnocentUdo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    private FoodService foodService;
    private UserService userService;
    private RestaurantService restaurantService;

    public FoodController(FoodService foodService, UserService userService, RestaurantService restaurantService) {
        this.foodService = foodService;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                                @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam(required = false) boolean vegetarian,
            @RequestParam(required = false) boolean seasonal,
            @RequestParam(required = false) boolean nonVegetarian,
            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantId,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantsFood(restaurantId, vegetarian, nonVegetarian, seasonal, food_category);

        return new ResponseEntity<>(foods, HttpStatus.OK);
    }
}
