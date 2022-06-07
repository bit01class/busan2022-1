package com.bit.sts04.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts04.model.EmpDao;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	@Autowired
	EmpDao empDao;

	@RequestMapping("list")
	public void list(Model model) throws SQLException {
		model.addAttribute("list", empDao.findAll());
	}
}
