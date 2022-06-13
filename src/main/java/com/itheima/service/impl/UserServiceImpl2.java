package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserServiceImpl2")
public class UserServiceImpl2 implements UserService {

  @Autowired
  private UserDao userDao;

  @Override
  public Boolean save(User user) {
    return userDao.insert(user) > 0;
  }

  @Override
  public Boolean update(User user) {
    return userDao.updateById(user) > 0;
  }

  @Override
  public Boolean delete(Integer id) {
    return userDao.deleteById(id) > 0;
  }

  @Override
  public User getById(Integer id) {
    return userDao.selectById(id);
  }

  @Override
  public List<User> getAll() {
    return userDao.selectList(null);
  }
}
