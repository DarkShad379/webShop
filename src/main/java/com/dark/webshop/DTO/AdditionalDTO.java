package com.dark.webshop.DTO;

import com.dark.webshop.validation.CheckImage;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AdditionalDTO {
    private Integer id;
    @NotBlank(message = "Поле не может быть пустым")
    @Size(min = 2, message = "Название должно быть не короче 2х символов!")
    private String name;
    @Min(value = 0, message = "Цена не может быть отрицательным числом!")
    private Integer cost;
    @CheckImage(message = "Должно иметь изображение!")
    private MultipartFile imageFile;

    public AdditionalDTO(Integer id, String name, Integer cost, MultipartFile imageFile) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.imageFile = imageFile;
    }

    public AdditionalDTO() {
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
