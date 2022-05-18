package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

public class EmpDelController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("idx"));
		RequestDispatcher rd=req.getRequestDispatcher("del.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("idx"));
		EmpDao dao=new EmpDao();
		dao.deleteOne(empno);
		resp.sendRedirect("list.html");
	}
}








