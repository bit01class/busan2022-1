package com.bit.sts05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit.sts05.service.MyModule;

public class App {

	public static void main(String[] args) {
		ApplicationContext ac=null;
		ac=new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		MyModule module=ac.getBean(MyModule.class);
		
		module.func01();
		
//		module.func02(1234);
		
//		System.out.println(module.func03());
//		String msg=module.func03();
//		System.out.println(msg);
		
//		module.func04();
	}

}
