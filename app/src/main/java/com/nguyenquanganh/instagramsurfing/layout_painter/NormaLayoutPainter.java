package com.nguyenquanganh.instagramsurfing.layout_painter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyenquanganh.instagramsurfing.R;

/**
 * Created by nguyenquanganh on 12/13/15.
 */
public class NormaLayoutPainter extends AbstractLayoutPainter {

    public NormaLayoutPainter(Context context, int resId){
        super(context, resId);
    }

    @Override
    protected void setUpView() {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.mainView = inflater.inflate(R.layout.painter_layout_normal, null);
        ViewGroup contentContainer = (ViewGroup) mainView.findViewById(R.id.normal_layout_main_content_container);

        View content = inflater.inflate(resId, contentContainer, false);
        contentContainer.addView(content);
    }

    @Override
    public View getView() {
        return this.mainView;
    }

    @Override
    public ViewGroup getContentViewGroup() {
        return (ViewGroup) mainView.findViewById(R.id.normal_layout_main_content_container);
    }
}
