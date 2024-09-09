package com.bytedance.sdk.openadsdk.res.layout.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv implements com.bytedance.sdk.openadsdk.res.layout.c {
    @Override // com.bytedance.sdk.openadsdk.res.layout.c
    public View c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387601);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387600);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, xk.ux(context, 44.0f)));
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387704);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.setMargins(xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f));
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(true);
        imageView.setFocusable(true);
        imageView.setPadding(xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f));
        int parseColor = Color.parseColor("#6E6E6E");
        com.bytedance.sdk.openadsdk.res.c cVar = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar.c(parseColor);
        float ux = xk.ux(context, 2.0f);
        cVar.c(ux);
        int parseColor2 = Color.parseColor("#B1B1B1");
        com.bytedance.sdk.openadsdk.res.c cVar2 = new com.bytedance.sdk.openadsdk.res.c(48);
        cVar2.c(parseColor2);
        cVar2.c(ux);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, cVar);
        stateListDrawable.addState(new int[0], cVar2);
        imageView.setImageDrawable(stateListDrawable);
        relativeLayout.addView(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(2114387703);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(17, 2114387704);
        imageView2.setLayoutParams(layoutParams2);
        imageView2.setClickable(true);
        imageView2.setFocusable(true);
        imageView2.setPadding(xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f), xk.ux(context, 5.0f));
        com.bytedance.sdk.openadsdk.res.xv xvVar = new com.bytedance.sdk.openadsdk.res.xv(48);
        xvVar.c(parseColor);
        xvVar.c(ux);
        com.bytedance.sdk.openadsdk.res.xv xvVar2 = new com.bytedance.sdk.openadsdk.res.xv(48);
        xvVar2.c(parseColor2);
        xvVar2.c(ux);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        stateListDrawable2.addState(new int[]{16842919}, xvVar);
        stateListDrawable2.addState(new int[0], xvVar2);
        imageView2.setImageDrawable(stateListDrawable2);
        relativeLayout.addView(imageView2);
        TextView textView = new TextView(context);
        textView.setId(2114387952);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(xk.ux(context, 200.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.addRule(15);
        layoutParams3.setMargins(xk.ux(context, 25.0f), 0, xk.ux(context, 25.0f), 0);
        textView.setLayoutParams(layoutParams3);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setGravity(17);
        textView.setPadding(xk.ux(context, 25.0f), 0, xk.ux(context, 25.0f), 0);
        textView.setSingleLine(true);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387626);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(21);
        layoutParams4.addRule(11);
        layoutParams4.addRule(15);
        layoutParams4.setMargins(0, 0, xk.ux(context, 15.0f), 0);
        textView2.setLayoutParams(layoutParams4);
        textView2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView2.setGravity(8388613);
        textView2.setSingleLine(true);
        textView2.setText(i.c(context, "tt_feedback"));
        textView2.setTextColor(Color.parseColor("#808080"));
        relativeLayout.addView(textView2);
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setId(2114387675);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, xk.ux(context, 77.0f));
        linearLayout2.setLayoutParams(layoutParams5);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setOrientation(1);
        linearLayout2.setVisibility(8);
        ImageView imageView3 = new ImageView(context);
        imageView3.setId(2114387599);
        imageView3.setLayoutParams(new LinearLayout.LayoutParams(-1, xk.ux(context, 1.0f)));
        imageView3.setBackgroundColor(Color.parseColor("#F2F2F2"));
        linearLayout2.addView(imageView3);
        TextView textView3 = new TextView(context);
        textView3.setId(2114387609);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, xk.ux(context, 15.0f));
        layoutParams6.setMargins(xk.ux(context, 16.0f), xk.ux(context, 8.0f), xk.ux(context, 16.0f), 0);
        textView3.setLayoutParams(layoutParams6);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        textView3.setSingleLine(true);
        textView3.setTextColor(Color.parseColor("#999999"));
        textView3.setTextSize(2, 10.0f);
        linearLayout2.addView(textView3);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387700);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, xk.ux(context, 15.0f));
        layoutParams7.setMargins(xk.ux(context, 16.0f), xk.ux(context, 7.0f), xk.ux(context, 16.0f), 0);
        textView4.setLayoutParams(layoutParams7);
        textView4.setEllipsize(TextUtils.TruncateAt.END);
        textView4.setSingleLine(true);
        textView4.setTextColor(Color.parseColor("#999999"));
        textView4.setTextSize(2, 10.0f);
        linearLayout2.addView(textView4);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387598);
        ViewGroup.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.setMargins(0, xk.ux(context, 8.0f), 0, 0);
        relativeLayout2.setLayoutParams(layoutParams8);
        relativeLayout2.setBackgroundColor(Color.parseColor("#26C4C4C4"));
        TextView textView5 = new TextView(context);
        textView5.setId(2114387597);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(xk.ux(context, 70.0f), -1);
        layoutParams9.addRule(20);
        layoutParams9.addRule(9);
        layoutParams9.addRule(10);
        layoutParams9.addRule(12);
        layoutParams9.setMargins(xk.ux(context, 64.0f), 0, 0, 0);
        textView5.setLayoutParams(layoutParams9);
        textView5.setGravity(17);
        textView5.setText("\u5e94\u7528\u6743\u9650");
        textView5.setTextColor(Color.parseColor("#1A73E8"));
        textView5.setTextSize(2, 12.0f);
        relativeLayout2.addView(textView5);
        ImageView imageView4 = new ImageView(context);
        imageView4.setId(2114387596);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(xk.ux(context, 0.5f), xk.ux(context, 9.0f));
        layoutParams10.addRule(13);
        imageView4.setLayoutParams(layoutParams10);
        imageView4.setBackgroundColor(Color.parseColor("#D8D8D8"));
        relativeLayout2.addView(imageView4);
        TextView textView6 = new TextView(context);
        textView6.setId(2114387699);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(xk.ux(context, 70.0f), -1);
        layoutParams11.addRule(21);
        layoutParams11.addRule(11);
        layoutParams11.addRule(10);
        layoutParams11.addRule(12);
        layoutParams11.setMargins(0, 0, xk.ux(context, 64.0f), 0);
        textView6.setLayoutParams(layoutParams11);
        textView6.setGravity(17);
        textView6.setText("\u9690\u79c1\u534f\u8bae");
        textView6.setTextColor(Color.parseColor("#1A73E8"));
        textView6.setTextSize(2, 12.0f);
        relativeLayout2.addView(textView6);
        linearLayout2.addView(relativeLayout2);
        linearLayout.addView(linearLayout2);
        return linearLayout;
    }
}
