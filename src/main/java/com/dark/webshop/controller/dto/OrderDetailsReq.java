package com.dark.webshop.controller.dto;

import com.dark.webshop.validation.PhoneIsCorrect;
import com.dark.webshop.validation.marker_interface.OnCreate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderDetailsReq {
    @NotNull
    @NotEmpty(message = "Обязательное поле", groups = OnCreate.class)
    @PhoneIsCorrect
    @Size(min = 11, max = 11, message = "Длина не соответствует", groups = OnCreate.class)
    private String phoneNumber;
    @NotNull
    @NotEmpty(message = "Обязательное поле")
    private String address;

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
