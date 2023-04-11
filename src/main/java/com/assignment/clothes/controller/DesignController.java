package com.assignment.clothes.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.model.Clothe.Brand;
import com.assignment.clothes.model.form.User;
import com.assignment.clothes.repository.ClotheRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private ClotheRepository clotheRepository;

    @ModelAttribute
    public Clothe clothe() {
        return Clothe.builder().build();
    }

    @ModelAttribute
    public void brands(Model model) {
        EnumSet<Brand> brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
    }

    @GetMapping
    public String getIndex() {
        return "design";
    }

    @PostMapping
    public String insertClothe(@Valid Clothe clothe, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }

        clotheRepository.save(clothe);
        return "redirect:/clothesList";
    }

    @PostMapping("/deleteAllClothes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processClothesDeletion(@AuthenticationPrincipal User user) {
        clotheRepository.deleteAll();
        return "redirect:/design";
    }
}
