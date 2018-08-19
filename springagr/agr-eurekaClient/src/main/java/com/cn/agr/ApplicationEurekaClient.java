package com.cn.agr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApplicationEurekaClient {

    public static void main(String[] agr) {
        SpringApplication.run(ApplicationEurekaClient.class, agr);
    }

}
