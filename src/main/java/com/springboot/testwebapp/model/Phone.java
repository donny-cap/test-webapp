package com.springboot.testwebapp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "phone")
public class Phone {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "phone")
	private int phone;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) // Связь с таблицей User
	private User user;


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
