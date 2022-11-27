package com.dark.webshop.controller.dto.mapper;

import com.dark.webshop.controller.dto.UserReq;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserReqMapper {
    UserReqMapper INSTANCE = Mappers.getMapper(UserReqMapper.class);

    UserReq modelToReq(UserModel userModel);

    UserModel reqToModel(UserReq userReq);
}
