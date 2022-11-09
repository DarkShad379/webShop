package com.dark.webshop.entity.food;

import com.dark.webshop.entity.user.User;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@FilterDef(name = "deletedAdditionalFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedAdditionalFilter", condition = "deleted = :isDeleted")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "orderedFood", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<OrderedFood> orderedFoodList;
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

}
