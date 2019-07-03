package com.leovinsen.materialcalendarweekview.calendar;

import java.io.Serializable;

public class CalendarDay implements Serializable {

    private int day;
    private int month;
    private int year;
    private long dateInMillis;

    public CalendarDay(int day, int month, int year, long dateInMillis) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.dateInMillis = dateInMillis;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public long getDateInMillis() {
        return dateInMillis;
    }
}
