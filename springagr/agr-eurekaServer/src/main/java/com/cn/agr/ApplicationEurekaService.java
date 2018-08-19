package com.cn.agr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApplicationEurekaService {

    public static void main(String[] agr){
        SpringApplication.run(ApplicationEurekaService.class,agr);
    }

}
