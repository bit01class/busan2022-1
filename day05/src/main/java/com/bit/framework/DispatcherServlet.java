package com.bit.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.controller.IndexController;
import com.bit.emp.controller.ListController;
import java.util.Properties;


public class DispatcherServlet extends HttpServlet {
	Map<String,BitController> cmap=new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		Map<String,String> handler=new HashMap<>();
		File file=new File(getServletContext().getRealPath("./")+"WEB-INF\\classes\\mapping.properties");
		
		Properties prop=new Properties();
		InputStream is=null;
		try {
			is=new FileInputStream(file);
			prop.load(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
				try {
					if(is!=null)is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		Enumeration<Object> eles = prop.keys();
		while(eles.hasMoreElements()) {
			String key=(String) eles.nextElement();
			System.out.println(key);
			handler.put(key, prop.getProperty(key));
		}
		
		Set<String> keys=handler.keySet();
		try {
			for(String key:keys)
				cmap.put(key, (BitController)(Class.forName(handler.get(key)).newInstance()));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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













