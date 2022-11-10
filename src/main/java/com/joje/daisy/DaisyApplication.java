package com.joje.daisy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ServletComponentScan
@EnableAspectJAutoProxy
@SpringBootApplication
public class DaisyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaisyApplication.class, args);
	}

}
