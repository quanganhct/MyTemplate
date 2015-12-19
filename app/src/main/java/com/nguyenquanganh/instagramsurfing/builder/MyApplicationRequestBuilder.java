package com.nguyenquanganh.instagramsurfing.builder;

import com.android.volley.Response;
import com.nguyenquanganh.instagramsurfing.apps.mynetwork.API;
import com.nguyenquanganh.instagramsurfing.helper.NetworkRequestBuilder;
import com.nguyenquanganh.instagramsurfing.network.AbstractNetworkRequest;

/**
 * Created by QuangAnh on 10/30/2015.
 */
public class MyApplicationRequestBuilder {

    public static AbstractNetworkRequest<String> getMyRequest(Response.Listener<String> listener, Response.ErrorListener errorListener){
        return NetworkRequestBuilder.createPlainRequest(API.INSTAGRAM_MEDIA, listener, errorListener).addParams("client_id", "7da3a5cd1ed943b0bc3f48d140d0cbc4").get();
    }
}
