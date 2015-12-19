package com.nguyenquanganh.instagramsurfing.apps.splashscreen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.apps.dialog.InstagramOauthDialog;
import com.nguyenquanganh.instagramsurfing.apps.dialog.MyDialog;
import com.nguyenquanganh.instagramsurfing.apps.home.activities.HomeActivity;
import com.nguyenquanganh.instagramsurfing.apps.utils.LocalMemoryManagement;
import com.nguyenquanganh.instagramsurfing.basecomponents.AbstractNetworkActivity;

public class SplashScreen extends AbstractNetworkActivity<String> implements Animation.AnimationListener, AuthenticationListener {

    private ImageView imvLogo;
    private Animation animationFadeIn;
    private InstagramOauthDialog dialog;
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDialog = new MyDialog(this);
        this.setContentView(R.layout.activity_splash_screen);
        this.imvLogo = (ImageView) this.findViewById(R.id.imv_logo);

        this.animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        this.animationFadeIn.setAnimationListener(this);
        this.imvLogo.startAnimation(this.animationFadeIn);
    }

    @Override
    public void onNetworkResponse(String response) {

    }

    @Override
    public void onNetworkResponseError(VolleyError volleyError) {

    }

    private boolean isLoggedInBefore() {
        String accessToken = LocalMemoryManagement.getValue("access_token");
        return accessToken != null;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        if (!this.isLoggedInBefore()) {
            dialog = new InstagramOauthDialog(this);
            dialog.show();
        } else {
            this.startHome();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void startHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        this.startActivity(intent);
        this.finish();
    }

    @Override
    public void onGettingAccessToken() {
        this.dialog.dismiss();
        this.startHome();
    }

    @Override
    public void onFailGettingAccessToken() {
        this.dialog.dismiss();
        this.myDialog.showMessage("Network Error");
    }
}
