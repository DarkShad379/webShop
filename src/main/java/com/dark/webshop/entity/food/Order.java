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
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "orderedFood", joinColumns = @JoinColumn(name = "orderId"), inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<OrderedFood> orderedFoodList;
}
