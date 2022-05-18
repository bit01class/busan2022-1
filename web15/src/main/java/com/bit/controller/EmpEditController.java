package com.bit.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;
import com.bit.model.EmpDto;

public class EmpEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("idx"));
		EmpDao dao=new EmpDao();
		EmpDto bean=dao.getOne(empno);
		req.setAttribute("emp", bean);
		RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int empno=Integer.parseInt(req.getParameter("empno"));
		String ename=req.getParameter("ename");
		int sal=Integer.parseInt(req.getParameter("sal"));
		String job=req.getParameter("job");
		Timestamp hiredate=new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String time1=req.getParameter("hiredate");
			Date time2 = sdf.parse(time1);
			hiredate=new Timestamp(time2.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		EmpDao dao=new EmpDao();
		dao.updateOne(empno,ename,sal,job,hiredate);
		resp.sendRedirect("detail.html?idx="+empno);
	}
}












