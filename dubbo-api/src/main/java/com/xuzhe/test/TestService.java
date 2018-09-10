package com.xuzhe.test;

import com.xuzhe.api.User;

/**
 * 提供API接口
 */
public interface TestService {

    String sayHello(String str);

    User findUser();
}