package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dependent")
public class Dependent {
	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;  
    private String name;
    private Date dob;
    
    @ManyToOne
    @JoinColumn(name = "enrollee_id",
            nullable = false, updatable = false)
    private Enrollee enrollees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Enrollee getEnrollees() {
		return enrollees;
	}

	public void setEnrollees(Enrollee enrollees) {
		this.enrollees = enrollees;
	}

	   
    
}
