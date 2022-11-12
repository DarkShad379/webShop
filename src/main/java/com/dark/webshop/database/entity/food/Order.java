package com.dark.webshop.database.entity.food;

import com.dark.webshop.database.entity.user.User;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.sql.Date;
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
    @Column(name = "confirmed")
    private boolean confirmed;
    @Column(name = "datetime")
    private Date datetime;
    public Order() {
    }

    public Order(Integer id, User user, boolean confirmed, Date datetime, List<OrderedFood> orderedFoodList) {
        this.id = id;
        this.user = user;
        this.confirmed = confirmed;
        this.datetime = datetime;
        this.orderedFoodList = orderedFoodList;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    private List<OrderedFood> orderedFoodList;


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
