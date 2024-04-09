package com.kunika.leaveRequestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
@EntityScan("com.kunika.leaveRequestApp.Entity")
public class LeaveRequestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveRequestAppApplication.class, args);
	}

}
