package com.dark.webshop.controller;

import com.dark.webshop.controller.dto.AdditionalReq;
import com.dark.webshop.controller.dto.mapper.AdditionalReqMapper;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.utils.ImageUtil;
import com.dark.webshop.validation.marker_interface.OnCreate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/additionals")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdditionalController {
    private final AdditionalReqMapper additionalReqMapper;
    private final AdditionalService additionalService;

    public AdditionalController(AdditionalReqMapper additionalReqMapper, AdditionalService additionalService) {
        this.additionalReqMapper = additionalReqMapper;
        this.additionalService = additionalService;
    }

    @GetMapping("/add")
    public String addAdditionalPage(Model model) {
        model.addAttribute("additionalReq", new AdditionalReq());
        return "additionals/add";
    }


    @Validated(OnCreate.class)
    @PostMapping("/add")
    public String addAdditional(@Valid @ModelAttribute("additionalReq") AdditionalReq additionalReq, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            AdditionalModel additionalModel = additionalReqMapper.reqToModel(additionalReq);
            additionalService.saveOrUpdateAdditional(additionalModel);
            return "redirect:";
        } else return "additionals/add";
    }

    @GetMapping("/edit/{id}")
    public String editAdditional(@PathVariable int id, Model model) {
        AdditionalModel additionalModel = additionalService.findAdditionalById(id);
        AdditionalReq additionalReq = additionalReqMapper.modelToReq(additionalModel);
        model.addAttribute("additionalReq", additionalReq);
        model.addAttribute("imgUtil", new ImageUtil());
        return "additionals/edit";
    }

    @Validated
    @PostMapping("/edit/{id}")
    public String editAdditional(@Valid @ModelAttribute("additionalReq") AdditionalReq additionalReq, BindingResult bindingResult, @PathVariable int id, Model model) {
        if (!bindingResult.hasErrors()) {
            AdditionalModel additionalModel = additionalReqMapper.reqToModel(additionalReq);
            if (additionalReq.getImageFile().isEmpty()) {
                additionalModel.setImage(additionalService.findAdditionalById(id).getImage());
            }
            additionalService.saveOrUpdateAdditional(additionalModel);
            return "redirect:..";
        } else {
            model.addAttribute("additionalReq", additionalReq);
            model.addAttribute("imgUtil", new ImageUtil());
            return "additionals/edit";
        }
    }

    @PostMapping("/remove/{id}")
    public String removeAdditional(@PathVariable int id) {
        AdditionalModel additionalModel = additionalService.findAdditionalById(id);
        if (additionalModel != null) {
            additionalService.removeAdditional(additionalModel);
        }
        return "redirect:..";
    }


    @GetMapping
    public String getAdditionals(Model model) {
        model.addAttribute("imgUtil", new ImageUtil());
        List<AdditionalModel> additionalModelList = additionalService.findAll(false);
        List<AdditionalReq> additionalReqList = additionalModelList.stream().map(additionalReqMapper::modelToReq).collect(Collectors.toList());
        model.addAttribute("additionalList", additionalReqList);
        return "additionals/list";
    }

}

