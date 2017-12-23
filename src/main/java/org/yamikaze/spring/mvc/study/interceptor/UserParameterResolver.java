package org.yamikaze.spring.mvc.study.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.yamikaze.spring.mvc.study.annotation.UserAnnotation;
import org.yamikaze.spring.mvc.study.entity.User;

/**
 * @author qinluo
 * @date 2017/12/23
 */
@Component("userParameterResolver")
public class UserParameterResolver implements HandlerMethodArgumentResolver {

    /**
     * 是否解析
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(UserAnnotation.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = new User();
        user.setId(2);
        user.setUsername("yamikaze");
        user.setPassword("123456");
        return user;
    }
}
