package com.nguyenquanganh.instagramsurfing.basecomponents;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.network.AbstractNetworkRequest;
import com.nguyenquanganh.instagramsurfing.network.NetworkRequestManager;

import org.json.JSONObject;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public abstract class AbstractNetworkActivity<T> extends FragmentActivity implements Response.Listener<T>, Response.ErrorListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.networkRequestManager.initLoad(this.getApplicationContext());
    }

    private NetworkRequestManager networkRequestManager = NetworkRequestManager.getInstance();

    public void makeNetworkRequest(AbstractNetworkRequest<T> request){
        this.networkRequestManager.sendRequest(request);
    }

    @Override
    public final void onResponse(T t) {
        this.onNetworkResponse(t);
    }

    @Override
    public final void onErrorResponse(VolleyError volleyError) {
        this.onNetworkResponseError(volleyError);
    }

    public abstract void onNetworkResponse(T t);
    public abstract void onNetworkResponseError(VolleyError volleyError);
    //protected void
}
