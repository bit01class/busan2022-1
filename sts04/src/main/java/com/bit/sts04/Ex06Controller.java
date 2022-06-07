package com.bit.sts04;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex06Controller {

	@RequestMapping("/ex06")
	public void ex06(HttpServletResponse res,HttpServletRequest req) throws IOException {
		res.getWriter().print("<h1>ex06 page</h1>");
	}
}
