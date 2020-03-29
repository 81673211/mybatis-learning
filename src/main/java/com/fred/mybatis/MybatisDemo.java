package com.fred.mybatis;

import com.fred.mybatis.dao.UserMapper;
import com.fred.mybatis.domain.User;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@Component
public class MybatisDemo {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    public void foo() {
        like();
    }

    private void batchInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Arrays.asList("a","b", "c").forEach(name -> {
                User user = new User();
                user.setName(name);
                mapper.insert(user);
                System.out.println(user.getId() + " " + user.getName());
            });
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    private void like() {
        Optional.ofNullable(userMapper.like("fred")).ifPresent(users -> users.forEach(user -> System.out.println(user.getId() + " " + user.getName())));
    }

    private void get() {
        Optional.ofNullable(userMapper.get(1)).ifPresent(user -> System.out.println(user.getId() + " " + user.getName()));
    }

    private void list() {
        Optional.ofNullable(userMapper.list()).ifPresent(users -> users.forEach(user -> System.out.println(user.getId() + " " + user.getName())));
    }
}
