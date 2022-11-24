package com.dark.webshop.service;




import com.dark.webshop.service.model.FoodModel;

import java.util.List;

public interface FoodService {
     FoodModel saveOrUpdateFood(FoodModel food);

     void removeFood(FoodModel food);

     List<FoodModel> findAll(boolean deleted);

     List<FoodModel> findByCategoryPaged(int category, Integer page, Integer size);

     FoodModel findFoodById(int id);
}
