package com.bit.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.util.BitMy;

public class EmpUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String[] param= {
				req.getParameter("empno"),
				req.getParameter("ename"),
				req.getParameter("sal")
		};
		try(
			Connection conn=BitMy.getConnection();	
			Statement stmt=conn.createStatement();
		){
			int empno=Integer.parseInt(param[0].trim());
			String ename=param[1].trim();
			int sal=Integer.parseInt(param[2].trim());
			String sql="update emp set ename='"+ename+"', sal="+sal+" where empno="+empno;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (NumberFormatException e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}






