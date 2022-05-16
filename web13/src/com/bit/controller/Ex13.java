package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDto;

public class Ex13 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int empno=Integer.parseInt(req.getParameter("empno"));
		String ename=req.getParameter("ename");
		int sal=Integer.parseInt(req.getParameter("sal"));
		
		///
		EmpDto bean=new EmpDto();
		bean.setEmpno(empno);
		bean.setEname(ename);
		bean.setSal(sal);
		Ex12.list.add(bean);
		
		resp.sendRedirect("/web13/emp.html");
		
	}
}
