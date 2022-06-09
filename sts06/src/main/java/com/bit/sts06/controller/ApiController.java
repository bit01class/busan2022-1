package com.bit.sts06.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts06.domain.EmpDao;
import com.bit.sts06.domain.EmpVo;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	EmpDao empDao;

	@RequestMapping(value = "/emp",method = RequestMethod.GET)
	public void list(HttpServletResponse res) throws Exception {
		res.setContentType("application/json; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("{\"root\":[");
		boolean boo=true;
		for(EmpVo bean: empDao.findAll()) {
			if(boo) {
				boo=false;
			}else {
				out.print(',');
			}
			out.print("{\"empno\":"+bean.getEmpno()+",\"ename\":\""
					+bean.getEname()+"\",\"hiredate\":\""
					+(bean.getHiredate()==null?"":bean.getHiredate().getTime())+"\"}");
			
		}
		out.print("]}");
	}
}





















