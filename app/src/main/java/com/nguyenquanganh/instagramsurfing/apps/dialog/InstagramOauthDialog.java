package com.nguyenquanganh.instagramsurfing.apps.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.apps.splashscreen.activities.AuthenticationListener;
import com.nguyenquanganh.instagramsurfing.apps.utils.LocalMemoryManagement;

/**
 * Created by nguyenquanganh on 11/15/15.
 */
public class InstagramOauthDialog extends Dialog {
    private final String authUrl = "https://instagram.com/oauth/authorize/";
    private String clientId = "";
    private String redirectUri = "";
    private AuthenticationListener listener;

    public InstagramOauthDialog(Context context) {
        super(context);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        clientId = context.getResources().getString(R.string.client_id);
        redirectUri = context.getResources().getString(R.string.redirect_url);
        String url = authUrl + "?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=token";
        setContentView(R.layout.dialog_oauth);
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new MyWebViewClient());
        webview.loadUrl(url);
    }

    public void setAutenticationListener(AuthenticationListener listener){
        this.listener = listener;
    }

    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith(redirectUri)){
                String accessToken = url.split("=")[1];
                LocalMemoryManagement.storeValue("access_token", accessToken);
                Log.v("ACCESS_TOKEN", accessToken);
                if (listener != null){
                    listener.onGettingAccessToken();
                }
                return true;
            }
            return false;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            listener.onFailGettingAccessToken();
        }
    }
}
