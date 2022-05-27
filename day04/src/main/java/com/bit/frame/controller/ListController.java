package com.bit.frame.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.frame.model.EmpDao;
import com.bit.frame.util.MyController;

public class ListController implements MyController{

	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpDao dao=new EmpDao();
		try {
			req.setAttribute("list", dao.selectAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "emp/list";
	}
}
