package com.acse.ottn.banner.e;

import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5281b = 0.75f;

    /* renamed from: c  reason: collision with root package name */
    private float f5282c;

    public c() {
        this.f5282c = 0.75f;
    }

    public c(float f4) {
        this.f5282c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f4) {
        int width = view.getWidth();
        if (f4 >= -1.0f) {
            if (f4 <= 0.0f) {
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                return;
            } else if (f4 <= 1.0f) {
                view.setVisibility(0);
                view.setAlpha(1.0f - f4);
                view.setTranslationX(width * (-f4));
                float f5 = this.f5282c;
                float abs = f5 + ((1.0f - f5) * (1.0f - Math.abs(f4)));
                view.setScaleX(abs);
                view.setScaleY(abs);
                if (f4 == 1.0f) {
                    view.setVisibility(4);
                    return;
                }
                return;
            }
        }
        view.setAlpha(0.0f);
    }
}
