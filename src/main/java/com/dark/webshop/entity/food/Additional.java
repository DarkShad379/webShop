package com.dark.webshop.entity.food;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table(name = "additionals")
@SQLDelete(sql = "UPDATE additionals SET deleted = true WHERE id=?")
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
    @Column(name = "deleted")
    private boolean deleted=false;
    @Column(name = "cost")
    private Integer cost;

    public Additional() {
    }

    public Additional(Integer id, String name, boolean deleted, Integer cost) {
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
