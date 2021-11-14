package com.webmuffins.rtsx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class RtGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtGatewayApplication.class, args);
    }

}
