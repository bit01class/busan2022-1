package com.bit.sts25.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bit.sts25.domain.Emp;
import com.bit.sts25.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiServiceImpl {
	final SqlSessionTemplate template;
	final EmpMapper empMapper;
	
	public List<Emp> selectAll(){
		log.debug(template!=null?template.toString():"주입실패");

		return empMapper.findAll();
	}
	
	public String selectCount() {
//		return template.getMapper(EmpMapper.class).findSize()+"";
		return empMapper.findSize()+"";
	}

	public Emp selectOne(int sabun) {
		return empMapper.findOne(sabun);
	}
	
	public boolean insertOne(Emp emp) {
		return empMapper.insertOne(emp)>0?true:false;
	}
	
	public Emp updateOne(Emp emp) {
		if(empMapper.updateOne(emp)>0)
			return emp;
		return null;
	}
	
	public Emp deleteOne(int sabun) {
		Emp target=selectOne(sabun);
		if(target!=null) empMapper.deleteOne(sabun);
		return target;
	}
}














