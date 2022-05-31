package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp01Dao;
import com.bit.model.Emp02Dao;
import com.bit.model.Emp03Dao;

public class EmpListController implements Controller {
	Emp03Dao dao=new Emp03Dao();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("emp/list");
		mav.addObject("list", dao.selectAll());
		return mav;
	}

}
