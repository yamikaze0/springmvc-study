package org.yamikaze.spring.mvc.study.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 另一种方式是继承AbstractController，并且实现handleRequestInternal方法
 * @author qinluo
 * @date 2017/12/22
 */
public class PrimaryControllerV2 extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("这是继承AbstractController的写法!");
        return new ModelAndView("basic/cf");
    }
}
