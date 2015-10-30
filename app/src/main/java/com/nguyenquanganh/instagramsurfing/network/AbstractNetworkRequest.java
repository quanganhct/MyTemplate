package com.nguyenquanganh.instagramsurfing.network;

import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public abstract class AbstractNetworkRequest<T> extends Request<T> implements MyNetworkRequest{
    protected Response.Listener<T> listener;

    public AbstractNetworkRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }
}
