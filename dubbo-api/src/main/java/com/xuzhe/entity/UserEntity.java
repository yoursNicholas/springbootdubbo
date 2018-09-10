package com.xuzhe.entity;

import lombok.Data;

import java.io.Serializable;
@Data

public class UserEntity extends BaseEntity implements Serializable
{
    private Long id;

    private String name;

    private int age;

    private String address;

}