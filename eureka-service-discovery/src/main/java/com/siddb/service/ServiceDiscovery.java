package com.siddb.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceDiscovery {
  public static void main(String[] args) {
    SpringApplication.run(ServiceDiscovery.class, args);
  }
}
