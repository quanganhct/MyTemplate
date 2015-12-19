package com.nguyenquanganh.instagramsurfing.apps.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nguyenquanganh on 11/15/15.
 */
public class LocalMemoryManagement {
    private static String mySharePreference = "qa_insta_share_preference";
    private SharedPreferences sharedPreferences;

    private static LocalMemoryManagement memoryManagement;

    public static void storeValue(String key, String value) {
        SharedPreferences.Editor editor = memoryManagement.sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getValue(String key) {
        return memoryManagement.sharedPreferences.getString(key, null);
    }

    public static void initiateLocalMemoryManager(Context context) {
        if (memoryManagement == null) {
            memoryManagement = new LocalMemoryManagement();
            memoryManagement.sharedPreferences = context.getSharedPreferences(mySharePreference, Context.MODE_PRIVATE);
        }
    }
}
