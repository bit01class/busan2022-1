package com.bit.sts07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts07.domain.DeptDao;
import com.bit.sts07.domain.DeptVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	DeptDao deptDao;
	
	@GetMapping("/")
	public String list(Model model) throws Exception {
		model.addAttribute("list", deptDao.findAll());
		return "list";
	}
	
	@PostMapping("/")
	public String insert(@ModelAttribute DeptVo bean) throws Exception {
		deptDao.insertOne(bean);
		return "redirect:./";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@GetMapping("/{1}")
	public String detail(@PathVariable("1") int deptno,Model model) throws Exception {
		model.addAttribute("bean", deptDao.findOne(deptno));
		return "detail";
	}
	@GetMapping("/{1}/edit")
	public String edit(@PathVariable("1") int deptno,Model model) throws Exception {
		model.addAttribute("bean", deptDao.findOne(deptno));
		return "edit";
	}
	@PutMapping("/{1}")
	public String update(@PathVariable("1") int deptno,@ModelAttribute DeptVo bean) throws Exception {
		log.info(bean.toString());
		deptDao.updateOne(bean);
		return "redirect:./"+deptno;
	}
	
	@DeleteMapping("/{deptno}")
	public String delete(@PathVariable int deptno) throws Exception {
		deptDao.deleteOne(deptno);
		return "redirect:./";
	}
	
	
}




















