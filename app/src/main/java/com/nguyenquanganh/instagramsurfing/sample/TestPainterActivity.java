package com.nguyenquanganh.instagramsurfing.sample;

import android.os.Bundle;

import com.nguyenquanganh.instagramsurfing.R;
import com.nguyenquanganh.instagramsurfing.layout_painter.ILayoutPainter;
import com.nguyenquanganh.instagramsurfing.layout_painter.PainterBuilder;

/**
 * Created by nguyenquanganh on 12/19/15.
 */
public class TestPainterActivity extends SampleActivity {

    @Override
    protected ILayoutPainter createPainter() {
        return PainterBuilder.getInstance(this, R.layout.example_activity_body).addHeader(R.layout.example_activity_header).addFooter(R.layout.example_activity_footer).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPainter = createPainter();
        this.setContentView(mPainter.getView());
    }
}
