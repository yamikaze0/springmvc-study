package org.yamikaze.spring.mvc.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yamikaze.spring.mvc.study.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * web请求的ContentType类型常用的有3种
 * 1、text/html
 *    id=1&username=123&password=123形式参数
 *
 * 2、application/x-www-form-urlencoded
 *    id=1&username=123&password=123形式参数
 *
 * 3、application/json
 *    {
 *        id : 1,
 *        username : 123,
 *        password : 123
 *    }
 *
 * 后台接收格式有两种
 * 1、普通接收(对象)
 * 2、json格式接收，对应ContentType为application/json
 *
 * 415情况1：web请求ContentType非json格式，后台json接收，出现415
 * 如果web请求ContentType为json，后台非json格式，参数映射失败
 *
 * 如果出现400错误，说明有字段的映射失败了，并不是UnSupport Media Type错误
 *
 * @author qinluo
 * @date 2017/12/21
 */
@Controller
@RequestMapping("/base")
public class CommunicationFormatController {

    @RequestMapping("/cf")
    public String index(HttpServletRequest request) {
        System.out.println(request.getContentType());
        return "basic/cf";
    }

    /**
     * web请求contentType为text/html, 接收格式为json格式
     * 参数格式为 id=1&username=xx&password=xx
     * 错误415，请求格式不支持
     */
    @RequestMapping("/thj")
    @ResponseBody
    public String thj(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    /**
     * web请求contentType为text/html, 接收格式为普通格式
     * 参数格式为 id=1&username=xx&password=xx
     * 成功，但参数映射失败
     */
    @RequestMapping("/thn")
    @ResponseBody
    public String thn(User user) {
        System.out.println(user);
        return "ok";
    }

    /**
     * web请求contentType为application/json, 接收格式为json格式
     * 参数格式为{} json格式
     * 请求成功 json - json
     */
    @RequestMapping("/jj")
    @ResponseBody
    public String jj(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    /**
     * web请求contentType为application/json, 接收格式为普通格式
     * 请求格式json
     * 成功，但参数映射失败
     */
    @RequestMapping("/jn")
    @ResponseBody
    public String jn(User user) {
        System.out.println(user);
        return "ok";
    }

    /**
     * web请求contentType为application/a-www-form-urlencoded, 接收格式为json格式
     * 参数格式与text/html一致
     * 失败：415格式不支持
     */
    @RequestMapping("/axj")
    @ResponseBody
    public String axj(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    /**
     * web请求contentType为application/a-www-form-urlencoded, 接收格式为普通格式
     * 参数格式与text/html一致
     * 成功
     */
    @RequestMapping("/axn")
    @ResponseBody
    public String axn(User user) {
        System.out.println(user);
        return "ok";
    }

}
