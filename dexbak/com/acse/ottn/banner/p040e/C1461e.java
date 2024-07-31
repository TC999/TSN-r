package com.acse.ottn.banner.p040e;

import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.acse.ottn.banner.e.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1461e extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2684b = 15.0f;

    /* renamed from: c */
    private float f2685c;

    public C1461e() {
        this.f2685c = f2684b;
    }

    public C1461e(float f) {
        this.f2685c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        int width;
        if (f < -1.0f) {
            view.setRotation(this.f2685c * (-1.0f));
            width = view.getWidth();
        } else if (f <= 1.0f) {
            if (f < 0.0f) {
                view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
            } else {
                view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
            }
            view.setPivotY(view.getHeight());
            view.setRotation(this.f2685c * f);
            return;
        } else {
            view.setRotation(this.f2685c);
            width = view.getWidth() * 0;
        }
        view.setPivotX(width);
        view.setPivotY(view.getHeight());
    }
}
