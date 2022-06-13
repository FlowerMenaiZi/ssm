package com.itheima.service;

import com.itheima.domain.User;

import java.util.List;

public interface UserService {
  Boolean save(User user);
  Boolean update(User user);
  Boolean delete(Integer id);
  User getById(Integer id);
  List<User> getAll();
}
