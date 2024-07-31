package com.acse.ottn.banner.p040e;

import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.acse.ottn.banner.e.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1464h extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2690b = 0.85f;

    /* renamed from: c */
    private float f2691c;

    public C1464h() {
        this.f2691c = f2690b;
    }

    public C1464h(float f) {
        this.f2691c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        float f2;
        float f3;
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f < -1.0f) {
            view.setScaleX(this.f2691c);
            view.setScaleY(this.f2691c);
            view.setPivotX(width);
        } else if (f > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.f2691c);
            view.setScaleY(this.f2691c);
        } else {
            if (f < 0.0f) {
                float f4 = this.f2691c;
                float f5 = ((f + 1.0f) * (1.0f - f4)) + f4;
                view.setScaleX(f5);
                view.setScaleY(f5);
                f2 = width;
                f3 = ((-f) * 0.5f) + 0.5f;
            } else {
                float f6 = 1.0f - f;
                float f7 = this.f2691c;
                float f8 = ((1.0f - f7) * f6) + f7;
                view.setScaleX(f8);
                view.setScaleY(f8);
                f2 = width;
                f3 = f6 * 0.5f;
            }
            view.setPivotX(f2 * f3);
        }
    }
}
