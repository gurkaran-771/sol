package com.assignment.clothes.controller.rest;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.clothes.model.Clothe;
import com.assignment.clothes.model.dto.CreateClothe;
import com.assignment.clothes.repository.ClotheRepository;
import com.assignment.clothes.repository.ClotheRepositoryPaginated;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/clothes", produces = "application/json")
public class ClotheController {

    private final ClotheRepositoryPaginated clotheRepositoryPaginated;

    private final ClotheRepository clotheRepository;

    public ClotheController(ClotheRepositoryPaginated clotheRepositoryPaginated,
            ClotheRepository clotheRepository) {
        this.clotheRepositoryPaginated = clotheRepositoryPaginated;
        this.clotheRepository = clotheRepository;
    }

    @GetMapping
    public Iterable<Clothe> allClothes(@RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        if (!page.isPresent() || !size.isPresent()) {
            return clotheRepository.findAll();
        } else {
            return clotheRepositoryPaginated.findAll(PageRequest.of(page.get(), size.get()));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClothe(@PathVariable("id") Long id) {
        clotheRepository.deleteById(id);
    }

    @PostMapping
    public Clothe createClothe(@Valid @RequestBody CreateClothe clothe) {
        return clotheRepository.save(clothe.toClothe());
    }

    @PutMapping("/{id}")
    public Clothe updateClothe(@PathVariable("id") Long id,
            @Valid @RequestBody CreateClothe clothe) {
        var clotheToUpdate = clotheRepository.findById(id).orElseThrow();
        clotheToUpdate.setName(clothe.getName());
        clotheToUpdate.setBrand(clothe.getBrand());
        clotheToUpdate.setPrice(clothe.getPrice());
        clotheToUpdate.setYearOfCreation(clothe.getYearOfCreation());

        clotheToUpdate.setName(clothe.getName());

        return clotheRepository.save(clotheToUpdate);
    }

}
