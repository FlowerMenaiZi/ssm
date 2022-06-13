package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {

  @Autowired
  private UserDao userDao;

  @Override
  public IPage<User> getPage(int currentPage, int pageSize,User user) {

    LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();

    lqw.like(Strings.isNotEmpty(user.getUsername()),User::getUsername,user.getUsername());
    lqw.like(Strings.isNotEmpty(user.getEmail()),User::getEmail,user.getEmail());
    lqw.like(Strings.isNotEmpty(user.getPhoneNum()),User::getPhoneNum,user.getPhoneNum());

    return userDao.selectPage(new Page<User>(currentPage,pageSize),lqw);
  }
}
