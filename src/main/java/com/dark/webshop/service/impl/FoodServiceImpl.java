package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.repository.FoodRepository;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.mapper.FoodServiceMapper;
import com.dark.webshop.service.model.FoodModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    FoodRepository foodRepository;
    FoodServiceMapper foodServiceMapper;

    public FoodServiceImpl(FoodRepository foodRepository, FoodServiceMapper foodServiceMapper) {
        this.foodRepository = foodRepository;
        this.foodServiceMapper = foodServiceMapper;
    }

    @Override
    public FoodModel findFoodById(int id) {
        Optional<Food> foodOpt = foodRepository.findById(id);
        return foodOpt.map(food -> foodServiceMapper.foodToFoodModel(food)).orElse(null);
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
    public List<FoodModel> findByCategoryPaged(int category, Integer page, Integer size) {
        List<Food> foodList = foodRepository.findByCategoryPaged(category, PageRequest.of(page, size));
        return foodList.stream().map(foodServiceMapper::foodToFoodModel).collect(Collectors.toList());
    }
}
