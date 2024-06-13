package com.velamdir.service;

import com.velamdir.model.IngrediantItem;
import com.velamdir.model.IngredientCategory;

import java.util.List;

public interface IngredientsService {
    public IngredientCategory createIngredientCategory (String name, Long restaurantId ) throws Exception;
    public IngredientCategory findIngredientCategoryById (Long id) throws Exception;
    public List <IngredientCategory> findIngredientCategoryByRestaurant (Long id) throws Exception;
    public IngrediantItem createIngredientItem (Long restaurantId, String ingredient, Long categoryId) throws Exception;
    public List <IngrediantItem> findRestaurantIngredients (Long restaurantId);
    public IngrediantItem updateStock (Long id) throws Exception;
    
}
