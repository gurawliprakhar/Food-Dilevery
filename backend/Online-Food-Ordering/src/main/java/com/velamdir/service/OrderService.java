package com.velamdir.service;

import com.velamdir.model.Order;
import com.velamdir.model.User;
import com.velamdir.request.OrderRequest;

import java.util.List;

public interface OrderService {
    public Order createOrder (OrderRequest order, User user) throws Exception;
    public Order updateOrder (Long orderId, String orderStatus) throws Exception;
    public void cancelOrder (Long overId) throws Exception;
    public List <Order> getUserOrder(Long userId) throws Exception;
    public List <Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception;
    public Order findOrderById (Long orderId) throws Exception;

}
