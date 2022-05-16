package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;

public class Step08 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		System.out.println(id);
		System.out.println(new String(id.getBytes("8859_1")));
		System.out.println(URLEncoder.encode(id));
		
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter pw=resp.getWriter();
		pw.println("<html><head><meta charset=\"utf8\"><body>");
		pw.println("<h1>Post ex08 page</h1>");
		pw.println("<p>id:"+id+"</p>");
		pw.println("</body></html>");
		pw.close();
	}
}










