package com.nguyenquanganh.instagramsurfing.application;

import android.app.Application;

import com.nguyenquanganh.instagramsurfing.apps.utils.LocalMemoryManagement;

/**
 * Created by nguyenquanganh on 11/15/15.
 */
public class InstagramSurfingApplication extends Application {

    public InstagramSurfingApplication() {
        super();
        //LocalMemoryManagement.initiateLocalMemoryManager(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LocalMemoryManagement.initiateLocalMemoryManager(this.getApplicationContext());
    }
}
