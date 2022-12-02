package com.dark.webshop.controller.dto;

import com.dark.webshop.validation.UserNotExist;
import com.dark.webshop.validation.marker_interface.OnCreate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class UserReq {
    private Integer id;
    @NotNull
    @NotEmpty(message = "Обязательное поле")
    @UserNotExist(groups = OnCreate.class)
    private String username;
    @NotNull
    @NotEmpty(message = "Обязательное поле")
    @Size(min = 8, message = "Пароль должен быть длиной не менее 8 символов")
    private String password;
    List<OrderedFoodReq> orderedFoodCard = new ArrayList<>();
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

    public List<OrderedFoodReq> getOrderedFoodCard() {
        return orderedFoodCard;
    }
}
