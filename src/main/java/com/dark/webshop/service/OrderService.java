package com.dark.webshop.service;

import com.dark.webshop.service.model.OrderedFoodModel;

import java.util.List;

public interface OrderService {

    void addOrderedFoodToUserCart(String username, OrderedFoodModel orderedFoodModel);

    Integer getUserCartSize(String username);

    Integer getUserCartPrice(String username);

    List<OrderedFoodModel> getUserCart(String username);
}
