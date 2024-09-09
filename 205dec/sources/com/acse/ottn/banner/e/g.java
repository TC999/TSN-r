package com.acse.ottn.banner.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class g extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5289b = 35.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f5290c;

    public g() {
        this.f5290c = 35.0f;
    }

    public g(float f4) {
        this.f5290c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        view.setPivotY(view.getHeight() / 2);
        if (f4 >= -1.0f) {
            if (f4 <= 1.0f) {
                view.setRotationY(this.f5290c * f4);
                if (f4 < 0.0f) {
                    view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
                } else {
                    view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
                }
            } else {
                view.setRotationY(this.f5290c * 1.0f);
            }
            view.setPivotX(0.0f);
            return;
        }
        view.setRotationY(this.f5290c * (-1.0f));
        view.setPivotX(view.getWidth());
    }
}
