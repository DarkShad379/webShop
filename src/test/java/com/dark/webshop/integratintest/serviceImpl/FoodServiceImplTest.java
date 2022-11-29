package com.dark.webshop.integratintest.serviceImpl;

import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.service.model.FoodModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void testUpdateFood() {
        FoodModel foodModel = new FoodModel();
        foodModel.setCost(2500);
        foodModel.setName("Пицца Четыре сыра");
        foodModel.setDescription("Сочетание четырех сыров и слезы программиста, придают этой пицце изысканный вкус");
        List<AdditionalModel> availableAdditionalList = additionalService.findAll(false);
        foodModel.setAvailableAdditionalList(availableAdditionalList);
        FoodModel newFoodModel = foodService.saveOrUpdateFood(foodModel);
        assertNotNull(newFoodModel.getId());
        assertEquals(foodModel.getName(), newFoodModel.getName());
        assertEquals(foodModel.getAvailableAdditionalList().get(0).toString(), newFoodModel.getAvailableAdditionalList().get(0).toString());
    }
}
