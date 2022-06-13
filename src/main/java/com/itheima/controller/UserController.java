package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserService iUserService;

//  @GetMapping
//  public R getAll() {
//    List<User> userList = iUserService.list();
//    return new R(R.SUCCESS,"获取成功", userList);
//  }

  @PostMapping
  public R save(@RequestBody User user) {
    boolean save = iUserService.save(user);
    if (save){
      return new R(R.SUCCESS,"新增成功");
    }
    return new R(R.ERROR,"新增失败");
  }

  @PutMapping
  public R update(@RequestBody User user) {
    boolean update = iUserService.updateById(user);
    if (update){
      return new R(R.SUCCESS,"更新成功");
    }
    return new R(R.ERROR,"更新失败");
  }

  @DeleteMapping("/{id}")
  public R delete(@PathVariable int id) {
    boolean remove = iUserService.removeById(id);
    if (remove){
      return new R(R.SUCCESS,"更新成功");
    }
    return new R(R.ERROR,"更新失败");
  }

  @GetMapping("/{id}")
  public R getById(@PathVariable int id) {
    User user = iUserService.getById(id);
    if (user != null){
      return new R(R.SUCCESS,"获取成功",user);
    }
    return new R(R.NOTFOUND,"该用户不存在");
  }

  @GetMapping
  public R getPages(@RequestParam(value = "current",defaultValue = "1") int current,
                    @RequestParam(value = "size",defaultValue = "5") int size, User user) {
    IPage<User> page = iUserService.getPage(current, size,user);
    if (page.getCurrent() > page.getPages()){
      page = iUserService.getPage((int) page.getPages(), size,user);
    }
    return new R(R.SUCCESS,"获取成功",page);
  }
}
