package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select ord from Order ord where ord.user.id= ?1")
    List<Order> findOrdersByUserId(Integer id);
}