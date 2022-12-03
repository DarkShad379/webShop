package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.mapper.OrderedFoodReqMapper;
import com.dark.webshop.service.OrderService;
import com.dark.webshop.service.model.OrderModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("order")
@PreAuthorize("hasAuthority('ADMIN')")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService, OrderedFoodReqMapper orderedFoodReqMapper) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrderPage(Model model) {
        List<OrderModel> orderModelList = orderService.getAllOrders();
        model.addAttribute("orderList", orderModelList);
        return "/order/list";
    }

    @GetMapping("view/{id}")
    public String getOrderDetails(@PathVariable int id, Model model) {
        OrderModel orderModel = orderService.findOrderById(id);
        model.addAttribute("order", orderModel);
        model.addAttribute("orderCost", orderService.getOrderCost(id));
        model.addAttribute("imgUtil", new ImageUtil());

        return "/order/view";
    }

    @PostMapping("confirm/{id}")
    public String orderConfirm(@PathVariable int id, Model model) {

        orderService.confirmOrder(id);
        return "redirect:..";
    }

    @PostMapping("/remove/{id}")
    public String removeOrder(@PathVariable int id) {
        orderService.removeOrderById(id);
        return "redirect:..";
    }
}
