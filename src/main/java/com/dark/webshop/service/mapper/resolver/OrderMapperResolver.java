package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.database.repository.OrderRepository;
import com.dark.webshop.service.model.OrderModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperResolver {

    OrderRepository orderRepository;

    public OrderMapperResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ObjectFactory
    public Order resolve(OrderModel orderModel, @TargetType Class<Order> type) {
        return orderModel != null && orderModel.getId() != null && orderRepository.findById(orderModel.getId()).isPresent()
                ? orderRepository.findById(orderModel.getId()).get() : new Order();
    }
}
