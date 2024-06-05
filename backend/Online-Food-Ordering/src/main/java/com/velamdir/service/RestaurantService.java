package com.velamdir.service;

import com.velamdir.DTO.RestaurantDto;
import com.velamdir.model.Restaurant;
import com.velamdir.model.User;
import com.velamdir.request.CreatedRestarantRequest;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreatedRestarantRequest req, User user);
    public Restaurant updateRestaurant(Long restaurantId, CreatedRestarantRequest updatedRestaurant) throws Exception;
    public void deleteRestaurant(Long restaurantId) throws Exception;
    public List <Restaurant> getAllRestaurant();
    public List <Restaurant> searchRestaurant(String keyword);
    public Restaurant findRestaurantById(Long id) throws Exception;
    public Restaurant getRestaurantByUserID(Long userId) throws Exception;
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception;
    public Restaurant updateRestaurantStatus(Long id)throws Exception;

}
