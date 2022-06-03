package com.bit.frame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.frame.model.EmpDao;
import com.bit.frame.model.EmpVo;

public class InsertController extends AbstractCommandController {
	@Autowired
	EmpDao empDao;

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println(errors.hasErrors());
		EmpVo bean=(EmpVo) command;
		empDao.insertOne(bean);
		return new ModelAndView("redirect:list");
	}

	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		EmpVo bean=(EmpVo) command;
		if(bean.getEname().isEmpty()) {
			
			ObjectError error=new ObjectError("ename", "이름이 비었음");
			errors.addError(error);
		}
			
		System.out.println(errors);
	}
}
