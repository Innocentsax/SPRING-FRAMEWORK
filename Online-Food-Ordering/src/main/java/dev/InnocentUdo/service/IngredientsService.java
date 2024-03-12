package dev.InnocentUdo.service;

import dev.InnocentUdo.model.IngredientCategory;
import dev.InnocentUdo.model.IngredientsItems;

import java.util.List;

public interface IngredientsService {
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception;
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;
    public IngredientsItems createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;
    public List<IngredientsItems> findRestaurantsIngredients(Long restaurantId);
    public IngredientsItems updateStock(Long id) throws Exception;
}
