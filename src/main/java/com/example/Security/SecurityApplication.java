package com.example.Security;

import com.example.Security.security.JwtTokenProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication  {

	public static void main (String[] args)  {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
