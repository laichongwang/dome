package com.cn.agr;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cn.agr"})
public class ApplicationApp {

    public static void main(String[] agr) {
        SpringApplication.run(ApplicationApp.class, agr);
        System.out.println("run success:" + "agrApi");
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 初始化转换器
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        // 初始化一个转换器配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //定义JSON格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
        // 将配置设置给转换器并添加到HttpMessageConverter转换器列表中
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(fastConvert);
    }

}
