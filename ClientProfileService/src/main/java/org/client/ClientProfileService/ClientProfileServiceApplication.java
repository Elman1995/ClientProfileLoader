package org.client.ClientProfileService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ClientProfileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientProfileServiceApplication.class, args);
	}

}
