package com.itheima.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

  @ExceptionHandler
  public R doException(Exception ex){

    return new R(R.SERVERERROR,"服务器异常");
  }
}
