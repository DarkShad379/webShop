package com.dark.webshop.controller.dto.mapper;

import com.dark.webshop.controller.dto.OrderedFoodReq;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.service.model.FoodModel;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderedFoodReqMapper {

    @Mapping(source = "additionalListId", target = "additionalList", qualifiedByName = "listIdToListModel")
    @Mapping(target = "food", source = "foodId", qualifiedByName = "idToCategory")
    OrderedFoodModel reqToModel(OrderedFoodReq orderedFoodReq);

    @Mapping(target = "foodId", source = "food", qualifiedByName = "categoryToId")
    @Mapping(source = "additionalList", target = "additionalListId", qualifiedByName = "listModelToListId")
    OrderedFoodReq modelToReq(OrderedFoodModel orderedFoodModel);

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

    @Named("idToFood")
    static FoodModel idToCategory(int id) {
        return new FoodModel(id);
    }

    @Named("FoodToId")
    static int categoryToId(FoodModel foodModel) {
        return foodModel.getId();
    }

}
