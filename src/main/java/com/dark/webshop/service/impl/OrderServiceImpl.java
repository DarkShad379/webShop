package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Order;
import com.dark.webshop.repository.OrderRepository;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.mapper.OrderServiceMapper;
import com.dark.webshop.service.model.OrderModel;
import com.dark.webshop.service.model.UserModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository;
    OrderServiceMapper orderServiceMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderServiceMapper orderServiceMapper) {
        this.orderRepository = orderRepository;
        this.orderServiceMapper = orderServiceMapper;
    }

    @Override
    public void updateOrder(OrderModel orderModel) {
        Order order = orderServiceMapper.modelToEntity(orderModel);
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(OrderModel orderModel) {
        Order order = orderServiceMapper.modelToEntity(orderModel);
        orderRepository.delete(order);
    }

    @Override
    public List<OrderModel> getOrdersForUser(UserModel userModel) {
        return orderRepository.findOrdersByUserId(userModel.getId()).stream()
                .map(orderServiceMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    public List<OrderModel> getOrdersForUserPaged(UserModel userModel, Integer page, Integer size, String sort) {
        return orderRepository.findOrdersByUserIdPaged(userModel.getId(), PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort)))
                .stream().map(orderServiceMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderServiceMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    public List<OrderModel> getAllOrdersPaged(Integer page, Integer size, String sort) {
        return orderRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort)))
                .stream().map(orderServiceMapper::entityToModel).collect(Collectors.toList());
    }
}
