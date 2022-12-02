package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.OrderedFoodReq;
import com.dark.webshop.controller.dto.mapper.OrderedFoodReqMapper;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.model.OrderedFoodModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;
    private final OrderedFoodReqMapper orderedFoodReqMapper;

    public OrderController(OrderService orderService, OrderedFoodReqMapper orderedFoodReqMapper) {
        this.orderService = orderService;
        this.orderedFoodReqMapper = orderedFoodReqMapper;
    }

    @PostMapping("addToCard/{foodCat}/{foodId}")
    public String addFoodToCard(Principal principal, @ModelAttribute("currentOrderedFood") OrderedFoodReq orderedFoodReq,
                                @PathVariable int foodId, @PathVariable int foodCat
    ) {
        if (principal == null) {
            return "redirect:../../../login";
        }
        orderedFoodReq.setFoodId(foodId);
        OrderedFoodModel orderedFood = orderedFoodReqMapper.reqToModel(orderedFoodReq);
        orderService.addOrderedFoodToUserCart(principal.getName(), orderedFood);
        return "redirect:../../../?catId=" + foodCat;
    }
}
