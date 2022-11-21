package com.dark.webshop.controller;

import com.dark.webshop.exception_handling.DTO.AdditionalDTO;
import com.dark.webshop.exception_handling.DTO.mapper.AdditionalDTOMapper;
import com.dark.webshop.exception_handling.NoSuchEntryInDatabase;
import com.dark.webshop.service.AdditionalService;
import com.dark.webshop.service.model.AdditionalModel;
import com.dark.webshop.utils.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "addAdditional";
    }

    @PostMapping("/add")
    public String addAdditional(@ModelAttribute("additionalDTO") AdditionalDTO additionalDTO) {
        AdditionalModel additionalModel = additionalDTOMapper.DTOtoModel(additionalDTO);
        additionalService.saveOrUpdateAdditional(additionalModel);
        return "redirect:";
    }

    @PostMapping("/remove/{id}")
    public String removeAdditional(@PathVariable int id) {
        AdditionalModel additionalModel = additionalService.findAdditionalById(id);
        if (additionalModel != null) {
            additionalService.removeAdditional(additionalModel);
        }
        return "redirect:2";
    }


    @GetMapping
    public String getAdditionals(Model model) {
        model.addAttribute("imgUtil", new ImageUtil());
        model.addAttribute("additionalList", additionalService.findAll(false));
        return "additionals";
    }

    @GetMapping("/all")
    public String getAllAdditionals(Model model) {
        //TODO Имплементировать проверку доступа на запрос
        model.addAttribute("additionaList", additionalService.findAll(true));
        return "all";
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

