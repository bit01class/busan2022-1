package com.bit.framework;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.controller.IndexController;
import com.bit.emp.controller.ListController;


public class DispatcherServlet extends HttpServlet {
	Map<String,BitController> cmap=new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		cmap.put("/index.bit", new IndexController());
		cmap.put("/emp/index.bit", new ListController());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	public void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dispatcher start..");
		
		String url=req.getRequestURI().substring(req.getContextPath().length());
		
		BitController controller=null;
		controller=cmap.get(url);
		
		String viewName="";
		try {
			viewName=controller.execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SimpleViewResolver resolver=new SimpleViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.viewResolver(viewName,req,resp);
	}
	
}













