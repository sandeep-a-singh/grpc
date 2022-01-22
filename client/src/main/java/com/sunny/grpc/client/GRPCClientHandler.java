package com.sunny.grpc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GRPCClientHandler extends SpringApplication {
    private static  final Logger LOGGER = LoggerFactory.getLogger(GRPCClientHandler.class);

    public static void main(String[] args) {
        SpringApplication.run(GRPCClientHandler.class,args);
    }
}
