package com.dark.webshop.controller.dto.mapper;

import com.dark.webshop.controller.dto.FoodReq;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.service.model.FoodCategoryModel;
import com.dark.webshop.service.model.FoodModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodReqMapper {

    @Mapping(source = "imageFile", target = "image", qualifiedByName = "fileToImage", conditionExpression = "java(!foodReq.getImageFile().isEmpty())")
    @Mapping(source = "availableAdditionalListId", target = "availableAdditionalList", qualifiedByName = "listIdToListModel")
    @Mapping(target = "foodCategory", source = "foodCategoryId", qualifiedByName = "idToCategory")
    FoodModel reqToModel(FoodReq foodReq);

    @Mapping(target = "imageFile", ignore = true)
    @Mapping(target = "foodCategoryId", source = "foodCategory", qualifiedByName = "categoryToId")
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

    @Named("idToCategory")
    static FoodCategoryModel idToCategory(int id) {
        return new FoodCategoryModel(id);
    }

    @Named("categoryToId")
    static int categoryToId(FoodCategoryModel foodCategoryModel) {
        return foodCategoryModel.getId();
    }
}
