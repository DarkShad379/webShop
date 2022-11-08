package com.dark.webshop.service;

import com.dark.webshop.entity.food.Order;
import com.dark.webshop.entity.user.User;
import com.dark.webshop.repository.OrderRepository;
import com.dark.webshop.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getOrdersForUser(User user) {
        return orderRepository.findOrdersByUserId(user.getId());
    }

    @Override
    public void addNewOrder(Order order) {
        orderRepository.save(order);
    }


}
