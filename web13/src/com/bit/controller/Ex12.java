package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDto;

public class Ex12 extends HttpServlet {
	public static ArrayList<EmpDto> list=new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
//		for(int i=1; i<5; i++) {
//			EmpDto bean=new EmpDto();
//			bean.setEmpno(1111*i);
//			bean.setEname("test"+i);
//			bean.setSal(1000);
//			list.add(bean);
//		}
		//
		
		PrintWriter pw=null;
		try{
			pw=resp.getWriter();
			pw.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			pw.println("<emp>");
			for(EmpDto bean:list) {
				pw.println("	<row>");
				pw.println("		<empno>"+bean.getEmpno()+"</empno>");
				pw.println("		<ename>"+bean.getEname()+"</ename>");
				pw.println("		<sal>"+bean.getSal()+"</sal>");
				pw.println("	</row>");
			}
			pw.println("</emp>");
		}finally {
			pw.close();
		}
		
	}
}














