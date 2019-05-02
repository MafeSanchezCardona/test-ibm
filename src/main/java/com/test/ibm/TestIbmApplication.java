package com.test.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class TestIbmApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TestIbmApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestIbmApplication.class, args);

	}

}
