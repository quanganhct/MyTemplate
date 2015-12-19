package com.nguyenquanganh.instagramsurfing.apps.home.activities;

import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.basecomponents.AbstractNetworkActivity;

import org.json.JSONObject;

/**
 * Created by nguyenquanganh on 11/29/15.
 */
public class HomeActivity extends AbstractNetworkActivity<JSONObject> {


    @Override
    public void onNetworkResponse(JSONObject jsonObject) {

    }

    @Override
    public void onNetworkResponseError(VolleyError volleyError) {

    }
}
