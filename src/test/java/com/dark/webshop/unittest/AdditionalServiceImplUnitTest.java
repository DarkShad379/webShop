package com.dark.webshop.unittest;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.impl.AdditionalServiceImpl;
import com.dark.webshop.service.mapper.AdditionalServiceMapper;
import com.dark.webshop.service.model.AdditionalModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AdditionalServiceImplUnitTest {
    @Mock
    private AdditionalRepository additionalRepository;
    @Mock
    private AdditionalServiceMapper additionalServiceMapper;
    @InjectMocks
    AdditionalServiceImpl additionalService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void updateAdditional() {
        AdditionalModel additionalModel = new AdditionalModel();
        additionalModel.setName("Халапеньо");
        additionalModel.setCost(250);
        Additional additionalMock = new Additional();
        additionalMock.setName("Халапеньо");
        additionalMock.setCost(250);
        additionalMock.setId(0);
        AdditionalModel additionalModelMock = new AdditionalModel();
        additionalModelMock.setCost(250);
        additionalModelMock.setName("Халапеньо");
        additionalModelMock.setId(0);
        when(additionalServiceMapper.entityToModel(any(Additional.class))).thenReturn(additionalModelMock);
        //Мок маппера и конвертации из энтети в модель
        when(additionalServiceMapper.modelToEntity(any(AdditionalModel.class))).thenReturn(additionalMock);
        //Мок маппера и конвертации из модели в энтети
        when(additionalRepository.save(any(Additional.class))).thenReturn(additionalMock);
        //Мок запроса в репозиторий
        AdditionalModel newAdditionalModel = additionalService.updateAdditional(additionalModel);
        assertNotNull(newAdditionalModel);
        assertNotNull(newAdditionalModel.getId());
        assertEquals("Халапеньо", newAdditionalModel.getName());
        assertEquals(250, newAdditionalModel.getCost().intValue());
    }
}