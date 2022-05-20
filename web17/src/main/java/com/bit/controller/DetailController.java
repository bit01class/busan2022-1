package com.bit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

@WebServlet("/emp/detail.html")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx=req.getParameter("idx");
		EmpDao dao=new EmpDao();
		req.setAttribute("bean", dao.selectOne(idx));
		req.getRequestDispatcher("../detail.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String,String[]> params=req.getParameterMap(); 
		EmpDao dao=new EmpDao();
		dao.updateOne(params);
		doGet(req,resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("put method..."+req.getParameter("idx"));
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String msg=br.readLine();
		EmpDao dao=new EmpDao();
		dao.deleteOne(msg);
	}
}








