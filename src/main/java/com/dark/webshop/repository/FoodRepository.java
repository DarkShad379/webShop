package com.dark.webshop.repository;

import com.dark.webshop.database.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query("select f from Food f where f.deleted = ?1 order by f.name")
    List<Food> findAllByOrderByNameAsc(boolean deleted);

    @Query("select f from Food f where f.deleted = false AND f.foodCategory.id =?1 order by f.name")
    List<Food> findByCategory(int category);
}