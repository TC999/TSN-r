package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r implements com.bytedance.sdk.openadsdk.res.layout.c {
    @Override // com.bytedance.sdk.openadsdk.res.layout.c
    public View c(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387673);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387871);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(580, 98);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.setMargins(0, xk.ux(context, 20.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#D33F57"));
        gradientDrawable.setCornerRadius(4.0f);
        textView.setBackground(gradientDrawable);
        textView.setGravity(17);
        textView.setPadding(xk.ux(context, 2.0f), xk.ux(context, 2.0f), xk.ux(context, 2.0f), xk.ux(context, 2.0f));
        textView.setTextColor(-1);
        textView.setTextSize(0, 34.0f);
        textView.setText(i.c(context, "tt_download"));
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387845);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387871);
        layoutParams3.addRule(14, -1);
        layoutParams3.setMargins(0, 60, 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setText(i.c(context, "tt_click_replay"));
        textView2.setTextColor(-1);
        textView2.setTextSize(0, 34.0f);
        relativeLayout.addView(textView2);
        return relativeLayout;
    }
}
