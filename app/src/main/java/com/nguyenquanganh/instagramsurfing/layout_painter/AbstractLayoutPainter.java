package com.nguyenquanganh.instagramsurfing.layout_painter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nguyenquanganh on 12/13/15.
 */
public abstract class AbstractLayoutPainter implements ILayoutPainter {
    protected Context context;
    protected int resId;
    protected View mainView;
    protected ILayoutPainter painter;

    public AbstractLayoutPainter(Context context, int resId){
        this.context = context;
        this.resId = resId;
        setUpView();
    }

    public AbstractLayoutPainter(Context context, int resId, ILayoutPainter painter){
        this.context = context;
        this.resId = resId;
        this.painter = painter;
        setUpView();
    }

    protected abstract void setUpView();

    @Override
    public View getView() {
        return this.mainView;
    }

    @Override
    public ViewGroup getContentViewGroup() {
        return painter.getContentViewGroup();
    }
}
