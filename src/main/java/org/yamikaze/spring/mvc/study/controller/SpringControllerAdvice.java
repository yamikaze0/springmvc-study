package org.yamikaze.spring.mvc.study.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.yamikaze.spring.mvc.study.converter.DatePropertyConverter;
import org.yamikaze.spring.mvc.study.entity.User;

import java.util.Date;

/**
 * Spring @ControllerAdvice控制器增强
 * 1、绑定参数解析器PropertyEditor @InitBinder
 * 2、异常处理@ExceptionHandler
 * 3、@ModelAttribute
 * @author yamikaze
 * @date 2017/12/29
 */
@ControllerAdvice
public class SpringControllerAdvice {

    /**
     * 需要将servlet-pub.xml中的conversionService注释掉才能看到效果
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Date.class, new DatePropertyConverter());
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody Object exceptionHand(Exception ex) {
        return ex.getMessage();
    }

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }
}
