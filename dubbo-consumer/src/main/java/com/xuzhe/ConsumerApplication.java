package com.xuzhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
使用spring boot专用dubbo就不用这样配置
@ImportResource({"classpath:dubbo.xml"})
 */
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}