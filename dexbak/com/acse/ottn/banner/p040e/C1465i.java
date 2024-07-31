package com.acse.ottn.banner.p040e;

import android.view.View;

/* renamed from: com.acse.ottn.banner.e.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1465i extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2692b = 0.85f;

    /* renamed from: c */
    private static final float f2693c = 0.5f;

    /* renamed from: d */
    private float f2694d;

    /* renamed from: e */
    private float f2695e;

    public C1465i() {
        this.f2694d = f2692b;
        this.f2695e = 0.5f;
    }

    public C1465i(float f, float f2) {
        this.f2694d = f;
        this.f2695e = f2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        float max = Math.max(this.f2694d, 1.0f - Math.abs(f));
        float f2 = 1.0f - max;
        float f3 = (height * f2) / 2.0f;
        float f4 = (width * f2) / 2.0f;
        if (f < 0.0f) {
            view.setTranslationX(f4 - (f3 / 2.0f));
        } else {
            view.setTranslationX((-f4) + (f3 / 2.0f));
        }
        view.setScaleX(max);
        view.setScaleY(max);
        float f5 = this.f2695e;
        float f6 = this.f2694d;
        view.setAlpha(f5 + (((max - f6) / (1.0f - f6)) * (1.0f - f5)));
    }
}
