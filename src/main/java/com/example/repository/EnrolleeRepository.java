package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Enrollee;

public interface EnrolleeRepository extends CrudRepository<Enrollee, Long> {
}

