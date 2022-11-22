package com.dark.webshop.request_model.mapper;

import com.dark.webshop.request_model.FoodReq;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface FoodReqMapper {
    FoodReqMapper INSTANCE = Mappers.getMapper(FoodReqMapper.class);

    @Mapping(source = "imageFile", target = "image", qualifiedByName = "fileToImage")
    FoodModel ReqToModel(FoodReq foodReq);

    @Named("fileToImage")
    static byte[] fileToImage(MultipartFile file) throws IOException {
        return file.getBytes();
    }
}
