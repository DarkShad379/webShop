package com.dark.webshop.entity.food;

import javax.persistence.*;

@Entity
@Table(name = "additionals")
public class Additional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name")
    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "cost")
    private Integer cost;

    public Additional() {
    }

    public Additional(Integer id, String name, Integer cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
