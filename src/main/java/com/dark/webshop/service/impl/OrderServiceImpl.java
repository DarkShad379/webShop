package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.database.repository.OrderRepository;
import com.dark.webshop.database.repository.OrderedFoodRepository;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.UserService;
import com.dark.webshop.service.mapper.OrderServiceMapper;
import com.dark.webshop.service.mapper.OrderedFoodServiceMapper;
import com.dark.webshop.service.model.OrderedFoodModel;
import com.dark.webshop.service.model.UserModel;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class OrderServiceImpl implements OrderService {
    FoodService foodService;
    UserService userService;
    OrderRepository orderRepository;
    OrderedFoodRepository orderedFoodRepository;
    OrderedFoodServiceMapper orderedFoodServiceMapper;
    OrderServiceMapper orderServiceMapper;
    AdditionalService additionalService;

    public OrderServiceImpl(FoodService foodService, UserService userService, OrderRepository orderRepository, OrderedFoodRepository orderedFoodRepository, OrderedFoodServiceMapper orderedFoodServiceMapper, OrderServiceMapper orderServiceMapper, AdditionalService additionalService) {
        this.foodService = foodService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderedFoodRepository = orderedFoodRepository;
        this.orderedFoodServiceMapper = orderedFoodServiceMapper;
        this.orderServiceMapper = orderServiceMapper;
        this.additionalService = additionalService;
    }

    @Override
    public List<OrderedFoodModel> getUserCart(String username) {
        UserModel userModel = userService.findUserByUsername(username);
        return userModel.getOrderedFoodCard();
    }

    @Override
    public void removeOrderedFood(String username, Integer orderedFoodId) {
        UserModel userModel = userService.findUserByUsername(username);
        userModel.getOrderedFoodCard().removeIf(it -> Objects.equals(it.getId(), orderedFoodId));
        userService.updateUserAccount(userModel);
        Optional<OrderedFood> orderedFood = orderedFoodRepository.findById(orderedFoodId);
        orderedFood.ifPresent(food -> orderedFoodRepository.delete(food));

    }

    @Override
    public Integer getUserCartSize(String username) {
        UserModel userModel = userService.findUserByUsername(username);
        return userModel.getOrderedFoodCard().size();
    }

    @Override
    public Integer getUserCartPrice(String username) {
        UserModel userModel = userService.findUserByUsername(username);
        AtomicReference<Integer> cost = new AtomicReference<>(0);
        userModel.getOrderedFoodCard().forEach(it -> cost.updateAndGet(v -> v + it.getTotalfoodcost()));
        return cost.get();
    }

    @Transactional
    @Override
    public void addOrderedFoodToUserCart(String username, OrderedFoodModel orderedFoodModel) {
        AtomicReference<Integer> cost = new AtomicReference<>(0);
        cost.updateAndGet(v -> v + foodService.findFoodById(orderedFoodModel.getFood().getId()).getCost());
        orderedFoodModel.getAdditionalList().forEach(it -> cost.updateAndGet(v -> v + additionalService.findAdditionalById(it.getId()).getCost()));
        orderedFoodModel.setTotalfoodcost(cost.get());
        UserModel userModel = userService.findUserByUsername(username);
        OrderedFood orderedFood = orderedFoodRepository.save(orderedFoodServiceMapper.modelToEntity(orderedFoodModel));
        userModel.getOrderedFoodCard().add(orderedFoodServiceMapper.entityToModel(orderedFood));
        userService.updateUserAccount(userModel);
    }
}
