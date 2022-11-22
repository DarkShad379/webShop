package com.dark.webshop.database.entity.food;

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
    @Column(name = "image", columnDefinition = "LONGBLOB")
    @Lob
    private byte[] image;
    @Column(name = "deleted")
    private boolean deleted = false;
    @Column(name = "cost")
    private Integer cost;

    public Additional() {
    }

    public Additional(Integer id, String name, byte[] image, boolean deleted, Integer cost) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.deleted = deleted;
        this.cost = cost;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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
