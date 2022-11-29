package com.dark.webshop.service;

import com.dark.webshop.service.model.FoodCategoryModel;

import java.util.List;

public interface FoodCategoryService {
    FoodCategoryModel saveOrUpdateCategory(FoodCategoryModel foodCategoryModel);

    FoodCategoryModel findById(int id);

    List<FoodCategoryModel> findAll();

    void removeCategory(FoodCategoryModel foodCategoryModel);
}
