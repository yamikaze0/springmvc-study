package org.yamikaze.spring.mvc.study.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yamikaze
 * @date 2017/12/22
 */
public class DateModel {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
