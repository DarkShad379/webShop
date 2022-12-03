package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.OrderDetailsReq;
import com.dark.webshop.controller.dto.OrderedFoodReq;
import com.dark.webshop.controller.dto.mapper.OrderedFoodReqMapper;
import com.dark.webshop.service.OrderService;
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
    private final OrderedFoodReqMapper orderedFoodReqMapper;

    public CartController(OrderService orderService, OrderedFoodReqMapper orderedFoodReqMapper) {
        this.orderService = orderService;
        this.orderedFoodReqMapper = orderedFoodReqMapper;
    }

    @GetMapping("/complete")
    public String orderCompletePage(Principal principal, Model model) {
        model.addAttribute("cartPrice", orderService.getUserCartPrice(principal.getName()));
        model.addAttribute("cartSize", orderService.getUserCartSize(principal.getName()));

        return "orderComplete";
    }

    @PostMapping("add/{foodCat}/{foodId}")
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

            orderService.convertUserCartToOrder(orderDetailsReq, principal.getName());

            return "redirect:/cart/complete";
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
