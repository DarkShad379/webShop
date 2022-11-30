package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.service.mapper.resolver.FoodMapperResolver;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {FoodMapperResolver.class})

public interface FoodCategoryServiceMapper {

    FoodCategoryModel entityToModel(FoodCategory foodCategory);

    FoodCategory modelToEntity(FoodCategoryModel foodCategoryModel);
}
