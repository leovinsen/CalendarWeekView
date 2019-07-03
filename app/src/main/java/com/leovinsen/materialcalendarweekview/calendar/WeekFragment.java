package com.leovinsen.materialcalendarweekview.calendar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.leovinsen.materialcalendarweekview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeekFragment extends Fragment {
    @BindView(R.id.sun)
    TextView sun;
    @BindView(R.id.mon)
    TextView mon;
    @BindView(R.id.tue)
    TextView tue;
    @BindView(R.id.wed)
    TextView wed;
    @BindView(R.id.thu)
    TextView thu;
    @BindView(R.id.fri)
    TextView fri;
    @BindView(R.id.sat)
    TextView sat;

    private Week week;
    private OnDateSelectedListener listener;

    public int getMonth(){
        return week.getMonth();
    }

    static final String KEY_WEEK = "week";

    public static WeekFragment newInstance(Week week, OnDateSelectedListener listener) {

        Bundle args = new Bundle();
        args.putSerializable(KEY_WEEK, week);

        WeekFragment fragment = new WeekFragment();
        fragment.setArguments(args);
        fragment.listener = listener;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week, container, false);
        ButterKnife.bind(this, view);
        Bundle args = getArguments();
        week = (Week) args.getSerializable(KEY_WEEK);

        CalendarDay sun = week.getSun();
        CalendarDay mon = week.getMon();
        CalendarDay tue = week.getTue();
        CalendarDay wed = week.getWed();
        CalendarDay thu = week.getThu();
        CalendarDay fri = week.getFri();
        CalendarDay sat = week.getSat();

        if (sun != null) this.sun.setText(String.valueOf(sun.getDay()));
        if (mon != null) this.mon.setText(String.valueOf(mon.getDay()));
        if (tue != null) this.tue.setText(String.valueOf(tue.getDay()));
        if (wed != null) this.wed.setText(String.valueOf(wed.getDay()));
        if (thu != null) this.thu.setText(String.valueOf(thu.getDay()));
        if (fri != null) this.fri.setText(String.valueOf(fri.getDay()));
        if (sat != null) this.sat.setText(String.valueOf(sat.getDay()));

        return view;
    }

    @OnClick({R.id.sun, R.id.mon, R.id.tue, R.id.wed, R.id.thu, R.id.fri, R.id.sat})
    void onDateClick(View v){
        v.setBackgroundResource(R.drawable.yellow_circle_indicator);
        switch(v.getId()){
            case R.id.sun:
                listener.onDateSelected(week.getSun(), v);
                break;
            case R.id.mon:
                listener.onDateSelected(week.getMon(), v);
                break;
            case R.id.tue:
                listener.onDateSelected(week.getTue(), v);
                break;
            case R.id.wed:
                listener.onDateSelected(week.getWed(), v);
                break;
            case R.id.thu:
                listener.onDateSelected(week.getThu(), v);
                break;
            case R.id.fri:
                listener.onDateSelected(week.getFri(), v);
                break;
            case R.id.sat:
                listener.onDateSelected(week.getSat(), v);
                break;
        }
    }

    public interface OnDateSelectedListener {
        void onDateSelected(CalendarDay day, View v);
    }
}
