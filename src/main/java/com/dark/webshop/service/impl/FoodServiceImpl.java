package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.database.repository.FoodRepository;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.mapper.FoodServiceMapper;
import com.dark.webshop.service.model.FoodModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodServiceMapper foodServiceMapper;

    public FoodServiceImpl(FoodRepository foodRepository, FoodServiceMapper foodServiceMapper) {
        this.foodRepository = foodRepository;
        this.foodServiceMapper = foodServiceMapper;
    }

    @Override
    public FoodModel findFoodById(int id) {
        Optional<Food> foodOpt = foodRepository.findById(id);
        return foodOpt.map(food -> foodServiceMapper.entityToModel(food)).orElse(null);
    }

    @Override
    public FoodModel saveOrUpdateFood(FoodModel foodModel) {
        Food food = foodServiceMapper.modelToEntity(foodModel);
        Food newFood = foodRepository.save(food);
        return foodServiceMapper.entityToModel(newFood);
    }

    @Override
    public void removeFood(FoodModel foodModel) {
        foodRepository.delete(foodServiceMapper.modelToEntity(foodModel));
    }

    @Override
    public List<FoodModel> findAll(boolean deleted) {
        List<Food> foodList = foodRepository.findAllByOrderByNameAsc(deleted);
        return foodList.stream().map(foodServiceMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    public List<FoodModel> findByCategory(int category) {
        List<Food> foodList = foodRepository.findByCategory(category);
        return foodList.stream().map(foodServiceMapper::entityToModel).collect(Collectors.toList());
    }
}
