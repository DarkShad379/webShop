package com.dark.webshop.request_model.mapper;

import com.dark.webshop.request_model.AdditionalReq;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface AdditionalReqMapper {
    AdditionalReqMapper INSTANCE = Mappers.getMapper(AdditionalReqMapper.class);

    @Mapping(source = "imageFile", target = "image", qualifiedByName = "fileToImage")
    @Mapping(target = "deleted", ignore = true)
    AdditionalModel reqToModel(AdditionalReq additionalReq);

    @Mapping(target = "imageFile", ignore = true)
    AdditionalReq modelToReq(AdditionalModel additionalModel);

    @Named("fileToImage")
    static byte[] fileToImage(MultipartFile file) throws IOException {
        return file.getBytes();
    }

}
