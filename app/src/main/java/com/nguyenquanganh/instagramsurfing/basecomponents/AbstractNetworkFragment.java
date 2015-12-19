package com.nguyenquanganh.instagramsurfing.basecomponents;

import android.support.v4.app.Fragment;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.network.AbstractNetworkRequest;
import com.nguyenquanganh.instagramsurfing.network.NetworkRequestManager;

/**
 * Created by nguyenquanganh on 11/29/15.
 */
public abstract class AbstractNetworkFragment<T> extends Fragment implements Response.Listener<T>, Response.ErrorListener{

    private NetworkRequestManager networkRequestManager = NetworkRequestManager.getInstance();


    public void makeNetworkRequest(AbstractNetworkRequest<T> request){
        this.networkRequestManager.sendRequest(request);
    }

    @Override
    public void onResponse(T t) {
        this.onNetworkResponse(t);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        this.onNetworkResponseError(volleyError);
    }

    public abstract void onNetworkResponse(T t);
    public abstract void onNetworkResponseError(VolleyError volleyError);
}
