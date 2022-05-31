package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp02Dao;

public class EmpDetailController implements Controller {
	Emp02Dao dao=new Emp02Dao();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("bean", dao.selectOne(Integer.parseInt(request.getParameter("empno"))));
		mav.setViewName("emp/detail");
		return mav;
	}

}
