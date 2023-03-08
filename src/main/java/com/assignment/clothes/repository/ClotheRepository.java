package com.assignment.clothes.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.clothes.model.Clothe;

public interface ClotheRepository extends CrudRepository<Clothe, Long> {
}
