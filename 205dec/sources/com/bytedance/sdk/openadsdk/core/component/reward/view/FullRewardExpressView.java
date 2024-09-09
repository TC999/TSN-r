package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.w.sr;
import com.bytedance.sdk.component.adexpress.w.t;
import com.bytedance.sdk.component.adexpress.w.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.f;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperItemView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.bk;
import com.bytedance.sdk.openadsdk.core.nativeexpress.p;
import com.bytedance.sdk.openadsdk.core.u.m;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.pr;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import java.util.HashSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class FullRewardExpressView extends NativeExpressView implements p {

    /* renamed from: c  reason: collision with root package name */
    p f32605c;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f32606f;

    /* renamed from: i  reason: collision with root package name */
    private c f32607i;

    /* renamed from: j  reason: collision with root package name */
    private FullSwiperItemView.c f32608j;

    /* renamed from: q  reason: collision with root package name */
    private c.w f32609q;
    private sr sr;

    /* renamed from: u  reason: collision with root package name */
    private HashSet<String> f32610u;
    private t ux;

    /* renamed from: w  reason: collision with root package name */
    FullRewardExpressBackupView f32611w;
    com.bytedance.sdk.openadsdk.core.video.w.c xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(int i4);
    }

    public FullRewardExpressView(Context context, me meVar, com.bytedance.sdk.openadsdk.ys.w.xv.w wVar, String str, boolean z3) {
        super(context, meVar, wVar, str, z3);
        this.f32610u = new HashSet<>();
    }

    private void q() {
        com.bytedance.sdk.openadsdk.core.video.w.c cVar;
        if ((this.sr instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) && (cVar = this.xv) != null) {
            if (cVar.ok()) {
                this.xv.f();
                w(true);
                return;
            }
            this.xv.ev();
            w(false);
        }
    }

    private void t() {
        setBackupListener(new xv() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.component.adexpress.w.xv
            public boolean c(ViewGroup viewGroup, int i4) {
                try {
                    ((NativeExpressView) viewGroup).s();
                    FullRewardExpressView.this.f32611w = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                    fullRewardExpressView.f32611w.c(((NativeExpressView) fullRewardExpressView).f34029p, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int S_() {
        a.w("FullRewardExpressView", "onGetVideoState");
        p pVar = this.f32605c;
        if (pVar != null) {
            return pVar.S_();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public int T_() {
        a.w("FullRewardExpressView", "onGetPlayTimeCurrent");
        p pVar = this.f32605c;
        if (pVar != null) {
            return pVar.T_();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void U_() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.U_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void V_() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.V_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void W_() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.W_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void X_() {
        a.w("FullRewardExpressView", "onSkipVideo");
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.X_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void Y_() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.Y_();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        super.a();
        this.f32610u.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void a_(boolean z3) {
        super.a_(z3);
        a.w("FullRewardExpressView", "onMuteVideo,mute:" + z3);
        this.fz = z3;
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.a_(z3);
        }
        sr srVar = this.sr;
        if (srVar == null || !(srVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c)) {
            return;
        }
        ((com.bytedance.sdk.component.adexpress.dynamic.c.c) srVar).c(z3);
    }

    public boolean bk() {
        t tVar = this.ux;
        if (tVar == null) {
            return true;
        }
        return tVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.w ? ((com.bytedance.sdk.openadsdk.core.ugeno.w.w) tVar).ia() != null : (tVar.ev() == 0.0d || this.ux.gd() == 0.0d) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void ev() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.ev();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long getActualPlayDuration() {
        p pVar = this.f32605c;
        if (pVar != null) {
            return pVar.getActualPlayDuration();
        }
        return 0L;
    }

    public t getRenderResult() {
        return this.ux;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public com.bykv.vk.openvk.component.video.api.sr.xv getVideoController() {
        return this.xv;
    }

    public FrameLayout getVideoFrameLayout() {
        if (fz()) {
            return this.f32611w.getVideoContainer();
        }
        return this.bk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void k() {
        this.ys = true;
        this.bk = new FrameLayout(this.f34031r);
        super.k();
        t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        xv(z3);
    }

    public void setExpressVideoListenerProxy(p pVar) {
        this.f32605c = pVar;
    }

    public void setInteractListener(FullSwiperItemView.c cVar) {
        this.f32608j = cVar;
    }

    public void setOnVideoSizeChangeListener(c cVar) {
        this.f32607i = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void setPauseFromExpressView(boolean z3) {
    }

    public void setVideoController(com.bykv.vk.openvk.component.video.api.sr.xv xvVar) {
        if (xvVar instanceof com.bytedance.sdk.openadsdk.core.video.w.c) {
            com.bytedance.sdk.openadsdk.core.video.w.c cVar = (com.bytedance.sdk.openadsdk.core.video.w.c) xvVar;
            this.xv = cVar;
            cVar.xv(50);
            this.xv.c(this.f32609q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(ViewGroup viewGroup, boolean z3) {
        c cVar;
        t tVar = this.ux;
        if (tVar == null) {
            return;
        }
        double f4 = tVar.f();
        double r3 = this.ux.r();
        double ev = this.ux.ev();
        double gd = this.ux.gd();
        int xv = (int) xk.xv(this.f34031r, (float) f4);
        int xv2 = (int) xk.xv(this.f34031r, (float) r3);
        int xv3 = (int) xk.xv(this.f34031r, (float) ev);
        int xv4 = (int) xk.xv(this.f34031r, (float) gd);
        float xv5 = this.ux.a() > 0.0f ? xk.xv(this.f34031r, this.ux.a()) : 0.0f;
        float xv6 = this.ux.bk() > 0.0f ? xk.xv(this.f34031r, this.ux.bk()) : 0.0f;
        float xv7 = this.ux.t() > 0.0f ? xk.xv(this.f34031r, this.ux.t()) : 0.0f;
        float xv8 = this.ux.ys() > 0.0f ? xk.xv(this.f34031r, this.ux.ys()) : 0.0f;
        if (xv6 < xv5) {
            xv5 = xv6;
        }
        if (xv7 >= xv5) {
            xv7 = xv5;
        }
        if (xv8 >= xv7) {
            xv8 = xv7;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(xv3, xv4);
        }
        layoutParams.width = xv3;
        layoutParams.height = xv4;
        layoutParams.topMargin = xv2;
        layoutParams.leftMargin = xv;
        viewGroup.setLayoutParams(layoutParams);
        xk.w(viewGroup, xv8);
        if (z3) {
            viewGroup.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (this.sr.xv() == 7) {
                t tVar2 = this.ux;
                if (tVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.w.w) {
                    FrameLayout ia = ((com.bytedance.sdk.openadsdk.core.ugeno.w.w) tVar2).ia();
                    if (ia != null) {
                        ia.addView(viewGroup, new FrameLayout.LayoutParams(-1, -1));
                    }
                    cVar = this.f32607i;
                    if (cVar != null || xv4 == 0) {
                    }
                    cVar.c(xv4);
                    return;
                }
            }
            addView(viewGroup);
            cVar = this.f32607i;
            if (cVar != null) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void f() {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.f();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public long xv() {
        a.w("FullRewardExpressView", "onGetCurrentPlayTime");
        p pVar = this.f32605c;
        if (pVar != null) {
            return pVar.xv();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ys
    public void c(sr<? extends View> srVar, t tVar) {
        this.sr = srVar;
        if (srVar instanceof bk) {
            bk bkVar = (bk) srVar;
            if (bkVar.R_() != null) {
                bkVar.R_().c((p) this);
            }
        }
        if (tVar != null && tVar.xv()) {
            this.ux = tVar;
            boolean z3 = false;
            if (tVar.w() == 2) {
                View c4 = tVar.c();
                if (c4 instanceof ViewGroup) {
                    ((ViewGroup) c4).addView(getVideoContainer());
                    z3 = true;
                }
            }
            if (!z3) {
                c((ViewGroup) this.bk, true);
            }
        }
        super.c(srVar, tVar);
        sr(getVisibility());
    }

    private void xv(boolean z3) {
        com.bytedance.sdk.openadsdk.core.video.w.c cVar;
        if ((this.sr instanceof com.bytedance.sdk.component.adexpress.dynamic.c.c) && z3) {
            ImageView imageView = this.f32606f;
            if (imageView != null && imageView.getVisibility() == 0 && (cVar = this.xv) != null) {
                cVar.f();
            } else {
                a_(this.fz);
            }
        }
    }

    public void c(final ViewGroup viewGroup, final boolean z3) {
        if (this.ux == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w(viewGroup, z3);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.w(viewGroup, z3);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(int i4) {
        a.w("FullRewardExpressView", "onChangeVideoState,stateType:" + i4);
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.c(i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4, float f5, float f6, float f7, int i4) {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.c(f4, f5, f6, f7, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(final int i4, final String str) {
        this.f32609q = new c.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3
            @Override // com.bytedance.sdk.openadsdk.core.video.c.c.w
            public void c(long j4, long j5) {
                p pVar;
                int abs = (int) Math.abs(i4 - j4);
                if (FullRewardExpressView.this.xv.wv() && (pVar = FullRewardExpressView.this.f32605c) != null) {
                    abs = (int) Math.abs(i4 - pVar.getActualPlayDuration());
                }
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                int i5 = fullRewardExpressView.xv instanceof f ? 200 : 50;
                int i6 = i4;
                if (i6 < 0 || abs > i5 || i6 > j5 || abs >= i5 || fullRewardExpressView.f32610u.contains(str)) {
                    return;
                }
                if (i4 > j4) {
                    FullRewardExpressView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            FullRewardExpressView.this.xv.f();
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            FullRewardExpressView.this.w(i4, str);
                            if (m.ia(((NativeExpressView) FullRewardExpressView.this).f34029p) || pr.c(((NativeExpressView) FullRewardExpressView.this).f34029p)) {
                                FullRewardExpressView.this.f32605c.c(2);
                            }
                            p pVar2 = FullRewardExpressView.this.f32605c;
                            if (pVar2 != null) {
                                pVar2.setPauseFromExpressView(true);
                            }
                        }
                    }, abs);
                } else {
                    FullRewardExpressView.this.xv.f();
                    FullRewardExpressView.this.w(i4, str);
                    if (m.ia(((NativeExpressView) FullRewardExpressView.this).f34029p) || pr.c(((NativeExpressView) FullRewardExpressView.this).f34029p)) {
                        FullRewardExpressView.this.f32605c.c(2);
                    }
                    p pVar2 = FullRewardExpressView.this.f32605c;
                    if (pVar2 != null) {
                        pVar2.setPauseFromExpressView(true);
                    }
                }
                FullRewardExpressView.this.f32610u.add(str);
            }
        };
        this.xv.xv(50);
        this.xv.c(this.f32609q);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void c(float f4) {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.c(f4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ev
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar) {
        FullSwiperItemView.c cVar = this.f32608j;
        if (cVar != null) {
            cVar.c();
        }
        if (i4 != -1 && xvVar != null && i4 == 3) {
            f();
        } else if (i4 == 5) {
            a_(!this.fz);
        } else if (i4 == 4) {
            q();
        } else {
            super.c(view, i4, xvVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.p
    public void w(int i4) {
        p pVar = this.f32605c;
        if (pVar != null) {
            pVar.w(i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.component.adexpress.w.ev
    public void c(View view, int i4, com.bytedance.sdk.component.adexpress.xv xvVar, int i5) {
        FullSwiperItemView.c cVar = this.f32608j;
        if (cVar != null) {
            cVar.c();
        }
        if (i4 != -1 && xvVar != null && i4 == 3) {
            f();
        } else {
            super.c(view, i4, xvVar, i5);
        }
    }

    protected void w(boolean z3) {
        if (this.f32606f == null) {
            this.f32606f = new ImageView(getContext());
            if (k.sr().gb() != null) {
                this.f32606f.setImageBitmap(k.sr().gb());
            } else {
                this.f32606f.setImageDrawable(i.xv(ls.getContext(), "tt_new_play_video"));
            }
            this.f32606f.setScaleType(ImageView.ScaleType.FIT_XY);
            int xv = (int) xk.xv(getContext(), 50.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xv, xv);
            layoutParams.gravity = 17;
            this.bk.addView(this.f32606f, layoutParams);
        }
        if (z3) {
            this.f32606f.setVisibility(0);
        } else {
            this.f32606f.setVisibility(8);
        }
    }
}
