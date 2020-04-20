package com.lsf.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by Administrator on 2020/3/11.
 */
@SpringBootApplication
//@ImportResource({"config/spring-dubbo.xml"})
//@ImportResource({"spring/spring*.xml"})
@MapperScan(annotationClass = Repository.class, basePackages = "com.lsf.test.mybatis.mapper")
public class ApplictionStart {


    public static void main(String[] args) {
        SpringApplication.run(ApplictionStart.class, args);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
