package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i3 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f5742c = 15.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f5743b;

    public i3() {
        this.f5743b = 15.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        if (f4 < -1.0f) {
            view.setRotation(this.f5743b * (-1.0f));
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else if (f4 > 1.0f) {
            view.setRotation(this.f5743b);
            view.setPivotX(view.getWidth() * 0);
            view.setPivotY(view.getHeight());
        } else if (f4 < 0.0f) {
            view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
            view.setPivotY(view.getHeight());
            view.setRotation(this.f5743b * f4);
        } else {
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
            view.setPivotY(view.getHeight());
            view.setRotation(this.f5743b * f4);
        }
    }

    public i3(float f4) {
        this.f5743b = f4;
    }
}
