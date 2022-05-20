package com.bit.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

@WebServlet("/emp/list.html")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		List<EmpDto> list=dao.selectAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}
}
