package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ShakeClickView extends ShakeAnimationView {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29608c;

    public ShakeClickView(Context context, View view, int i4, int i5, int i6) {
        super(context, view, i4, i5, i6);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void c(Context context, View view) {
        addView(view);
        this.f29608c = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.f29608c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.f29608c.setText(i.w(this.f29608c.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e4) {
                a.f("shakeClickView", e4.getMessage());
                return;
            }
        }
        this.f29608c.setText(str);
    }
}
