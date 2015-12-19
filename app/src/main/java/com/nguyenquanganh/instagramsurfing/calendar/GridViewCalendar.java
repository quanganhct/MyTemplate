package com.nguyenquanganh.instagramsurfing.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.nguyenquanganh.instagramsurfing.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by nguyenquanganh on 12/2/15.
 */
public class GridViewCalendar extends LinearLayout {

    private GridView myGridView;
    private Context myContext;

    public GridViewCalendar(Context context) {
        super(context);
        this.myContext = context;
    }

    public GridViewCalendar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.myContext = context;
    }

    public static GridViewCalendar newInstance(LayoutInflater inflater, ViewGroup parent) {
        return (GridViewCalendar) inflater.inflate(R.layout.my_grid_view_calendar, parent, false);
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

    public void fillData(int year, int month) {
        List<Date> dates = this.getDate(year, month);
        List<DateData> datas = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Date date: dates){
            calendar.setTime(date);
            DateData data = new DateData(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
            datas.add(data);
        }

        GridCalendarAdapter adapter = new GridCalendarAdapter(this.myContext);
        adapter.addAll(datas);
        this.myGridView.setAdapter(adapter);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.myGridView = (GridView) this.findViewById(R.id.calendar_view);
    }

    public class GridCalendarAdapter extends ArrayAdapter<DateData> implements OnClickListener {

        private DateData lastSelected = null;

        public GridCalendarAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_1);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DateData data = this.getItem(position);
            RadioButton button = (RadioButton) LayoutInflater.from(myContext).inflate(R.layout.my_grid_view_calendar_item, parent, false);
            button.setText("" + data.getDate());
            button.setTag(data);
            button.setSelected(data.isSelected());
            return button;
        }

        @Override
        public void onClick(View view) {
            DateData data = (DateData) view.getTag();
            if (lastSelected == null) {
                lastSelected = data;
                lastSelected.setSelected(true);
            } else {
                lastSelected.setSelected(false);
                lastSelected = data;
                lastSelected.setSelected(true);
            }
            this.notifyDataSetChanged();
        }
    }
}
