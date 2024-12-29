package com.springboot.testwebapp.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;


	@Column(name = "email")
	private String email;


	@Column(name = "birthDate")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<>();

	// Метод для проверки возраста
	public boolean isAdult() {
		return Period.between(this.birthDate, LocalDate.now()).getYears() >= 18;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
