package com.dark.webshop.service.model;

import com.dark.webshop.database.entity.user.UserDetails;


public class UserModel {
    private Integer id;
    private String username;
    private String password;
    private UserDetails userDetails;

    public UserModel(Integer id, String login, String password, UserDetails userDetails) {
        this.id = id;
        this.username = login;
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
        return username;
    }

    public void setLogin(String login) {
        this.username = login;
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
