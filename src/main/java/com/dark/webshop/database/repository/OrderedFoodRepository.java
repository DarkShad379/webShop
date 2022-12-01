package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.food.OrderedFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderedFoodRepository extends JpaRepository<OrderedFood, Integer> {
    @Modifying
    @Query(nativeQuery = true, value = "insert into joinorderedfoodusercard values(?1,?2)")
    public void addOrderedFoodToUserCard(int userId, int orderedFoodId);
}