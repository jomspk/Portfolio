package com.example.Portfolio.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {
	@GetMapping
	public String home(Model model) {
		return "portfolio/home";
	}

	@GetMapping("/product")
	public String product(Model model) {
		return "portfolio/product";
	}

	@GetMapping("/english")
	public String english(Model model) {
		return "portfolio/english";
	}

	@GetMapping("/books")
	public String books(Model model) {
		return "portfolio/books";
	}

	@GetMapping("/business")
	public String business(Model model) {
		return "portfolio/business";
	}

	@GetMapping("/about_me")
	public String about_me(Model model) {
		return "portfolio/about_me";
	}
	/*
	 * @GetMapping("hello") public String hello(Model model) { return "hello"; }
	 * 
	 * @GetMapping("loginForm") public String loginForm(Model model) { return
	 * "loginForm"; }
	 */
	@GetMapping("/hello")
	public String hello(Model model) { 
		return "hello"; 
	}
	@PostMapping("/hello")
	public String formGoBack(Model model) {
		System.out.println("helloページが要求された");
		return "hello";
	}
	@GetMapping("/loginForm")
	public String loginForm(Model model) { 
		System.out.println("loginFormが要求された");
		return "portfolio/loginForm";
	}
}
