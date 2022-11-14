package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.repository.AdditionalRepository;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdditionalMapperResolver {
    @Autowired
    private AdditionalRepository additionalRepository;

    @ObjectFactory
    public Additional resolve(AdditionalModel additionalModel, @TargetType Class<Additional> type) {
        return additionalModel != null && additionalModel.getId() != null && additionalRepository.findById(additionalModel.getId()).isPresent()
                ? additionalRepository.findById(additionalModel.getId()).get() : new Additional();
    }
}