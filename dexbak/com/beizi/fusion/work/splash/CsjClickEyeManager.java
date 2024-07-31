package com.beizi.fusion.work.splash;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.beizi.fusion.p072g.BeiZiEnContext;
import com.beizi.fusion.p072g.C3138av;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.work.splash.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CsjClickEyeManager {

    /* renamed from: l */
    private static volatile CsjClickEyeManager f12570l;

    /* renamed from: a */
    private int f12571a;

    /* renamed from: b */
    private int f12572b;

    /* renamed from: c */
    private int f12573c;

    /* renamed from: d */
    private int f12574d;

    /* renamed from: e */
    private int f12575e;

    /* renamed from: f */
    private int f12576f;

    /* renamed from: g */
    private CSJSplashAd f12577g;

    /* renamed from: h */
    private View f12578h;

    /* renamed from: i */
    private int[] f12579i = new int[2];

    /* renamed from: j */
    private int f12580j;

    /* renamed from: k */
    private int f12581k;

    /* compiled from: CsjClickEyeManager.java */
    /* renamed from: com.beizi.fusion.work.splash.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3447a {
        /* renamed from: a */
        void mo46506a();

        /* renamed from: a */
        void mo46505a(int i);
    }

    private CsjClickEyeManager(Context context) {
        Context origApplicationContext;
        if (context == null) {
            origApplicationContext = BeiZiEnContext.m48266a();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        m46509b(origApplicationContext);
        this.f12573c = C3138av.m48304a(origApplicationContext, 16.0f);
        this.f12574d = C3138av.m48304a(origApplicationContext, 100.0f);
        this.f12575e = 1;
        this.f12576f = 300;
    }

    /* renamed from: a */
    public static CsjClickEyeManager m46515a(Context context) {
        if (f12570l == null) {
            synchronized (CsjClickEyeManager.class) {
                if (f12570l == null) {
                    f12570l = new CsjClickEyeManager(context);
                }
            }
        }
        return f12570l;
    }

    /* renamed from: b */
    private void m46509b(Context context) {
        int min = Math.min(C3138av.m48283o(context), C3138av.m48284n(context));
        CSJSplashAd cSJSplashAd = this.f12577g;
        if (cSJSplashAd != null && cSJSplashAd.getSplashClickEyeSizeToDp() != null) {
            this.f12571a = C3138av.m48304a(context, this.f12577g.getSplashClickEyeSizeToDp()[0]);
            this.f12572b = C3138av.m48304a(context, this.f12577g.getSplashClickEyeSizeToDp()[1]);
            return;
        }
        int round = Math.round(min * 0.3f);
        this.f12571a = round;
        this.f12572b = Math.round((round * 16) / 9);
    }

    /* renamed from: a */
    public void m46514a(Context context, CSJSplashAd cSJSplashAd, View view, View view2) {
        Context origApplicationContext;
        this.f12577g = cSJSplashAd;
        this.f12578h = view;
        view.getLocationOnScreen(this.f12579i);
        this.f12580j = view2.getWidth();
        this.f12581k = view2.getHeight();
        if (context == null) {
            origApplicationContext = BeiZiEnContext.m48266a();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        m46509b(origApplicationContext);
    }

    /* renamed from: b */
    public CSJSplashAd m46510b() {
        return this.f12577g;
    }

    /* renamed from: a */
    public void m46516a() {
        this.f12577g = null;
        this.f12578h = null;
    }

    /* renamed from: a */
    public ViewGroup m46512a(ViewGroup viewGroup, ViewGroup viewGroup2, InterfaceC3447a interfaceC3447a) {
        View view;
        if (viewGroup == null || viewGroup2 == null || this.f12577g == null || (view = this.f12578h) == null) {
            return null;
        }
        return m46513a(view, viewGroup, viewGroup2, interfaceC3447a);
    }

    /* renamed from: a */
    public ViewGroup m46513a(final View view, ViewGroup viewGroup, final ViewGroup viewGroup2, final InterfaceC3447a interfaceC3447a) {
        if (view == null || viewGroup2 == null) {
            return null;
        }
        final int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Context context = viewGroup2.getContext();
        int width = view.getWidth();
        int height = view.getHeight();
        int width2 = viewGroup.getWidth();
        int height2 = viewGroup.getHeight();
        if (width2 == 0) {
            width2 = this.f12580j;
        }
        if (height2 == 0) {
            height2 = this.f12581k;
        }
        int i = this.f12571a;
        float f = i / width;
        int i2 = this.f12572b;
        float f2 = i2 / height;
        final float f3 = this.f12575e == 0 ? this.f12573c : (width2 - this.f12573c) - i;
        final float f4 = (height2 - this.f12574d) - i2;
        C3138av.m48302a(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        final FrameLayout frameLayout = new FrameLayout(context);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.animate().scaleX(f).scaleY(f2).x(f3).y(f4).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.f12576f).setListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.work.splash.c.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C3138av.m48302a(view);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setX(0.0f);
                view.setY(0.0f);
                int[] iArr2 = new int[2];
                viewGroup2.getLocationOnScreen(iArr2);
                float f5 = f3 - iArr2[0];
                int[] iArr3 = iArr;
                float f6 = f5 + iArr3[0];
                float f7 = (f4 - iArr2[1]) + iArr3[1];
                frameLayout.addView(view, -1, -1);
                viewGroup2.addView(frameLayout, new FrameLayout.LayoutParams(CsjClickEyeManager.this.f12571a, CsjClickEyeManager.this.f12572b));
                frameLayout.setTranslationX(f6);
                frameLayout.setTranslationY(f7);
                InterfaceC3447a interfaceC3447a2 = interfaceC3447a;
                if (interfaceC3447a2 != null) {
                    interfaceC3447a2.mo46506a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                InterfaceC3447a interfaceC3447a2 = interfaceC3447a;
                if (interfaceC3447a2 != null) {
                    interfaceC3447a2.mo46505a(CsjClickEyeManager.this.f12576f);
                }
            }
        });
        return frameLayout;
    }
}
