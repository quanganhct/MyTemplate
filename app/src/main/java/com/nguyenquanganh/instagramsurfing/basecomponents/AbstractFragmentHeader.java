package com.nguyenquanganh.instagramsurfing.basecomponents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.VolleyError;
import com.nguyenquanganh.instagramsurfing.R;

/**
 * Created by nguyenquanganh on 11/29/15.
 */
public abstract class AbstractFragmentHeader extends AbstractNetworkFragment {

    AbstractNetworkFragment fragment;

    public AbstractFragmentHeader() {

    }

    public AbstractFragmentHeader(AbstractNetworkFragment fragment) {
        this.fragment = fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_fragment_header, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_content);
        return view;
    }
}
