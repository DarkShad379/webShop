package com.dark.webshop.controller;

import com.dark.webshop.request_model.FoodReq;
import com.dark.webshop.request_model.mapper.FoodReqMapper;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.model.AdditionalModel;
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

    public List<FoodModel> getFood() {
        return foodService.findAll();
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
    public String add(@Valid @ModelAttribute("foodReq") FoodReq foodReq) {
        FoodModel foodModel = foodReqMapper.reqToModel(foodReq);
        foodService.saveOrUpdateFood(foodModel);
        return "food/add";
    }

    @GetMapping("/details/{id}")
    public String getFoodDetails(@PathVariable int id, Model model) {
        FoodModel foodModel = foodService.findFoodById(id);
        model.addAttribute("foodModel", foodModel);
        model.addAttribute("additionalList", additionalService.findAll(false));
        model.addAttribute("currentAdd", new AdditionalModel());
        model.addAttribute("imgUtil", new ImageUtil());
        return "/food/details/" + id;
    }

    @PostMapping("/details/{id}")
    public String setFoodDetails(@PathVariable int id, Model model, @ModelAttribute FoodModel foodModel, @ModelAttribute AdditionalModel currentAdd) {
        foodModel.getAvailableAdditionalList().add(currentAdd);
        return "/food/details/" + id;
    }

    @GetMapping("/edit/{id}")
    public String editFood(@PathVariable int id, Model model) {
        FoodModel foodModel = foodService.findFoodById(id);
        FoodReq foodReq = foodReqMapper.modelToReq(foodModel);
        model.addAttribute("foodReq", foodReq);
        model.addAttribute("imageArray", foodModel.getImage());
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("categoryList", foodCategoryService.findAll());
        model.addAttribute("additionalList", additionalService.findAll(false));
        return "food/edit";
    }

    @GetMapping
    public String getFoods(Model model) {
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("foodList", foodService.findAll());
        return "additionals/list";
    }

    @Validated
    @PostMapping("/edit/{id}")
    public String editFood(@Valid @ModelAttribute("foodReq") FoodReq foodReq, BindingResult bindingResult, @PathVariable int id, Model model) {
        if (!bindingResult.hasErrors()) {
            FoodModel foodModel = foodReqMapper.reqToModel(foodReq);
            if (foodReq.getImageFile().isEmpty()) {
                foodModel.setImage(additionalService.findAdditionalById(id).getImage());
            }
            foodService.saveOrUpdateFood(foodModel);
            return "redirect:..";
        } else {
            FoodModel foodModel = foodService.findFoodById(id);
            model.addAttribute("foodReq", foodReq);
            model.addAttribute("imageArray", foodModel.getImage());
            model.addAttribute("imgUtil", new ImageUtil());
            return "additionals/edit";
        }
    }
}
