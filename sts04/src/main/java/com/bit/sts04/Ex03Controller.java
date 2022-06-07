package com.bit.sts04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex03Controller {

	@RequestMapping("/ex03")
	public String ex03(HttpServletRequest req,HttpServletResponse res) {
		req.setAttribute("msg", "ex03 page...");
		return "ex01";
	}
}
