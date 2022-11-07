package com.dark.webshop.entity.user;

import javax.persistence.*;

@Entity
@Table(name = "usercatalog")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userDetailsId")
    private UserDetails userDetails;

    public User() {
    }

    public User(Integer id, String login, String password, UserDetails userDetails) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userDetails = userDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
