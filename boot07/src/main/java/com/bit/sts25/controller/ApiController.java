package com.bit.sts25.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts25.domain.Emp;
import com.bit.sts25.service.ApiServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	ApiServiceImpl apiService;

	@GetMapping("/emp")
	public ResponseEntity<?> getList(){
//		ResponseEntity entity=new ResponseEntity(apiService.selectAll(),HttpStatus.OK);
//		ResponseEntity entity=ResponseEntity.ok(apiService.selectAll());
//		ResponseEntity entity=ResponseEntity.ok().body(apiService.selectAll());
		ResponseEntity entity=ResponseEntity
								.status(HttpStatus.OK)
								.body(apiService.selectAll());
		System.out.println(entity);
		return entity;
	}
	
	@GetMapping("/size")
	public String getSize() {
		return apiService.selectCount();
	}
	
	@GetMapping("/emp/{sabun}")
	public ResponseEntity<?> getObjectList(@PathVariable int sabun){
		return ResponseEntity.ok(apiService.selectOne(sabun));
	}
	
	@PostMapping("/emp")
	public ResponseEntity<?> addList(@RequestBody Emp emp){
		if(apiService.insertOne(emp))
			return ResponseEntity.ok(emp);
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/emp/{sabun}")
	public ResponseEntity<?> setList(@RequestBody Emp emp){
		return ResponseEntity.ok(apiService.updateOne(emp));
	}
	
	@DeleteMapping("/emp/{sabun}")
	public ResponseEntity<?> rmlist(@PathVariable int sabun){
		return ResponseEntity.ok(apiService.deleteOne(sabun));
	}
	
	@PostMapping("/")
	public void head(@RequestHeader("cors") String key) {
		System.out.println(key);
	}
}












