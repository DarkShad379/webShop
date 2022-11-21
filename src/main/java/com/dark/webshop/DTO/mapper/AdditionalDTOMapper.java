package com.dark.webshop.DTO.mapper;

import com.dark.webshop.DTO.AdditionalDTO;
import com.dark.webshop.service.model.AdditionalModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface AdditionalDTOMapper {
    AdditionalDTOMapper INSTANCE = Mappers.getMapper(AdditionalDTOMapper.class);

    @Mapping(source = "imageFile", target = "image", qualifiedByName = "fileToImage")
    AdditionalModel DTOtoModel(AdditionalDTO additionalDTO);

    @Named("fileToImage")
    static byte[] fileToImage(MultipartFile file) throws IOException {
        return file.getBytes();
    }
}
