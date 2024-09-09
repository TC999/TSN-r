package com.acse.ottn.banner.e;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5293b = 0.85f;

    /* renamed from: c  reason: collision with root package name */
    private static final float f5294c = 0.5f;

    /* renamed from: d  reason: collision with root package name */
    private float f5295d;

    /* renamed from: e  reason: collision with root package name */
    private float f5296e;

    public i() {
        this.f5295d = 0.85f;
        this.f5296e = 0.5f;
    }

    public i(float f4, float f5) {
        this.f5295d = f4;
        this.f5296e = f5;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f4) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f4 < -1.0f || f4 > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float max = Math.max(this.f5295d, 1.0f - Math.abs(f4));
        float f5 = 1.0f - max;
        float f6 = (height * f5) / 2.0f;
        float f7 = (width * f5) / 2.0f;
        if (f4 < 0.0f) {
            view.setTranslationX(f7 - (f6 / 2.0f));
        } else {
            view.setTranslationX((-f7) + (f6 / 2.0f));
        }
        view.setScaleX(max);
        view.setScaleY(max);
        float f8 = this.f5296e;
        float f9 = this.f5295d;
        view.setAlpha(f8 + (((max - f9) / (1.0f - f9)) * (1.0f - f8)));
    }
}
