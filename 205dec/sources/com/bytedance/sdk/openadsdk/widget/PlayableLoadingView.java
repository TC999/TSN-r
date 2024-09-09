package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class PlayableLoadingView extends FrameLayout {
    public PlayableLoadingView(Context context) {
        super(context);
        c(context);
    }

    public void c(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundColor(Color.parseColor("#0D1833"));
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    public void w() {
        setVisibility(0);
    }

    public void c() {
        setVisibility(8);
    }
}
