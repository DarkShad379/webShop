package com.dark.webshop.controller;

import com.dark.webshop.DTO.AdditionalDTO;
import com.dark.webshop.DTO.mapper.AdditionalDTOMapper;
import com.dark.webshop.exception_handling.NoSuchEntryInDatabase;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/additionals")
public class AdditionalController {

    AdditionalDTOMapper additionalDTOMapper;
    AdditionalService additionalService;

    public AdditionalController(AdditionalDTOMapper additionalDTOMapper, AdditionalService additionalService) {
        this.additionalDTOMapper = additionalDTOMapper;
        this.additionalService = additionalService;
    }

    @GetMapping("/add")
    public String addAdditionalPage(Model model) {
        model.addAttribute("additionalDTO", new AdditionalDTO());
        return "additionals/add";
    }

    @GetMapping("/remove/{id}")
    public String editAdditional(@PathVariable int id, Model model) {
        AdditionalModel additionalModel = additionalService.findAdditionalById(id);
        model.addAttribute("editAdditional", additionalModel);
        return "additionals/edit";
    }

    @Validated
    @PostMapping("/add")
    public String addAdditional(@Valid @ModelAttribute("additionalDTO") AdditionalDTO additionalDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            AdditionalModel additionalModel = additionalDTOMapper.DTOtoModel(additionalDTO);
            additionalService.saveOrUpdateAdditional(additionalModel);
            return "redirect:";
        } else {
            return "additionals/add";
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
        model.addAttribute("additionalList", additionalService.findAll(false));
        return "additionals/list";
    }


    @GetMapping("/{additionalId}")
    public String getAdditionalById(@PathVariable int additionalId, Model model) {
        AdditionalModel additionalModel = additionalService.findAdditionalById(additionalId);
        if (additionalModel == null) {
            throw new NoSuchEntryInDatabase("Exception: Not found additional with Id " + additionalId);
        }
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("additionalList", additionalService.findAll(false));
        model.addAttribute("additional", additionalModel);
        return "/" + additionalId;
    }
}

