package com.siddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.bootng", "com.bootng.controller"})
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {
  public static void main(String args[]) {
    SpringApplication.run(ConsumerApplication.class, args);
  }
}
