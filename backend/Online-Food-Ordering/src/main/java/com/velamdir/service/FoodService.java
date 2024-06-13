package com.velamdir.service;


import com.velamdir.model.Category;
import com.velamdir.model.Food;
import com.velamdir.model.Restaurant;
import com.velamdir.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantsFood (Long restaurantId,
                                          boolean isVegiterian,
                                          boolean isNonveg,
                                          boolean isSeasonal,
                                          String foodCategory
    );

    public List<Food> searchFood (String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food updateAvailibiltyStatus(Long FoodId) throws Exception;


}
