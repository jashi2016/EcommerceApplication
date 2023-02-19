package com.kiran.ecommerce.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcommerceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EcommerceCustomException.class)
    @ResponseBody
    public String handleEcommerceCustomException(EcommerceCustomException ecommerceCustomException){
        return ecommerceCustomException.getMessage();
    }
}
