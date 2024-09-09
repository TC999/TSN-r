package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SplashClickBar extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private int f32801c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private String f32802f;
    private SplashClickBarBtn gd;

    /* renamed from: r  reason: collision with root package name */
    private boolean f32803r;
    private int sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private int f32804w;
    private int xv;

    public SplashClickBar(Context context, me meVar) {
        super(context);
        c(context, meVar);
    }

    public void c(Context context, me meVar) {
        setClipChildren(false);
        SplashClickBarBtn splashClickBarBtn = new SplashClickBarBtn(getContext(), meVar);
        this.gd = splashClickBarBtn;
        addView(splashClickBarBtn);
        this.gd.setClipChildren(false);
    }

    public void setBtnLayout(boolean z3) {
        int i4;
        int ux;
        int i5 = this.f32804w + 150;
        if (this.f32801c <= i5 && this.ev != 4) {
            this.f32801c = i5;
        }
        if (z3) {
            i4 = this.xv;
        } else {
            i4 = this.sr;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gd.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        int i6 = this.ev;
        if (i6 != 4) {
            if (i6 == 5) {
                layoutParams.height = -50;
                layoutParams.width = -50;
                ux = xk.ux(getContext(), 10.0f);
            } else if (i6 != 7) {
                layoutParams.height = xk.ux(ls.getContext(), this.f32804w);
                layoutParams.width = xk.ux(ls.getContext(), this.f32801c);
            } else {
                layoutParams.height = -50;
                layoutParams.width = -50;
                ux = xk.ux(getContext(), 20.0f);
            }
            i4 += ux;
        } else {
            layoutParams.height = -50;
            layoutParams.width = -50;
        }
        layoutParams.bottomMargin = xk.ux(ls.getContext(), i4);
        layoutParams.gravity = 81;
        this.gd.setLayoutParams(layoutParams);
    }

    public void c(me meVar) {
        this.f32801c = meVar.oh();
        this.f32804w = meVar.h();
        this.xv = meVar.fm();
        this.sr = meVar.te();
        this.ux = meVar.xu();
        this.f32802f = meVar.ng();
        this.ev = meVar.ge();
        this.f32803r = meVar.ok();
        SplashClickBarBtn splashClickBarBtn = this.gd;
        if (splashClickBarBtn != null) {
            splashClickBarBtn.setShakeValue(meVar.mc());
            this.gd.setDeepShakeValue(meVar.co());
            this.gd.setWriggleValue(meVar.za());
            this.gd.setTwistConfig(meVar.jk());
            this.gd.setCalculationTwistMethod(meVar.bs());
            this.gd.setCalculationMethod(meVar.g());
        }
        this.gd.c(meVar.gp());
        if (this.ux == 1 && this.f32803r) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.c cVar) {
        this.gd.c(cVar);
    }
}
