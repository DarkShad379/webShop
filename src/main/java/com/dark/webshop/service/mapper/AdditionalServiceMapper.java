package com.dark.webshop.service.mapper;

import com.dark.webshop.database.entity.food.Additional;
import com.dark.webshop.service.mapper.resolver.AdditionalMapperResolver;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring", uses = {AdditionalMapperResolver.class})
public interface AdditionalServiceMapper {

    AdditionalModel entityToModel(Additional additional);

    Additional modelToEntity(AdditionalModel additionalModel);
}
