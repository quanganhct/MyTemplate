package com.nguyenquanganh.instagramsurfing.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.nguyenquanganh.instagramsurfing.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by quanganh.nguyen on 12/2/2015.
 */
public class WeekView extends LinearLayout {
    private TextView d1, d2, d3, d4, d5, d6, d7;

    public WeekView(Context context) {
        super(context);
        //setUpField();
    }

    public WeekView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setUpField();
    }

    private void setUpField() {
        d1 = (TextView) this.findViewById(R.id.tv_d1);
        d2 = (TextView) this.findViewById(R.id.tv_d2);
        d3 = (TextView) this.findViewById(R.id.tv_d3);
        d4 = (TextView) this.findViewById(R.id.tv_d4);
        d5 = (TextView) this.findViewById(R.id.tv_d5);
        d6 = (TextView) this.findViewById(R.id.tv_d6);
        d7 = (TextView) this.findViewById(R.id.tv_d7);
    }

    public static WeekView newInstance(LayoutInflater inflater, ViewGroup parent) {
        WeekView weekView = (WeekView) inflater.inflate(R.layout.my_week_layout, parent, false);
        return weekView;
    }

    public void setData(Date d1, Date d2, Date d3, Date d4, Date d5, Date d6, Date d7) {
        //setUpField();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d1);
        this.d1.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d2);
        this.d2.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d3);
        this.d3.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d4);
        this.d4.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d5);
        this.d5.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d6);
        this.d6.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(d7);
        this.d7.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setUpField();
    }
}