package com.dark.webshop.database.entity.food;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderedfoodcatalog")
public class OrderedFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "foodid", referencedColumnName = "id")
    private Food food;
    @Column(name = "totalfoodcost", nullable = false)
    private Integer totalfoodcost;
    @ManyToMany
    @JoinTable(name = "joinorderedfoodadditionals", joinColumns = @JoinColumn(name = "orderedfoodid"), inverseJoinColumns = @JoinColumn(name = "additionalid")
    )
    private List<Additional> additionalList;

    public OrderedFood() {
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


    public List<Additional> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<Additional> additionalList) {
        this.additionalList = additionalList;
    }
}
