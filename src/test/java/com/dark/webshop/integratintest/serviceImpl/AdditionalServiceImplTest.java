package com.dark.webshop.integratintest.serviceImpl;

import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdditionalServiceImplTest {
    @Autowired
    AdditionalService additionalService;

    @Test
    void testUpdateAdditional() {
        AdditionalModel additionalModel = new AdditionalModel();
        additionalModel.setName("Пепперони");
        additionalModel.setCost(250);
        AdditionalModel newAdditionalModel = additionalService.saveOrUpdateAdditional(additionalModel);
        assertNotNull(newAdditionalModel);
        assertNotNull(newAdditionalModel.getId());
        assertEquals(250, newAdditionalModel.getCost().intValue());
    }

    @Test
    void deleteAdditional() {
        List<AdditionalModel> listModel = additionalService.findAll(false);

    }

    @Test
    void findAll() {
    }

}