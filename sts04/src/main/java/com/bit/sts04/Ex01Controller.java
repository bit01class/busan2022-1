package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ex01Controller {
	
	@RequestMapping("/ex01")
	public ModelAndView ex01(HttpServletRequest req,HttpServletResponse res) {
		
		return new ModelAndView("ex01","msg","hello");
	}
}
