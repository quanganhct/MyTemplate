package com.nguyenquanganh.instagramsurfing.apps.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.Window;

/**
 * Created by nguyenquanganh on 11/29/15.
 */
public class MyDialog extends AlertDialog {
    public MyDialog(Context context) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void showMessage(String message){
        this.setMessage(message);
        this.show();
    }
}
