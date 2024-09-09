package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class sr extends c {
    private View w(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387692);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, xk.ux(context, 32.0f));
        layoutParams.addRule(3, 2114387809);
        layoutParams.addRule(14);
        layoutParams.topMargin = xk.ux(context, 17.0f);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(xk.ux(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setMinimumWidth(xk.ux(context, 110.0f));
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387879);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(xk.ux(context, 12.0f), xk.ux(context, 14.0f));
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = xk.ux(context, 6.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setBackground(i.xv(context, "tt_live_ad_loading_btn_status"));
        TextView textView = new TextView(context);
        textView.setId(2114387754);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387879);
        layoutParams3.addRule(17, 2114387879);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(i.c(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setLayoutParams(layoutParams3);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(xk.ux(context, 12.0f), xk.ux(context, 14.0f));
        layoutParams4.addRule(13);
        layoutParams4.addRule(1, 2114387754);
        layoutParams4.addRule(17, 2114387754);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setBackground(i.xv(context, "tt_splash_click_bar_go"));
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.c
    public View c(Context context) {
        RelativeLayout c4 = c(context, 2114387615);
        c4.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        c4.addView(relativeLayout, layoutParams);
        relativeLayout.addView(w(context, 0));
        TextView textView = new TextView(context);
        textView.setId(2114387743);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387916);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, xk.ux(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(context.getResources().getColor(17170443));
        textView.setTextSize(2, 16.0f);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387809);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387743);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, xk.ux(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextColor(context.getResources().getColor(17170443));
        textView2.setTextSize(2, 12.0f);
        textView2.setText(i.c(context, "tt_live_loading_text"));
        relativeLayout.addView(textView2);
        relativeLayout.addView(w(context));
        return c4;
    }
}
