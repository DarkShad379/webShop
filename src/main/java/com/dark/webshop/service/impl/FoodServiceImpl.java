package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.repository.FoodRepository;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.mapper.FoodServiceMapper;
import com.dark.webshop.service.model.FoodModel;

import java.util.List;
import java.util.stream.Collectors;

public class FoodServiceImpl implements FoodService {
    FoodRepository foodRepository;
    FoodServiceMapper foodServiceMapper;

    public FoodServiceImpl(FoodRepository foodRepository, FoodServiceMapper foodServiceMapper) {
        this.foodRepository = foodRepository;
        this.foodServiceMapper = foodServiceMapper;
    }

    @Override
    public FoodModel updateFood(FoodModel foodModel) {
        Food food = foodServiceMapper.foodModelToFood(foodModel);
        Food newFood = foodRepository.save(food);
        return foodServiceMapper.foodToFoodModel(newFood);
    }

    @Override
    public void removeFood(FoodModel foodModel) {
        foodRepository.delete(foodServiceMapper.foodModelToFood(foodModel));
    }

    @Override
    public List<FoodModel> findAll() {
        List<Food> foodList = foodRepository.findAllByOrderByNameAsc();
        return foodList.stream().map(foodServiceMapper::foodToFoodModel).collect(Collectors.toList());
    }

    @Override
    public List<FoodModel> findByCategoryPaged(FoodCategory category, Integer page, Integer size) {
        return null;
    }
}
