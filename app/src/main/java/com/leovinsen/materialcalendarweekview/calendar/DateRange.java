package com.leovinsen.materialcalendarweekview.calendar;

import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateRange {

    String TAG = "DateRange";
    private long today;
    private List<Week> data;
    private int lastMonth = -1;
    private boolean previousEndOfMonthIsSaturday = false;


    private final static int MONTHS_RANGE = 5;
    public DateRange(long today){
        this.today = today;
        this.data = new ArrayList<>();
        calculateDates();
    }

    private void calculateDates(){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(today);

        Calendar endOfCal = (Calendar) cal.clone();
        endOfCal.add(Calendar.MONTH, MONTHS_RANGE);
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
            long dateInMillis = start.getTimeInMillis();

            if(lastMonth == -1 ) {
                // do nothing
            } else if (lastMonth != month){
                Log.d(TAG, "Different month");
                //different month
                if(!previousEndOfMonthIsSaturday){
                    Log.d(TAG, "Adding new getWeek");
                    data.add(week);
                    week = new Week();

                } else {
                    previousEndOfMonthIsSaturday = false;
                    Log.d(TAG, "Last Month end of month was saturday; skip adding an empty getWeek");
                }
                //dont increment calendar
            } else {
                //same month
                Log.d(TAG, day + " " + month + " " + year);
                CalendarDay cd = new CalendarDay(day, month, year, dateInMillis);
                switch(dayOfWeek){
                    case Calendar.SUNDAY:
                        week.setSun(cd);
                        break;
                    case Calendar.MONDAY:
                        week.setMon(cd);
                        break;
                    case Calendar.TUESDAY:
                        week.setTue(cd);
                        break;
                    case Calendar.WEDNESDAY:
                        week.setWed(cd);
                        break;
                    case Calendar.THURSDAY:
                        week.setThu(cd);
                        break;
                    case Calendar.FRIDAY:
                        week.setFri(cd);
                        break;
                    case Calendar.SATURDAY:
                        week.setSat(cd);
                        data.add(week);
                        week = new Week();

                        int endOfMonth = start.getActualMaximum(Calendar.DAY_OF_MONTH);
                        if(endOfMonth == day){
                            previousEndOfMonthIsSaturday = true;
                        }
                        Log.d(TAG, "Adding new getWeek");
                        break;
                    default:
                        Log.e(TAG, "Default");
                }
                start.add(Calendar.DATE, 1);
            }


            lastMonth = month;

        }

        //If last added getWeek is fully filled, don't add
        //Else, add it to calendar (because add getWeek is only executed on Saturdays which can only happen if getWeek is fully filled)
        if(!week.isEmpty()){
            data.add(week);
        }
    }
}
