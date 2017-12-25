package org.yamikaze.spring.mvc.study.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、直接实现HandlerInterceptor接口
 * 2、继承HandlerInterceptorAdapter，覆盖自己想要的方法
 * @author yamikaze
 * @date 2017/12/23
 */
@Component("timeInvokeInterceptor")
public class InvokeTimeConsumingInterceptor extends HandlerInterceptorAdapter{

    private static ThreadLocal<Long> startTime = new ThreadLocal<>();
    private static Logger logger = LoggerFactory.getLogger(InvokeTimeConsumingInterceptor.class);

    /**
     * Controller处理前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime.set(System.currentTimeMillis());
        return true;
    }

    /**
     * Controller处理后 或者 有HandlerInterceptor的preHandle返回false
     * 那么在这个HandlerInterceptor之前的HandlerInterceptor的afterCompletion方法都会执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long endTime = System.currentTimeMillis();
        long consumingTime = endTime - startTime.get();
        logger.info("invoke handler [" + handler.getClass().getSimpleName() + "] time consuming {}ms and request uri is {}, request type is {}"
                , consumingTime, request.getRequestURI(), request.getMethod());
    }
}
