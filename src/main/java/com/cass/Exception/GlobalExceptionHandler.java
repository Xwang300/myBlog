package com.cass.Exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception e, HttpServletRequest request){
        ModelAndView model = new ModelAndView("/error/error");
        model.addObject("url",request.getRequestURI());
        model.addObject("message",e.getMessage());
        model.addObject("stackTrace",e.getStackTrace());
//        e.printStackTrace();
        return model;
    }
}
