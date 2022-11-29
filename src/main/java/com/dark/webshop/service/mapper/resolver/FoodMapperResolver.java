package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.database.repository.FoodRepository;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FoodMapperResolver {

    private FoodRepository foodRepository;

    public FoodMapperResolver(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @ObjectFactory
    public Food resolve(FoodModel foodModel, @TargetType Class<Food> type) {
        Optional<Food> foodOptional = foodRepository.findById(foodModel.getId());
        return foodOptional.orElseGet(Food::new);
    }
}
