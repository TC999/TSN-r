package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.res.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardChestView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f32620c;

    /* renamed from: w  reason: collision with root package name */
    private View f32621w;

    public RewardChestView(Context context) {
        super(context);
        c();
    }

    void c() {
        addView(ux.f(getContext()));
        this.f32620c = (LinearLayout) findViewById(2114387906);
        this.f32621w = findViewById(2114387810);
    }

    public void c(int i4) {
    }

    public void c(int i4, int i5) {
    }

    public void ev() {
        setVisibility(8);
    }

    public void f() {
    }

    public void r() {
    }

    public void setRewardChestTip(boolean z3) {
        xk.c(this.f32621w, z3 ? 0 : 8);
    }

    public void sr() {
        this.f32620c.setHorizontalGravity(8388627);
    }

    public void ux() {
        this.f32620c.setHorizontalGravity(8388629);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f32620c.getLayoutParams();
        layoutParams.gravity = 80;
        layoutParams.rightMargin = xk.ux(getContext(), 16.0f);
        layoutParams.bottomMargin = xk.ux(getContext(), 100.0f);
    }

    public void w() {
    }

    public void xv() {
    }
}
