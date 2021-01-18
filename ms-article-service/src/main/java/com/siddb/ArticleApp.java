package com.siddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.siddb"})
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ArticleApp {
	public static void main(String args[]) {
		SpringApplication.run(ArticleApp.class, args);
		
		
	}
}
