package com.velamdir.service;

import com.velamdir.model.IngrediantItem;
import com.velamdir.model.IngredientCategory;
import com.velamdir.model.Restaurant;
import com.velamdir.repository.IngredientCategoryRepository;
import com.velamdir.repository.IngredientItemRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientsService{
    @Autowired
    private IngredientItemRepository ingredientItemRepository;
    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    private RestaurantService restaurantService;

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
        Optional<IngredientCategory> opt = ingredientCategoryRepository.findById();
        return null;
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurant(Long id) throws Exception {
        return List.of();
    }

    @Override
    public IngrediantItem createIngredientItem(Long restaurantId, String ingredient, Long categoryId) throws Exception {
        return null;
    }

    @Override
    public List<IngrediantItem> findRestaurantIngredients(Long restaurantId) {
        return List.of();
    }

    @Override
    public IngrediantItem updateStock(Long id) throws Exception {
        return null;
    }
}
