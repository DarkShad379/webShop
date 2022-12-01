package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.OrderedFood;
import com.dark.webshop.service.mapper.resolver.OrderedFoodMapperResolver;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderedFoodMapperResolver.class})
public interface OrderedFoodServiceMapper {

    OrderedFoodModel entityToModel(OrderedFood orderedFood);

    OrderedFood modelToEntity(OrderedFoodModel orderedFoodModel);
}
