package com.acse.ottn.banner.p040e;

import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.acse.ottn.banner.e.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1462f extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2686b = 15.0f;

    /* renamed from: c */
    private float f2687c;

    public C1462f() {
        this.f2687c = f2686b;
    }

    public C1462f(float f) {
        this.f2687c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        if (f < -1.0f) {
            view.setRotation(this.f2687c);
            view.setPivotX(view.getWidth());
        } else if (f <= 1.0f) {
            if (f < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
            }
            view.setPivotY(0.0f);
            view.setRotation((-this.f2687c) * f);
            return;
        } else {
            view.setRotation(-this.f2687c);
            view.setPivotX(0.0f);
        }
        view.setPivotY(0.0f);
    }
}
