package com.infnet.victorapiparttwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VictorapiparttwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VictorapiparttwoApplication.class, args);
	}

}
