package com.itheima.util;

public class R {
  public static final int SUCCESS = 6200;
  public static final int ERROR = 6400;
  public static final int NOTFOUND = 6404;
  public static final int SERVERERROR = 6500;

  private int code;
  private Object data;
  private String message;

  public R() {
  }

  public R(int code,  String message) {
    this.code = code;
    this.message = message;
  }

  public R(int code,  String message, Object data) {
    this.code = code;
    this.data = data;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
