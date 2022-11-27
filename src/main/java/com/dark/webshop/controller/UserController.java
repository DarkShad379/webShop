package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.UserReq;
import com.dark.webshop.controller.dto.mapper.UserReqMapper;
import com.dark.webshop.service.UserService;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    UserDetailsService userDetailsService;
    UserReqMapper userReqMapper;
    UserService userService;

    public UserController(UserDetailsService userDetailsService, UserReqMapper userReqMapper, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userReqMapper = userReqMapper;
        this.userService = userService;
    }

    @GetMapping(value = "login")
    public String getLoginPage(Model model) {
        model.addAttribute("userReq", new UserReq());
        return "login";
    }

    @PostMapping(value = "login")
    public String loginUser(@Valid @ModelAttribute("userReq") UserReq userReq, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (userService.userPasswordIsValid(userReqMapper.reqToModel(userReq))) {
                userDetailsService.loadUserByUsername(userReq.getUsername());
                return "redirect:menu";
            } else {
                bindingResult.addError(new ObjectError("password", "password incorrect"));
                return "login";

            }
        } else return "login";
    }

    @GetMapping(value = "registration")
    public String getSignPage(Model model) {
        model.addAttribute("userReq", new UserReq());
        return "sign";
    }

    @Validated(OnCreate.class)
    @PostMapping(value = "registration")
    public String registerUser(@Valid @ModelAttribute("userReq") UserReq userReq, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            userService.registerNewUserAccount(userReqMapper.reqToModel(userReq));
            return "redirect:login";
        } else return "sign";
    }
}
