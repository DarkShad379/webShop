package com.dark.webshop.service.interfaces;

import com.dark.webshop.entity.food.Order;
import com.dark.webshop.entity.user.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersForUser(User user);
    void addNewOrder(Order order);
}
