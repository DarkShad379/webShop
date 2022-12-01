package com.dark.webshop.service;

import com.dark.webshop.service.model.OrderedFoodModel;

public interface OrderService {

    public void addOrderedFoodToUserCard(String username, OrderedFoodModel orderedFoodModel);
}
