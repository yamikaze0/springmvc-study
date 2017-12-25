package org.yamikaze.spring.mvc.study.converter;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * @author yamikaze
 * @date 2017/12/22
 */
public class MyWebBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new DatePropertyConverter());
    }
}
