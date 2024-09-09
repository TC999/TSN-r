package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class k3 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f5808c = 35.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f5809b;

    public k3() {
        this.f5809b = 35.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        view.setPivotY(view.getHeight() / 2);
        if (f4 < -1.0f) {
            view.setRotationY(this.f5809b * (-1.0f));
            view.setPivotX(view.getWidth());
        } else if (f4 <= 1.0f) {
            view.setRotationY(this.f5809b * f4);
            if (f4 < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
                view.setPivotX(view.getWidth());
                return;
            }
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
            view.setPivotX(0.0f);
        } else {
            view.setRotationY(this.f5809b * 1.0f);
            view.setPivotX(0.0f);
        }
    }

    public k3(float f4) {
        this.f5809b = f4;
    }
}
