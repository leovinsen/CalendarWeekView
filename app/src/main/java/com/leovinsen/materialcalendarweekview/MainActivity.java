package com.leovinsen.materialcalendarweekview;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.leovinsen.materialcalendarweekview.calendar.CalendarAdapter;
import com.leovinsen.materialcalendarweekview.calendar.CustomCalendar;
import com.leovinsen.materialcalendarweekview.calendar.DateRange;
import com.leovinsen.materialcalendarweekview.calendar.WeekFragment;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.cal)
    CustomCalendar calView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        calView.init(getSupportFragmentManager());
    }




}
