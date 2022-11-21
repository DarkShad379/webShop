package com.dark.webshop.exception_handling.DTO;

import org.springframework.web.multipart.MultipartFile;

public class AdditionalDTO {
    private Integer id;
    private String name;
    private Integer cost;
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
