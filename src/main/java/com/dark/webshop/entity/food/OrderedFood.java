package com.dark.webshop.entity.food;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "orderedfood")
public class OrderedFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "foodId")
    private Food food;
    @Column(name = "orderId", nullable = false)
    private Integer orderId;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "joinOrderedFoodAdditionals", joinColumns = @JoinColumn(name = "orderedFoodId"), inverseJoinColumns = @JoinColumn(name = "additionalId")
    )
    private List<Additional> additionalList;
}
