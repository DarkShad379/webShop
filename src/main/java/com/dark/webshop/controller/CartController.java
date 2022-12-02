package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.OrderDetailsReq;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.UserService;
import com.dark.webshop.service.model.OrderedFoodModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final OrderService orderService;
    private final UserService userService;

    public CartController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String getUserCartPage(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/login";
        }
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("cartPrice", orderService.getUserCartPrice(principal.getName()));
        model.addAttribute("cartSize", orderService.getUserCartSize(principal.getName()));
        List<OrderedFoodModel> userCartList = orderService.getUserCart(principal.getName());
        model.addAttribute("cartList", userCartList);
        OrderDetailsReq orderDetailsReq = new OrderDetailsReq();
        model.addAttribute("orderDetailsReq", orderDetailsReq);
        return "cart";
    }

    @Validated
    @PostMapping("/confirm")
    public String confirmOrderFromCart(@Valid @ModelAttribute("orderDetailsReq") OrderDetailsReq orderDetailsReq, BindingResult bindingResult, Principal principal, Model model) {
        if (!bindingResult.hasErrors()) {
            System.out.println(orderDetailsReq.getAddress());
            System.out.println(orderDetailsReq.getPhoneNumber());
            return "redirect:";
        } else {
            model.addAttribute("imgUtil", new ImageUtil());
            model.addAttribute("cartPrice", orderService.getUserCartPrice(principal.getName()));
            model.addAttribute("cartSize", orderService.getUserCartSize(principal.getName()));
            List<OrderedFoodModel> userCartList = orderService.getUserCart(principal.getName());
            model.addAttribute("cartList", userCartList);
            model.addAttribute("orderDetailsReq", orderDetailsReq);
            return "cart";
        }

    }

    @PostMapping("/remove")
    public String removeOrderedFoodFromCart(@RequestParam(value = "ordFoodId") Integer ordFoodId, Principal principal) {
        orderService.removeOrderedFood(principal.getName(), ordFoodId);
        return "redirect:../cart";
    }
}
