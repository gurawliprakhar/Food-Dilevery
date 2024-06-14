package com.velamdir.service;

import com.velamdir.model.IngrediantItem;
import com.velamdir.model.IngredientCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IngredientService {
    IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
    IngredientCategory findIngredientCategoryById(Long id) throws Exception;
    List<IngredientCategory> findIngredientCategoryByRestaurant(Long id) throws Exception;
    IngrediantItem createIngredientItem(Long restaurantId, String ingredient, Long categoryId) throws Exception; // Removed the redundant ingrediantName parameter
    List<IngrediantItem> findRestaurantIngredients(Long restaurantId); // Corrected spelling from IngrediantItem to IngredientItem
    IngrediantItem updateStock(Long id) throws Exception;
}
