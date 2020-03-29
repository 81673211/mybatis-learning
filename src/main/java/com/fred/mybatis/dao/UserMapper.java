package com.fred.mybatis.dao;

import com.fred.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    List<User> list();

    User get(int id);

    List<User> like(String key);

    int insert(@Param("user") User user);
}
