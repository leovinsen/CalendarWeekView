package com.leovinsen.materialcalendarweekview.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CalendarTextView extends android.support.v7.widget.AppCompatTextView {
    public CalendarTextView(Context context) {
        super(context);
    }

    public CalendarTextView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = this.getMeasuredWidth();
        setMeasuredDimension(size, size);
    }
}
