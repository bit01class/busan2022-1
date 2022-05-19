package com.bit.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpDto;

public class EmpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDto bean=new EmpDto();
		bean.setEmpno(Integer.parseInt(req.getParameter("empno")));
		EmpDao dao=new EmpDao();
		try {
			bean=dao.getOne(bean.getEmpno());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("bean", bean);
		req.getRequestDispatcher("emp/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			EmpDto bean=new EmpDto();
			bean.setEmpno(Integer.parseInt(req.getParameter("empno")));
			bean.setEname(req.getParameter("ename"));
			bean.setSal(Integer.parseInt(req.getParameter("sal")));
			EmpDao dao=new EmpDao();
			dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			req.getRequestDispatcher("emp/detail.jsp").forward(req, resp);
		}
			//resp.sendRedirect("./emp.html");
		doGet(req,resp);
	}
}












