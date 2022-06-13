package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.domain.User;

public interface IUserService extends IService<User> {

  IPage<User> getPage(int currentPage,int PageSize,User user);

}
