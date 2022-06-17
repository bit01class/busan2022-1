package com.bit.sts22.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Bean
	public HiddenHttpMethodFilter getFilter() {
		HiddenHttpMethodFilter methodFilter=new HiddenHttpMethodFilter();
		return methodFilter;
	} 
}
