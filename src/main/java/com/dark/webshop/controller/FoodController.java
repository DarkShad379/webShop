package com.dark.webshop.controller;

import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    FoodService foodService;

    @RequestMapping("/food")
    public List<FoodModel> getFood() {
        return foodService.findAll();
    }

}
