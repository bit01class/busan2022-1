package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.util.BitMy;

public class EmpOneController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empno=Integer.parseInt(req.getParameter("empno"));
		String sql="select * from emp where empno="+empno;
		
		resp.setContentType("application/json");
		PrintWriter pw=resp.getWriter();
		pw.print("{\"emp\":[{");
		try(
			Connection conn=BitMy.getConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		){
			if(rs.next()) {
				pw.print("\"empno\":"+rs.getInt("empno"));
				pw.print(",\"ename\":\""+rs.getString("ename")+"\"");
				pw.print(",\"sal\":"+rs.getInt("sal"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pw.print("}]}");
	}
}













