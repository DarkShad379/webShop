package com.dark.webshop.service;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.database.entity.user.User;

import java.util.List;

public interface OrderService {
    void updateOrder(Order order);
    List<Order> getOrdersForUser(User user);
    List<Order> getOrdersForUserPaged(User user,Integer page, Integer size, String sort);
    List<Order> getAllOrders();
    List<Order> getAllOrdersPaged(Integer page, Integer size, String sort);
}
