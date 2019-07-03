package com.leovinsen.materialcalendarweekview.calendar;

public class CalendarDay {

    private int day;
    private int month;
    private int year;

    public CalendarDay(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
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
}
