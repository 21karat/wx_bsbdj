package com.karat.cn.impl;


import com.karat.cn.service.UserService;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Override
    public String hello() {
        return "hello dubbo";
    }
}
