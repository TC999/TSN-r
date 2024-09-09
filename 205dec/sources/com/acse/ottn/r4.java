package com.acse.ottn;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class r4 extends c0 {

    /* renamed from: d  reason: collision with root package name */
    public static final float f6205d = 0.85f;

    /* renamed from: e  reason: collision with root package name */
    public static final float f6206e = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public float f6207b;

    /* renamed from: c  reason: collision with root package name */
    public float f6208c;

    public r4() {
        this.f6207b = 0.85f;
        this.f6208c = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f4) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (f4 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f4 <= 1.0f) {
            float max = Math.max(this.f6207b, 1.0f - Math.abs(f4));
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
            float f8 = this.f6208c;
            float f9 = this.f6207b;
            view.setAlpha(f8 + (((max - f9) / (1.0f - f9)) * (1.0f - f8)));
        } else {
            view.setAlpha(0.0f);
        }
    }

    public r4(float f4, float f5) {
        this.f6207b = f4;
        this.f6208c = f5;
    }
}
