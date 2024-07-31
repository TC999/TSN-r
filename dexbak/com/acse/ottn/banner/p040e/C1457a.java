package com.acse.ottn.banner.p040e;

import android.view.View;
import androidx.annotation.NonNull;

/* renamed from: com.acse.ottn.banner.e.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1457a extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2677b = 0.5f;

    /* renamed from: c */
    private float f2678c;

    public C1457a() {
        this.f2678c = 0.5f;
    }

    public C1457a(float f) {
        this.f2678c = f;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        float f2;
        float f3;
        view.setScaleX(0.999f);
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(this.f2678c);
            return;
        }
        if (f < 0.0f) {
            f2 = this.f2678c;
            f3 = (1.0f - f2) * (f + 1.0f);
        } else {
            f2 = this.f2678c;
            f3 = (1.0f - f2) * (1.0f - f);
        }
        view.setAlpha(f2 + f3);
    }
}
