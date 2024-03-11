package dev.InnocentUdo.service;

import dev.InnocentUdo.DTO.request.CreateFoodRequest;
import dev.InnocentUdo.model.Category;
import dev.InnocentUdo.model.Food;
import dev.InnocentUdo.model.Restaurant;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegetarian,
                                         boolean isNonVegetarian, boolean isSeasonal,
                                         String foodCategory);
    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food updateAvailabilityStatus(Long foodId) throws Exception;
}
