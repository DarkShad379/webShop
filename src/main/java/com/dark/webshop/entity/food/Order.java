package com.dark.webshop.entity.food;

import com.dark.webshop.entity.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    public Order() {
    }

    public Order(Integer id, User user, List<OrderedFood> orderedFoodList) {
        this.id = id;
        this.user = user;
        this.orderedFoodList = orderedFoodList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderedFood> getOrderedFoodList() {
        return orderedFoodList;
    }

    public void setOrderedFoodList(List<OrderedFood> orderedFoodList) {
        this.orderedFoodList = orderedFoodList;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "orderedFood", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<OrderedFood> orderedFoodList;
}
