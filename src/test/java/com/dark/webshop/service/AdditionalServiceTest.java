package com.dark.webshop.service;


import com.dark.webshop.entity.food.Additional;
import com.dark.webshop.service.interfaces.AdditionalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testSoftDeleteAdditional() {
        List<Additional> additionalList = additionalService.findAll(false);
        additionalList.forEach(it -> additionalService.deleteAdditional(it));
        assertTrue(additionalService.findAll(true).size() > 0);
        assertEquals(0, additionalService.findAll(false).size());

    }

    @Test
    public void testFindAllAdditionals() {
        System.out.println(additionalService.findAll(false));

    }
}
