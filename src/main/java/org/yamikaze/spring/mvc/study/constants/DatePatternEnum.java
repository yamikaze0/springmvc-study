package org.yamikaze.spring.mvc.study.constants;

/**
 * @author qinluo
 * @date 2017/12/22
 */
public enum DatePatternEnum {

    DATETIME(1, DateFormatPattern.DATETIME),
    DATE(2, DateFormatPattern.DATE),
    DATETIME_OF_SLASH(3, DateFormatPattern.DATETIME_OF_SLASH),
    DATE_OF_SLASH(4, DateFormatPattern.DATE_OF_SLASH);

    private int order;
    private String pattern;

    public static String getFirstPattern() {
        return DATETIME.pattern;
    }

    public static String getNextPattern(int code) {
        int nextCode = code + 1;
        for(DatePatternEnum dpe : values()) {
            if(dpe.order == nextCode) {
                return dpe.pattern;
            }
        }
        return "";
    }

    public static String getNextPatternByPattern(String pattern) {
        int code = -1;
        for(DatePatternEnum dpe : values()) {
            if(dpe.pattern.equals(pattern)) {
                code = dpe.order;
            }
        }
        return getNextPattern(code);
    }

    DatePatternEnum(int order, String pattern) {
        this.order = order;
        this.pattern = pattern;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
