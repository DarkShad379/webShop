package com.dark.webshop.database.entity.food;

import com.dark.webshop.database.entity.user.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ordercatalog")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;
    @ManyToMany
    @JoinTable(name = "joinorderedfoodorder", joinColumns = @JoinColumn(name = "orderid"), inverseJoinColumns = @JoinColumn(name = "orderedfoodid"))
    List<OrderedFood> orderedFoodList;
    @Column(name = "date")
    private Timestamp timestamp;
    @Column(name = "adress")
    private String address;
    @Column(name = "phone")
    private String phone;

    public Order() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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
