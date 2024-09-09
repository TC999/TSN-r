package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.u.me;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class c extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    protected final Context f32004c;
    protected int ev;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.nativeexpress.c f32005f;
    protected boolean gd;

    /* renamed from: p  reason: collision with root package name */
    protected String f32006p;

    /* renamed from: r  reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.ls.c.w.c.xv f32007r;
    protected me sr;
    protected com.bytedance.sdk.openadsdk.ys.w.xv.w ux;

    /* renamed from: w  reason: collision with root package name */
    protected NativeExpressView f32008w;
    protected NativeExpressView xv;

    public c(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        super(context);
        this.f32006p = "banner_ad";
        this.f32004c = context;
        this.sr = meVar;
        this.ux = wVar;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        NativeExpressView nativeExpressView = this.xv;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.xv.a();
            this.xv = null;
        }
    }

    private ObjectAnimator w(NativeExpressView nativeExpressView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(nativeExpressView, "translationX", getWidth(), 0.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.c.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                c cVar = c.this;
                cVar.gd = false;
                cVar.r();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        if (this.gd || this.xv == null || this.f32008w == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(c(this.f32008w)).with(w(this.xv));
        animatorSet.setDuration(this.ev).start();
        xk.c((View) this.xv, 0);
        this.gd = true;
        NativeExpressView nativeExpressView = this.f32008w;
        this.f32008w = this.xv;
        this.xv = nativeExpressView;
    }

    public NativeExpressView getCurView() {
        return this.f32008w;
    }

    public NativeExpressView getNextView() {
        return this.xv;
    }

    public void setDuration(int i4) {
        this.ev = i4;
    }

    public void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar) {
        this.f32005f = cVar;
        NativeExpressView nativeExpressView = this.f32008w;
        if (nativeExpressView != null) {
            nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.c.2
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public void c(View view, int i4) {
                    c cVar2 = c.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar3 = cVar2.f32005f;
                    if (cVar3 != null) {
                        cVar3.c(cVar2, i4);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public void c(View view, String str, int i4) {
                    c cVar2 = c.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar3 = cVar2.f32005f;
                    if (cVar3 != null) {
                        cVar3.c(cVar2, str, i4);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public void c(View view, float f4, float f5) {
                    if (!(view instanceof NativeExpressView) || !((NativeExpressView) view).fz()) {
                        c.this.c(f4, f5);
                    }
                    c cVar2 = c.this;
                    com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar3 = cVar2.f32005f;
                    if (cVar3 != null) {
                        cVar3.c(cVar2, f4, f5);
                    }
                }
            });
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.ls.c.w.c.xv xvVar) {
        this.f32007r = xvVar;
    }

    public void sr() {
        NativeExpressView nativeExpressView = this.f32008w;
        if (nativeExpressView != null) {
            removeView(nativeExpressView);
            this.f32008w.a();
            this.f32008w = null;
        }
        NativeExpressView nativeExpressView2 = this.xv;
        if (nativeExpressView2 != null) {
            removeView(nativeExpressView2);
            this.xv.a();
            this.xv = null;
        }
    }

    public void ux() {
        NativeExpressView nativeExpressView = this.f32008w;
        if (nativeExpressView != null) {
            nativeExpressView.fp();
        }
    }

    public void xv() {
        NativeExpressView nativeExpressView = this.xv;
        if (nativeExpressView != null) {
            nativeExpressView.fp();
        }
    }

    protected void c() {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f32004c, this.sr, this.ux, this.f32006p);
        this.f32008w = nativeExpressView;
        addView(nativeExpressView, new ViewGroup.LayoutParams(-1, -1));
    }

    public void c(me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar) {
        NativeExpressView nativeExpressView = new NativeExpressView(this.f32004c, meVar, wVar, this.f32006p);
        this.xv = nativeExpressView;
        nativeExpressView.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.c.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, int i4) {
                c cVar = c.this;
                com.bytedance.sdk.openadsdk.core.nativeexpress.c cVar2 = cVar.f32005f;
                if (cVar2 != null) {
                    cVar2.c(cVar, i4);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public void c(View view, float f4, float f5) {
                c.this.c(f4, f5);
                c.this.f();
            }
        });
        xk.c((View) this.xv, 8);
        addView(this.xv, new ViewGroup.LayoutParams(-1, -1));
    }

    public boolean w() {
        return this.xv != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(float f4, float f5) {
        int xv = (int) xk.xv(this.f32004c, f4);
        int xv2 = (int) xk.xv(this.f32004c, f5);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(xv, xv2);
        }
        layoutParams.width = xv;
        layoutParams.height = xv2;
        setLayoutParams(layoutParams);
    }

    private ObjectAnimator c(NativeExpressView nativeExpressView) {
        return ObjectAnimator.ofFloat(nativeExpressView, "translationX", 0.0f, -getWidth());
    }
}
