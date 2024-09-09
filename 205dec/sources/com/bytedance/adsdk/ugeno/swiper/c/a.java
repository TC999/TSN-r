package com.bytedance.adsdk.ugeno.swiper.c;

import android.view.View;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a implements ViewPager.e {

    /* renamed from: a  reason: collision with root package name */
    final float f26239a = 0.8f;

    /* renamed from: b  reason: collision with root package name */
    final float f26240b = 0.5f;

    @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.e
    public void a(View view, float f4) {
        float f5 = ((f4 < 0.0f ? 0.19999999f : -0.19999999f) * f4) + 1.0f;
        float f6 = ((f4 < 0.0f ? 0.5f : -0.5f) * f4) + 1.0f;
        if (f4 < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f5);
        view.setScaleY(f5);
        view.setAlpha(Math.abs(f6));
    }
}
