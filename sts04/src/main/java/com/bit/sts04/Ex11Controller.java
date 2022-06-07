package com.bit.sts04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Ex11Controller {

//	@RequestMapping(value = {"/ex11","/test11"}, method = RequestMethod.GET)
	@RequestMapping("ex11")
	public String ex11() {
		return "ex01";
	}
	@RequestMapping("ex12")
	public String ex12() {
		return "ex09";
	}
}
