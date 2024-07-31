package com.mbridge.msdk.widget.custom.baseview;

import android.graphics.drawable.GradientDrawable;

/* renamed from: com.mbridge.msdk.widget.custom.baseview.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class StrokeGradientDrawable {

    /* renamed from: a */
    private int f32602a;

    /* renamed from: b */
    private int f32603b;

    /* renamed from: c */
    private GradientDrawable f32604c;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.f32604c = gradientDrawable;
    }

    /* renamed from: a */
    public final void m20513a(int i) {
        this.f32602a = i;
        this.f32604c.setStroke(i, this.f32603b);
    }

    /* renamed from: b */
    public final void m20512b(int i) {
        this.f32603b = i;
        this.f32604c.setStroke(this.f32602a, i);
    }

    /* renamed from: a */
    public final GradientDrawable m20514a() {
        return this.f32604c;
    }
}
