package com.acse.ottn.banner.p040e;

import android.view.View;

/* renamed from: com.acse.ottn.banner.e.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1459c extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2680b = 0.75f;

    /* renamed from: c */
    private float f2681c;

    public C1459c() {
        this.f2681c = 0.75f;
    }

    public C1459c(float f) {
        this.f2681c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        int width = view.getWidth();
        if (f >= -1.0f) {
            if (f <= 0.0f) {
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                return;
            } else if (f <= 1.0f) {
                view.setVisibility(0);
                view.setAlpha(1.0f - f);
                view.setTranslationX(width * (-f));
                float f2 = this.f2681c;
                float abs = f2 + ((1.0f - f2) * (1.0f - Math.abs(f)));
                view.setScaleX(abs);
                view.setScaleY(abs);
                if (f == 1.0f) {
                    view.setVisibility(4);
                    return;
                }
                return;
            }
        }
        view.setAlpha(0.0f);
    }
}
