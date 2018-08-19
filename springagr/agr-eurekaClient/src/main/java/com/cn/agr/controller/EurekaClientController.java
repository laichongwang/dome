package com.cn.agr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaClientController {

    @RequestMapping(value = "/hi")
    public String home( String name) {
        return name;
    }

}
