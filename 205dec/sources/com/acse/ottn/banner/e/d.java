package com.acse.ottn.banner.e;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class d extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final float f5283b = 0.85f;

    /* renamed from: c  reason: collision with root package name */
    private float f5284c;

    public d() {
        this.f5284c = 0.85f;
    }

    public d(float f4) {
        this.f5284c = f4;
    }

    private ViewPager2 a(@NonNull View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View view, float f4) {
        ViewPager2 a4;
        float paddingLeft = a(view).getPaddingLeft();
        float measuredWidth = f4 - (paddingLeft / ((a4.getMeasuredWidth() - paddingLeft) - a4.getPaddingRight()));
        float f5 = this.f5284c;
        float f6 = 1.0f - f5;
        float width = (view.getWidth() * f6) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(width);
            view.setScaleX(this.f5284c);
            view.setScaleY(this.f5284c);
            return;
        }
        double d4 = measuredWidth;
        if (d4 > 1.0d) {
            view.setScaleX(f5);
            view.setScaleY(this.f5284c);
            view.setTranslationX(-width);
            return;
        }
        float abs = f6 * Math.abs(1.0f - Math.abs(measuredWidth));
        float f7 = (-width) * measuredWidth;
        if (d4 <= -0.5d) {
            f7 += Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f;
        } else if (measuredWidth > 0.0f && d4 >= 0.5d) {
            f7 -= Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f;
        }
        view.setTranslationX(f7);
        view.setScaleX(this.f5284c + abs);
        view.setScaleY(abs + this.f5284c);
    }
}
