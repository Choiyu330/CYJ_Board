package com.java.CYJ_Board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CyjBoardApplication {
	public static void main(String[] args) {
		SpringApplication.run(CyjBoardApplication.class, args);
	}
}
