package com.tencent.wxcloudrun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Test {
    @PostMapping("/test")
    public String test() {
        return "test";
    }
}
