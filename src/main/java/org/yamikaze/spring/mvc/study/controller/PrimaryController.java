package org.yamikaze.spring.mvc.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yamikaze
 * @date 2017/12/22
 */
public class PrimaryController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("Spring MVC最原始的写法!");
        return new ModelAndView("basic/cf");
    }
}
