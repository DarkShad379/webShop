package com.dark.webshop.entity.food;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "FoodCatalog")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private Blob image;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private Integer cost;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinFoodCatalogAdditionals", joinColumns = @JoinColumn(name = "foodId"), inverseJoinColumns = @JoinColumn(name = "additionalId")
    )
    private List<Additional> availableAdditionalList;

    public Food(Integer id, String name, Blob image, String description, Integer cost) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.cost = cost;
    }

    public Food() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
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

}
