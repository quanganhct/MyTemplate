package com.nguyenquanganh.instagramsurfing.network;

import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public class PlainNetworkRequest extends AbstractNetworkRequest<String>{
    private Map<String, String> params;
    private boolean firstParam = true;

    private String url;
    private Response.Listener<String> listener;
    private Response.ErrorListener errorListener;

    public PlainNetworkRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = listener;
        this.errorListener = errorListener;
        this.url = url;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.params;
    }

    @Override
    public PlainNetworkRequest addParams(String key, String value) {
        if (this.params == null) {
            this.params = new HashMap<String, String>();
        }

        if (this.firstParam){
            this.url += "?" + key + "=" + value;
        }else{
            this.url += "&" + key + "=" + value;
        }
        this.params.put(key, value);

        return this;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            String response = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(response, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    public PlainNetworkRequest get() {
        return new PlainNetworkRequest(this.url, this.listener, this.errorListener);
    }

    @Override
    protected void deliverResponse(String s) {
        this.listener.onResponse(s);
    }
}
