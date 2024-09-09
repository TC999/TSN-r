package com.acse.ottn.banner.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5285b = 15.0f;

    /* renamed from: c  reason: collision with root package name */
    private float f5286c;

    public e() {
        this.f5286c = 15.0f;
    }

    public e(float f4) {
        this.f5286c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        int width;
        if (f4 < -1.0f) {
            view.setRotation(this.f5286c * (-1.0f));
            width = view.getWidth();
        } else if (f4 <= 1.0f) {
            if (f4 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
            }
            view.setPivotY(view.getHeight());
            view.setRotation(this.f5286c * f4);
            return;
        } else {
            view.setRotation(this.f5286c);
            width = view.getWidth() * 0;
        }
        view.setPivotX(width);
        view.setPivotY(view.getHeight());
    }
}
