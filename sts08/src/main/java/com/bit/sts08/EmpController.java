package com.bit.sts08;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts08.domain.Emp;
import com.bit.sts08.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	@Autowired
	HttpSession session;

	@GetMapping("/emp/")
	public String list(Model model) {
		System.out.println(session.getId());
		empService.selectAll(model);
		return "list";
	}
	
	@GetMapping("/emp/add")
	public String add() {return "add";}
	
	@PostMapping("/emp/")
	public String add(@ModelAttribute("bean") Emp bean,Model model) {
		try {
			empService.insert(bean);
			return "redirect:./";
		}catch (Exception e) {
			model.addAttribute("err", e);
			return "add";
		}
	}
	
	@GetMapping("/emp/{empno}")
	public String detail(@PathVariable int empno,Model model) {
		model.addAttribute("bean", empService.detail(empno));
		return "detail";
	}
	
	@PutMapping("/emp/{empno}")
	public String update(@PathVariable int empno,@ModelAttribute Emp bean) {
		empService.update(bean);
		return "redirect:./"+empno;
	}
	
	@GetMapping("/login/")
	public String login() {
		return "login";
	}
	@PostMapping("/login/")
	public String login(@ModelAttribute Emp bean) {
		if(empService.login(bean)) return "redirect:../";
		return "login";
	}
	@RequestMapping("/logout/")
	public String logout() {
		empService.logout();
		return "redirect:../";
	}
}













