package org.yamikaze.spring.mvc.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yamikaze.spring.mvc.study.constants.DatePatternEnum;
import org.yamikaze.spring.mvc.study.converter.DateConverterCache;
import org.yamikaze.spring.mvc.study.entity.DateModel;

import java.util.Date;

/**
 * @author yamikaze
 * @date 2017/12/22
 */
@Controller
@RequestMapping("data/bind")
public class DataBindingController {

    @RequestMapping("/index")
    public String index() {
        return "bind/index";
    }

    @RequestMapping("/date")
    @ResponseBody
    public String bindDate(DateModel dateModel) {
        if(dateModel != null && dateModel.getDate() != null) {
            System.out.println("time is " + DateConverterCache.getSimpleDateFormat
                    (DatePatternEnum.getFirstPattern()).format(dateModel.getDate()));
        }
        return "ok";
    }

    @RequestMapping("/onlyDate")
    @ResponseBody
    public String onlyDate(Date date) {
        System.out.println(date);
        return "ok";
    }

}
