package com.dark.webshop.controller.dto;

import com.dark.webshop.validation.CheckImage;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

public class AdditionalReq {
    private Integer id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Название должно быть не короче 2х символов!")
    private String name;
    @NotNull(message = "Поле не может быть пустым")
    @Min(value = 0, message = "Цена не может быть отрицательным числом!")
    @Max(value = 1000000, message = "Слишком большая цена! Кто такое купит?!?!")
    private Integer cost;
    @CheckImage(groups = OnCreate.class, message = "Должно иметь изображение!")
    private MultipartFile imageFile;
    private byte[] image;

    public AdditionalReq(Integer id, String name, Integer cost, MultipartFile imageFile, byte[] image) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.imageFile = imageFile;
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public AdditionalReq() {
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }
}
