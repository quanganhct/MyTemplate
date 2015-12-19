package com.nguyenquanganh.instagramsurfing.layout_painter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyenquanganh.instagramsurfing.R;

/**
 * Created by nguyenquanganh on 12/13/15.
 */
public class HeaderLayoutPainter extends AbstractLayoutPainter {

    public HeaderLayoutPainter(Context context, int resHeaderId, ILayoutPainter painter) {
        super(context, resHeaderId, painter);
    }

    protected void setUpView(){
        LayoutInflater inflater = LayoutInflater.from(context);
        this.mainView = inflater.inflate(R.layout.painter_layout_header, null);
        ViewGroup headerContainer = (ViewGroup) mainView.findViewById(R.id.header_container);
        ViewGroup contentContainer = (ViewGroup) mainView.findViewById(R.id.header_layout_main_content_container);

        View header = inflater.inflate(resId, headerContainer, false);
        headerContainer.addView(header);
        contentContainer.addView(painter.getView());
    }
}
