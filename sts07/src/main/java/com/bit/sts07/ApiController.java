package com.bit.sts07;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts07.domain.EmpDao;
import com.bit.sts07.domain.EmpVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	EmpDao empDao;

	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		Map<String,Object> map=new HashMap<>();
		map.put("empno", 1111);
		map.put("ename", "tester");
		map.put("arr", new ArrayList());
		return new EmpVo();
	}
	
//	@RequestMapping(value = "/emp",method = RequestMethod.GET)
	@GetMapping("/emp")
	@ResponseBody
	public List<EmpVo> list() throws SQLException{
		List<EmpVo> list= empDao.findAll();
		return list;
	}
	
	@PostMapping("/emp")
	@ResponseBody
	public void add(@ModelAttribute EmpVo bean) throws SQLException {
		log.info(bean.toString());
		empDao.insertOne(bean);
	}
	
	@GetMapping("/emp/{empno}")
	@ResponseBody
	public EmpVo detail(@PathVariable int empno) throws SQLException {
		EmpVo bean=empDao.findOne(empno);
		return bean;
	}
	
	@PutMapping("/emp/{empno}")
	@ResponseBody
	public void update(@PathVariable int empno) {
		log.info("update:"+empno);
	}
}


















