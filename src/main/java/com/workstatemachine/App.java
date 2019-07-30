package com.workstatemachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * describe:
 *
 * @author hongxiao.shou
 * @date 2019/07/25
 */
@SpringBootApplication()
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

    }
}
