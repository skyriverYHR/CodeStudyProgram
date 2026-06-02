package io.github.skyriveryhr.springbootstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Stack;

/**
 * RestController 告诉你这是用来返回数据而不是html
 * SpringBootApplication 结合了三个注解 --> @SpringBootConfiguration 、 @EnableAutoConfiguration 和 @ComponentScan
 */
@RestController
@SpringBootApplication
//**扫描所有子包
@MapperScan("io.github.skyriveryhr.springbootstudy.mapper.**")
public class SpringBootStudyApplication {
    @Value("${school.name}")
    String name;
    @Value("${my.name}")
    String myName;
    @Value("${my.id}")
    String myId;


    @RequestMapping("/")
    public String home() {
        return "hello world" + name + " " + myName + " " + myId;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }

}
