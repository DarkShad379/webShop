package com.dark.webshop.controller;

import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.model.FoodCategoryModel;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CategoryController {
    FoodCategoryService foodCategoryService;

    public CategoryController(FoodCategoryService foodCategoryService) {
        this.foodCategoryService = foodCategoryService;
    }

    @GetMapping
    public String getCategories(Model model) {
        model.addAttribute("categoryList", foodCategoryService.findAll());
        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryPage(Model model) {
        model.addAttribute("categoryModel", new FoodCategoryModel());
        return "category/add";
    }

    @Validated
    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("categoryModel") FoodCategoryModel foodCategoryModel, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            foodCategoryService.saveOrUpdateCategory(foodCategoryModel);
            return "redirect:";
        } else return "category/add";
    }

    @PostMapping("/remove/{id}")
    public String removeCategory(@PathVariable int id) {
        FoodCategoryModel foodCategoryModel = foodCategoryService.findById(id);
        if (foodCategoryModel != null) {
            foodCategoryService.removeCategory(foodCategoryModel);
        }
        return "redirect:..";
    }

    @GetMapping("edit/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        model.addAttribute("categoryModel", foodCategoryService.findById(id));
        return "category/edit";
    }

    @Validated
    @PostMapping("/edit/{id}")
    public String editCategory(@Valid @ModelAttribute("categoryModel") FoodCategoryModel foodCategoryModel, BindingResult bindingResult, @PathVariable int id, Model model) {
        if (!bindingResult.hasErrors()) {
            foodCategoryService.saveOrUpdateCategory(foodCategoryModel);
            return "redirect:..";
        } else {
            return "category/edit";
        }
    }
}
