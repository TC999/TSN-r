package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import java.util.HashSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class NativeExpressVideoView extends NativeExpressView implements xv.sr, xv.InterfaceC0335xv, p {

    /* renamed from: c  reason: collision with root package name */
    protected ExpressVideoView f34005c;

    /* renamed from: f  reason: collision with root package name */
    boolean f34006f;

    /* renamed from: i  reason: collision with root package name */
    private long f34007i;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.w.sr f34008j;
    private HashSet<String> ls;

    /* renamed from: q  reason: collision with root package name */
    private long f34009q;
    boolean sr;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.multipro.w.c f34010u;
    int ux;

    /* renamed from: w  reason: collision with root package name */
    int f34011w;
    boolean xv;

    public NativeExpressVideoView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        super(context, meVar, wVar, str, true);
        this.f34011w = 1;
        this.xv = false;
        this.sr = true;
        this.f34006f = true;
        this.fz = com.bytedance.sdk.openadsdk.core.ls.w().sr(wv.gd(this.f34029p));
        bk();
    }

    private void j() {
        ExpressVideoView expressVideoView;
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (((srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) || (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv)) && (expressVideoView = this.f34005c) != null) {
            expressVideoView.w(true);
            if (this.f34005c.O_()) {
                this.f34005c.setPauseIcon(true);
                this.f34005c.setVideoPlayStatus(2);
            } else {
                this.f34005c.setVideoPlayStatus(3);
                this.f34005c.setPauseIcon(false);
            }
            this.f34005c.performClick();
            this.f34005c.f();
        }
    }

    private void q() {
        try {
            this.f34010u = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
            ExpressVideoView c4 = c(this.f34031r, this.f34029p, this.ev);
            this.f34005c = c4;
            c4.setNativeExpressVideoView(this);
            this.f34005c.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.c
                public void c(View view, int i4) {
                    c expressInteractionListener = NativeExpressVideoView.this.getExpressInteractionListener();
                    if (expressInteractionListener == null) {
                        return;
                    }
                    expressInteractionListener.c(view, i4);
                }
            });
            this.f34005c.setShouldCheckNetChange(false);
            this.f34005c.setControllerStatusCallBack(new NativeVideoTsView.xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xv
                public void c(boolean z3, long j4, long j5, long j6, boolean z4, boolean z5) {
                    NativeExpressVideoView.this.f34010u.f33977c = z3;
                    NativeExpressVideoView.this.f34010u.ux = j4;
                    NativeExpressVideoView.this.f34010u.f33978f = j5;
                    NativeExpressVideoView.this.f34010u.f33979r = j6;
                    NativeExpressVideoView.this.f34010u.sr = z4;
                    NativeExpressVideoView.this.f34010u.ev = z5;
                }
            });
            this.f34005c.setVideoAdLoadListener(this);
            this.f34005c.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.ev)) {
                this.f34005c.setIsAutoPlay(this.xv ? this.gd.r() : this.sr);
            } else if ("splash_ad".equals(this.ev)) {
                this.f34005c.setIsAutoPlay(true);
            } else {
                this.f34005c.setIsAutoPlay(this.sr);
            }
            if ("splash_ad".equals(this.ev)) {
                this.f34005c.setIsQuiet(true);
            } else {
                this.f34005c.setIsQuiet(com.bytedance.sdk.openadsdk.core.ls.w().sr(this.ux));
            }
            this.f34005c.xv();
        } catch (Exception e4) {
            this.f34005c = null;
            com.bytedance.sdk.component.utils.a.f("NativeExpressVideoView", "\uff08dev ignore\uff09ExpressVideoView-->print:" + e4.toString());
        }
    }

    private void setShowAdInteractionView(boolean z3) {
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z3);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void B_() {
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoLoad");
        xv.sr srVar = this.f34026k;
        if (srVar != null) {
            srVar.B_();
        }
        com.bytedance.sdk.component.adexpress.w.sr srVar2 = this.f34008j;
        if (srVar2 != null) {
            if (srVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) {
                ((com.bytedance.sdk.component.adexpress.dynamic.c.c) srVar2).ux();
            }
            com.bytedance.sdk.component.adexpress.w.sr srVar3 = this.f34008j;
            if (srVar3 instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar3).ux();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void C_() {
        this.f34006f = false;
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoAdStartPlay");
        xv.InterfaceC0335xv interfaceC0335xv = this.f34020a;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.C_();
        }
        this.f34011w = 2;
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar).p();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void D_() {
        this.f34006f = false;
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoAdPaused");
        xv.InterfaceC0335xv interfaceC0335xv = this.f34020a;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.D_();
        }
        this.f34032t = true;
        this.f34011w = 3;
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar).ev();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void E_() {
        this.f34006f = false;
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoAdContinuePlay");
        xv.InterfaceC0335xv interfaceC0335xv = this.f34020a;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.E_();
        }
        this.f34032t = false;
        this.f34011w = 2;
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar).gd();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void F_() {
        this.f34006f = false;
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar != null) {
            if (srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) {
                ((com.bytedance.sdk.component.adexpress.dynamic.c.c) srVar).sr();
            }
            com.bytedance.sdk.component.adexpress.w.sr srVar2 = this.f34008j;
            if (srVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
                ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar2).sr();
                ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) this.f34008j).f();
            }
        }
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoComplete");
        xv.InterfaceC0335xv interfaceC0335xv = this.f34020a;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.F_();
        }
        this.f34011w = 5;
        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = this.f34010u;
        if (cVar != null) {
            cVar.f33977c = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        ExpressVideoView expressVideoView;
        if (this.f34011w == 3 && (expressVideoView = this.f34005c) != null) {
            expressVideoView.xv();
        }
        ExpressVideoView expressVideoView2 = this.f34005c;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().q()) {
            return this.f34011w;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void U_() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void X_() {
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
        super.Y_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        super.a();
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null) {
            expressVideoView.s();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
        super.a_(z3);
        this.fz = z3;
        this.f34005c.w(z3, true);
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onMuteVideo,mute:" + z3);
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null && expressVideoView.getNativeVideoController() != null) {
            this.f34005c.getNativeVideoController().w(z3);
        }
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar == null || !(srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.c.c) srVar).c(z3);
    }

    protected void bk() {
        this.bk = new FrameLayout(this.f34031r);
        this.ux = wv.gd(this.f34029p);
        this.ls = new HashSet<>();
        xv(this.ux);
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.sr.xv getVideoController() {
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null) {
            return expressVideoView.getVideoController();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.multipro.w.c getVideoModel() {
        return this.f34010u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ExpressVideoView expressVideoView;
        int i4;
        super.onAttachedToWindow();
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if ((!(srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) && !(srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv)) || (expressVideoView = this.f34005c) == null || (i4 = this.f34011w) == 2 || i4 == 5) {
            return;
        }
        expressVideoView.setNeedNativeVideoPlayBtnVisible(true);
        this.f34005c.N_();
        this.f34005c.M_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z3) {
        ExpressVideoView expressVideoView;
        ImageView imageView;
        super.onWindowFocusChanged(z3);
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (((srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) || (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv)) && (expressVideoView = this.f34005c) != null && z3 && (imageView = expressVideoView.f34001w) != null && imageView.getVisibility() == 0) {
            this.f34005c.f34001w.setVisibility(8);
        }
    }

    public void setCanInterruptVideoPlay(boolean z3) {
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    public void t() {
        this.f34005c.gd();
    }

    void xv(int i4) {
        int r3 = com.bytedance.sdk.openadsdk.core.ls.w().r(i4);
        if (3 == r3) {
            this.xv = false;
            this.sr = false;
        } else if (1 == r3) {
            this.xv = false;
            this.sr = com.bytedance.sdk.component.utils.ys.sr(this.f34031r);
        } else if (2 == r3) {
            if (com.bytedance.sdk.component.utils.ys.ux(this.f34031r) || com.bytedance.sdk.component.utils.ys.sr(this.f34031r) || com.bytedance.sdk.component.utils.ys.f(this.f34031r)) {
                this.xv = false;
                this.sr = true;
            }
        } else if (5 == r3) {
            if (com.bytedance.sdk.component.utils.ys.sr(this.f34031r) || com.bytedance.sdk.component.utils.ys.f(this.f34031r)) {
                this.xv = false;
                this.sr = true;
            }
        } else if (4 == r3) {
            this.xv = true;
        }
        if (!this.sr) {
            this.f34011w = 3;
        }
        com.bytedance.sdk.component.utils.a.xv("NativeVideoAdView", "mIsAutoPlay=" + this.sr + ",status=" + r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(com.bytedance.sdk.component.adexpress.w.t tVar) {
        if (tVar == null) {
            return;
        }
        double f4 = tVar.f();
        double r3 = tVar.r();
        double ev = tVar.ev();
        double gd = tVar.gd();
        int xv = (int) xk.xv(this.f34031r, (float) f4);
        int xv2 = (int) xk.xv(this.f34031r, (float) r3);
        int xv3 = (int) xk.xv(this.f34031r, (float) ev);
        int xv4 = (int) xk.xv(this.f34031r, (float) gd);
        float xv5 = tVar.a() > 0.0f ? xk.xv(this.f34031r, tVar.a()) : 0.0f;
        float xv6 = tVar.bk() > 0.0f ? xk.xv(this.f34031r, tVar.bk()) : 0.0f;
        float xv7 = tVar.t() > 0.0f ? xk.xv(this.f34031r, tVar.t()) : 0.0f;
        float xv8 = tVar.ys() > 0.0f ? xk.xv(this.f34031r, tVar.ys()) : 0.0f;
        if (xv6 < xv5) {
            xv5 = xv6;
        }
        if (xv7 >= xv5) {
            xv7 = xv5;
        }
        if (xv8 >= xv7) {
            xv8 = xv7;
        }
        if (tVar.w() != 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bk.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(xv3, xv4);
            }
            layoutParams.width = xv3;
            layoutParams.height = xv4;
            layoutParams.topMargin = xv2;
            layoutParams.leftMargin = xv;
            this.bk.setLayoutParams(layoutParams);
        }
        xk.w(this.bk, xv8);
        this.bk.removeAllViews();
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView != null) {
            this.bk.addView(expressVideoView);
            this.f34005c.c(0L, true, false);
            xv(this.ux);
            if (!com.bytedance.sdk.component.utils.ys.sr(this.f34031r) && !this.sr && this.f34006f) {
                this.f34005c.N_();
            }
            setShowAdInteractionView(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.bk.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.bk);
        }
        if (tVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.w) {
            FrameLayout ia = ((com.bytedance.sdk.openadsdk.core.ugeno.w.w) tVar).ia();
            if (ia != null) {
                this.f34005c.setClickable(false);
                ia.addView(this.bk, new FrameLayout.LayoutParams(-1, -1));
            }
        } else if (tVar.w() == 2) {
            View c4 = tVar.c();
            if (c4 instanceof ViewGroup) {
                this.f34005c.setClickable(false);
                ((ViewGroup) c4).addView(this.bk);
            }
        } else {
            addView(this.bk);
        }
    }

    protected ExpressVideoView c(Context context, me meVar, String str) {
        return new ExpressVideoView(context, meVar, str, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ys
    public void c(com.bytedance.sdk.component.adexpress.w.sr<? extends View> srVar, com.bytedance.sdk.component.adexpress.w.t tVar) {
        this.f34008j = srVar;
        if ((srVar instanceof bk) && ((bk) srVar).R_() != null) {
            ((bk) this.f34008j).R_().c((p) this);
        }
        if (tVar != null && tVar.xv()) {
            if (tVar.w() == 2 || tVar.w() == 7) {
                this.f34005c.c(this.f34031r, 25, ng.w(this.f34029p));
            }
            c(tVar);
        }
        com.bytedance.sdk.component.adexpress.w.sr srVar2 = this.f34008j;
        if (srVar2 != null && (srVar2 instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c)) {
            ((com.bytedance.sdk.component.adexpress.dynamic.c.c) srVar2).c(com.bytedance.sdk.openadsdk.core.ls.w().sr(this.ux));
        }
        super.c(srVar, tVar);
    }

    public NativeExpressVideoView(boolean z3, Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str) {
        super(z3, context, meVar, wVar, str, true);
        this.f34011w = 1;
        this.xv = false;
        this.sr = true;
        this.f34006f = true;
        this.fz = com.bytedance.sdk.openadsdk.core.ls.w().sr(wv.gd(this.f34029p));
        bk();
    }

    private void c(final com.bytedance.sdk.component.adexpress.w.t tVar) {
        if (tVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(tVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.3
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.w(tVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        return this.f34007i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onChangeVideoState,stateType:" + i4);
        ExpressVideoView expressVideoView = this.f34005c;
        if (expressVideoView == null) {
            com.bytedance.sdk.component.utils.a.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        } else if (i4 == 1) {
            expressVideoView.c(0L, true, false);
        } else if (i4 == 2 || i4 == 3) {
            expressVideoView.setVideoPlayStatus(i4);
            this.f34005c.setCanInterruptVideoPlay(true);
            this.f34005c.performClick();
        } else if (i4 == 4) {
            expressVideoView.getNativeVideoController().p();
        } else if (i4 != 5) {
        } else {
            expressVideoView.c(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ev
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar) {
        if (i4 == -1 || xvVar == null) {
            return;
        }
        if (i4 == 4) {
            j();
        } else if (i4 != 5) {
            super.c(view, i4, xvVar);
        } else {
            a_(!this.fz);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ev
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar, int i5) {
        if (i4 == -1 || xvVar == null) {
            return;
        }
        if (i4 != 4) {
            if (i4 != 5) {
                super.c(view, i4, xvVar, i5);
                return;
            }
        } else if (this.ev == "draw_ad") {
            ExpressVideoView expressVideoView = this.f34005c;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        a_(!this.fz);
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
    public void c(long j4, long j5) {
        this.f34006f = false;
        xv.InterfaceC0335xv interfaceC0335xv = this.f34020a;
        if (interfaceC0335xv != null) {
            interfaceC0335xv.c(j4, j5);
        }
        if (c(j4)) {
            this.f34011w = 2;
        }
        this.f34007i = j4;
        this.f34009q = j5;
        if (!this.ls.isEmpty()) {
            com.bykv.vk.openvk.component.video.api.sr.xv videoController = this.f34005c.getVideoController();
            if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) {
                ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) videoController).xv(50);
            }
        }
        com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = this.f34010u;
        if (cVar != null) {
            cVar.f33979r = j4;
        }
        com.bytedance.sdk.component.adexpress.w.sr srVar = this.f34008j;
        if (srVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.xv) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.w.xv) srVar).c(j4, j5);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.sr.xv.sr
    public void c(int i4, int i5) {
        com.bytedance.sdk.component.utils.a.w("NativeExpressVideoView", "onVideoError,errorCode:" + i4 + ",extraCode:" + i5);
        xv.sr srVar = this.f34026k;
        if (srVar != null) {
            srVar.c(i4, i5);
        }
        this.f34007i = this.f34009q;
        this.f34011w = 4;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(final int i4, final String str) {
        super.c(i4, str);
        com.bykv.vk.openvk.component.video.api.sr.xv videoController = this.f34005c.getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.xv xvVar = (com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) videoController;
            xvVar.xv(50);
            xvVar.c(new c.w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4
                @Override // com.bytedance.sdk.openadsdk.core.video.c.c.w
                public void c(long j4, long j5) {
                    int abs = (int) Math.abs(i4 - j4);
                    int i5 = i4;
                    if (i5 < 0 || abs > 50 || i5 > j5 || abs >= 50 || NativeExpressVideoView.this.ls.contains(str)) {
                        return;
                    }
                    if (i4 > j4) {
                        NativeExpressVideoView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NativeExpressVideoView.this.f34005c.setVideoPlayStatus(2);
                                NativeExpressVideoView.this.f34005c.setCanInterruptVideoPlay(true);
                                NativeExpressVideoView.this.f34005c.performClick();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                NativeExpressVideoView.this.w(i4, str);
                            }
                        }, abs);
                    } else {
                        NativeExpressVideoView.this.f34005c.setVideoPlayStatus(2);
                        NativeExpressVideoView.this.f34005c.setCanInterruptVideoPlay(true);
                        NativeExpressVideoView.this.f34005c.performClick();
                        NativeExpressVideoView.this.w(i4, str);
                    }
                    NativeExpressVideoView.this.ls.add(str);
                }
            });
        }
    }

    private boolean c(long j4) {
        ExpressVideoView expressVideoView;
        int i4 = this.f34011w;
        return !(i4 == 5 || i4 == 3 || j4 <= this.f34007i) || ((expressVideoView = this.f34005c) != null && expressVideoView.O_());
    }
}
