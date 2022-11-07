package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}