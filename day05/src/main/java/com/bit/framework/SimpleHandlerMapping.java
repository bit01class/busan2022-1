package com.bit.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SimpleHandlerMapping implements BitHandlerMapping {
	Map<String,BitController> cmap=new HashMap<>();

	String path;
	
	public Map<String,BitController> getMapping(){
		return cmap;
	}
	
	public void setPath(String path) {
		this.path = path;
		mapping();
	}
	
	public Map<String,BitController> mapping(){
		Map<String,String> handler=new HashMap<>();
		File file=new File(path);
		
		Properties prop=new Properties();
		InputStream is=null;
		try {
			is=new FileInputStream(file);
			prop.load(is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
				try {
					if(is!=null)is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		Enumeration<Object> eles = prop.keys();
		while(eles.hasMoreElements()) {
			String key=(String) eles.nextElement();
			System.out.println(key);
			handler.put(key, prop.getProperty(key));
		}
		
		Set<String> keys=handler.keySet();
		try {
			for(String key:keys)
				cmap.put(key, (BitController)(Class.forName(handler.get(key)).newInstance()));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cmap;
	}
	
}
