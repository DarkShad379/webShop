package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.food.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select ord from Order ord where ord.user.id= ?1")
    List<Order> findOrdersByUserId(Integer id);

    @Query("select ord from Order ord where ord.user.id= ?1")
    Page<Order> findOrdersByUserIdPaged(Integer id, Pageable pageable);
}