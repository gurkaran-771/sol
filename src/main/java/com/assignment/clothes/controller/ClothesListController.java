package com.assignment.clothes.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.model.dto.ClotheSearchByDateDTO;
import com.assignment.clothes.repository.ClotheRepository;
import com.assignment.clothes.repository.ClotheRepositoryPaginated;

@Controller
@RequestMapping("/clothesList")
public class ClothesListController {
    private static final int PAGE_SIZE = 8;

    @Autowired
    private ClotheRepository clotheRepository;

    @Autowired
    ClotheRepositoryPaginated clotheRepositoryPaginated;

    @ModelAttribute
    public Clothe clothe() {
        return Clothe.builder().build();
    }

    @ModelAttribute
    public void findAllClothes(Model model) {
        model.addAttribute("clothes", clotheRepository.findAll());
    }

    @GetMapping
    public String clothesList() {
        return "clothesList";
    }

    @ModelAttribute
    public void clothesByDateDto(Model model) {
        model.addAttribute("clothesByDateDto", new ClotheSearchByDateDTO());
    }

    @PostMapping
    public String searchClothesByDate(@ModelAttribute ClotheSearchByDateDTO clothesByDateDto,
            Model model) {
        var startDateString = clothesByDateDto.getStartDate();
        var endDateString = clothesByDateDto.getEndDate();

        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var startDate = LocalDate.parse(startDateString, dateFormatter);
        var endDate = LocalDate.parse(endDateString, dateFormatter);

        model.addAttribute("clothes", clotheRepository.findByNameStartsWithAndYearOfCreationBetween(
                clothesByDateDto.getName(), startDate.toString(), endDate.toString()));

        return "clothesList";
    }

    @ModelAttribute
    public void clothes(Model model) {
        var clothePage = clotheRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("clothes", clothePage);
        model.addAttribute("currentPage", clothePage.getNumber());
        model.addAttribute("totalPages", clothePage.getTotalPages());
    }

    @GetMapping("/switchPage")
    public String switchPage(Model model,
            @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "clothesList";
        }
        var clothePage = clotheRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("clothes", clothePage.getContent());
        model.addAttribute("currentPage", clothePage.getNumber());
        return "clothesList";
    }
}
