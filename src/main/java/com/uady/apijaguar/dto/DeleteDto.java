package com.uady.apijaguar.dto;

public class DeleteDto {
    private Integer code;
    private String message;

    public DeleteDto(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    //GETTERS
    public Integer getCode(){
        return this.code;
    }
    public String getMessage(){
        return this.message;
    }

    //SETTERS
    public void setCode(Integer code){
        this.code = code;
    }
    public void setMessage(String message){
        this.message = message;
    }
}
