package com.nguyenquanganh.instagramsurfing.network;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

/**
 * Created by QuangAnh on 10/29/2015.
 */
public class NetworkRequestManager {
    private static NetworkRequestManager instance;

    private RequestQueue myQueue;

    private NetworkRequestManager() {

    }

    public static NetworkRequestManager getInstance() {
        if (instance == null) {
            instance = new NetworkRequestManager();

        }
        return instance;
    }

    public void initLoad(Context context) {
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024 * 5);
        Network network = new BasicNetwork(new HurlStack());
        this.myQueue = new RequestQueue(cache, network);
        this.myQueue.start();
    }
}
