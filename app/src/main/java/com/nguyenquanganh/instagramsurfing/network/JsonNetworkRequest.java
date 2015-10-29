package com.nguyenquanganh.instagramsurfing.network;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public class JsonNetworkRequest extends Request<JSONObject> implements MyNetworkRequest{

    private Map<String, String> params;
    private Response.Listener<JSONObject> listener;

    public JsonNetworkRequest(String url, Map<String, String> params,
                              Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.params = params;
        this.listener = reponseListener;
    }

    public JsonNetworkRequest(int method, String url, Map<String, String> params,
                              Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.params = params;
        this.listener = reponseListener;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {

        try {
            String json = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            return Response.success(new JSONObject(json), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(JSONObject jsonObject) {
        this.listener.onResponse(jsonObject);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return this.params;
    }

    @Override
    public JsonNetworkRequest addParams(String key, String value) {
        this.params.put(key, value);
        return this;
    }
}
