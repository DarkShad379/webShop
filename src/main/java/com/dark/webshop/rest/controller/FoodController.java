package com.dark.webshop.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
    @RequestMapping("/foodTest")
    public String TestPage() {
        return "index";
    }
}
