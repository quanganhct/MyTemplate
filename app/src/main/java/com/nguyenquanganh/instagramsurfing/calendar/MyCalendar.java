package com.nguyenquanganh.instagramsurfing.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.nguyenquanganh.instagramsurfing.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by quanganh.nguyen on 12/1/2015.
 */
public class MyCalendar extends LinearLayout {

    private Context mContext;

    public MyCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        //setDateList(2015, 11);
    }


    private List<Date> getDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfMonthInWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int offset = calendar.getFirstDayOfWeek() - firstDayOfMonthInWeek;

        if (offset > 0) {
            offset -= 7;
        }

        calendar.add(Calendar.DATE, offset);

        List<Date> dateList = new ArrayList<>();
        while ((calendar.get(Calendar.MONTH) < month + 1 || calendar.get(Calendar.YEAR) < year) && calendar.get(Calendar.YEAR) <= year) {
            dateList.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        //calendar.add(Calendar.DAY_OF_MONTH, -1);
        while (calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek() != 0) {
            dateList.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dateList;
    }

    public void setDateList(int year, int month) {
        List<Date> dateList = getDate(year, month);
        int row = 1;
        for (int i = 0; i < dateList.size(); i += 7) {
            LayoutInflater inflater = LayoutInflater.from(this.mContext);
            WeekView weekView = WeekView.newInstance(inflater, this);
            weekView.setData(dateList.get(i), dateList.get(i + 1), dateList.get(i + 2), dateList.get(i + 3), dateList.get(i + 4),
                    dateList.get(i + 5), dateList.get(i + 6));
            this.addView(weekView);
            row++;
        }
    }

    public MyCalendar initData(LayoutInflater inflater, ViewGroup parent, String data) {
        MyCalendar myCalendar = (MyCalendar) inflater.inflate(R.layout.my_calendar_layout, parent, false);
        return myCalendar;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }
}