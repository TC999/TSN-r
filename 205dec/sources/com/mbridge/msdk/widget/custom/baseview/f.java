package com.mbridge.msdk.widget.custom.baseview;

import android.graphics.drawable.GradientDrawable;

/* compiled from: StrokeGradientDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private int f41289a;

    /* renamed from: b  reason: collision with root package name */
    private int f41290b;

    /* renamed from: c  reason: collision with root package name */
    private GradientDrawable f41291c;

    public f(GradientDrawable gradientDrawable) {
        this.f41291c = gradientDrawable;
    }

    public final void a(int i4) {
        this.f41289a = i4;
        this.f41291c.setStroke(i4, this.f41290b);
    }

    public final void b(int i4) {
        this.f41290b = i4;
        this.f41291c.setStroke(this.f41289a, i4);
    }

    public final GradientDrawable a() {
        return this.f41291c;
    }
}
