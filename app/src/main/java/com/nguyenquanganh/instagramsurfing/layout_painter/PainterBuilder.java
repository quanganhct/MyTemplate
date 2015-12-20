package com.nguyenquanganh.instagramsurfing.layout_painter;

import android.content.Context;

/**
 * Created by nguyenquanganh on 12/20/15.
 */
public class PainterBuilder {
    private static PainterBuilder mBuilder;
    private boolean haveHeader, haveFooter;
    private int headerResId, footerResId, contentResId;
    private Context context;

    private PainterBuilder() {
    }

    private void resetBuilder() {
        haveHeader = false;
        haveFooter = false;
    }

    public static PainterBuilder getInstance(Context context, int mainResId) {
        if (mBuilder == null) {
            mBuilder = new PainterBuilder();
        }
        mBuilder.resetBuilder();
        mBuilder.context = context;
        mBuilder.contentResId = mainResId;

        return mBuilder;
    }

    public PainterBuilder addHeader(int resId) {
        haveHeader = true;
        this.headerResId = resId;
        return this;
    }

    public PainterBuilder addFooter(int resId){
        haveFooter = true;
        this.footerResId = resId;
        return this;
    }

    public ILayoutPainter build(){
        ILayoutPainter painter = new NormalLayoutPainter(context, contentResId);
        if (haveHeader){
            painter = new HeaderLayoutPainter(context, headerResId, painter);
        }
        if (haveFooter){
            painter = new FooterLayoutPainter(context, footerResId, painter);
        }
        return painter;
    }
}
