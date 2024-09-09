package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.y;
import com.bytedance.sdk.openadsdk.r.w;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    public SaasAuthProductEnvelope(@NonNull Context context, y.c cVar) {
        super(context);
        c(context, cVar);
    }

    private void c(Context context, y.c cVar) {
        if (cVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout c4 = c(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            imageView.setImageResource(i.sr(context, "tt_saas_reward_goods_bg"));
        } catch (Error unused) {
        }
        c4.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387804);
        layoutParams.topMargin = xk.ux(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("\u8d85\u503c\u597d\u7269");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        c4.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = xk.ux(context, 20.0f);
        textView2.setId(2114387461);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(xk.ux(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(cVar.c());
        textView2.setTextColor(Color.parseColor("#161823"));
        c4.addView(textView2);
        int ux = xk.ux(context, 80.0f);
        int ux2 = xk.ux(context, 10.0f);
        ImageView tTRoundRectImageView = new TTRoundRectImageView(context, ux2, ux2);
        tTRoundRectImageView.setId(2114387455);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ux, ux);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = xk.ux(context, 12.0f);
        w.c(cVar.w()).c(ux).w(ux).c(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        c4.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387456);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = xk.ux(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("\u00a5");
        linearLayout.addView(textView3);
        double sr = cVar.sr();
        int floor = (int) Math.floor(sr);
        double d4 = floor;
        Double.isNaN(d4);
        int i4 = (int) ((sr - d4) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(floor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(i4);
        sb.append(i4 >= 10 ? "" : "0");
        textView5.setText(sb.toString());
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("\uffe5" + cVar.xv());
        linearLayout.addView(textView6);
        c4.addView(linearLayout);
        c(context, "\u4e00\u952e\u5173\u8054\u6296\u97f3\u8d2d\u4e70", c4);
        addView(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void c() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void w() {
        super.w();
    }
}
