package com.acse.ottn.banner.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5291b = 0.85f;

    /* renamed from: c  reason: collision with root package name */
    private float f5292c;

    public h() {
        this.f5292c = 0.85f;
    }

    public h(float f4) {
        this.f5292c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        float f5;
        float f6;
        int width = view.getWidth();
        view.setPivotY(view.getHeight() / 2);
        view.setPivotX(width / 2);
        if (f4 < -1.0f) {
            view.setScaleX(this.f5292c);
            view.setScaleY(this.f5292c);
            view.setPivotX(width);
        } else if (f4 > 1.0f) {
            view.setPivotX(0.0f);
            view.setScaleX(this.f5292c);
            view.setScaleY(this.f5292c);
        } else {
            if (f4 < 0.0f) {
                float f7 = this.f5292c;
                float f8 = ((f4 + 1.0f) * (1.0f - f7)) + f7;
                view.setScaleX(f8);
                view.setScaleY(f8);
                f5 = width;
                f6 = ((-f4) * 0.5f) + 0.5f;
            } else {
                float f9 = 1.0f - f4;
                float f10 = this.f5292c;
                float f11 = ((1.0f - f10) * f9) + f10;
                view.setScaleX(f11);
                view.setScaleY(f11);
                f5 = width;
                f6 = f9 * 0.5f;
            }
            view.setPivotX(f5 * f6);
        }
    }
}
