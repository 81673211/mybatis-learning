package com.fred.mybatis;


import com.fred.mybatis.dao.UserMapper;
import com.fred.mybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/create")
    public void create(String name) {
        userMapper.get(1);
    }
}
