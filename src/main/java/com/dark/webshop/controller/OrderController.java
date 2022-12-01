package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.OrderedFoodReq;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("order")
public class OrderController {
    @PostMapping("addToCard/{foodId}")
    public String addFoodToCard(Principal principal, @ModelAttribute("currentOrderedFood") OrderedFoodReq orderedFoodReq, @RequestParam(value = "foodId") int foodId) {
        if (principal == null) {
            return "redirect:login";
        }
        orderedFoodReq.setFoodId(foodId);
        return "/";
    }
}
