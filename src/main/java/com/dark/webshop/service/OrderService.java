package com.dark.webshop.service;

import com.dark.webshop.controller.dto.OrderDetailsReq;
import com.dark.webshop.service.model.OrderModel;
import com.dark.webshop.service.model.OrderedFoodModel;

import java.util.List;

public interface OrderService {
    int getOrderCost(int id);

    void confirmOrder(int id);

    OrderModel findOrderById(int id);

    void convertUserCartToOrder(OrderDetailsReq orderDetailsReq, String username);

    List<OrderModel> getAllOrders();

    void addOrderedFoodToUserCart(String username, OrderedFoodModel orderedFoodModel);

    Integer getUserCartSize(String username);

    Integer getUserCartPrice(String username);

    List<OrderedFoodModel> getUserCart(String username);

    void removeOrderedFood(String username, Integer orderedFoodId);

    void removeOrderById(int id);
}
