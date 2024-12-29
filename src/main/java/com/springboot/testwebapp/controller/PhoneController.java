package com.springboot.testwebapp.controller;

import com.springboot.testwebapp.model.Phone;
import com.springboot.testwebapp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneController {

	@Autowired
	private PhoneService phoneService;
	
	// Показать лист юзеров
	@GetMapping("/viewPhonePage")
	public String viewPhonePage(Model model) {
		model.addAttribute("listPhones",phoneService.getAllPhones());
		return "phone";
	}

	@GetMapping("/showNewPhoneForm")
	public String showNewPhoneForm(Model model) {
		//создать атрибут модели для привязки данных формы
		Phone phone = new Phone();
		model.addAttribute("phone", phone);
		return "new_phone";
	}

	@PostMapping("/savePhone")
	public String savePhone(@ModelAttribute("phone") Phone phone) {
		// сохранить телефон в базе данных
		phoneService.savePhone(phone);
		return "redirect:/viewPhonePage";
	}

	@GetMapping("/showFormForUpdatePhone/{id}")
	public String showFormForUpdatePhone(@PathVariable ( value = "id") long id, Model model) {

		// получить телефон из сервиса
		Phone phone = phoneService.getPhoneById(id);

		// установите телефон как атрибут модели для предварительного заполнения формы
		model.addAttribute("phone", phone);
		return "update_phone";
	}

	@GetMapping("/deletePhone/{id}")
	public String deletePhone(@PathVariable (value = "id") long id) {

		// метод удаления вызова телефона
		this.phoneService.deletePhoneById(id);
		return "redirect:/viewPhonePage";
	}

}
