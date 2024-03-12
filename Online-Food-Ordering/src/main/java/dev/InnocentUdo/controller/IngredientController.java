package dev.InnocentUdo.controller;

import dev.InnocentUdo.DTO.request.IngredientCategoryRequest;
import dev.InnocentUdo.DTO.request.IngredientRequest;
import dev.InnocentUdo.model.IngredientCategory;
import dev.InnocentUdo.model.IngredientsItems;
import dev.InnocentUdo.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {
    @Autowired
    private IngredientsService ingredientsService;
    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(
            @RequestBody IngredientCategoryRequest req) throws Exception {
        IngredientCategory item = ingredientsService.createIngredientCategory(
                req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @PostMapping()
    public ResponseEntity<IngredientsItems> createIngredientItem(
            @RequestBody IngredientRequest req) throws Exception{
        IngredientsItems item = ingredientsService.createIngredientItem(req.getRestaurantId(),
                req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @PutMapping("/{id}/stoke")
    public ResponseEntity<IngredientsItems> updateIngredientStock(
            @PathVariable Long id) throws Exception{
        IngredientsItems item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItems>> getRestaurantIngredient(
            @PathVariable Long id) throws Exception{
        List<IngredientsItems> items = ingredientsService.findRestaurantsIngredients(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(
            @PathVariable Long id) throws Exception{
        List<IngredientCategory> items = ingredientsService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
