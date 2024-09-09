package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.ugeno.r.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    private com.bytedance.sdk.openadsdk.core.ugeno.f.c bk;
    private com.bytedance.sdk.openadsdk.core.ugeno.ev.c fp;
    private String fz;

    /* renamed from: i  reason: collision with root package name */
    private AtomicBoolean f32415i;
    private com.bytedance.sdk.openadsdk.core.ugeno.gd.w ia;

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.reward.w.ux f32416j;
    private boolean ls;

    /* renamed from: q  reason: collision with root package name */
    private AtomicBoolean f32417q;

    /* renamed from: s  reason: collision with root package name */
    private AtomicBoolean f32418s;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.a.ux f32419t;

    /* renamed from: u  reason: collision with root package name */
    private RewardLpBottomView f32420u;
    private com.bytedance.sdk.openadsdk.core.ugeno.gd.sr ys;

    public c(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3, com.bytedance.sdk.openadsdk.core.a.ux uxVar, com.bytedance.sdk.openadsdk.core.component.reward.w.ux uxVar2) {
        super(tTBaseVideoActivity, meVar, z3);
        this.bk = meVar.ys();
        this.f32419t = uxVar;
        this.f32472w.r(0);
        this.f32418s = new AtomicBoolean();
        this.f32415i = new AtomicBoolean();
        this.f32417q = new AtomicBoolean();
        this.f32416j = uxVar2;
    }

    private void fz() {
        com.bytedance.sdk.openadsdk.core.ugeno.ev.c cVar = new com.bytedance.sdk.openadsdk.core.ugeno.ev.c(this.f32472w, u(), this.bk, this.xv);
        this.fp = cVar;
        cVar.c(this.f32472w.gw());
        this.fp.c(new com.bytedance.sdk.openadsdk.core.ugeno.sr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.8
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(View view) {
                com.bytedance.sdk.openadsdk.n.f.c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32472w.r(8);
                        c.this.f32418s.set(true);
                        if (c.this.f32420u != null) {
                            c.this.f32420u.c();
                        }
                    }
                });
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(int i4) {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32472w.r(8);
                        c.this.f32472w.ls();
                    }
                });
                c.this.f32418s.set(false);
            }
        });
        this.fp.c();
    }

    private void ia() {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.sr srVar = new com.bytedance.sdk.openadsdk.core.ugeno.gd.sr(this.f32472w, this.f32471r, this.f32419t, this.xv, this.fz, wv.c(this.f32467c));
        this.ys = srVar;
        srVar.w(true);
        this.ys.c(new com.bytedance.sdk.openadsdk.core.ugeno.sr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(View view) {
                c.this.f32472w.r(8);
                c.this.f32418s.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(int i4) {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32472w.r(8);
                        c.this.f32472w.ls();
                    }
                });
                c.this.f32418s.set(false);
            }
        });
        this.ys.a();
    }

    private void s() {
        FrameLayout frameLayout = new FrameLayout(this.f32472w);
        this.f32471r.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = new com.bytedance.sdk.openadsdk.core.ugeno.gd.w(this.f32472w, frameLayout, this.f32419t, this.xv, this.fz, wv.c(this.f32467c));
        this.ia = wVar;
        wVar.w(true);
        this.ia.c(new com.bytedance.sdk.openadsdk.core.ugeno.r.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.3
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.w
            public void c() {
                c.this.f32472w.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.w
            public void w() {
                c.this.f32472w.m();
                c.this.f32415i.set(true);
                c.this.ia.fz();
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.w
            public void xv() {
                c.this.ia.sr(false);
                c.this.ia.xv(0);
            }
        });
        this.ia.c(new com.bytedance.sdk.openadsdk.core.ugeno.sr.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(View view) {
                c.this.f32472w.r(8);
                c.this.f32418s.set(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.sr.c
            public void c(int i4) {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f32472w.r(8);
                        c.this.ia.fp();
                        c.this.ia.c(i.c(c.this.f32472w, "tt_ecomm_page_reward_acquire"));
                        c.this.f32472w.sr(0);
                        c.this.f32416j.c(0, 0);
                    }
                });
                c.this.f32418s.set(false);
            }
        });
        this.ia.c(new c.InterfaceC0515c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.5
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c.InterfaceC0515c
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.r.c.InterfaceC0515c
            public void w() {
                q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f32472w.wo()) {
                            c.this.ia.c(i.c(c.this.f32472w, "tt_ecomm_page_reward_acquire"));
                            return;
                        }
                        c.this.ia.c(String.format(i.c(c.this.f32472w, "tt_ecomm_page_reward_tip"), Integer.valueOf(c.this.f32472w.b().yu())));
                    }
                });
            }
        });
        this.ia.a();
        k.sr().xv().xv(new c.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.6
            @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
            public void w() {
                if (c.this.f32415i.get() || !c.this.ia.bk()) {
                    c.this.f32417q.set(false);
                } else {
                    c.this.f32417q.set(true);
                }
            }
        });
        if (TextUtils.equals(this.bk.c(), "3")) {
            return;
        }
        w();
    }

    private ViewGroup u() {
        if (this.f32471r == null) {
            return null;
        }
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.f32472w);
        this.f32471r.addView(playableEndcardFrameLayout);
        this.f32420u = new RewardLpBottomView(this.f32472w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f32471r.addView(this.f32420u, layoutParams);
        this.f32420u.c(this.xv, this.fz);
        playableEndcardFrameLayout.c(new PlayableEndcardFrameLayout.c() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.9
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout.c
            public void c() {
                if (c.this.f32420u != null) {
                    c.this.f32420u.w();
                }
            }
        });
        return playableEndcardFrameLayout;
    }

    public void ev() {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = this.ia;
        if (wVar != null) {
            wVar.ia();
        }
    }

    public void gd() {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = this.ia;
        if (wVar != null) {
            wVar.u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void p() {
        com.bytedance.sdk.openadsdk.core.ugeno.ev.c cVar = this.fp;
        if (cVar != null) {
            cVar.w();
        }
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = this.ia;
        if (wVar != null) {
            wVar.ys();
        }
        RewardLpBottomView rewardLpBottomView = this.f32420u;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.w();
        }
    }

    public boolean f() {
        return this.f32418s.get();
    }

    public void r() {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = this.ia;
        if (wVar != null) {
            wVar.s();
        }
    }

    public boolean sr() {
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar = this.ia;
        if (wVar != null) {
            return wVar.bk();
        }
        return false;
    }

    public AtomicInteger ux() {
        return new AtomicInteger(0);
    }

    public void w() {
        final ImageView imageView = new ImageView(this.f32472w);
        float xv = xk.xv(this.f32472w, 18.0f);
        float xv2 = xk.xv(this.f32472w, 20.0f);
        int i4 = (int) xv;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4);
        layoutParams.gravity = 53;
        int i5 = (int) xv2;
        layoutParams.setMargins(i5, i5, i5, i5);
        this.f32471r.addView(imageView, layoutParams);
        imageView.setImageDrawable(i.xv(this.f32472w, "tt_unmute"));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.ls = !cVar.ls;
                imageView.setImageDrawable(c.this.ls ? i.xv(c.this.f32472w, "tt_mute") : i.xv(c.this.f32472w, "tt_unmute"));
                c.this.ia.xv(c.this.ls);
            }
        });
    }

    public boolean xv() {
        return this.f32417q.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.fz = wv.c(wv.c(this.f32467c));
        com.bytedance.sdk.openadsdk.core.ugeno.f.c cVar = this.bk;
        if (cVar == null) {
            q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.f32472w.r(8);
                    c.this.f32472w.ls();
                }
            });
            return;
        }
        int sr = cVar.sr();
        if (sr == 2) {
            ia();
        } else if (sr == 3) {
            s();
        } else if (sr != 4) {
            this.f32472w.r(8);
            this.f32472w.ls();
        } else {
            fz();
        }
    }

    public void w(boolean z3) {
        if (this.ia == null || !com.bytedance.sdk.openadsdk.core.ugeno.f.sr(this.xv)) {
            return;
        }
        this.ia.xv(z3);
    }

    public void c(boolean z3) {
        this.f32417q.set(z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar, com.bytedance.sdk.openadsdk.core.w.w wVar2) {
        super.c(wVar, wVar2);
        com.bytedance.sdk.openadsdk.core.ugeno.gd.sr srVar = this.ys;
        if (srVar != null) {
            srVar.c(this.f32472w.gw());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.gd.w wVar3 = this.ia;
        if (wVar3 != null) {
            wVar3.c(this.f32472w.gw());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.ev.c cVar = this.fp;
        if (cVar != null) {
            cVar.c(wVar);
        }
    }

    public void c(int i4) {
        if (this.ys == null || !com.bytedance.sdk.openadsdk.core.ugeno.f.ux(this.xv)) {
            return;
        }
        this.ys.xv(i4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c(DownloadListener downloadListener) {
        com.bytedance.sdk.openadsdk.core.ugeno.ev.c cVar = this.fp;
        if (cVar != null) {
            cVar.c(downloadListener);
        }
    }
}
