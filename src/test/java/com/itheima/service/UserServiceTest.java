package com.itheima.service;

import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

  @Autowired
  private IUserService UserServiceImpl;

  @Test
  void testGetById(){
    User user = UserServiceImpl.getById(1);
    System.out.println(user);
  }
}
