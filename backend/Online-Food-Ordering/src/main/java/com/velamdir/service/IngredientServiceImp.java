package com.velamdir.service;

import com.velamdir.model.IngrediantItem;
import com.velamdir.model.IngredientCategory;
import com.velamdir.model.Restaurant;
import com.velamdir.repository.IngredientCategoryRepository;
import com.velamdir.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientService {

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
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
        Optional<IngredientCategory> opt = ingredientCategoryRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Ingredient category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurant(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngrediantItem createIngredientItem(Long restaurantId, String ingredient, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category = findIngredientCategoryById(categoryId);
        IngrediantItem item = new IngrediantItem();
        item.setName(ingredient);
        item.setRestaurant(restaurant);
        item.setCategory(category);

        return ingredientItemRepository.save(item);
    }

    @Override
    public List<IngrediantItem> findRestaurantIngredients(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngrediantItem updateStock(Long id) throws Exception {
        Optional<IngrediantItem> opt = ingredientItemRepository.findById(id); // Corrected spelling from IngrediantItem to IngredientItem
        if (opt.isEmpty()) {
            throw new Exception("Ingredient item not found");
        }
        IngrediantItem item = opt.get();
        return ingredientItemRepository.save(item);
    }
}
