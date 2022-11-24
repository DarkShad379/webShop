package com.dark.webshop.controller.dto;

import com.dark.webshop.validation.CheckImage;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class FoodReq {
    private Integer id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Название должно быть не короче 2х символов!")
    private String name;
    @CheckImage(groups = OnCreate.class, message = "Должно иметь изображение!")
    private MultipartFile imageFile;
    private byte[] image;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Описание должно быть не короче 2х символов!")
    private String description;
    @NotNull(message = "Поле не может быть пустым")
    @Min(value = 0, message = "Цена не может быть отрицательным числом!")
    @Max(value = 1000000, message = "Слишком большая цена! Кто такое купит?!?!")
    private Integer cost;
    private Integer foodCategoryId;
    private List<Integer> availableAdditionalListId = new ArrayList<>();
    private boolean deleted = false;

    public FoodReq(Integer id, String name, MultipartFile imageFile, byte[] image, String description, Integer cost, Integer foodCategoryId, List<Integer> availableAdditionalListId, boolean deleted) {
        this.id = id;
        this.name = name;
        this.imageFile = imageFile;
        this.image = image;
        this.description = description;
        this.cost = cost;
        this.foodCategoryId = foodCategoryId;
        this.availableAdditionalListId = availableAdditionalListId;
        this.deleted = deleted;
    }

    public FoodReq() {
    }

    public Integer getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Integer foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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


    public List<Integer> getAvailableAdditionalListId() {
        return availableAdditionalListId;
    }

    public void setAvailableAdditionalListId(List<Integer> availableAdditionalListId) {
        this.availableAdditionalListId = availableAdditionalListId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
