package com.nguyenquanganh.instagramsurfing.apps.activities;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.basecomponents.AbstractNetworkActivity;
import com.nguyenquanganh.instagramsurfing.builder.MyApplicationRequestBuilder;

public class SplashScreen extends AbstractNetworkActivity<String> {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.splash_screen_activity);
        this.textView = (TextView) this.findViewById(R.id.content);
        this.makeNetworkRequest(MyApplicationRequestBuilder.getMyRequest(this, this));
    }

    @Override
    public void onNetworkResponse(String response) {
        this.textView.setText(response);
    }

    @Override
    public void onNetworkResponseError(VolleyError volleyError) {
        this.textView.setText(volleyError.getMessage());
    }
}
