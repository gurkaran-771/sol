package com.assignment.clothes.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignment.clothes.model.Clothe;

public interface ClotheRepository extends CrudRepository<Clothe, Long> {
   List<Clothe> findByBrand(Clothe clothe);

   List<Clothe> findByNameStartsWithAndYearOfCreationBetween(String name, String startDate, String endDate);
}
