package com.dark.webshop.service.model;

public class AdditionalModel {
    private Integer id;
    private String name;
    private boolean deleted = false;
    private Integer cost;

    public AdditionalModel() {
    }


    public AdditionalModel(Integer id, String name, boolean deleted, Integer cost) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
        this.cost = cost;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
}
