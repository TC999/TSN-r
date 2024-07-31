package com.acse.ottn.banner.p040e;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: com.acse.ottn.banner.e.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1460d extends AbstractC1458b {

    /* renamed from: b */
    private static final float f2682b = 0.85f;

    /* renamed from: c */
    private float f2683c;

    public C1460d() {
        this.f2683c = f2682b;
    }

    public C1460d(float f) {
        this.f2683c = f;
    }

    /* renamed from: a */
    private ViewPager2 m56706a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f) {
        ViewPager2 m56706a;
        float paddingLeft = m56706a(view).getPaddingLeft();
        float measuredWidth = f - (paddingLeft / ((m56706a.getMeasuredWidth() - paddingLeft) - m56706a.getPaddingRight()));
        float f2 = this.f2683c;
        float f3 = 1.0f - f2;
        float width = (view.getWidth() * f3) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(width);
            view.setScaleX(this.f2683c);
            view.setScaleY(this.f2683c);
            return;
        }
        double d = measuredWidth;
        if (d > 1.0d) {
            view.setScaleX(f2);
            view.setScaleY(this.f2683c);
            view.setTranslationX(-width);
            return;
        }
        float abs = f3 * Math.abs(1.0f - Math.abs(measuredWidth));
        float f4 = (-width) * measuredWidth;
        if (d <= -0.5d) {
            f4 += Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f;
        } else if (measuredWidth > 0.0f && d >= 0.5d) {
            f4 -= Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f;
        }
        view.setTranslationX(f4);
        view.setScaleX(this.f2683c + abs);
        view.setScaleY(abs + this.f2683c);
    }
}
