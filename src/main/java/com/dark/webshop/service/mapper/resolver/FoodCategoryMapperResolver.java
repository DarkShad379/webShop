package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.repository.FoodCategoryRepository;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
public class FoodCategoryMapperResolver {
    private FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryMapperResolver(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }

    @ObjectFactory
    public FoodCategory resolve(FoodCategoryModel foodCategoryModel, @TargetType Class<FoodCategory> type) {
        return foodCategoryModel != null && foodCategoryRepository.findById(foodCategoryModel.getId()).isPresent()
                ? foodCategoryRepository.findById(foodCategoryModel.getId()).get() : new FoodCategory();
    }
}
