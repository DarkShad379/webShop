package com.dark.webshop.request_model.mapper;

import com.dark.webshop.request_model.FoodReq;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodReqMapper {
    FoodReqMapper INSTANCE = Mappers.getMapper(FoodReqMapper.class);

    @Mapping(source = "imageFile", target = "image", qualifiedByName = "fileToImage")
    @Mapping(source = "availableAdditionalListId", target = "availableAdditionalList", qualifiedByName = "listIdToListModel")
    FoodModel reqToModel(FoodReq foodReq);

    @Mapping(target = "imageFile", ignore = true)
    @Mapping(source = "availableAdditionalList", target = "availableAdditionalListId", qualifiedByName = "listModelToListId")
    FoodReq modelToReq(FoodModel foodModel);

    @Named("fileToImage")
    static byte[] fileToImage(MultipartFile file) throws IOException {
        return file.getBytes();
    }

    @Named("listIdToListModel")
    static List<AdditionalModel> listIdToListModel(List<Integer> listId) {
        List<AdditionalModel> listModel = new ArrayList<>();
        listId.forEach(it -> listModel.add(new AdditionalModel(it)));
        return listModel;
    }

    @Named("listModelToListId")
    static List<Integer> listModelToListId(List<AdditionalModel> listFood) {
        List<Integer> listId = new ArrayList<>();
        listFood.forEach(it -> listId.add(it.getId()));
        return listId;
    }
}
