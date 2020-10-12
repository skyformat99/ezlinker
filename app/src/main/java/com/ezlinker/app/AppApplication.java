package com.ezlinker.app;

import com.ezlinker.app.common.utils.AliyunMailProperties;
import lombok.extern.java.Log;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author wangwenhai
 */

@EnableScheduling
@MapperScan(basePackages = "com.ezlinker.app.modules.*.mapper")
@SpringBootApplication(scanBasePackages = {"com.ezlinker.*"})
@EnableConfigurationProperties({AliyunMailProperties.class})
@EnableWebSocketMessageBroker
@EnableWebSocket
@EnableWebMvc
@Log
public class AppApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }


    @Override
    public void run(String... args) {
        log.info("------------------------------------");
        log.info("<'_'> EZLINKER started successfully!");
        log.info("------------------------------------");

    }

}
