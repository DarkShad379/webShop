package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.OrderedFoodReq;
import com.dark.webshop.service.FoodCategoryService;
import com.dark.webshop.service.FoodService;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.UserService;
import com.dark.webshop.service.model.FoodCategoryModel;
import com.dark.webshop.service.model.FoodModel;
import com.dark.webshop.service.model.OrderedFoodModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MenuController {
    private final FoodService foodService;
    private final FoodCategoryService foodCategoryService;
    private final OrderService orderService;
    private final UserService userService;

    public MenuController(FoodService foodService, FoodCategoryService foodCategoryService, OrderService orderService, UserService userService) {
        this.foodService = foodService;
        this.foodCategoryService = foodCategoryService;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String getUserCartPage(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:login";
        }
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("cartPrice", orderService.getUserCartPrice(principal.getName()));
        model.addAttribute("cartSize", orderService.getUserCartSize(principal.getName()));
        List<OrderedFoodModel> userCartList = orderService.getUserCart(principal.getName());
        model.addAttribute("cartList", userCartList);
        model.addAttribute("phone", userService.getUserPhone(principal.getName()));
        model.addAttribute("address", userService.getUserAddress(principal.getName()));
        return "cart";
    }

    @GetMapping
    public String getMenuPage(Principal principal, Model model, @RequestParam(value = "catId", required = false) Integer catId) {
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
        if (principal != null) {

            model.addAttribute("cartPrice", orderService.getUserCartPrice(principal.getName()));
            model.addAttribute("cartSize", orderService.getUserCartSize(principal.getName()));
        } else {
            model.addAttribute("cartPrice", 0);
            model.addAttribute("cartSize", 0);

        }
        model.addAttribute("currentOrderedFood", new OrderedFoodReq());
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("foodModelList", foodModelList);
        return "mainPage";
    }


}
