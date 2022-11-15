package com.dark.webshop.database.entity.food;

import javax.persistence.*;

@Entity
@Table(name = "foodCategory")
public class FoodCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false)
    int categoryId;
    @Column(name = "name")
    private String name;

    public FoodCategory(int categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public FoodCategory() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
