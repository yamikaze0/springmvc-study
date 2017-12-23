package org.yamikaze.spring.mvc.study.converter;

import org.springframework.format.Formatter;
import org.springframework.format.Parser;
import org.yamikaze.spring.mvc.study.constants.DatePatternEnum;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * @author qinluo
 * @date 2017/12/23
 */
public class DateMessageConverter implements Formatter<Date> {

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return DateConverterCache.getDate(text, DatePatternEnum.getFirstPattern());
    }

    @Override
    public String print(Date object, Locale locale) {
        return DateConverterCache.getSimpleDateFormat(DatePatternEnum.DATETIME.getPattern()).format(object);
    }
}
