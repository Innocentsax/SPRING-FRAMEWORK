package dev.InnocentUdo.controller;

import dev.InnocentUdo.DTO.request.CreateFoodRequest;
import dev.InnocentUdo.DTO.response.MessageResponse;
import dev.InnocentUdo.model.Food;
import dev.InnocentUdo.model.Restaurant;
import dev.InnocentUdo.model.User;
import dev.InnocentUdo.service.FoodService;
import dev.InnocentUdo.service.RestaurantService;
import dev.InnocentUdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
    private FoodService foodService;
    private UserService userService;
    private RestaurantService restaurantService;

    @Autowired
    public AdminFoodController(FoodService foodService, UserService userService, RestaurantService restaurantService) {
        this.foodService = foodService;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse msg = new MessageResponse();
        msg.setMessage("Food deleted successfully");

        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvailabilityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
