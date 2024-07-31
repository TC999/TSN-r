package com.p518qq.p519e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaView */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class MediaView extends FrameLayout {
    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NewApi"})
    protected void onAttachedToWindow() {
        GDTLogger.m20308d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            return;
        }
        GDTLogger.m20304w("硬件加速未开启");
    }
}
