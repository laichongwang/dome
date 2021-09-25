package com.cn.agr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cn.agr"})
public class ApplicationApi {

    public static void main(String[] agr) {
        SpringApplication.run(ApplicationApi.class, agr);
        System.out.println("run success:" + "agrApi");
    }
}