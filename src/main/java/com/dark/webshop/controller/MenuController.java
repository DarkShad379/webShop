package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.mapper.FoodReqMapper;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.FoodCategoryModel;
import com.dark.webshop.service.model.FoodModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {
    FoodService foodService;
    FoodCategoryService foodCategoryService;
    AdditionalService additionalService;
    FoodReqMapper foodReqMapper;

    public MenuController(FoodService foodService, FoodCategoryService foodCategoryService, AdditionalService additionalService, FoodReqMapper foodReqMapper) {
        this.foodService = foodService;
        this.foodCategoryService = foodCategoryService;
        this.additionalService = additionalService;
        this.foodReqMapper = foodReqMapper;
    }

    @GetMapping
    public String getMenuPage(Model model, @RequestParam(value = "catId", required = false) Integer catId) {
        List<FoodCategoryModel> foodCategoryModelList = foodCategoryService.findAll();
        model.addAttribute("categoryList", foodCategoryModelList);
        List<FoodModel> foodModelList = new ArrayList<>();
        if (foodCategoryModelList.isEmpty()) {
            foodModelList.addAll(foodService.findAll(false));
        } else {
            if (catId == null) {
                catId = foodCategoryModelList.get(0).getId();
            }
            foodModelList.addAll(foodService.findByCategory(catId));
        }
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("foodModelList", foodModelList);
        return "mainPage";
    }


}
