package com.leovinsen.materialcalendarweekview.calendar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.leovinsen.materialcalendarweekview.R;

import java.util.Calendar;

public class CustomCalendar extends LinearLayout {

    TextView textMonth;
    TextView textYear;
    ImageButton btnPrev;
    ImageButton btnNext;
    ViewGroup layoutWeekdays;
    ViewPager pagerDates;

    CalendarAdapter adapter;


    public CustomCalendar(Context context) {
        super(context);
    }

    public CustomCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_calendar, this);

        assignViews();
    }

    private void assignViews() {
        textMonth = findViewById(R.id.month);
        textYear = findViewById(R.id.year);
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        layoutWeekdays = findViewById(R.id.layout_weekDays);
        pagerDates = findViewById(R.id.pagerDates);

    }

    public CustomCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAdapter(final PagerAdapter adapter){
        this.adapter = (CalendarAdapter) adapter;
        this.pagerDates.setAdapter(adapter);
        this.pagerDates.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                WeekFragment frag = (WeekFragment) ((CalendarAdapter) adapter).getItem(i);
                updateMonth(frag.getMonth());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }


    public void updateMonth(int month){
        String monthText = null;
        switch (month){
            case Calendar.JANUARY:
                monthText = "January";
                break;
            case Calendar.FEBRUARY:
                monthText = "February";
                break;
            case Calendar.MARCH:
                monthText = "March";
                break;
            case Calendar.APRIL:
                monthText = "April";
                break;
            case Calendar.MAY:
                monthText = "May";
                break;
            case Calendar.JUNE:
                monthText = "June";
                break;
            case Calendar.JULY:
                monthText = "July";
                break;
            case Calendar.AUGUST:
                monthText = "August";
                break;
            case Calendar.SEPTEMBER:
                monthText = "September";
                break;
            case Calendar.OCTOBER:
                monthText = "October";
                break;
            case Calendar.NOVEMBER:
                monthText = "November";
                break;
            case Calendar.DECEMBER:
                monthText = "December";
                break;
            default:
                monthText = "(Not Found)";
        }
        this.textMonth.setText(monthText);
    }


}
