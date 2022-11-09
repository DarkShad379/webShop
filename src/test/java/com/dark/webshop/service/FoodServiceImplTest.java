package com.dark.webshop.service;

import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.entity.food.Food;
import com.dark.webshop.entity.food.FoodCategory;
import com.dark.webshop.service.interfaces.AdditionalService;
import com.dark.webshop.service.interfaces.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class FoodServiceImplTest {
    @Autowired
    FoodService foodService;
    @Autowired
    AdditionalService additionalService;

    @Test
    void addFood() {
        Food testFood = new Food();
        testFood.setName("Пицца Маргарита");
        testFood.setFoodCategory(FoodCategory.PIZZA);
        testFood.setCost(1800);
        List<Additional> additionalList = new ArrayList<>(additionalService.findAll(false));
        testFood.setAvailableAdditionalList(additionalList);
        testFood.setDescription("Пицца с томатной пастой и сыром");
        Food newPizza = foodService.addFood(testFood);
        assertNotNull(newPizza);
        assertNotNull(newPizza.getId());
        assertEquals(newPizza.getName(), "Пицца Маргарита");
        assertEquals(newPizza.getAvailableAdditionalList().get(0).getName(), additionalList.get(0).getName());
    }
}