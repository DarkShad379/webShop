package com.dark.webshop.controller.dto;

import com.dark.webshop.validation.PhoneIsCorrect;
import com.dark.webshop.validation.UserNotExist;
import com.dark.webshop.validation.marker_interface.OnCreate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(groups = OnCreate.class)
    @NotEmpty(message = "Обязательное поле", groups = OnCreate.class)
    @PhoneIsCorrect(groups = OnCreate.class)
    @Size(min = 11, max = 11, message = "Длина не соответствует", groups = OnCreate.class)
    private String phoneNumber;
    @NotNull(groups = OnCreate.class)
    @NotEmpty(message = "Обязательное поле", groups = OnCreate.class)
    private String address;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
