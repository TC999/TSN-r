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
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c implements com.bytedance.sdk.openadsdk.res.layout.c {
    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout c(Context context, int i4) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i4 != 0) {
            relativeLayout.setId(i4);
        }
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View w(Context context, int i4) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387916);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xk.ux(context, 66.0f), xk.ux(context, 66.0f));
        layoutParams.addRule(14);
        if (i4 != 0) {
            layoutParams.setMargins(0, xk.ux(context, i4), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setBackground(i.xv(context, "tt_live_avatar_bg"));
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387834);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(xk.ux(context, 65.0f), xk.ux(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387607);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(xk.ux(context, 42.0f), xk.ux(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        imageView.setBackground(i.xv(context, "tt_live_ad_status_icon"));
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View c(Context context, int i4, int i5) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387692);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, xk.ux(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(xk.ux(context, 40.0f), 0, xk.ux(context, 40.0f), xk.ux(context, i4));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(xk.ux(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387879);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(xk.ux(context, 14.0f), xk.ux(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, xk.ux(context, i5), 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setBackground(i.xv(context, "tt_live_ad_loading_btn_status"));
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387754);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387879);
        layoutParams3.addRule(17, 2114387879);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(i.c(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(xk.ux(context, 14.0f), xk.ux(context, 16.0f));
        layoutParams4.addRule(1, 2114387754);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, xk.ux(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        imageView2.setBackground(i.xv(context, "tt_splash_click_bar_go"));
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
