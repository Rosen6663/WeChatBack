package com.attend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WxCloudRunApplication {

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}