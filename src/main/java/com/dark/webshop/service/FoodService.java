package com.dark.webshop.service;




import com.dark.webshop.service.model.FoodModel;

import java.util.List;

public interface FoodService {
     FoodModel updateFood(FoodModel food);

     void removeFood(FoodModel food);

     List<FoodModel> findAll();

     List<FoodModel> findByCategoryPaged(int category, Integer page, Integer size);

     FoodModel findFoodById(int id);
}
