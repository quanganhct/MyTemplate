package com.nguyenquanganh.instagramsurfing.sample;

import android.support.v4.app.FragmentActivity;

import com.nguyenquanganh.instagramsurfing.layout_painter.ILayoutPainter;

/**
 * Created by nguyenquanganh on 12/19/15.
 */
public abstract class SampleActivity extends FragmentActivity{
    protected ILayoutPainter mPainter;
    protected abstract ILayoutPainter createPainter();
}
