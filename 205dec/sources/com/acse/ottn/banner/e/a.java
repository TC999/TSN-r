package com.acse.ottn.banner.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5278b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    private float f5279c;

    public a() {
        this.f5279c = 0.5f;
    }

    public a(float f4) {
        this.f5279c = f4;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        float f5;
        float f6;
        view.setScaleX(0.999f);
        if (f4 < -1.0f || f4 > 1.0f) {
            view.setAlpha(this.f5279c);
            return;
        }
        if (f4 < 0.0f) {
            f5 = this.f5279c;
            f6 = (1.0f - f5) * (f4 + 1.0f);
        } else {
            f5 = this.f5279c;
            f6 = (1.0f - f5) * (1.0f - f4);
        }
        view.setAlpha(f5 + f6);
    }
}
