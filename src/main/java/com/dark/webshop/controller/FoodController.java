package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.FoodReq;
import com.dark.webshop.controller.dto.mapper.FoodReqMapper;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.FoodModel;
import com.dark.webshop.utils.ImageUtil;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/food")
public class FoodController {

    FoodService foodService;
    FoodCategoryService foodCategoryService;
    AdditionalService additionalService;
    FoodReqMapper foodReqMapper;

    public FoodController(FoodService foodService, FoodCategoryService foodCategoryService, AdditionalService additionalService, FoodReqMapper foodReqMapper) {
        this.foodService = foodService;
        this.foodCategoryService = foodCategoryService;
        this.additionalService = additionalService;
        this.foodReqMapper = foodReqMapper;
    }


    @GetMapping
    public String getFoods(Model model) {
        List<FoodModel> foodModelList = foodService.findAll(false);
        List<FoodReq> foodReqList = foodModelList.stream().map(foodReqMapper::modelToReq).collect(Collectors.toList());
        model.addAttribute("foodList", foodReqList);
        model.addAttribute("foodCategory", foodCategoryService.findAll());
        model.addAttribute("additionalList", additionalService.findAll(false));
        model.addAttribute("imgUtil", new ImageUtil());
        return "food/list";
    }

    @GetMapping("/add")
    public String addFoodPage(Model model) {
        model.addAttribute("foodReq", new FoodReq());
        model.addAttribute("categoryList", foodCategoryService.findAll());
        model.addAttribute("additionalList", additionalService.findAll(false));
        return "food/add";
    }

    @Validated({OnCreate.class})
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("foodReq") FoodReq foodReq, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            FoodModel foodModel = foodReqMapper.reqToModel(foodReq);
            foodService.saveOrUpdateFood(foodModel);
            return "redirect:";
        } else return "food/add";
    }

    @GetMapping("/edit/{id}")
    public String editFood(@PathVariable int id, Model model) {
        FoodModel foodModel = foodService.findFoodById(id);
        FoodReq foodReq = foodReqMapper.modelToReq(foodModel);
        model.addAttribute("foodReq", foodReq);
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("categoryList", foodCategoryService.findAll());
        model.addAttribute("additionalList", additionalService.findAll(false));
        return "food/edit";
    }


    @Validated
    @PostMapping("/edit/{id}")
    public String editFood(@Valid @ModelAttribute("foodReq") FoodReq foodReq, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            FoodModel foodModel = foodReqMapper.reqToModel(foodReq);
            foodService.saveOrUpdateFood(foodModel);
            return "redirect:..";
        } else {
            model.addAttribute("foodReq", foodReq);
            model.addAttribute("imgUtil", new ImageUtil());
            return "food/edit";
        }
    }

    @PostMapping("/remove/{id}")
    public String removeFood(@PathVariable int id) {
        FoodModel foodModel = foodService.findFoodById(id);
        if (foodModel != null) {
            foodService.removeFood(foodModel);
        }
        return "redirect:..";
    }

}
