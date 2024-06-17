package com.velamdir.controller;

import com.velamdir.model.CartItem;
import com.velamdir.model.Order;
import com.velamdir.model.User;
import com.velamdir.request.AddCartItemRequest;
import com.velamdir.request.OrderRequest;
import com.velamdir.service.OrderService;
import com.velamdir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req,user);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> order = orderService.getUserOrder(user.getId());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}