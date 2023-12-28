package dev.harolds.springbootmicroservice1inmueble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootMicroservice1InmuebleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservice1InmuebleApplication.class, args);
	}

}
