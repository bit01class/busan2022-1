package com.bit.frame.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.frame.model.EmpDao;
import com.bit.frame.util.MyController;

public class AddController implements MyController {

	protected String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "emp/add";
	}
	
	protected String doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		String ename=req.getParameter("ename");
		String job=req.getParameter("job");
		int sal=Integer.parseInt(req.getParameter("sal"));
		EmpDao dao=new EmpDao();
		try {
			dao.insertOne(empno,ename,job,sal);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:list.bit";
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getMethod().equals("GET")) return doGet(req,res);
		else if(req.getMethod().equals("POST")) return doPost(req, res);
		return null;
	}
}










