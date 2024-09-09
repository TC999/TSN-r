package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv extends c {
    @Override // com.bytedance.sdk.openadsdk.res.layout.c
    public View c(Context context) {
        RelativeLayout c4 = c(context, 2114387615);
        c4.addView(w(context, 159));
        c4.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387743);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 2114387916);
        layoutParams.addRule(14);
        layoutParams.setMargins(0, xk.ux(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(context.getResources().getColor(17170443));
        textView.setTextSize(2, 16.0f);
        c4.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387809);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387743);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, xk.ux(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextColor(context.getResources().getColor(17170443));
        textView2.setTextSize(2, 12.0f);
        textView2.setText(i.c(context, "tt_live_loading_text"));
        c4.addView(textView2);
        TTProgressBar tTProgressBar = new TTProgressBar(context, null, i.ux(context, "tt_Widget_ProgressBar_Horizontal"));
        tTProgressBar.setId(2114387682);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(xk.ux(context, 32.0f), xk.ux(context, 32.0f));
        layoutParams3.addRule(3, 2114387809);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, xk.ux(context, 32.0f), 0, 0);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(i.xv(context, "tt_live_video_loading_progress"));
        c4.addView(tTProgressBar);
        c4.addView(c(context, 158, 6));
        return c4;
    }
}
