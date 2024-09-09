package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SwiperView extends BaseSwiper<ViewGroup> {
    public SwiperView(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void ev(int i4) {
        super.ev(i4);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper, com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
    public void gd(int i4) {
        super.gd(i4);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View r(int i4) {
        return (ViewGroup) this.f26225c.get(i4);
    }
}
