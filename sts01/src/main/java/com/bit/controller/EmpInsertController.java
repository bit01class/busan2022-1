package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.asm.commons.EmptyVisitor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.Emp01Dao;
import com.bit.model.Emp02Dao;
import com.bit.model.EmpVo;

public class EmpInsertController implements Controller {
	Emp02Dao dao=new Emp02Dao();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		request.setCharacterEncoding("utf-8");		
		EmpVo bean=new EmpVo(
				Integer.parseInt(request.getParameter("empno"))
				,request.getParameter("ename")
				,Integer.parseInt(request.getParameter("sal"))
				,request.getParameter("job")
				);
		if("POST".equals(request.getMethod())) {
			
			dao.insertOne(bean);
			mav.setViewName("redirect:list.bit");
//			mav.addObject("list", dao.selectAll());
//			mav.setViewName("emp/list");
		}else {
			mav.setViewName("emp/add");
		}
		return mav;
	}

}
