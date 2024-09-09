package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.res.sr;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class TTLoadingProgressBar extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private View f36374c;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f36375w;
    private View xv;

    public TTLoadingProgressBar(Context context) {
        super(context);
        c(context);
    }

    private void c(Context context) {
        addView(sr.sr(context));
        this.f36374c = findViewById(2047279084);
        this.f36375w = (ImageView) findViewById(2047279083);
        this.xv = findViewById(2047279082);
    }

    public View getProgressBar() {
        return this.f36374c;
    }

    public ImageView getProgressIcon() {
        return this.f36375w;
    }

    public void setProgress(int i4) {
        if (this.f36375w.getVisibility() == 0 && i4 > 3) {
            ((LinearLayout.LayoutParams) this.f36375w.getLayoutParams()).leftMargin = c(this.f36374c.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f36374c.getLayoutParams();
        float f4 = i4 / 100.0f;
        layoutParams.weight = f4;
        this.f36374c.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.xv.getLayoutParams();
        layoutParams2.weight = 1.0f - f4;
        this.xv.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int c(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
