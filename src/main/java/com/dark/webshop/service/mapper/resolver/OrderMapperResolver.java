package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.database.repository.OrderRepository;
import com.dark.webshop.service.model.OrderModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderMapperResolver {

    OrderRepository orderRepository;

    public OrderMapperResolver(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ObjectFactory
    public Order resolve(OrderModel orderModel, @TargetType Class<Order> type) {
        Optional<Order> orderOptional = orderRepository.findById(orderModel.getId());
        return orderOptional.orElseGet(Order::new);
    }
}
