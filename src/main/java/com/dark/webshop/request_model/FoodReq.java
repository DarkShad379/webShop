package com.dark.webshop.request_model;

import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.service.model.FoodCategoryModel;
import com.dark.webshop.validation.CheckImage;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.List;

public class FoodReq {
    private Integer id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Название должно быть не короче 2х символов!")
    private String name;
    @CheckImage(groups = OnCreate.class, message = "Должно иметь изображение!")
    private MultipartFile imageFile;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Описание должно быть не короче 2х символов!")
    private String description;
    @NotNull(message = "Поле не может быть пустым")
    @Min(value = 0, message = "Цена не может быть отрицательным числом!")
    @Max(value = 1000000, message = "Слишком большая цена! Кто такое купит?!?!")
    private Integer cost;
    private FoodCategoryModel foodCategory;
    private List<AdditionalModel> availableAdditionalList;
    private boolean deleted = false;

    public FoodReq(Integer id, String name, MultipartFile imageFile, String description, Integer cost, FoodCategoryModel foodCategory, List<AdditionalModel> availableAdditionalList, boolean deleted) {
        this.id = id;
        this.name = name;
        this.imageFile = imageFile;
        this.description = description;
        this.cost = cost;
        this.foodCategory = foodCategory;
        this.availableAdditionalList = availableAdditionalList;
        this.deleted = deleted;
    }

    public FoodReq() {
    }

    public FoodCategoryModel getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategoryModel foodCategory) {
        this.foodCategory = foodCategory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    public List<AdditionalModel> getAvailableAdditionalList() {
        return availableAdditionalList;
    }

    public void setAvailableAdditionalList(List<AdditionalModel> availableAdditionalList) {
        this.availableAdditionalList = availableAdditionalList;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
