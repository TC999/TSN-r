package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w extends c {
    @Override // com.bytedance.sdk.openadsdk.res.layout.c
    public View c(Context context) {
        RelativeLayout c4 = c(context, 2114387953);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        relativeLayout.setLayoutParams(layoutParams);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387958);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(xk.ux(context, 72.0f), xk.ux(context, 72.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, xk.ux(context, 30.0f), 0, 0);
        roundImageView.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        textView.setId(2114387932);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, 2114387958);
        layoutParams3.setMargins(0, xk.ux(context, 8.0f), 0, 0);
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(context.getResources().getColor(17170443));
        textView.setTextSize(2, 14.0f);
        textView.setText("\u76f4\u64ad\u7ed3\u675f");
        TextView textView2 = new TextView(context);
        textView2.setId(2114387880);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, 2114387932);
        layoutParams4.setMargins(0, xk.ux(context, 24.0f), 0, 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setTextColor(context.getResources().getColor(17170443));
        textView2.setTextSize(2, 20.0f);
        textView2.setText("\u76f4\u64ad\u5df2\u7ed3\u675f");
        relativeLayout.addView(roundImageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(textView2);
        c4.addView(relativeLayout);
        return c4;
    }
}
