package com.bytedance.sdk.openadsdk.core.playable;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.fp;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.u.wx;
import com.bytedance.sdk.openadsdk.core.video.w.c;
import com.bytedance.sdk.openadsdk.n.gd;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements n.c {

    /* renamed from: c  reason: collision with root package name */
    private final String f34425c;
    private f ev;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f34426f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f34427k;

    /* renamed from: r  reason: collision with root package name */
    private PlayableVideoContainer f34429r;

    /* renamed from: t  reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.video.w.w f34430t;
    private final int ux;

    /* renamed from: w  reason: collision with root package name */
    private final Context f34431w;
    private final me xv;
    private final n sr = new n(Looper.getMainLooper(), this);
    private boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f34428p = true;

    /* renamed from: a  reason: collision with root package name */
    private boolean f34424a = false;
    private boolean bk = false;

    public r(String str, Activity activity, me meVar, int i4, com.bytedance.sdk.openadsdk.core.video.w.w wVar, FrameLayout frameLayout) {
        this.f34425c = str;
        this.f34431w = activity;
        this.xv = meVar;
        this.ux = i4;
        if (!fp.sr(meVar)) {
            this.f34426f = frameLayout;
        }
        ux();
        this.f34430t = wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gd() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "csj_bkbw_playable_error");
        com.bytedance.sdk.openadsdk.core.a.xv.p(this.xv, this.f34425c, "playable_track", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f34429r == null || this.f34426f == null) {
            return;
        }
        r();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f34429r, "translationX", -xk.ux(this.f34431w, 150.0f), 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f34429r, "translationY", -xk.ux(this.f34431w, 100.0f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f34429r, "alpha", 0.1f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(500L);
        animatorSet.start();
    }

    private void p() {
        PlayableVideoContainer playableVideoContainer = this.f34429r;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.w(true);
        this.sr.sendEmptyMessageDelayed(1, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        this.f34424a = true;
        if (this.f34427k) {
            this.f34427k = false;
            w();
        }
        c(this.f34428p);
    }

    private void f() {
        xk.c((View) this.f34426f, 8);
        xk.c((View) this.f34429r, 8);
    }

    private void r() {
        xk.c((View) this.f34426f, 0);
        xk.c((View) this.f34429r, 0);
    }

    private void ux() {
        if (this.f34426f == null) {
            return;
        }
        if (wx.c(this.xv, this.ux) == 1) {
            PlayableVideoContainer playableVideoContainer = new PlayableVideoContainer(this.f34431w);
            playableVideoContainer.setBackgroundColor(0);
            playableVideoContainer.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(xk.ux(this.f34431w, 156.0f), xk.ux(this.f34431w, 87.0f));
            layoutParams.gravity = 8388661;
            layoutParams.topMargin = xk.ux(this.f34431w, 55.0f);
            layoutParams.rightMargin = xk.ux(this.f34431w, 20.0f);
            this.f34426f.addView(playableVideoContainer, layoutParams);
            this.f34429r = playableVideoContainer;
            return;
        }
        PlayableVideoContainer playableVideoContainer2 = new PlayableVideoContainer(this.f34431w);
        playableVideoContainer2.setBackgroundColor(0);
        playableVideoContainer2.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(xk.ux(this.f34431w, 73.0f), xk.ux(this.f34431w, 130.0f));
        layoutParams2.gravity = 8388661;
        layoutParams2.topMargin = xk.ux(this.f34431w, 55.0f);
        layoutParams2.rightMargin = xk.ux(this.f34431w, 30.0f);
        this.f34426f.addView(playableVideoContainer2, layoutParams2);
        this.f34429r = playableVideoContainer2;
    }

    public void sr() {
        f fVar = this.ev;
        if (fVar == null) {
            return;
        }
        fVar.p();
        this.ev = null;
        this.gd = false;
        this.f34427k = false;
        this.f34424a = false;
    }

    public void w() {
        if (this.bk && this.gd && this.ev != null) {
            this.sr.removeMessages(1);
            if (this.f34424a) {
                this.ev.f();
            } else {
                this.f34427k = true;
            }
        }
    }

    public void xv() {
        if (this.bk && this.gd && this.ev != null) {
            this.f34427k = false;
            this.sr.sendEmptyMessageDelayed(1, 2000L);
            if (this.ev.ok()) {
                return;
            }
            this.ev.ev();
        }
    }

    public void c(long j4, boolean z3) {
        PlayableVideoContainer playableVideoContainer;
        this.bk = true;
        this.f34428p = z3;
        c(j4);
        if (this.gd) {
            if (this.f34430t != null && (playableVideoContainer = this.f34429r) != null) {
                playableVideoContainer.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.playable.r.1
                    @Override // java.lang.Runnable
                    public void run() {
                        r.this.k();
                    }
                }, 500L);
                this.f34429r.setCustomClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.playable.r.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (r.this.f34426f != null) {
                            r.this.c();
                            r.this.f34430t.w();
                        }
                    }
                });
            } else if (gd.c(this.xv)) {
                f();
            } else {
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "csj_enter_bkbw_playable");
        hashMap.put("is_plbkbw_video_show", Boolean.valueOf(z3));
        com.bytedance.sdk.openadsdk.core.a.xv.p(this.xv, this.f34425c, "playable_track", hashMap);
    }

    public void c() {
        this.bk = false;
        sr();
        f();
    }

    private void c(long j4) {
        if (this.f34429r == null) {
            return;
        }
        if (wx.ck(this.xv) || this.f34430t != null || gd.c(this.xv)) {
            if (this.gd) {
                f fVar = this.ev;
                if (fVar != null) {
                    fVar.w(j4);
                    this.ev.c(j4);
                    return;
                }
                return;
            }
            this.gd = true;
            com.bykv.vk.openvk.component.video.api.xv.sr c4 = ng.c(1, this.xv, this.ux);
            c4.w(this.xv.jr());
            c4.w(this.f34429r.getWidth());
            c4.xv(this.f34429r.getHeight());
            c4.xv(this.xv.cf());
            c4.c(j4);
            c4.w(this.f34428p);
            if (gd.c(this.xv)) {
                c4.c(true);
            }
            f fVar2 = new f(this.f34431w, this.f34429r.getVideoContainer(), this.xv, null);
            this.ev = fVar2;
            fVar2.c(new c.InterfaceC0520c() { // from class: com.bytedance.sdk.openadsdk.core.playable.r.3
                @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
                public void c() {
                    if (r.this.f34430t == null) {
                        if (!gd.c(r.this.xv) || r.this.ev == null || r.this.ev.ux()) {
                            return;
                        }
                        r.this.c();
                        return;
                    }
                    r.this.c();
                    r.this.f34430t.xv();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
                public void w() {
                    r.this.gd();
                    r.this.f34429r.c(true);
                    if (r.this.f34430t != null) {
                        r.this.f34430t.p();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
                public void xv() {
                    r.this.w(true);
                    r.this.ev();
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
                public void c(int i4, String str) {
                    if (i4 == 308) {
                        return;
                    }
                    r.this.gd();
                    r.this.f34429r.c(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.video.w.c.InterfaceC0520c
                public void c(long j5, long j6) {
                    r.this.f34429r.c(false);
                    if (r.this.f34430t != null) {
                        r.this.f34430t.c(j5, j6);
                    }
                }
            });
            this.ev.w(j4);
            this.ev.c(c4);
            if (this.f34430t != null) {
                this.ev.gb();
                this.ev.r(false);
                this.f34429r.c();
                return;
            }
            if (gd.c(this.xv)) {
                this.ev.r(true);
            }
            p();
        }
    }

    public void c(boolean z3) {
        f fVar = this.ev;
        if (fVar == null) {
            return;
        }
        this.f34428p = z3;
        fVar.w(z3);
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        PlayableVideoContainer playableVideoContainer = this.f34429r;
        if (playableVideoContainer == null) {
            return;
        }
        playableVideoContainer.w(false);
    }
}
