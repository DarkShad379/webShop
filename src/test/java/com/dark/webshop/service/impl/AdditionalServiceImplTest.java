package com.dark.webshop.service.impl;

import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AdditionalServiceImplTest {
    @Autowired
    AdditionalService additionalService;

    @Test
    void updateAdditional() {
        AdditionalModel additionalModel = new AdditionalModel();
        additionalModel.setName("Шоколадная крошка");
        additionalModel.setId(9);
        additionalModel.setCost(350);
        AdditionalModel newAdditionalModel = additionalService.updateAdditional(additionalModel);
        assertNotNull(newAdditionalModel);
        assertNotNull(newAdditionalModel.getId());
        assertEquals(350, newAdditionalModel.getCost().intValue());
    }

    @Test
    void deleteAdditional() {
        List<AdditionalModel> listModel = additionalService.findAll(false);

    }

    @Test
    void findAll() {
    }

}