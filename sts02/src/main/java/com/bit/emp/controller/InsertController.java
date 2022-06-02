package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpVo;

public class InsertController implements Controller {
	EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse response) throws Exception {
		empDao.insertOne(new EmpVo(
				Integer.parseInt(req.getParameter("empno")),
				Integer.parseInt(req.getParameter("sal")),
				req.getParameter("ename"),
				req.getParameter("job"),
				null
				));
		return new ModelAndView("redirect:list.bit");
	}

}
