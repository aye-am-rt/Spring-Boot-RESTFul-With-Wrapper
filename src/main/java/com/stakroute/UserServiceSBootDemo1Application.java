package com.stakroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class UserServiceSBootDemo1Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(UserServiceSBootDemo1Application.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserServiceSBootDemo1Application.class);
	}

	private static Class<UserServiceSBootDemo1Application> applicationClass = UserServiceSBootDemo1Application.class;

}
