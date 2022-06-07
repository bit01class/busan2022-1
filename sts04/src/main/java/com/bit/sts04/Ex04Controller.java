package com.bit.sts04;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex04Controller {

	@RequestMapping("/ex04")
	public void ex04(HttpServletRequest req,HttpServletResponse res) throws IOException {
		req.setAttribute("msg", "ex04 page...");
		res.getWriter().print("<h1>ex04 page</h1>");
	}
}
