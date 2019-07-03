package com.leovinsen.materialcalendarweekview.calendar;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class DateRange {

    String TAG = "DateRange";
    private long today;
    private List<Week> data;
    private int lastMonth = -1;

    public DateRange(long today){
        this.today = today;
        this.data = new ArrayList<>();
        calculateDates();
    }

    private void calculateDates(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(today);

        Calendar endOfCal = (Calendar) cal.clone();
        endOfCal.add(Calendar.MONTH, 3);
        getWeeksFromRange(cal, endOfCal);
    }

    public int getWeekSize(){
        return data.size();
    }

    public Week getWeekIndex(int position){
        return data.get(position);
    }

    private void getWeeksFromRange(Calendar start, Calendar end){
        Week week = new Week();
        while(start.getTime().before(end.getTime())){

            int dayOfWeek = start.get(Calendar.DAY_OF_WEEK);
            int day = start.get(Calendar.DAY_OF_MONTH);
            int month = start.get(Calendar.MONTH);
            int year = start.get(Calendar.YEAR);

            if(lastMonth == -1 ) {
                // do nothing
            } else if (lastMonth != month){
                //different month
                data.add(week);
                week = new Week();
                //dont increment calendar
            } else {
                //same month
                Log.d(TAG, day + " " + month + " " + year);
                switch(dayOfWeek){
                    case Calendar.SUNDAY:
                        week.setSun(new CalendarDay(day, month, year));
                        break;
                    case Calendar.MONDAY:
                        week.setMon(new CalendarDay(day, month, year));
                        break;
                    case Calendar.TUESDAY:
                        week.setTue(new CalendarDay(day, month, year));
                        break;
                    case Calendar.WEDNESDAY:
                        week.setWed(new CalendarDay(day, month, year));
                        break;
                    case Calendar.THURSDAY:
                        week.setThu(new CalendarDay(day, month, year));
                        break;
                    case Calendar.FRIDAY:
                        week.setFri(new CalendarDay(day, month, year));
                        break;
                    case Calendar.SATURDAY:
                        week.setSat(new CalendarDay(day, month, year));
                        data.add(week);
                        week = new Week();
                        Log.d(TAG, "Adding new week");
                        break;
                    default:
                        Log.e(TAG, "Default");
                }
                start.add(Calendar.DATE, 1);
            }


            lastMonth = month;

        }
    }
}