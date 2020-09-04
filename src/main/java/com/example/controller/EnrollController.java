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

import com.example.model.Enrollee;
import com.example.repository.EnrolleeRepository;

@RestController
@RequestMapping("/api")
public class EnrollController {
	
	@Autowired
    private EnrolleeRepository enrolleeRepository;
	
	@PostMapping("/enrollee")
    public ResponseEntity<Enrollee> saveOrder(@RequestBody Enrollee enrollee) {
        return new ResponseEntity<>(enrolleeRepository.save(enrollee), HttpStatus.CREATED);
    }
	
	@PutMapping("/enrollee//{id}")
    public ResponseEntity<Enrollee> updateOrder(@PathVariable Long id, @RequestBody Enrollee enrollee) throws Exception {
		if(enrolleeRepository.findById(id) == null) {
			 throw new Exception("The Enrollee to be updated was not found");
		}
        return new ResponseEntity<>(enrolleeRepository.save(enrollee), HttpStatus.OK);
    }

	@DeleteMapping("/enrollee/{id}")
    public boolean deleteOrder(@PathVariable Long id) throws Exception {
		if(enrolleeRepository.findById(id) == null) {
			 throw new Exception("The Enrollee to be deleted was not found");
		}
        enrolleeRepository.deleteById(id);
        return true;
    }

}
