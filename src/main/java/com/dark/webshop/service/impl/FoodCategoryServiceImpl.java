package com.dark.webshop.service.impl;

import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.exception_handling.NoSuchEntryInDatabase;
import com.dark.webshop.repository.FoodCategoryRepository;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.mapper.FoodCategoryServiceMapper;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {
    FoodCategoryRepository foodCategoryRepository;
    FoodCategoryServiceMapper foodCategoryServiceMapper;

    public FoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository, FoodCategoryServiceMapper foodCategoryServiceMapper) {
        this.foodCategoryRepository = foodCategoryRepository;
        this.foodCategoryServiceMapper = foodCategoryServiceMapper;
    }

    @Override
    public FoodCategoryModel saveOrUpdateCategory(FoodCategoryModel foodCategoryModel) {
        FoodCategory foodCategory = foodCategoryServiceMapper.modelToEntity(foodCategoryModel);
        FoodCategory newFoodCategory = foodCategoryRepository.save(foodCategory);
        return foodCategoryServiceMapper.entityToModel(newFoodCategory);
    }

    @Override
    public FoodCategoryModel findById(int id) {
        Optional<FoodCategory> foodCategory = foodCategoryRepository.findById(id);
        if (foodCategory.isPresent()) {
            return foodCategoryServiceMapper.entityToModel(foodCategory.get());
        } else {
            throw new NoSuchEntryInDatabase("Category with provided id doesnt exist");
        }
    }

    @Override
    public List<FoodCategoryModel> findAll() {
        List<FoodCategory> foodCategories = foodCategoryRepository.findAllByOrderByNameAsc();
        return foodCategories.stream().map(foodCategoryServiceMapper::entityToModel).collect(Collectors.toList());
    }

    @Override
    public void removeCategory(FoodCategoryModel foodCategoryModel) {
        foodCategoryRepository.delete(foodCategoryServiceMapper.modelToEntity(foodCategoryModel));
    }
}
