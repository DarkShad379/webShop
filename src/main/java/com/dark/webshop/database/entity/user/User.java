package com.dark.webshop.database.entity.user;

import com.dark.webshop.database.entity.food.OrderedFood;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usercatalog")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinorderedfoodusercard", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "orderedfoodid"))
    List<OrderedFood> orderedFoodCard;

    public User() {
    }

    public List<OrderedFood> getOrderedFoodCard() {
        return orderedFoodCard;
    }

    public void setOrderedFoodCard(List<OrderedFood> orderedFoodCard) {
        this.orderedFoodCard = orderedFoodCard;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
