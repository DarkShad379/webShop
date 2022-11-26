package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.food.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer> {
    List<FoodCategory> findAllByOrderByNameAsc();
}
