package com.itheima.service;

import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTestCase {

  @Autowired
  private UserService UserServiceImpl2;

  @Test
  void save(){
    User user = new User();
    user.setUsername("测试Service1234");
    user.setPassword("678");
    user.setEmail("123123@qq.com");
    user.setPhoneNum("19999898988");
    UserServiceImpl2.save(user);
  }

  @Test
  void testGetById(){
    User user = UserServiceImpl2.getById(7);
    System.out.println(user);
  }
}
