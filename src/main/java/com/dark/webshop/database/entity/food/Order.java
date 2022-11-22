package com.dark.webshop.database.entity.food;

import com.dark.webshop.database.entity.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "orderedFood", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "id"))
    List<OrderedFood> orderedFoodList;
    @Column(name = "datetime")
    private Date datetime;

    public Order(Integer id, User user, List<OrderedFood> orderedFoodList, Date datetime) {
        this.id = id;
        this.user = user;
        this.orderedFoodList = orderedFoodList;
        this.datetime = datetime;
    }

    public Order() {
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
