package com.leovinsen.materialcalendarweekview.calendar;

import java.io.Serializable;

class Week implements Serializable {
    private CalendarDay sun;
    private CalendarDay mon;
    private CalendarDay tue;
    private CalendarDay wed;
    private CalendarDay thu;
    private CalendarDay fri;
    private CalendarDay sat;
    private int month = -1;

    public int getMonth(){
        return month;
    }

    private void setMonth(CalendarDay day){
        if(month == -1 ) {
            this.month = day.getMonth();
        }
    }

    public void setSun(CalendarDay sun) {
        this.sun = sun;
        setMonth(sun);
    }

    public void setMon(CalendarDay mon) {
        this.mon = mon;
        setMonth(mon);
    }

    public void setTue(CalendarDay tue) {
        this.tue = tue;
        setMonth(tue);
    }

    public void setWed(CalendarDay wed) {
        this.wed = wed;
        setMonth(wed);
    }

    public void setThu(CalendarDay thu) {
        this.thu = thu;
        setMonth(thu);
    }

    public void setFri(CalendarDay fri) {
        this.fri = fri;
        setMonth(fri);
    }

    public void setSat(CalendarDay sat) {
        this.sat = sat;
        setMonth(sat);
    }

    public CalendarDay getSun() {
        return sun;
    }

    public CalendarDay getMon() {
        return mon;
    }

    public CalendarDay getTue() {
        return tue;
    }

    public CalendarDay getWed() {
        return wed;
    }

    public CalendarDay getThu() {
        return thu;
    }

    public CalendarDay getFri() {
        return fri;
    }

    public CalendarDay getSat() {
        return sat;
    }
}