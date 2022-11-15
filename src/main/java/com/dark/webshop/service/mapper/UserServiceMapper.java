package com.dark.webshop.service.mapper;


import com.dark.webshop.database.entity.user.User;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserServiceMapper {
    UserServiceMapper INSTANCE = Mappers.getMapper(UserServiceMapper.class);

    UserModel userToUserModel(User user);

    User userModelToUser(UserModel userModel);
}
