package com.dark.webshop.entity.food;

import org.hibernate.type.descriptor.sql.LobTypeMappings;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "foodcatalog")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "image", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] image;
    @Column(name = "description")
    private String description;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "foodcategory")
    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinFoodCatalogAdditionals", joinColumns = @JoinColumn(name = "foodId"), inverseJoinColumns = @JoinColumn(name = "additionalId")
    )
    private List<Additional> availableAdditionalList;

    public Food() {
    }

    public Food(Integer id, String name, byte[] image, String description, Integer cost, FoodCategory foodCategory, List<Additional> availableAdditionalList) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.cost = cost;
        this.foodCategory = foodCategory;
        this.availableAdditionalList = availableAdditionalList;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public List<Additional> getAvailableAdditionalList() {
        return availableAdditionalList;
    }

    public void setAvailableAdditionalList(List<Additional> availableAdditionalList) {
        this.availableAdditionalList = availableAdditionalList;
    }
}
