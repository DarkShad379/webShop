package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.service.mapper.resolver.FoodMapperResolver;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FoodMapperResolver.class})

public interface FoodCategoryServiceMapper {
    FoodCategoryServiceMapper INSTANCE = Mappers.getMapper(FoodCategoryServiceMapper.class);

    FoodCategoryModel modelToEntity(FoodCategory foodCategory);

    FoodCategory entityToModel(FoodCategoryModel foodCategoryModel);
}
