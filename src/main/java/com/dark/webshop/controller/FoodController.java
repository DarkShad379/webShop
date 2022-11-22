package com.dark.webshop.controller;

import com.dark.webshop.request_model.FoodReq;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.FoodModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class FoodController {

    FoodService foodService;
    FoodCategoryService foodCategoryService;

    public FoodController(FoodService foodService, FoodCategoryService foodCategoryService) {
        this.foodService = foodService;
        this.foodCategoryService = foodCategoryService;
    }

    @RequestMapping("/food")
    public List<FoodModel> getFood() {
        return foodService.findAll();
    }

    @GetMapping("/add")
    public String addFoodPage(Model model) {
        model.addAttribute("foodReq", new FoodReq());
        model.addAttribute("categoryList", foodCategoryService.findAll());
        return "food/add";
    }
}
