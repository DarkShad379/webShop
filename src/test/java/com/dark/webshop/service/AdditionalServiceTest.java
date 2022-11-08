package com.dark.webshop.service;


import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.service.interfaces.AdditionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AdditionalServiceTest {
    @Autowired
    AdditionalService additionalService;

    @Test
    public void testAddAdditional() {
        Additional testAdditional = new Additional();
        testAdditional.setName("Сырный бортик");
        testAdditional.setCost(200);
        Additional newAdditional = additionalService.addAdditional(testAdditional);
        assertNotNull(newAdditional);
        assertNotNull(newAdditional.getId());
        assertEquals("Сырный бортик", newAdditional.getName());
    }

}
