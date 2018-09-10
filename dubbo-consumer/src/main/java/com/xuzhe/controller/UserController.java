package com.xuzhe.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xuzhe.api.UserService;
import com.xuzhe.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("list")
    public List<UserEntity> list() {
        return userService.list();
    }

    @GetMapping("add")
    public String add() {
        return userService.add();
    }

}