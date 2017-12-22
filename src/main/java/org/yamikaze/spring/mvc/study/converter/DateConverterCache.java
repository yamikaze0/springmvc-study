package org.yamikaze.spring.mvc.study.converter;

import org.springframework.util.StringUtils;
import org.yamikaze.spring.mvc.study.constants.DateFormatPattern;

import java.text.SimpleDateFormat;
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

    public static void setDatePatternCache(SimpleDateFormat sdf) {
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
}
