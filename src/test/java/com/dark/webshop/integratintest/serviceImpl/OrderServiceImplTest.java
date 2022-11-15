package com.dark.webshop.integratintest.serviceImpl;

import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.model.FoodModel;
import com.dark.webshop.service.model.OrderModel;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class OrderServiceImplTest {
    @Autowired
    OrderService orderService;
    @Autowired
    FoodService foodService;

    @Test
    public void testUpdateOrder() {
        OrderModel orderModel = new OrderModel();
        OrderedFoodModel orderedFoodModel = new OrderedFoodModel();
        FoodModel foodModel = foodService.findAll().get(0);
        orderedFoodModel.setFood(foodModel);
        orderedFoodModel.setAdditionalList(foodModel.getAvailableAdditionalList());
    }
}
