package com.docs.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1")
public class TestController {

    @PostMapping("/test")
    @ApiOperation("1111")
    String test(){
        System.out.println("你好世界");
        return "";
    }
}
