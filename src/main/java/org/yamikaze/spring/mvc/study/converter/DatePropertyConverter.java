package org.yamikaze.spring.mvc.study.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.yamikaze.spring.mvc.study.constants.DatePatternEnum;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 继承PropertyEditorSupport，而不是实现PropertyEditor接口
 * 缺点：只能支持String <--> Object之间的转换，不支持Object <--> Object转换
 * 绑定，
 * 1、可以继承AbstractCommandController,但这种方式缺点是每个Controller都需要绑定
 * 2、实现WebBindingInitializer批量进行绑定
 *    然后在配置文件中注入
 * @author qinluo
 * @date 2017/12/22
 */
public class DatePropertyConverter extends PropertyEditorSupport {

    private static Logger logger = LoggerFactory.getLogger(DatePropertyConverter.class);

    /**
     * 将Object转换为String
     */
    @Override
    public String getAsText() {
        return super.getAsText();
    }

    /**
     * 将String 类型转换为Object类型
     * @param text
     * @throws IllegalArgumentException
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.isEmpty(text)) {
            return;
        }
        Date date = getDate(text, DatePatternEnum.getFirstPattern());
        setValue(date);
    }

    private Date getDate(String text, String pattern) {
        SimpleDateFormat sdf;
        Date date = null;
        try {
            sdf = DateConverterCache.getSimpleDateFormat(pattern);
            if(sdf == null) {
                return null;
            }
            date = sdf.parse(text);
        } catch (ParseException e) {
            return parseFail(text, pattern);
        }
        return date;
    }

    private Date parseFail(String text, String pattern) {
        String nextPattern = DatePatternEnum.getNextPatternByPattern(pattern);
        if(StringUtils.isEmpty(nextPattern)) {
            logger.warn("解析时间失败!, 时间字符串为[" + text + "]");
            return null;
        }
        return getDate(text, nextPattern);
    }
}
