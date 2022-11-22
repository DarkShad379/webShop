package com.dark.webshop.database.entity.food;

import javax.persistence.*;

@Entity
@Table(name = "foodcategory")
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "name")
    private String name;

    public FoodCategory(int categoryId, String name) {
        this.id = categoryId;
        this.name = name;
    }

    public FoodCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
