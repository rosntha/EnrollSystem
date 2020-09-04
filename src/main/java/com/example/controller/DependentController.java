package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Dependent;
import com.example.model.Enrollee;
import com.example.repository.DependentRepository;
import com.example.repository.EnrolleeRepository;

@RestController
@RequestMapping("/api")
public class DependentController {
	
	@Autowired
    private DependentRepository dependentRepository;
	
	@PostMapping("/dependent")
    public ResponseEntity<Dependent> saveOrder(@RequestBody Dependent dependent) {
        return new ResponseEntity<>(dependentRepository.save(dependent), HttpStatus.CREATED);
    }
	
	@PutMapping("/dependent//{id}")
    public ResponseEntity<Dependent> updateOrder(@PathVariable Long id, @RequestBody Dependent dependent) throws Exception {
		if(dependentRepository.findById(id) == null) {
			 throw new Exception("The Enrollee to be updated was not found");
		}
        return new ResponseEntity<>(dependentRepository.save(dependent), HttpStatus.OK);
    }

	@DeleteMapping("/dependent/{id}")
    public boolean deleteOrder(@PathVariable Long id) throws Exception {
		if(dependentRepository.findById(id) == null) {
			 throw new Exception("The Dependent to be deleted was not found");
		}
		dependentRepository.deleteById(id);
        return true;
    }

}
