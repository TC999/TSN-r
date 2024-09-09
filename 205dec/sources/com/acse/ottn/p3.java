package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p3 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f6133c = 0.85f;

    /* renamed from: b  reason: collision with root package name */
    public float f6134b;

    public p3() {
        this.f6134b = 0.85f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f4 < -1.0f) {
            view.setScaleX(this.f6134b);
            view.setScaleY(this.f6134b);
            view.setPivotX(width);
        } else if (f4 > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.f6134b);
            view.setScaleY(this.f6134b);
        } else if (f4 < 0.0f) {
            float f5 = this.f6134b;
            float f6 = ((f4 + 1.0f) * (1.0f - f5)) + f5;
            view.setScaleX(f6);
            view.setScaleY(f6);
            view.setPivotX(width * (((-f4) * 0.5f) + 0.5f));
        } else {
            float f7 = 1.0f - f4;
            float f8 = this.f6134b;
            float f9 = ((1.0f - f8) * f7) + f8;
            view.setScaleX(f9);
            view.setScaleY(f9);
            view.setPivotX(width * f7 * 0.5f);
        }
    }

    public p3(float f4) {
        this.f6134b = f4;
    }
}
