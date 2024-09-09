package com.beizi.fusion.work.splash;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import com.beizi.fusion.g.av;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CsjClickEyeManager.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class c {

    /* renamed from: l  reason: collision with root package name */
    private static volatile c f15996l;

    /* renamed from: a  reason: collision with root package name */
    private int f15997a;

    /* renamed from: b  reason: collision with root package name */
    private int f15998b;

    /* renamed from: c  reason: collision with root package name */
    private int f15999c;

    /* renamed from: d  reason: collision with root package name */
    private int f16000d;

    /* renamed from: e  reason: collision with root package name */
    private int f16001e;

    /* renamed from: f  reason: collision with root package name */
    private int f16002f;

    /* renamed from: g  reason: collision with root package name */
    private CSJSplashAd f16003g;

    /* renamed from: h  reason: collision with root package name */
    private View f16004h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f16005i = new int[2];

    /* renamed from: j  reason: collision with root package name */
    private int f16006j;

    /* renamed from: k  reason: collision with root package name */
    private int f16007k;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: CsjClickEyeManager.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface a {
        void a();

        void a(int i4);
    }

    private c(Context context) {
        Context origApplicationContext;
        if (context == null) {
            origApplicationContext = com.beizi.fusion.g.g.a();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        b(origApplicationContext);
        this.f15999c = av.a(origApplicationContext, 16.0f);
        this.f16000d = av.a(origApplicationContext, 100.0f);
        this.f16001e = 1;
        this.f16002f = 300;
    }

    public static c a(Context context) {
        if (f15996l == null) {
            synchronized (c.class) {
                if (f15996l == null) {
                    f15996l = new c(context);
                }
            }
        }
        return f15996l;
    }

    private void b(Context context) {
        int min = Math.min(av.o(context), av.n(context));
        CSJSplashAd cSJSplashAd = this.f16003g;
        if (cSJSplashAd != null && cSJSplashAd.getSplashClickEyeSizeToDp() != null) {
            this.f15997a = av.a(context, this.f16003g.getSplashClickEyeSizeToDp()[0]);
            this.f15998b = av.a(context, this.f16003g.getSplashClickEyeSizeToDp()[1]);
            return;
        }
        int round = Math.round(min * 0.3f);
        this.f15997a = round;
        this.f15998b = Math.round((round * 16) / 9);
    }

    public void a(Context context, CSJSplashAd cSJSplashAd, View view, View view2) {
        Context origApplicationContext;
        this.f16003g = cSJSplashAd;
        this.f16004h = view;
        view.getLocationOnScreen(this.f16005i);
        this.f16006j = view2.getWidth();
        this.f16007k = view2.getHeight();
        if (context == null) {
            origApplicationContext = com.beizi.fusion.g.g.a();
        } else {
            origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        b(origApplicationContext);
    }

    public CSJSplashAd b() {
        return this.f16003g;
    }

    public void a() {
        this.f16003g = null;
        this.f16004h = null;
    }

    public ViewGroup a(ViewGroup viewGroup, ViewGroup viewGroup2, a aVar) {
        View view;
        if (viewGroup == null || viewGroup2 == null || this.f16003g == null || (view = this.f16004h) == null) {
            return null;
        }
        return a(view, viewGroup, viewGroup2, aVar);
    }

    public ViewGroup a(final View view, ViewGroup viewGroup, final ViewGroup viewGroup2, final a aVar) {
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
            width2 = this.f16006j;
        }
        if (height2 == 0) {
            height2 = this.f16007k;
        }
        int i4 = this.f15997a;
        float f4 = i4 / width;
        int i5 = this.f15998b;
        float f5 = i5 / height;
        final float f6 = this.f16001e == 0 ? this.f15999c : (width2 - this.f15999c) - i4;
        final float f7 = (height2 - this.f16000d) - i5;
        av.a(view);
        viewGroup.addView(view, new FrameLayout.LayoutParams(width, height));
        final FrameLayout frameLayout = new FrameLayout(context);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.animate().scaleX(f4).scaleY(f5).x(f6).y(f7).setInterpolator(new OvershootInterpolator(0.0f)).setDuration(this.f16002f).setListener(new Animator.AnimatorListener() { // from class: com.beizi.fusion.work.splash.c.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                av.a(view);
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
                view.setX(0.0f);
                view.setY(0.0f);
                int[] iArr2 = new int[2];
                viewGroup2.getLocationOnScreen(iArr2);
                float f8 = f6 - iArr2[0];
                int[] iArr3 = iArr;
                float f9 = f8 + iArr3[0];
                float f10 = (f7 - iArr2[1]) + iArr3[1];
                frameLayout.addView(view, -1, -1);
                viewGroup2.addView(frameLayout, new FrameLayout.LayoutParams(c.this.f15997a, c.this.f15998b));
                frameLayout.setTranslationX(f9);
                frameLayout.setTranslationY(f10);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(c.this.f16002f);
                }
            }
        });
        return frameLayout;
    }
}
