package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.service.mapper.resolver.AdditionalMapperResolver;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(uses = {AdditionalMapperResolver.class})
public interface AdditionalServiceMapper {
    AdditionalServiceMapper INSTANCE = Mappers.getMapper(AdditionalServiceMapper.class);
    AdditionalModel additionalToAdditionalModel(Additional additional);
}
