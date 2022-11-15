package com.dark.webshop.database.entity.food;

import javax.persistence.*;
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
    @Column(name = "totalfoodcost", nullable = false)
    private Integer totalfoodcost;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinOrderedFoodAdditionals", joinColumns = @JoinColumn(name = "orderedFoodId"), inverseJoinColumns = @JoinColumn(name = "additionalId")
    )
    private List<Additional> additionalList;

    public OrderedFood() {
    }

    public OrderedFood(Integer id, Food food, Integer orderId, Integer totalfoodcost, List<Additional> additionalList) {
        this.id = id;
        this.food = food;
        this.orderId = orderId;
        this.totalfoodcost = totalfoodcost;
        this.additionalList = additionalList;
    }

    public Integer getTotalfoodcost() {
        return totalfoodcost;
    }

    public void setTotalfoodcost(Integer totalfoodcost) {
        this.totalfoodcost = totalfoodcost;
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
