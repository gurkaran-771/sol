package com.assignment.clothes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.assignment.clothes.model.Clothe;

public interface ClotheRepositoryPaginated extends PagingAndSortingRepository<Clothe, Double> {

}
