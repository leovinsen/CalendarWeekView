package com.leovinsen.materialcalendarweekview.calendar;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter extends FragmentPagerAdapter {

    private static final String TAG = CalendarAdapter.class.getSimpleName();
    private DateRange dateRange;
    private long today;
    private List<Fragment> fragments = new ArrayList<>();

    private CalendarDay selectedDay;

    public CalendarAdapter(FragmentManager fm, DateRange dateRange, long today) {
        super(fm);
        this.dateRange = dateRange;
        this.today = today;
        int size = dateRange.getWeekSize();
        Log.d(TAG, "Size " + size);
        for(int i =0; i < size; i++){
            fragments.add(WeekFragment.newInstance(dateRange.getWeekIndex(i)));
        }
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public CalendarDay getSelectedDay() {
        return selectedDay;
    }

    public interface OnMonthChangeListener{
        void onMonthChange();
    }
}