package com.xuzhe.api;

import com.xuzhe.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> list();
    List<UserEntity> select();
    String add();
    List<UserEntity> age();
    String deleteWhere();
    List<UserEntity> cutPage(int page);
}