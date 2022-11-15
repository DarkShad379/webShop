package com.dark.webshop.service;

import com.dark.webshop.service.model.OrderModel;
import com.dark.webshop.service.model.UserModel;

import java.util.List;

public interface OrderService {
    void updateOrder(OrderModel orderModel);

    void deleteOrder(OrderModel orderModel);

    List<OrderModel> getOrdersForUser(UserModel userModel);

    List<OrderModel> getOrdersForUserPaged(UserModel userModel, Integer page, Integer size, String sort);

    List<OrderModel> getAllOrders();

    List<OrderModel> getAllOrdersPaged(Integer page, Integer size, String sort);
}
