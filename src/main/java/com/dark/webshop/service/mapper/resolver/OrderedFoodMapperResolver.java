package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.database.repository.OrderedFoodRepository;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderedFoodMapperResolver {
    OrderedFoodRepository orderRepository;

    public OrderedFoodMapperResolver(OrderedFoodRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ObjectFactory
    public OrderedFood resolve(OrderedFoodModel orderedFoodModel, @TargetType Class<OrderedFood> type) {
        if (orderedFoodModel.getId() != null) {
            Optional<OrderedFood> orderOptional = orderRepository.findById(orderedFoodModel.getId());
            return orderOptional.orElseGet(OrderedFood::new);
        } else return new OrderedFood();
    }
}
