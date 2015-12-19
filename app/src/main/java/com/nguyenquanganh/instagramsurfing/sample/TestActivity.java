package com.nguyenquanganh.instagramsurfing.sample;

import android.os.Bundle;

import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.layout_painter.HeaderLayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.ILayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.NormalLayoutPainter;

/**
 * Created by nguyenquanganh on 12/19/15.
 */
public class TestActivity extends SampleActivity {

    @Override
    protected ILayoutPainter createPainter() {
        return new HeaderLayoutPainter(this, R.layout.activity_header, new NormalLayoutPainter(this, R.layout.activity_test));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPainter = createPainter();
        this.setContentView(mPainter.getView());
    }
}
