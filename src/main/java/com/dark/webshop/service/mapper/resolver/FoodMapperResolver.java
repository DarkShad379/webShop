package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.repository.FoodRepository;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodMapperResolver {
    @Autowired
    private FoodRepository foodRepository;

    public FoodMapperResolver() {

    }

    @ObjectFactory
    public Food resolve(FoodModel foodModel, @TargetType Class<Food> type) {
        return foodModel != null && foodModel.getId() != null && foodRepository.findById(foodModel.getId()).isPresent()
                ? foodRepository.findById(foodModel.getId()).get() : new Food();
    }
}
