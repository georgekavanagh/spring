package com.georgekavanagh.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.georgekavanagh.service.demo.GenericWelcomeService;

//@Controller is the same as @ComponentScan just specifies further that it is a controller.

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping("/")
	public String doWelcome(Model model) {
		
		// 1. Retrieving the processed Data
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("George Kavanagh");
		
		// 2. Add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		// 3. Return logical view name which is resolved using InternalResourceViewResolver.
		return "welcomeNew";
		
	}
}
