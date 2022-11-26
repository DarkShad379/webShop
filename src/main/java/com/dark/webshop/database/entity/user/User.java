package com.dark.webshop.database.entity.user;

import javax.persistence.*;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userDetailsId")
    private UserDetails userDetails;
    @OneToOne
    @JoinColumn(name = "AuthHG")
    private String authGroup;

    public User() {
    }

    public User(Integer id, String username, String password, UserDetails userDetails) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
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

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

}
