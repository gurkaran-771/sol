package com.assignment.clothes.controller;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.model.Clothe.Brand;
import com.assignment.clothes.repository.ClotheRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ClotheRepository clotheRepository;

    @ModelAttribute
    public Clothe clothe() {
        return Clothe.builder().build();
    }

    @ModelAttribute
    public void brands(Model model) {
        Set<Brand> brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);

    }

    @GetMapping
    public String home() {
        return "home";
    }

    @PostMapping
    public String addClothe(@Valid Clothe clothe, BindingResult result) {
        if (result.hasErrors()) {
            return "/home";
        }
        clotheRepository.save(clothe);

        return "redirect:/list";
    }
}
