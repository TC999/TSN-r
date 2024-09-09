package com.acse.ottn;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final float f5663c = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    public float f5664b;

    public g() {
        this.f5664b = 0.5f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        view.setScaleX(0.999f);
        if (f4 < -1.0f) {
            view.setAlpha(this.f5664b);
        } else if (f4 > 1.0f) {
            view.setAlpha(this.f5664b);
        } else if (f4 < 0.0f) {
            float f5 = this.f5664b;
            view.setAlpha(f5 + ((1.0f - f5) * (f4 + 1.0f)));
        } else {
            float f6 = this.f5664b;
            view.setAlpha(f6 + ((1.0f - f6) * (1.0f - f4)));
        }
    }

    public g(float f4) {
        this.f5664b = f4;
    }
}
