package com.notgabs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/authenticate")
	public String process() {
		// TODO: manage user access here
		System.out.println("==========> I was here");
		return "redirect:/";
	}
}
