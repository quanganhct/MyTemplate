package com.nguyenquanganh.instagramsurfing.helper;

import com.android.volley.Response;
import com.nguyenquanganh.instagramsurfing.network.JsonNetworkRequest;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public class NetworkRequestBuilder {
    public JsonNetworkRequest creatRequest(int method, String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener){
        JsonNetworkRequest request = new JsonNetworkRequest(method, url, new HashMap<String, String>(), listener, errorListener);
        return request;
    }
}
