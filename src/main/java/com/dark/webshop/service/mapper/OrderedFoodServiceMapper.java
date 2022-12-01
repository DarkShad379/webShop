package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.service.mapper.resolver.FoodMapperResolver;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FoodMapperResolver.class})
public interface OrderedFoodServiceMapper {

    OrderedFoodModel entityToModel(OrderedFood orderedFood);

    OrderedFood modelToEntity(OrderedFoodModel orderedFoodModel);
}
