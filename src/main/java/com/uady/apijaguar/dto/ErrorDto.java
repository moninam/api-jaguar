package com.uady.apijaguar.dto;

public class ErrorDto {
    private int code;
    private String message;
  
    public ErrorDto() {
    }
  
    public String getMessage() {
      return this.message;
    }
  
    public void setMessage(String message) {
      this.message = message;
    }
  
    public int getCode() {
      return this.code;
    }
  
    public void setCode(int code) {
      this.code = code;
    }
}
