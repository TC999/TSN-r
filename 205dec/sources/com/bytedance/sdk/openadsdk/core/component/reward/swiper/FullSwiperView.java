package com.bytedance.sdk.openadsdk.core.component.reward.swiper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.swiper.BaseSwiper;
import com.bytedance.adsdk.ugeno.viewpager.ViewPager;
import com.bytedance.sdk.openadsdk.core.bk.sr;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.u.ls;
import com.bytedance.sdk.openadsdk.core.u.me;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FullSwiperView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f32563a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    private BaseSwiper<ViewGroup> f32564c;
    private List<Integer> ev;

    /* renamed from: f  reason: collision with root package name */
    private String f32565f;
    private List<Integer> gd;

    /* renamed from: k  reason: collision with root package name */
    private List<FullSwiperItemView> f32566k;

    /* renamed from: p  reason: collision with root package name */
    private List<Long> f32567p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f32568r;
    private float sr;

    /* renamed from: t  reason: collision with root package name */
    private AtomicBoolean f32569t;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private List<c> f32570w;
    private Context xv;

    public FullSwiperView(Context context) {
        super(context);
        this.f32568r = false;
        this.bk = true;
        this.f32569t = new AtomicBoolean(false);
        this.xv = context;
        this.ev = new ArrayList();
        this.gd = new ArrayList();
        this.f32567p = new ArrayList();
        this.f32564c = new SwiperView(context);
        this.f32566k = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f32564c, layoutParams);
    }

    public int getCurrentPosition() {
        return this.f32563a;
    }

    public void sr() {
        BaseSwiper<ViewGroup> baseSwiper = this.f32564c;
        if (baseSwiper != null) {
            baseSwiper.ux();
        }
    }

    public void ux() {
        for (FullSwiperItemView fullSwiperItemView : this.f32566k) {
            if (fullSwiperItemView != null) {
                fullSwiperItemView.s();
            }
        }
    }

    public FullSwiperView w(float f4) {
        this.ux = f4;
        return this;
    }

    public void xv() {
        FullSwiperItemView w3 = w(this.f32563a);
        if (w3 != null) {
            w3.fp();
        }
        if (this.f32563a == this.f32566k.size() - 1) {
            return;
        }
        this.f32564c.p(this.f32563a);
        List<Integer> list = this.gd;
        if (list == null || this.f32563a >= list.size()) {
            return;
        }
        if (!this.bk && !this.f32569t.get()) {
            this.f32564c.k(this.gd.get(this.f32563a).intValue());
        }
        this.bk = false;
    }

    public FullSwiperView c(List<c> list) {
        this.f32570w = list;
        return this;
    }

    public void w() {
        FullSwiperItemView w3 = w(this.f32563a);
        if (w3 != null) {
            w3.ys();
        }
        List<Long> list = this.f32567p;
        if (list != null && this.f32563a < list.size()) {
            this.gd.add(this.f32563a, Integer.valueOf(this.ev.get(this.f32563a).intValue() - ((int) (System.currentTimeMillis() - this.f32567p.get(this.f32563a).longValue()))));
        }
        this.f32564c.ux();
    }

    public FullSwiperView c(float f4) {
        this.sr = f4;
        return this;
    }

    public FullSwiperView c(String str) {
        this.f32565f = str;
        return this;
    }

    public void c() {
        ls dc;
        List<c> list = this.f32570w;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f32564c.c(false).sr(false).xv(false).w(false);
        this.f32564c.setOnPageChangeListener(new ViewPager.i() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.1
            @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
            public void c(int i4, float f4, int i5) {
            }

            @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
            public void ev(int i4) {
                FullSwiperView.this.f32563a = i4;
                FullSwiperItemView w3 = FullSwiperView.this.w(i4);
                if (w3 != null && FullSwiperView.this.f32563a != 0) {
                    w3.w(false);
                }
                FullSwiperItemView w4 = FullSwiperView.this.w(i4 - 1);
                if (w4 != null) {
                    w4.ys();
                    w4.ia();
                }
                FullSwiperView.this.c(i4 + 1);
                if (!FullSwiperView.this.f32568r && i4 >= 1) {
                    FullSwiperView.this.f32568r = true;
                    sr.w(FullSwiperView.this.f32565f);
                }
                int intValue = ((Integer) FullSwiperView.this.ev.get(i4)).intValue();
                if (intValue > 0 && i4 != FullSwiperView.this.f32566k.size() - 1) {
                    FullSwiperView.this.f32567p.add(i4, Long.valueOf(System.currentTimeMillis()));
                    if (FullSwiperView.this.f32569t.get()) {
                        return;
                    }
                    FullSwiperView.this.f32564c.k(intValue);
                }
            }

            @Override // com.bytedance.adsdk.ugeno.viewpager.ViewPager.i
            public void gd(int i4) {
            }
        });
        for (c cVar : this.f32570w) {
            me c4 = cVar.c();
            if (c4 != null && (dc = c4.dc()) != null) {
                this.ev.add(Integer.valueOf((int) dc.w()));
                this.gd.add(0);
                this.f32567p.add(Long.valueOf(System.currentTimeMillis()));
                FullSwiperItemView fullSwiperItemView = new FullSwiperItemView(this.xv, cVar, this.sr, this.ux);
                fullSwiperItemView.setOnSwiperItemInteractListener(new FullSwiperItemView.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.c
                    public void c() {
                        FullSwiperView.this.f32564c.ux();
                        FullSwiperView.this.f32569t.set(true);
                    }
                });
                this.f32564c.c((BaseSwiper<ViewGroup>) fullSwiperItemView);
                this.f32566k.add(fullSwiperItemView);
            }
        }
        final FullSwiperItemView fullSwiperItemView2 = this.f32566k.get(0);
        fullSwiperItemView2.setOnSwiperItemRenderResultListener(new FullSwiperItemView.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView.w
            public void c(View view, float f4, float f5) {
                int intValue = ((Integer) FullSwiperView.this.ev.get(0)).intValue();
                if (intValue <= 0) {
                    FullSwiperView.this.f32564c.sr();
                } else {
                    FullSwiperView.this.f32567p.add(0, Long.valueOf(System.currentTimeMillis()));
                    FullSwiperView.this.f32564c.sr();
                    FullSwiperView.this.f32564c.k(intValue);
                }
                fullSwiperItemView2.w(true);
                FullSwiperView.this.c(1);
            }
        });
        fullSwiperItemView2.bk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FullSwiperItemView w(int i4) {
        List<FullSwiperItemView> list = this.f32566k;
        if (list == null || i4 < 0 || i4 >= list.size()) {
            return null;
        }
        return this.f32566k.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        FullSwiperItemView w3 = w(i4);
        if (w3 != null) {
            w3.bk();
        }
    }
}
