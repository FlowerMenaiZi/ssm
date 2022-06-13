package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTestCase {

  @Autowired
  private UserDao userDao;

  @Test
  void testGetByUser(){
//    System.out.println(userDao.selectList(null));

    System.out.println(userDao.selectById(1));
  }

  @Test
  void testSave(){
    User user = new User();
    user.setUsername("测试数据1234");
    user.setPassword("678");
    user.setEmail("123123@qq.com");
    user.setPhoneNum("19999898988");
    userDao.insert(user);
  }

  @Test
  void testUpdate(){
    User user = new User();
    user.setId(7);
    user.setUsername("测试数据645745");
    user.setPassword("678");
    user.setEmail("123123@qq.com");
    user.setPhoneNum("19777898988");
    userDao.updateById(user);
  }

  @Test
  void testDelete(){
    userDao.deleteById(8);
  }

  @Test
  void testGetAll(){
    System.out.println(userDao.selectList(null));
  }

  @Test
  void testGetPage(){
    IPage<User> page = new Page<User>(1,5);
    IPage<User> iPage = userDao.selectPage(page, null);
    List<User> records = iPage.getRecords();
    for (User record : records) {
      System.out.println(record);
    }
  }

  @Test
  void testGetBye(){
    QueryWrapper<User> qw = new QueryWrapper<>();
    qw.like("username","lisi");
    userDao.selectList(qw);
  }

  @Test
  void testGetBye2(){
    String name = "lisi";
    LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
    lqw.like(name != null,User::getUsername,name);
    userDao.selectList(lqw);
  }
}
