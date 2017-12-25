package org.yamikaze.spring.mvc.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yamikaze.spring.mvc.study.annotation.UserAnnotation;
import org.yamikaze.spring.mvc.study.entity.User;

/**
 * @author yamikaze
 * @date 2017/12/23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("resolver")
    @ResponseBody
    public String testResolver(@UserAnnotation User user) {
        System.out.println(user);
        return "ok";
    }
}
