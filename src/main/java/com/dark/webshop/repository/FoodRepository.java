package com.dark.webshop.repository;

import com.dark.webshop.database.entity.food.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    public List<Food> findAllByOrderByNameAsc();

    @Query("select f from Food f where f.deleted = false AND f.category =?1 order by f.name")
    List<Food> findByCategoryPaged(String category,Pageable pageable);
}