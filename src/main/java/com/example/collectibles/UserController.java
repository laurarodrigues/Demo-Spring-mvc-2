package com.example.collectibles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.collectibles.beans.User_;
import com.example.collectibles.dao.UserRepository;
import com.example.collectibles.validators.UserValidator;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private UserValidator userValidator;
	private UserRepository userRepository;
	
	
	
	
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@InitBinder
	public void bindUser(WebDataBinder binder) {
		
		binder.addValidators(this.userValidator);
	}

	@GetMapping("/newUser")
	public String displayRequistrationForm(Model model) {
		model.addAttribute("user", new User_());
		return "register-user";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid User_ user, BindingResult result, Model model) {
		//Validate & save to DB
		if(result.hasErrors()) {
		return "register-user";
		}
		
		User_ savedUser = userRepository.save(user);
		if(savedUser != null) {
			model.addAttribute("userSaved", true);
		}
		return "register-user";
	}

}
