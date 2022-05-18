package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class EmpOneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("idx"));
		//model
		EmpDao dao=new EmpDao();
		EmpDto bean=dao.getOne(empno);
		req.setAttribute("emp", bean);
		//view
		RequestDispatcher rd=req.getRequestDispatcher("emp.jsp");
		rd.forward(req, resp);
	}
}
