package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Dependent;

public interface DependentRepository extends CrudRepository<Dependent, Long> {
}

