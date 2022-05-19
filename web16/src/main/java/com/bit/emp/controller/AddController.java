package com.bit.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpDto;

public class AddController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/emp/add.jsp").forward(req, resp);
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
			dao.insertOne(bean);
		} catch (SQLException e) {
			// validation
			req.setAttribute("err", "사원번호 중복입니다");
			doGet(req,resp);
			return;
		} catch (NumberFormatException e) {
			// validation
			req.setAttribute("err", "사원번호와 연봉은 숫자로만 입력하세요");
			doGet(req,resp);
			return;
		}
		resp.sendRedirect("emp.html");
	}
}











