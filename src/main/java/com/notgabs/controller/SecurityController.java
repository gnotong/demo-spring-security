package com.notgabs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/authenticate")
	public String process() {
		// TODO: manage user access here
		return "redirect:/";
	}
}
