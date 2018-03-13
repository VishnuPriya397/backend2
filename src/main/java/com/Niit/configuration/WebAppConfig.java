package com.Niit.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.Niit")
public class WebAppConfig extends WebMvcConfigurerAdapter{
	
	public WebAppConfig(){
    	System.out.println("WebAppConfig");
    }
	
	 @Bean(name="multipartResolver")
	    public CommonsMultipartResolver commonsMultipartResolver() {
	    	 CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
	    	 return commonsMultipartResolver;
     }
}
