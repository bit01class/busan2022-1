package com.bit.sts25.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts25.domain.Emp;

@Mapper
public interface EmpMapper {

	@Select("select * from emp")
	List<Emp> findAll();
	
	@Select("select * from emp where sabun=#{sabun}")
	Emp findOne(int sabun);
	
	@Select("select count(*) from emp")
	int findSize();
	
	@Options(keyColumn = "sabun", useGeneratedKeys = true)
	@Insert("insert into emp (ename,pay,nalja) values (#{ename},#{pay},now())")
	int insertOne(Emp emp);
	
	@Update("update emp set ename=#{ename},pay=#{pay} where sabun=#{sabun}")
	int updateOne(Emp emp);
	
	@Delete("delete from emp where sabun=#{sabun}")
	int deleteOne(int sabun);
}











