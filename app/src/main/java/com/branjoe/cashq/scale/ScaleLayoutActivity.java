package com.branjoe.cashq.scale;

import com.branjoe.cashq.util.Util;
import com.leochuan.ScaleLayoutManager;

public class ScaleLayoutActivity extends ScaleActivity<ScaleLayoutManager> {

    @Override
    protected ScaleLayoutManager createLayoutManager() {
        ScaleLayoutManager scActivity = new ScaleLayoutManager(this, Util.Dp2px(this, 10));
        scActivity.setOrientation(1);
        return scActivity;
    }
}
