package com.example.demo.exception;

import com.example.demo.model.MyResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;




@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public MyResult bindExceptionHandle(BindException e){
        FieldError fieldError = e.getBindingResult().getFieldError();
        MyResult result=new MyResult();
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMsg(fieldError.getDefaultMessage());
        result.setObj(fieldError.getObjectName()+"."+fieldError.getField());
        return result;

    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public MyResult  methodArgumentExceptionHandle(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        FieldError fieldError = bindingResult.getFieldError();
        MyResult result=new MyResult();
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMsg(fieldError.getDefaultMessage());
        result.setObj(fieldError.getObjectName()+"."+fieldError.getField());
        return result;
    }

}
