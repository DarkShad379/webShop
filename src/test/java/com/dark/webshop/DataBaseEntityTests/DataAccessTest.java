package com.dark.webshop.DataBaseEntityTests;

import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.entity.food.Food;
import com.dark.webshop.entity.food.FoodCategory;
import com.dark.webshop.repository.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.dialect.AbstractDialect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DataAccessTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    FoodRepository foodRepository;

    @Test
    public void testFoodEntity() throws IOException {
        entityManager.clear();
        Food testFood = new Food();
        Additional testAdditional = new Additional();
        testAdditional.setCost(200);
        testAdditional.setName("Сырный бортик");
        List<Additional> additionalList = new ArrayList<>();
        testFood.setAvailableAdditionalList(additionalList);
        testFood.getAvailableAdditionalList().add(testAdditional);
        testFood.setName("Пицца Маргарита");
        ClassPathResource resource = new ClassPathResource("pizzaImage.jpg");
        InputStream inputStream = resource.getInputStream();
        testFood.setImage(inputStream.readAllBytes());
        testFood.setDescription("Лучшая пицца в мире");
        testFood.setCost(9999);
        testFood.setFoodCategory(FoodCategory.PIZZA);
        int Id = (int) entityManager.persistAndGetId(testFood);
        Food margarita = foodRepository.findById(Id).get();
        assertEquals(margarita.getName(), testFood.getName());
        assertEquals(margarita.getDescription(), testFood.getDescription());
        assertEquals(margarita.getImage(), testFood.getImage());
        assertEquals(margarita.getAvailableAdditionalList().get(0), testFood.getAvailableAdditionalList().get(0));
        assertEquals(margarita.getFoodCategory(), FoodCategory.PIZZA);
    }}
