package com.xuzhe.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xuzhe.test.TestService;
import com.xuzhe.api.User;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(version = "1.0.0")
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()) + ": " + str;
    }

    @Override
    public User findUser() {
        User user = new User();
        user.setId(4324);
        user.setUsername("cdscsd");
        user.setPassword("rrrrr");
        user.setAge(13);
        user.setGender(0);
        return user;
    }
}