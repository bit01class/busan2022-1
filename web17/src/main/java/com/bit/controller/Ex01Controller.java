package com.bit.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName=getServletConfig().getInitParameter("viewName");
		String param1=this.getInitParameter("param1");
		String param2=this.getInitParameter("param2");
		System.out.println("web xml mapping servlet... Ex01 param1=:"+param1);
		System.out.println("web xml mapping servlet... Ex01 param2=:"+param2);
		Enumeration<String> names=getInitParameterNames();
		while(names.hasMoreElements()) {
			String name=names.nextElement();
			System.out.println(name+":"+getInitParameter(name));
		}
		System.out.println("-------context-----------------");
		String cparam1=req.getServletContext().getInitParameter("cname1");
		System.out.println("Ex01 context param: cname1="+cparam1);
		req.getRequestDispatcher(viewName+".jsp").forward(req, resp);
	}
}
