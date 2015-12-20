package com.nguyenquanganh.instagramsurfing.sample;

import android.os.Bundle;

import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.layout_painter.HeaderLayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.ILayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.NormalLayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.PainterBuilder;

/**
 * Created by nguyenquanganh on 12/19/15.
 */
public class TestActivity extends SampleActivity {

    @Override
    protected ILayoutPainter createPainter() {
        return PainterBuilder.getInstance(this, R.layout.activity_test).addHeader(R.layout.activity_header).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPainter = createPainter();
        this.setContentView(mPainter.getView());
    }
}
