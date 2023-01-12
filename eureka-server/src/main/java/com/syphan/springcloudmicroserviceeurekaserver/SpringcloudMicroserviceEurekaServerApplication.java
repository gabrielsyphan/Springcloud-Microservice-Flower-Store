package com.syphan.springcloudmicroserviceeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudMicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudMicroserviceEurekaServerApplication.class, args);
	}

}
