package org.yamikaze.spring.mvc.study.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.yamikaze.spring.mvc.study.constants.DateFormatPattern;
import org.yamikaze.spring.mvc.study.constants.DatePatternEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinluo
 * @date 2017/12/22
 */
public final class DateConverterCache {

    private static final Map<String, SimpleDateFormat> dateCache =
            new HashMap<>(8);

    static {
        setDatePatternCache(new SimpleDateFormat(DateFormatPattern.DATE));
        setDatePatternCache(new SimpleDateFormat(DateFormatPattern.DATETIME));
        setDatePatternCache(new SimpleDateFormat(DateFormatPattern.DATE_OF_SLASH));
        setDatePatternCache(new SimpleDateFormat(DateFormatPattern.DATETIME_OF_SLASH));

    }

    private static void setDatePatternCache(SimpleDateFormat sdf) {
        if(sdf == null || StringUtils.isEmpty(sdf.toPattern()) ||
                dateCache.containsKey(sdf.toPattern())) {
            return;
        }

        dateCache.put(sdf.toPattern(), sdf);
    }

    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        SimpleDateFormat sdf = dateCache.get(pattern);

        if(sdf == null) {
            sdf = dateCache.get(DateFormatPattern.DATETIME);
        }
        return sdf;
    }

    public static Date getDate(String text, String pattern) {
        SimpleDateFormat sdf;
        java.util.Date date = null;
        try {
            sdf = getSimpleDateFormat(pattern);
            if(sdf == null) {
                return null;
            }
            date = sdf.parse(text);
        } catch (ParseException e) {
            return parseFail(text, pattern);
        }
        return date;
    }

    private static Date parseFail(String text, String pattern) {
        String nextPattern = DatePatternEnum.getNextPatternByPattern(pattern);
        if(StringUtils.isEmpty(nextPattern)) {
            return null;
        }
        return getDate(text, nextPattern);
    }
}
