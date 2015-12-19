package com.nguyenquanganh.instagramsurfing.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.calendar.TestCalendarFragment;

/**
 * Created by nguyenquanganh on 12/2/15.
 */
public class TestActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_test);
        FragmentManager manager = this.getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TestCalendarFragment fragment = new TestCalendarFragment();
        transaction.add(R.id.container, fragment, TestCalendarFragment.class.getName());
        transaction.commit();
    }
}
