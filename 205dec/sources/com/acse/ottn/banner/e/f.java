package com.acse.ottn.banner.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5287b = 15.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f5288c;

    public f() {
        this.f5288c = 15.0f;
    }

    public f(float f4) {
        this.f5288c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        if (f4 < -1.0f) {
            view.setRotation(this.f5288c);
            view.setPivotX(view.getWidth());
        } else if (f4 <= 1.0f) {
            if (f4 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
            }
            view.setPivotY(0.0f);
            view.setRotation((-this.f5288c) * f4);
            return;
        } else {
            view.setRotation(-this.f5288c);
            view.setPivotX(0.0f);
        }
        view.setPivotY(0.0f);
    }
}
