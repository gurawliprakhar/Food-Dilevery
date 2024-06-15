package com.velamdir.service;

import com.velamdir.model.Address;
import com.velamdir.model.Order;
import com.velamdir.model.Restaurant;
import com.velamdir.model.User;
import com.velamdir.repository.*;
import com.velamdir.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantService restaurantService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {
        Address shippAddress = order.getDeliveryAddress();
        Address savedAddress = addressRepository.save(shippAddress);

        if(!user.getAddresses().contains(savedAddress)) {
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }

        Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());
        Order createOrder = new Order();
        createOrder.setCustomer(user);
        createOrder.setCreatedAt(LocalDateTime.now());

        return null;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatus) throws Exception {
        return null;
    }

    @Override
    public void cancelOrder(Long overId) throws Exception {

    }

    @Override
    public List<Order> getUserOrder(Long userId) throws Exception {
        return List.of();
    }

    @Override
    public List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception {
        return List.of();
    }
}
