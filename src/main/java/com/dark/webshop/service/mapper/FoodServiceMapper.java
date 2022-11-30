package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.Food;
import com.dark.webshop.service.mapper.resolver.FoodMapperResolver;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FoodMapperResolver.class})
public interface FoodServiceMapper {

    FoodModel entityToModel(Food food);

    Food modelToEntity(FoodModel foodModel);
}
