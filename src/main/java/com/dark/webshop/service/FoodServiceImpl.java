package com.dark.webshop.service;

import com.dark.webshop.entity.food.Food;
import com.dark.webshop.repository.FoodRepository;
import com.dark.webshop.service.interfaces.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }
}
