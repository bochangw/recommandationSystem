package com.bowang.recommandationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RecommandationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecommandationSystemApplication.class, args);
	}

}
