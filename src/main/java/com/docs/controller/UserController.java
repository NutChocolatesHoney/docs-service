package com.docs.controller;

import com.docs.common.ApiDataResultHelper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/user")
public class UserController {

    @GetMapping("/visitFlag")
    @ApiOperation("用户是否访问")
    ApiDataResultHelper<Boolean> visitFlag(){
        return new ApiDataResultHelper(Boolean.TRUE);
    }
}
