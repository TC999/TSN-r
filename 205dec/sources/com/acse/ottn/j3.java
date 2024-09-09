package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j3 extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f5786c = 15.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f5787b;

    public j3() {
        this.f5787b = 15.0f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        if (f4 < -1.0f) {
            view.setRotation(this.f5787b);
            view.setPivotX(view.getWidth());
            view.setPivotY(0.0f);
        } else if (f4 > 1.0f) {
            view.setRotation(-this.f5787b);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
        } else if (f4 < 0.0f) {
            view.setPivotX(view.getWidth() * (((-f4) * 0.5f) + 0.5f));
            view.setPivotY(0.0f);
            view.setRotation((-this.f5787b) * f4);
        } else {
            view.setPivotX(view.getWidth() * 0.5f * (1.0f - f4));
            view.setPivotY(0.0f);
            view.setRotation((-this.f5787b) * f4);
        }
    }

    public j3(float f4) {
        this.f5787b = f4;
    }
}
