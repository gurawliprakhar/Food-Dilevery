package com.velamdir.service;

import com.velamdir.DTO.RestaurantDto;
import com.velamdir.model.Address;
import com.velamdir.model.Restaurant;
import com.velamdir.model.User;
import com.velamdir.repository.AddressRepository;
import com.velamdir.repository.RestaurantRepository;
import com.velamdir.request.CreatedRestarantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    @Override
    public Restaurant createRestaurant(CreatedRestarantRequest req, User user) {
        Address address = addressRepository.save(req.getAddress())
        address.set
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreatedRestarantRequest updatedRestaurant) throws Exception {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return List.of();
    }

    @Override
    public List<Restaurant> searchRestaurant() {
        return List.of();
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        return null;
    }

    @Override
    public Restaurant getRestaurantByUserID(Long userId) throws Exception {
        return null;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
        return null;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        return null;
    }
}
