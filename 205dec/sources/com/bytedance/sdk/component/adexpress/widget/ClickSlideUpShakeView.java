package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ClickSlideUpShakeView extends SlideUpView {

    /* renamed from: c  reason: collision with root package name */
    private ShakeClickView f29505c;

    public ClickSlideUpShakeView(Context context, int i4, int i5, int i6) {
        super(context);
        c(context, i4, i5, i6);
    }

    private void c(Context context, int i4, int i5, int i6) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.xv.c.xv(context), i4, i5, i6);
        this.f29505c = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f29505c.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.f29505c;
    }

    public void setShakeText(String str) {
        if (this.f29505c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f29505c.setShakeText("");
        } else {
            this.f29505c.setShakeText(str);
        }
    }
}
