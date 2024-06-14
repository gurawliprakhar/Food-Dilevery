package com.velamdir.controller;

import com.velamdir.model.IngrediantItem;
import com.velamdir.model.IngredientCategory;
import com.velamdir.request.IngredientCategoryRequest;
import com.velamdir.request.IngredientRequest;
import com.velamdir.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(
            @RequestBody IngredientCategoryRequest req
    ) throws Exception {
        IngredientCategory category = ingredientService.createIngredientCategory(req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<IngrediantItem> createIngredientItem(
            @RequestBody IngredientCategoryRequest req
    ) throws Exception {
        IngrediantItem item = ingredientService.createIngredientItem(req.getRestaurantId(), req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stocks")
    public ResponseEntity<IngrediantItem> updateIngredientStock (
            @PathVariable Long id
            ) throws Exception {
        IngrediantItem item = ingredientService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngrediantItem>> getRestaurantIngredient (
            @PathVariable Long id
    ) throws Exception {
       List<IngrediantItem> item = ingredientService.findRestaurantIngredients(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory (
            @PathVariable Long id
    ) throws Exception {
        List<IngredientCategory> item = ingredientService.findIngredientCategoryByRestaurant(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
