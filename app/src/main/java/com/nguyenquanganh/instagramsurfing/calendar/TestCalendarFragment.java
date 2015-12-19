package com.nguyenquanganh.instagramsurfing.calendar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyenquanganh.instagramsurfing.R;

/**
 * Created by nguyenquanganh on 12/2/15.
 */
public class TestCalendarFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar_layout, container, false);
        GridViewCalendar calendar = (GridViewCalendar) view.findViewById(R.id.my_calendar);
        calendar.fillData(2015, 11);
        return view;
    }
}
