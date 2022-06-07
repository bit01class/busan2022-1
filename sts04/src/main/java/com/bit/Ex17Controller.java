package com.bit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

//@Controller
public class Ex17Controller {

	@RequestMapping("/ex17")
	public String ex17() {
		return "ex01";
	}
}
