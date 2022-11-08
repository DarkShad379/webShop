package com.dark.webshop.entity.food;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "orderedfood")
public class OrderedFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "foodId")
    private Food food;
    @Column(name = "orderId", nullable = false)
    private Integer orderId;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinOrderedFoodAdditionals", joinColumns = @JoinColumn(name = "orderedFoodId"), inverseJoinColumns = @JoinColumn(name = "additionalId")
    )
    private List<Additional> additionalList;

    public OrderedFood() {
    }

    public OrderedFood(Integer id, Food food, Integer orderId, List<Additional> additionalList) {
        this.id = id;
        this.food = food;
        this.orderId = orderId;
        this.additionalList = additionalList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<Additional> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<Additional> additionalList) {
        this.additionalList = additionalList;
    }
}
