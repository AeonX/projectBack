package com.finaly.projectback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages={"com.finaly.projectback"})
public class ProjectbackApplication {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("m123"));
		
		SpringApplication.run(ProjectbackApplication.class, args);
	}
}
