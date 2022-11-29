package com.dark.webshop.controller.dto.mapper;

import com.dark.webshop.controller.dto.UserReq;
import com.dark.webshop.service.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserReqMapper {

    UserReq modelToReq(UserModel userModel);

    UserModel reqToModel(UserReq userReq);
}
