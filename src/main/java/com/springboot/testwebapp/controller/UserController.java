package com.springboot.testwebapp.controller;

import com.springboot.testwebapp.model.User;
import com.springboot.testwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	// отобразить список пользователей
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listUsers",userService.getAllUsers());
		return "index";
	}

	@GetMapping("/showNewUserForm")
	public String showNewUserForm(Model model) {
		// создать атрибут модели для привязки данных формы
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}



	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user, Model model) {
		// сохранить сотрудника в базе данных

		if (!user.isAdult()) {
			model.addAttribute("error", "User must be at least 18 years old.");
			return "new_user";
		}
		userService.saveUser(user);

		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// получить пользователя из сервиса
		User user = userService.getUserById(id);
		
		// установить пользователя как атрибут модели для предварительного заполнения формы
		model.addAttribute("user", user);
		return "update_user";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable (value = "id") long id) {
		
		// вызов метода удаления сотрудника
		this.userService.deleteUserById(id);
		return "redirect:/";
	}

}
