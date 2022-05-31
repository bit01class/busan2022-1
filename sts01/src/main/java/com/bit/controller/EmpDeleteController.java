package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp02Dao;

public class EmpDeleteController implements Controller {
	Logger log=Logger.getLogger(getClass());
	Emp02Dao dao=new Emp02Dao();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int empno=Integer.parseInt(request.getParameter("empno"));
		log.debug(empno);
		if(!request.getMethod().equals("POST"))
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		else
			dao.deleteOne(empno);
		return null;
	}

}
