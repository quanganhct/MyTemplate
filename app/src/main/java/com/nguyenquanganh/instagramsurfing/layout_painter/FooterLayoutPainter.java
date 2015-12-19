package com.nguyenquanganh.instagramsurfing.layout_painter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nguyenquanganh.instagramsurfing.R;

/**
 * Created by nguyenquanganh on 12/13/15.
 */
public class FooterLayoutPainter extends AbstractLayoutPainter {

    public FooterLayoutPainter(Context context, int resFooterId, ILayoutPainter painter) {
        super(context, resFooterId, painter);
    }

    @Override
    protected void setUpView() {
        LayoutInflater inflater = LayoutInflater.from(context);
        this.mainView = inflater.inflate(R.layout.painter_layout_footer, null);
        ViewGroup footerContainer = (ViewGroup) mainView.findViewById(R.id.footer_container);
        ViewGroup contentContainer = (ViewGroup) mainView.findViewById(R.id.footer_layout_main_content_container);

        View footer = inflater.inflate(resId, footerContainer, false);
        footerContainer.addView(footer);
        contentContainer.addView(painter.getView());
    }
}
