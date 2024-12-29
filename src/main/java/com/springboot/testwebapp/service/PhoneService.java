package com.springboot.testwebapp.service;

import com.springboot.testwebapp.model.Phone;

import java.util.List;

public interface PhoneService {
	List<Phone> getAllPhones();
	void savePhone(Phone phone);
	Phone getPhoneById(long id);
	void deletePhoneById(long id);
}
