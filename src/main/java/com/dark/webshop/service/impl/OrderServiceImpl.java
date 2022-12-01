package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.database.repository.OrderRepository;
import com.dark.webshop.database.repository.OrderedFoodRepository;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.UserService;
import com.dark.webshop.service.mapper.OrderServiceMapper;
import com.dark.webshop.service.mapper.OrderedFoodServiceMapper;
import com.dark.webshop.service.model.OrderedFoodModel;
import com.dark.webshop.service.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderServiceImpl implements OrderService {
    UserService userService;
    OrderRepository orderRepository;
    OrderedFoodRepository orderedFoodRepository;
    OrderedFoodServiceMapper orderedFoodServiceMapper;
    OrderServiceMapper orderServiceMapper;

    public OrderServiceImpl(UserService userService, OrderRepository orderRepository,
                            OrderedFoodRepository orderedFoodRepository,
                            OrderedFoodServiceMapper orderedFoodServiceMapper,
                            OrderServiceMapper orderServiceMapper) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderedFoodRepository = orderedFoodRepository;
        this.orderedFoodServiceMapper = orderedFoodServiceMapper;
        this.orderServiceMapper = orderServiceMapper;
    }

    @Override
    public void addOrderedFoodToUserCard(String username, OrderedFoodModel orderedFoodModel) {
        AtomicReference<Integer> cost = new AtomicReference<>(0);
        cost.updateAndGet(v -> v + orderedFoodModel.getFood().getCost());
        orderedFoodModel.getAdditionalList().forEach(it -> cost.updateAndGet(v -> v + it.getCost()));
        orderedFoodModel.setTotalFoodCost(cost.get());
        UserModel userModel = userService.findUserByUsername(username);
        OrderedFood orderedFood = orderedFoodRepository.save(orderedFoodServiceMapper.modelToEntity(orderedFoodModel));
        userModel.getOrderedFoodCard().add(orderedFoodServiceMapper.entityToModel(orderedFood));
        userService.updateUserAccount(userModel);
    }
}
