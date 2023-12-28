package dev.harolds.springbootmicroservice2compra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootMicroservice2CompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice2CompraApplication.class, args);
	}

}
