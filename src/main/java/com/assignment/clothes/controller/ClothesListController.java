package com.assignment.clothes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.clothes.repository.ClotheRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/list")
@Slf4j
public class ClothesListController {

    @Autowired
    private ClotheRepository clotheRepository;

    @ModelAttribute
    public void findAll(Model model) {
        var findAll = clotheRepository.findAll();
        model.addAttribute("clothes_list", findAll);
        log.info("clothes list: ", findAll);
    }

    @GetMapping
    public String clothesList() {
        return "clotheslist";
    }

}
