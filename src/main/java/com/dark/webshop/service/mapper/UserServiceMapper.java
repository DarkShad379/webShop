package com.dark.webshop.service.mapper;


import com.dark.webshop.database.entity.user.User;
import com.dark.webshop.service.mapper.resolver.UserMapperResolver;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapperResolver.class})

public interface UserServiceMapper {

    UserModel entityToModel(User user);

    User modelToEntity(UserModel userModel);
}
