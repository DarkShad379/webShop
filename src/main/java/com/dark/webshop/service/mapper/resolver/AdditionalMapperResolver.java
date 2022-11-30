package com.dark.webshop.service.mapper.resolver;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.database.repository.AdditionalRepository;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AdditionalMapperResolver {
    private final AdditionalRepository additionalRepository;

    public AdditionalMapperResolver(AdditionalRepository additionalRepository) {
        this.additionalRepository = additionalRepository;
    }

    @ObjectFactory
    public Additional resolve(AdditionalModel additionalModel, @TargetType Class<Additional> type) {
        if (additionalModel.getId() != null) {
            Optional<Additional> optionalAdditional = additionalRepository.findById(additionalModel.getId());
            return optionalAdditional.orElseGet(Additional::new);
        } else return new Additional();

    }
}