package com.bit.emp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;

public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		try {
			req.setAttribute("list", dao.getList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/emp/list.jsp").forward(req, resp);		
	}
}
