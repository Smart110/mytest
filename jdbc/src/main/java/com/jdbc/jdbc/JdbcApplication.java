package com.jdbc.jdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jdbc.Controller.StudentController;

@SpringBootApplication
public class JdbcApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(StudentController.class, args);
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
	     FastJsonConfig fastJsonConfig=new  FastJsonConfig();
	     fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
	     fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
	     converters.add(fastJsonHttpMessageConverter);
	}
	
}