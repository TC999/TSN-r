package com.acse.ottn;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class t0 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f6606c = 0.75f;

    /* renamed from: b  reason: collision with root package name */
    public float f6607b;

    public t0() {
        this.f6607b = 0.75f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f4) {
        int width = view.getWidth();
        if (f4 < -1.0f) {
            view.setAlpha(0.0f);
        } else if (f4 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f4 <= 1.0f) {
            view.setVisibility(0);
            view.setAlpha(1.0f - f4);
            view.setTranslationX(width * (-f4));
            float f5 = this.f6607b;
            float abs = f5 + ((1.0f - f5) * (1.0f - Math.abs(f4)));
            view.setScaleX(abs);
            view.setScaleY(abs);
            if (f4 == 1.0f) {
                view.setVisibility(4);
            }
        } else {
            view.setAlpha(0.0f);
        }
    }

    public t0(float f4) {
        this.f6607b = f4;
    }
}
