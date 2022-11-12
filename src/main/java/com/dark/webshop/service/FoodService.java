package com.dark.webshop.service;




import com.dark.webshop.database.entity.food.FoodCategory;
import com.dark.webshop.service.model.FoodModel;

import java.util.List;

public interface FoodService {
     FoodModel updateFood(FoodModel food);
     void removeFood(FoodModel food);
     List<FoodModel> findAll(boolean isDeleted);
     List<FoodModel> findByCategoryPaged(FoodCategory category, Integer page, Integer size);
}
