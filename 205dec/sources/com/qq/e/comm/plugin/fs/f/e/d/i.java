package com.qq.e.comm.plugin.fs.f.e.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends RelativeLayout {
    public i(Context context) {
        this(context, null);
    }

    private void b() {
        d1.a("LoadingView init", new Object[0]);
        setLayerType(1, null);
        setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("endcardLoadingUrl");
        if (TextUtils.isEmpty(c4)) {
            c4 = "https://qzs.qq.com/union/res/union_cdn/page/images/loading_2x.gif";
        }
        com.qq.e.comm.plugin.r0.f fVar = new com.qq.e.comm.plugin.r0.f(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(128, 128);
        layoutParams2.addRule(13);
        fVar.setId(2131755010);
        com.qq.e.comm.plugin.b0.b.a().a(c4, fVar);
        addView(fVar, layoutParams2);
        TextView textView = new TextView(getContext());
        textView.setId(2131755011);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2131755010);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = f1.a(getContext(), 16);
        textView.setLayoutParams(layoutParams3);
        textView.setText("\u6b63\u5728\u52a0\u8f7d\u6e38\u620f");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        addView(textView);
        TextView textView2 = new TextView(getContext());
        textView2.setId(2131755012);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, 2131755011);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = f1.a(getContext(), 8);
        textView2.setLayoutParams(layoutParams4);
        textView2.setText("\u5373\u5c06\u5f00\u542f\u8bd5\u73a9");
        textView2.setTextColor(-1);
        textView2.setTextSize(16.0f);
        addView(textView2);
        setVisibility(8);
    }

    public void a() {
        d1.a("LoadingView dismiss", new Object[0]);
        clearAnimation();
        setVisibility(8);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }
}
