package com.beizi.fusion.p072g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.ScrollClickView;

/* renamed from: com.beizi.fusion.g.ap */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScrollClickUtil {

    /* renamed from: j */
    private static AdSpacesBean.BuyerBean.ScrollClickBean f11304j;

    /* renamed from: a */
    ScrollClickView f11305a;

    /* renamed from: b */
    int f11306b;

    /* renamed from: c */
    int f11307c;

    /* renamed from: d */
    private Context f11308d;

    /* renamed from: e */
    private int f11309e;

    /* renamed from: f */
    private int f11310f;

    /* renamed from: g */
    private InterfaceC3132a f11311g = null;

    /* renamed from: h */
    private boolean f11312h = false;

    /* renamed from: i */
    private int f11313i = 200;

    /* compiled from: ScrollClickUtil.java */
    /* renamed from: com.beizi.fusion.g.ap$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3132a {
        /* renamed from: b */
        void mo46554b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

        /* renamed from: c_ */
        void mo46549c_();
    }

    public ScrollClickUtil(Context context) {
        this.f11308d = context;
    }

    /* renamed from: c */
    private void m48371c() {
        Pair<Integer, Boolean> m48370c = m48370c(this.f11310f);
        if (((Boolean) m48370c.second).booleanValue()) {
            HandlerUtil.m48514a(new Runnable() { // from class: com.beizi.fusion.g.ap.1
                @Override // java.lang.Runnable
                public void run() {
                    ScrollClickUtil.this.m48379a();
                }
            }, this.f11309e + (((Integer) m48370c.first).intValue() * 10));
        }
    }

    /* renamed from: b */
    public void m48372b(int i) {
        this.f11310f = i;
        m48371c();
    }

    /* renamed from: a */
    public void m48374a(AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean) {
        if (scrollClickBean == null) {
            return;
        }
        f11304j = scrollClickBean;
        m48378a(scrollClickBean.getRandomClickTime());
        m48372b(scrollClickBean.getRandomClickNum());
    }

    /* renamed from: b */
    public void m48373b() {
        this.f11312h = false;
        ScrollClickView scrollClickView = this.f11305a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
        this.f11311g = null;
        this.f11308d = null;
        this.f11305a = null;
        this.f11313i = 200;
    }

    /* renamed from: a */
    public void m48378a(int i) {
        this.f11309e = i;
    }

    /* renamed from: c */
    public static Pair<Integer, Boolean> m48370c(int i) {
        int random = (int) ((Math.random() * 100.0d) + 1.0d);
        if (random <= i) {
            return new Pair<>(Integer.valueOf(random), Boolean.TRUE);
        }
        return new Pair<>(Integer.valueOf(random), Boolean.FALSE);
    }

    /* renamed from: a */
    public void m48376a(InterfaceC3132a interfaceC3132a) {
        this.f11311g = interfaceC3132a;
    }

    /* renamed from: a */
    protected void m48379a() {
        StringBuilder sb = new StringBuilder();
        sb.append("enter callBackShakeHappened and mShakeStateListener != null ? ");
        sb.append(this.f11311g != null);
        sb.append(",!isCallBack = ");
        sb.append(!this.f11312h);
        C3116af.m48496a("ScrollClickUtil", sb.toString());
        if (this.f11311g == null || this.f11312h) {
            return;
        }
        C3116af.m48496a("ScrollClickUtil", "callback onShakeHappened()");
        this.f11311g.mo46554b("100", "200", "105", "206", "100", "200", "105", "206");
        this.f11312h = true;
        ScrollClickView scrollClickView = this.f11305a;
        if (scrollClickView != null) {
            scrollClickView.stopAnim();
        }
    }

    /* renamed from: a */
    public View m48377a(final int i, final int i2, AdSpacesBean.BuyerBean.ScrollClickPositionBean scrollClickPositionBean) {
        int parseInt;
        int parseInt2;
        C3116af.m48496a("ScrollClickUtil", "enter getScrollClick");
        if (this.f11308d == null || scrollClickPositionBean == null) {
            return null;
        }
        ScrollClickView scrollClickView = new ScrollClickView(this.f11308d);
        this.f11305a = scrollClickView;
        try {
            AdSpacesBean.BuyerBean.ScrollClickBean scrollClickBean = f11304j;
            if (scrollClickBean != null) {
                scrollClickView.setScrollDirection(scrollClickBean.getScrollDirection());
                this.f11305a.setTitleText(f11304j.getTitle());
                this.f11305a.setTitleFont(f11304j.getTitleFont());
                this.f11305a.setDetailText(f11304j.getDetails());
                this.f11305a.setDetailsFont(f11304j.getDetailsFont());
                AdSpacesBean.BuyerBean.ScrollClickPositionBean position = f11304j.getPosition();
                String width = position.getWidth();
                String height = position.getHeight();
                if (width.endsWith("%")) {
                    parseInt = (Integer.parseInt(width.substring(0, width.indexOf("%"))) * i) / 100;
                } else {
                    parseInt = Integer.parseInt(width);
                }
                if (height.endsWith("%")) {
                    parseInt2 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * parseInt) / 100;
                } else {
                    parseInt2 = Integer.parseInt(height);
                }
                this.f11305a.setHandWidth(parseInt);
                this.f11305a.setScrollbarHeight(parseInt2);
                this.f11305a.buildRealView();
            }
            String top2 = scrollClickPositionBean.getTop();
            String centerX = scrollClickPositionBean.getCenterX();
            centerX = (TextUtils.isEmpty(centerX) || "0".equals(centerX)) ? "50%" : "50%";
            top2 = (TextUtils.isEmpty(top2) || "0".equals(top2)) ? "50%" : "50%";
            C3138av.m48288j(this.f11308d);
            if (centerX.endsWith("%")) {
                this.f11306b = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
            } else {
                this.f11306b = Integer.parseInt(centerX);
            }
            if (top2.endsWith("%")) {
                this.f11307c = (Integer.parseInt(top2.substring(0, top2.indexOf("%"))) * i2) / 100;
            } else {
                this.f11307c = Integer.parseInt(top2);
            }
            this.f11306b = C3138av.m48304a(this.f11308d, this.f11306b);
            this.f11307c = C3138av.m48304a(this.f11308d, this.f11307c);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            C3116af.m48496a("ScrollClickUtil", "topInt = " + this.f11307c + ",centerXInt = " + this.f11306b + ",adWidthDp = " + i + ",adHeightDp = " + i2);
            this.f11305a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.beizi.fusion.g.ap.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ScrollClickView scrollClickView2 = ScrollClickUtil.this.f11305a;
                    if (scrollClickView2 == null) {
                        return;
                    }
                    scrollClickView2.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth = ScrollClickUtil.this.f11305a.getMeasuredWidth();
                    ScrollClickUtil scrollClickUtil = ScrollClickUtil.this;
                    if (scrollClickUtil.f11307c == 0) {
                        scrollClickUtil.f11307c = C3138av.m48304a(scrollClickUtil.f11308d, i2) / 2;
                    }
                    ScrollClickUtil scrollClickUtil2 = ScrollClickUtil.this;
                    if (scrollClickUtil2.f11306b == 0) {
                        scrollClickUtil2.f11306b = C3138av.m48304a(scrollClickUtil2.f11308d, i) / 2;
                    }
                    FrameLayout.LayoutParams layoutParams2 = layoutParams;
                    ScrollClickUtil scrollClickUtil3 = ScrollClickUtil.this;
                    layoutParams2.topMargin = scrollClickUtil3.f11307c;
                    layoutParams2.leftMargin = scrollClickUtil3.f11306b - (measuredWidth / 2);
                    scrollClickUtil3.f11305a.setLayoutParams(layoutParams2);
                    C3116af.m48496a("ScrollClickUtil", "topMargin = " + layoutParams.topMargin + ",leftMargin = " + layoutParams.leftMargin + ",scrollViewWidthInt = " + measuredWidth);
                }
            });
            this.f11305a.setLayoutParams(layoutParams);
            this.f11305a.postDelayed(new Runnable() { // from class: com.beizi.fusion.g.ap.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ScrollClickView scrollClickView2 = ScrollClickUtil.this.f11305a;
                        if (scrollClickView2 != null) {
                            scrollClickView2.startAnim();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 10L);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return this.f11305a;
    }
}
