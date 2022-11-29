package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.database.repository.FoodCategoryRepository;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FoodCategoryMapperResolver {
    private FoodCategoryRepository foodCategoryRepository;

    public FoodCategoryMapperResolver(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }

    @ObjectFactory
    public FoodCategory resolve(FoodCategoryModel foodCategoryModel, @TargetType Class<FoodCategory> type) {
        Optional<FoodCategory> optionalFoodCategory = foodCategoryRepository.findById(foodCategoryModel.getId());
        return optionalFoodCategory.orElseGet(FoodCategory::new);
    }
}
