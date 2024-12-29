package com.springboot.testwebapp.service;

import com.springboot.testwebapp.model.Phone;
import com.springboot.testwebapp.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public List<Phone> getAllPhones() {
		return phoneRepository.findAll();
	}

	@Override
	public void savePhone(Phone phone) {
		this.phoneRepository.save(phone);
	}

	@Override
	public Phone getPhoneById(long id) {
		Optional<Phone> optional = phoneRepository.findById(id);
		Phone phone = null;
		if (optional.isPresent()) {
			phone = optional.get();
		} else {
			throw new RuntimeException(" Phone not found for id :: " + id);
		}
		return phone;
	}

	@Override
	public void deletePhoneById(long id) {
		this.phoneRepository.deleteById(id);
	}

}
