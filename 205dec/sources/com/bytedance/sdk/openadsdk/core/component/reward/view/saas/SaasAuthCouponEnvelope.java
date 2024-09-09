package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.y;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {

    /* renamed from: c  reason: collision with root package name */
    private TextView f32669c;

    public SaasAuthCouponEnvelope(@NonNull Context context, y.w wVar) {
        super(context);
        c(context, wVar);
    }

    private void c(Context context, y.w wVar) {
        if (wVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout c4 = c(context);
        ImageView imageView = new ImageView(context);
        try {
            imageView.setImageResource(i.sr(context, "tt_saas_reward_coupon_bg"));
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        c4.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387804);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = xk.ux(context, 20.0f);
        textView.setText("\u4f18\u60e0\u5238");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        c4.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387460);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.f32669c = textView2;
        textView2.setId(2114387459);
        this.f32669c.setText(String.valueOf(wVar.c()));
        this.f32669c.setTextColor(Color.parseColor("#F93F3F"));
        this.f32669c.setTextSize(2, 60.0f);
        linearLayout.addView(this.f32669c, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("\u5143");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        c4.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387458);
        textView4.setText("\u6ee1" + wVar.w() + "\u5143\u53ef\u7528");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = xk.ux(context, -4.0f);
        c4.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("\u9886\u53d6\u540e30\u5206\u949f\u5185\u6709\u6548");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = xk.ux(context, 8.0f);
        c4.addView(textView5, layoutParams4);
        c(context, "\u4e00\u952e\u5173\u8054\u6296\u97f3\u9886\u53d6", c4);
        addView(c4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void w() {
        setVisibility(8);
        super.w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void c() {
        setVisibility(0);
    }
}
