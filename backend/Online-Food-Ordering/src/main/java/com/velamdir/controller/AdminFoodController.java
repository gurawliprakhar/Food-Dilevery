package com.velamdir.controller;

import com.velamdir.model.Food;
import com.velamdir.model.Restaurant;
import com.velamdir.model.User;
import com.velamdir.request.CreateFoodRequest;
import com.velamdir.response.MessageResponse;
import com.velamdir.service.FoodService;
import com.velamdir.service.RestaurantService;
import com.velamdir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(), restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);
        MessageResponse response = new MessageResponse();
        response.setMessage("Food deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Food> updateFoodAvailibility(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvailibiltyStatus(id);

        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}
