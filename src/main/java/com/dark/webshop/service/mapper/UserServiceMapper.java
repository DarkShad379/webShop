package com.dark.webshop.service.mapper;


import com.dark.webshop.database.entity.user.User;
import com.dark.webshop.service.mapper.resolver.UserMapperResolver;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapperResolver.class})

public interface UserServiceMapper {
    UserServiceMapper INSTANCE = Mappers.getMapper(UserServiceMapper.class);

    UserModel entityToModel(User user);

    User modelToEntity(UserModel userModel);
}
