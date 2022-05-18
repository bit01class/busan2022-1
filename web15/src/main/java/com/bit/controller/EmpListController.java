package com.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class EmpListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// model
		EmpDao dao=new EmpDao();
		List<EmpDto>list=dao.getList();
		//view
		RequestDispatcher rd=req.getRequestDispatcher("list.jsp");
		req.setAttribute("list", list); // request scope 속성값으로 전달
		rd.forward(req, resp);
	}
}










