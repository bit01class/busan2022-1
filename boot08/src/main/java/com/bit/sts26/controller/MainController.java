package com.bit.sts26.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.type.NullType;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bit.sts26.domain.Emp;

@RestController
public class MainController {
	String apiPath="http://localhost:8070/api/emp";

	@GetMapping("/list")
	public ResponseEntity<String> list() throws URISyntaxException{
		URI url=new URI(apiPath);
		
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class);
		return entity;
	}
	@GetMapping("/list/{num}")
	public ResponseEntity<?> One(@PathVariable int num) throws URISyntaxException{
		URI url=new URI(apiPath+"/"+num);
		
		RestTemplate template=new RestTemplate();
//		String result = template.getForObject(url,String.class);
//		return ResponseEntity.ok(result);
//		ResponseEntity<String> result = template.getForEntity(url, String.class);
//		return result;
		ResponseEntity<String> result = template.exchange(url, HttpMethod.GET, null, String.class);
		return result;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add() throws URISyntaxException{
		URI url=new URI(apiPath);
		
		RestTemplate template=new RestTemplate();
		
//		LinkedMultiValueMap header=new LinkedMultiValueMap<>();
//		header.add("Content-Type", "application/json");  //Content-Type: application/json
		
		HashMap<String, Object> params=new HashMap<>();
		params.put("ename", "rest5");
		params.put("pay", "5555");
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		
//		HttpEntity entity=new HttpEntity<>(params);
//		HttpEntity entity=new HttpEntity<>(params,headers);
//		HttpEntity entity=new HttpEntity<>(new Emp(0,1000,"test",null),headers);
//		return template.postForEntity(url, entity, String.class);
//		ResponseEntity<String> result = template.postForEntity(url, params, String.class);
//		return result;
		Map result = template.postForObject(url, params, Map.class);
		System.out.println(result);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> update() throws URISyntaxException{
		URI url=new URI(apiPath+"/"+1);
		
		RestTemplate template =new RestTemplate();
		
		Map<String,Object> params=new HashMap<>();
		params.put("sabun", 1);
		params.put("ename", "한글2");
		params.put("pay", 1111);
		
		template.put(url, params);
		return null;
//		RequestEntity entity=new RequestEntity(params, HttpMethod.PUT, url);
//		ResponseEntity<Void> result = template.exchange(url, HttpMethod.PUT, entity,Void.class);
	}
	
	@GetMapping("/delete/{sabun}")
	public ResponseEntity<?> delete(@PathVariable int sabun) throws URISyntaxException{
		URI url=new URI(apiPath+"/"+sabun);
		RestTemplate template=new RestTemplate();
		template.delete(url);
		return null;
	}
	
	@GetMapping("/head")
	public ResponseEntity<?> head() throws URISyntaxException{
		URI url=new URI("http://localhost:8070/api/");
		
//		Map<String,Object> header=new HashMap<>();
		MultiValueMap<String, String> header=new LinkedMultiValueMap<String, String>();
		header.add("cors", "ABCD");
		
		RestTemplate template=new RestTemplate();
		
//		HttpEntity entity=new HttpEntity(null,header);
		HttpEntity entity=new HttpEntity(header);
		template.postForEntity(url, entity, null);
		return null;
	}
}









