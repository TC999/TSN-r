package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardAuthToastLayout extends RelativeLayout {
    public RewardAuthToastLayout(Context context, int i4) {
        super(context);
        c(context, i4);
    }

    private void c(Context context, int i4) {
        setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, xk.ux(context, 36.0f));
        layoutParams.topMargin = xk.ux(context, 160.0f);
        setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#55161823"));
        gradientDrawable.setCornerRadius(xk.ux(context, 50.0f));
        linearLayout.setBackground(gradientDrawable);
        layoutParams2.addRule(14);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(i.xv(context, "tt_reward_auth_gold_icon"));
        int ux = xk.ux(context, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ux, ux);
        layoutParams3.leftMargin = xk.ux(context, 12.0f);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(layoutParams3);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setTypeface(null, 1);
        textView.setText("\u6388\u6743\u6296\u97f3\u8d26\u53f7\u5f97" + i4 + "\u91d1\u5e01");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = xk.ux(context, 8.0f);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams4);
        linearLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(i.xv(context, "ic_top_arrow_right"));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, ux);
        layoutParams5.rightMargin = xk.ux(context, 12.0f);
        imageView2.setLayoutParams(layoutParams5);
        linearLayout.addView(imageView2);
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout.1
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(0);
            }
        }, 2500L);
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout.2
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(8);
            }
        }, 5500L);
    }
}
