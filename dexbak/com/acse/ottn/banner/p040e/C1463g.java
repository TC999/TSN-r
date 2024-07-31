package com.acse.ottn.banner.p040e;

import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.acse.ottn.banner.e.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1463g extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2688b = 35.0f;

    /* renamed from: c */
    private float f2689c;

    public C1463g() {
        this.f2689c = f2688b;
    }

    public C1463g(float f) {
        this.f2689c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        view.setPivotY(view.getHeight() / 2);
        if (f >= -1.0f) {
            if (f <= 1.0f) {
                view.setRotationY(this.f2689c * f);
                if (f < 0.0f) {
                    view.setPivotX(view.getWidth() * (((-f) * 0.5f) + 0.5f));
                } else {
                    view.setPivotX(view.getWidth() * 0.5f * (1.0f - f));
                }
            } else {
                view.setRotationY(this.f2689c * 1.0f);
            }
            view.setPivotX(0.0f);
            return;
        }
        view.setRotationY(this.f2689c * (-1.0f));
        view.setPivotX(view.getWidth());
    }
}
