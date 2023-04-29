package org.client.ClientProfileLoader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableRedisRepositories
public class ClientProfileLoaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientProfileLoaderApplication.class, args);
	}

}
