package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.core.r.sr;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.s;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p extends com.bytedance.msdk.core.r.sr implements com.bytedance.msdk.adapter.w.sr {
    private final com.bytedance.msdk.core.admanager.reward.c be;
    private com.bytedance.msdk.core.admanager.reward.rewardagain.xv bs;

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.msdk.api.sr.c.ev.c f27730c;
    private com.bytedance.msdk.api.sr.c.ev.c eu;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.msdk.core.admanager.reward.c f27731g;
    private boolean lf;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.ev.w f27732w;
    private com.bytedance.msdk.adapter.w.w xg;
    private com.bytedance.msdk.api.sr.c.ev.c xv;

    public p(Context context, String str) {
        super(context, str, 7);
        this.be = new com.bytedance.msdk.core.admanager.reward.c(this.gd);
        this.f27731g = new com.bytedance.msdk.core.admanager.reward.c(this.gd);
        this.f27730c = new AnonymousClass1();
        this.xg = new com.bytedance.msdk.adapter.w.w() { // from class: com.bytedance.msdk.core.admanager.p.7
            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void b_(@NonNull com.bytedance.msdk.api.c cVar) {
                String str2;
                long j4;
                long currentTimeMillis = System.currentTimeMillis();
                if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str2 = null;
                    j4 = -1;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, cVar, 1, 0, str2, j4);
                p.this.ux(cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0126  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0155  */
            @Override // com.bytedance.msdk.api.sr.c.sr.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void c() {
                /*
                    Method dump skipped, instructions count: 444
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.p.AnonymousClass7.c():void");
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void f() {
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 3, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        }
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 3, 0, 0, (String) null);
                    }
                    if (p.this.a()) {
                        return;
                    }
                    p.this.t();
                    if (p.this.xv != null) {
                        p.this.xv.f();
                        return;
                    }
                    return;
                }
                p.this.t();
                if (p.this.xv != null) {
                    p.this.xv.f();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void o_() {
                String str2;
                String str3;
                String str4 = null;
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 5, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        } else if (s.f()) {
                            str3 = i.c(Thread.currentThread().getStackTrace());
                            if (!p.this.a() && p.this.xv != null) {
                                p.this.xv.r_();
                            }
                            str2 = str3;
                        }
                    }
                    str3 = null;
                    if (!p.this.a()) {
                        p.this.xv.r_();
                    }
                    str2 = str3;
                } else {
                    if (p.this.xv != null) {
                        p.this.xv.r_();
                    }
                    str2 = null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = -1;
                if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                    str4 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                }
                com.bytedance.msdk.core.w.c.ux(((com.bytedance.msdk.core.r.xv) p.this).gd);
                com.bytedance.msdk.xv.r.w(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 0, str4, j4, str2, ((com.bytedance.msdk.core.r.ux) p.this).bm.isClickListenRepeatOnce());
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void p_() {
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 2, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        }
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 2, 0, 0, (String) null);
                    }
                    if (p.this.a()) {
                        return;
                    }
                    p.this.t();
                    if (p.this.xv != null) {
                        p.this.xv.s_();
                        return;
                    }
                    return;
                }
                p.this.t();
                if (p.this.xv != null) {
                    p.this.xv.s_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void q_() {
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 1, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        }
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 1, 0, 0, (String) null);
                    }
                    if (p.this.a()) {
                        return;
                    }
                    p.this.t();
                    if (p.this.xv != null) {
                        p.this.xv.t_();
                        return;
                    }
                    return;
                }
                p.this.t();
                if (p.this.xv != null) {
                    p.this.xv.t_();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void ux() {
                String str2;
                long j4;
                long currentTimeMillis = System.currentTimeMillis();
                if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str2 = null;
                    j4 = -1;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, (com.bytedance.msdk.api.c) null, 2, 0, str2, j4);
                if (p.this.xv != null) {
                    p.this.xv.ux();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
                if (p.this.xv != null) {
                    p.this.xv.c(p.c(((com.bytedance.msdk.core.r.xv) p.this).f28155k, cVar, ((com.bytedance.msdk.core.r.ux) p.this).bm));
                }
            }
        };
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void c_(com.bytedance.msdk.api.c cVar) {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, cVar, 1, 0, str, j4);
        ux(cVar);
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void r_() {
        String str;
        String str2;
        com.bytedance.msdk.api.sr.c.ev.c cVar;
        com.bytedance.msdk.core.w.c.ux(this.f28155k.u());
        String str3 = null;
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 5, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                } else if (s.xv()) {
                    str2 = i.c(Thread.currentThread().getStackTrace());
                    if (!a() && (cVar = this.xv) != null) {
                        cVar.r_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!a()) {
                cVar.r_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.sr.c.ev.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.r_();
            }
            str = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str3 = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.c.ux uxVar2 = this.bm;
        com.bytedance.msdk.xv.r.w(uxVar2, this.f28155k, 0, str3, j4, str, uxVar2.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void s_() {
        com.bytedance.msdk.api.sr.c.ev.c cVar;
        com.bytedance.msdk.api.sr.c.ev.c cVar2;
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 2, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 2, 0, 0, (String) null);
            }
            if (a()) {
                return;
            }
            t();
            if (p() || (cVar2 = this.xv) == null) {
                return;
            }
            cVar2.s_();
            return;
        }
        t();
        if (p() || (cVar = this.xv) == null) {
            return;
        }
        cVar.s_();
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void t_() {
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 1, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 1, 0, 0, (String) null);
            }
            if (a()) {
                return;
            }
            t();
            if (this.be.c()) {
                this.be.ux();
            }
            com.bytedance.msdk.api.sr.c.ev.c cVar = this.xv;
            if (cVar != null) {
                cVar.t_();
                return;
            }
            return;
        }
        t();
        if (this.be.c()) {
            this.be.ux();
        }
        com.bytedance.msdk.api.sr.c.ev.c cVar2 = this.xv;
        if (cVar2 != null) {
            cVar2.t_();
        }
    }

    private boolean p() {
        int i4;
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        if (wVar != null && wVar.ev() != 1) {
            com.bytedance.msdk.core.admanager.reward.rewardagain.c gd = com.bytedance.msdk.core.admanager.reward.rewardagain.xv.gd(this.gd);
            if (gd == null) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\u5f00\u5173\u672a\u5f00\u542f: " + this.gd);
                return false;
            } else if (this.lf) {
                com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\uff0cadn\u5df2\u7ecf\u89e6\u53d1\u4e86\u518d\u770b\u4e00\u4e2a: " + this.gd);
                return false;
            } else {
                com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar = this.bs;
                if (xvVar != null) {
                    int c4 = xvVar.c(this.f28155k, gd, this.bm);
                    com.bytedance.msdk.core.k.w wVar2 = this.f28159r;
                    String mt = wVar2 != null ? wVar2.mt() : null;
                    if (com.bytedance.msdk.core.ux.w.w.c().xv(this.gd, u())) {
                        i4 = ((com.bytedance.msdk.core.r.sr) this).wx ? 4 : 2;
                    } else {
                        i4 = 1;
                    }
                    com.bytedance.msdk.xv.r.c(this.f28155k, mt, c4, i4);
                    if (c4 == 0) {
                        this.bs.c(gd, mt, this.bm);
                        return true;
                    }
                }
                return false;
            }
        }
        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "--==--ra: \u6fc0\u52b1\u518d\u5f97\uff0c\u4e00\u6b21\u94fe\u8def\u53ea\u5c55\u793a\u4e00\u6b21\u6fc0\u52b1\u518d\u5f97: " + this.gd);
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void f() {
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 3, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 3, 0, 0, (String) null);
            }
            if (a()) {
                return;
            }
            t();
            if (this.be.c()) {
                this.be.w();
            }
            com.bytedance.msdk.api.sr.c.ev.c cVar = this.xv;
            if (cVar != null) {
                cVar.f();
                return;
            }
            return;
        }
        t();
        if (this.be.c()) {
            this.be.w();
        }
        com.bytedance.msdk.api.sr.c.ev.c cVar2 = this.xv;
        if (cVar2 != null) {
            cVar2.f();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
        com.bytedance.msdk.api.sr.c.ev.w wVar = this.f27732w;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void ux() {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, (com.bytedance.msdk.api.c) null, 2, 0, str, j4);
        com.bytedance.msdk.api.sr.c.ev.c cVar = this.xv;
        if (cVar != null) {
            cVar.ux();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        com.bytedance.msdk.api.sr.c.ev.w wVar = this.f27732w;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void w(com.bytedance.msdk.api.c.w wVar, @NonNull com.bytedance.msdk.api.sr.c.ev.w wVar2) {
        if (k()) {
            this.f27732w = wVar2;
            if (wVar != null) {
                this.f28155k = new com.bytedance.msdk.api.c.w(wVar);
            }
            this.up = this;
            this.mt = this.f27730c;
            if (com.bytedance.msdk.core.admanager.reward.rewardagain.xv.gd(this.gd) != null) {
                this.bs = new com.bytedance.msdk.core.admanager.reward.rewardagain.xv(this.vc.get(), this.f28155k, this.xv, this.eu);
            }
            g_();
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, @NonNull com.bytedance.msdk.api.sr.c.ev.w wVar2) {
        if (!com.bytedance.msdk.core.c.w().c(pr(), 7) && wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
        } else if (com.bytedance.msdk.core.c.w().ys()) {
            w(wVar, wVar2);
        } else if (wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840036, com.bytedance.msdk.api.c.c(840036)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.msdk.api.xv.c cVar, int i4) {
        String str;
        long j4;
        String str2;
        int i5;
        int i6;
        Map<String, Object> customData;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.bm)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        String str3 = str;
        long j5 = j4;
        if (cVar == null || (customData = cVar.getCustomData()) == null) {
            str2 = "";
            i5 = 0;
            i6 = 0;
        } else {
            Integer num = (Integer) customData.get("reason");
            int intValue = num != null ? num.intValue() : 0;
            Integer num2 = (Integer) customData.get("errorCode");
            i6 = num2 != null ? num2.intValue() : 0;
            str2 = (String) customData.get("errorMsg");
            i5 = intValue;
        }
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, i4, str3, j5, i5, i6, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.p.4
            @Override // java.lang.Runnable
            public void run() {
                if (p.this.xv != null) {
                    p.this.xv.c_(cVar);
                }
            }
        });
    }

    public void w(com.bytedance.msdk.api.sr.c.ev.c cVar) {
        this.eu = cVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar = this.bs;
        if (xvVar != null) {
            xvVar.w(cVar);
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        if (this.bm == null) {
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        }
        super.w();
        this.be.xv();
        this.f27731g.xv();
        this.f27732w = null;
        this.xv = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.p.5
            @Override // java.lang.Runnable
            public void run() {
                if (p.this.eu != null) {
                    p.this.eu.c_(cVar);
                }
            }
        });
    }

    @MainThread
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar = this.bs;
        if (xvVar != null) {
            xvVar.c(activity, ritScenes, str);
        }
        super.c(activity, ritScenes, str, new sr.c() { // from class: com.bytedance.msdk.core.admanager.p.2
            @Override // com.bytedance.msdk.core.r.sr.c
            public void c() {
                p.this.ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            }
        });
        if (this.xv == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u6ce8\u610f\uff1a\u672a\u8bbe\u7f6eGMRewardedAdListener\uff0c\u5c06\u6536\u4e0d\u5230\u5e7f\u544a\u64ad\u653e/\u70b9\u51fb/\u5173\u95ed\u7b49\u56de\u8c03\u4fe1\u606f");
        }
        w((com.bytedance.msdk.c.ux) null);
    }

    /* renamed from: com.bytedance.msdk.core.admanager.p$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 implements com.bytedance.msdk.api.sr.c.ev.c {
        AnonymousClass1() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x017b  */
        @Override // com.bytedance.msdk.api.sr.c.ev.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c() {
            /*
                Method dump skipped, instructions count: 416
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.p.AnonymousClass1.c():void");
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void c_(@NonNull com.bytedance.msdk.api.c cVar) {
            String str;
            long j4;
            long currentTimeMillis = System.currentTimeMillis();
            if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                str = i.w(Thread.currentThread().getStackTrace());
                j4 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j4 = -1;
            }
            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, cVar, 1, 1, str, j4);
            p.this.f(cVar);
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void f() {
            if (!s.c()) {
                if (p.this.f27731g.c()) {
                    p.this.f27731g.w();
                }
                if (p.this.eu != null) {
                    p.this.eu.f();
                    return;
                }
                return;
            }
            if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 3, 1, 1, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 3, 0, 1, (String) null);
            }
            if (p.this.a()) {
                return;
            }
            if (p.this.f27731g.c()) {
                p.this.f27731g.w();
            }
            if (p.this.eu != null) {
                p.this.eu.f();
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void r_() {
            String str;
            String str2;
            String str3 = null;
            if (!s.c()) {
                if (p.this.eu != null) {
                    p.this.eu.r_();
                }
                str = null;
            } else {
                if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                    if (!s.c(Thread.currentThread().getStackTrace())) {
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 5, 1, 1, i.c(Thread.currentThread().getStackTrace()));
                        return;
                    } else if (s.xv()) {
                        str2 = i.c(Thread.currentThread().getStackTrace());
                        if (!p.this.a() && p.this.eu != null) {
                            p.this.eu.r_();
                        }
                        str = str2;
                    }
                }
                str2 = null;
                if (!p.this.a()) {
                    p.this.eu.r_();
                }
                str = str2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j4 = -1;
            if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                str3 = i.w(Thread.currentThread().getStackTrace());
                j4 = System.currentTimeMillis() - currentTimeMillis;
            }
            com.bytedance.msdk.xv.r.w(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 1, str3, j4, str, ((com.bytedance.msdk.core.r.ux) p.this).bm.isClickListenRepeatPlayAgainOnce());
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void s_() {
            if (!s.c()) {
                if (p.this.eu != null) {
                    p.this.eu.s_();
                    return;
                }
                return;
            }
            if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 2, 1, 1, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 2, 0, 1, (String) null);
            }
            if (p.this.a() || p.this.eu == null) {
                return;
            }
            p.this.eu.s_();
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void t_() {
            if (!s.c()) {
                if (p.this.f27731g.c()) {
                    p.this.f27731g.ux();
                }
                if (p.this.eu != null) {
                    p.this.eu.t_();
                    return;
                }
                return;
            }
            if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 1, 1, 1, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 1, 0, 1, (String) null);
            }
            if (p.this.a()) {
                return;
            }
            if (p.this.f27731g.c()) {
                p.this.f27731g.ux();
            }
            if (p.this.eu != null) {
                p.this.eu.t_();
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void ux() {
            String str;
            long j4;
            long currentTimeMillis = System.currentTimeMillis();
            if (i.c(((com.bytedance.msdk.core.r.ux) p.this).bm)) {
                str = i.w(Thread.currentThread().getStackTrace());
                j4 = System.currentTimeMillis() - currentTimeMillis;
            } else {
                str = null;
                j4 = -1;
            }
            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, (com.bytedance.msdk.api.c) null, 2, 1, str, j4);
            if (p.this.eu != null) {
                p.this.eu.ux();
            }
        }

        @Override // com.bytedance.msdk.api.sr.c.ev.c
        public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
            if (!s.c()) {
                if (p.this.f27731g.c()) {
                    p.this.f27731g.sr();
                    return;
                } else if (p.this.eu != null) {
                    p.this.eu.c(p.c(((com.bytedance.msdk.core.r.xv) p.this).f28155k, cVar, ((com.bytedance.msdk.core.r.ux) p.this).bm));
                    p.this.c((com.bytedance.msdk.api.xv.c) null, 1);
                    return;
                } else {
                    return;
                }
            }
            if (((com.bytedance.msdk.core.r.ux) p.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) p.this).bm.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 4, 1, 1, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) p.this).bm, ((com.bytedance.msdk.core.r.xv) p.this).f28155k, 4, 0, 1, s.sr() ? i.c(Thread.currentThread().getStackTrace()) : null);
            }
            if (p.this.a()) {
                return;
            }
            if (p.this.f27731g.c()) {
                p.this.f27731g.sr();
            } else if (p.this.eu != null) {
                p.this.eu.c(p.c(((com.bytedance.msdk.core.r.xv) p.this).f28155k, cVar, ((com.bytedance.msdk.core.r.ux) p.this).bm));
                p.this.c((com.bytedance.msdk.api.xv.c) null, 1);
            }
        }
    }

    @Override // com.bytedance.msdk.core.r.sr
    public void c(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (uxVar != null) {
            if (uxVar.getSubAdType() == 6) {
                this.up = this;
            } else if (uxVar.getSubAdType() == 7) {
                this.up = this.xg;
            } else {
                this.up = this;
            }
        }
        super.c(uxVar, activity, ritScenes, str);
    }

    @MainThread
    public void c(Activity activity) {
        c(activity, (TTAdConstant.RitScenes) null, (String) null);
    }

    public void c(com.bytedance.msdk.api.sr.c.ev.c cVar) {
        this.xv = cVar;
        com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar = this.bs;
        if (xvVar != null) {
            xvVar.c(cVar);
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.ev.w wVar = this.f27732w;
        if (wVar != null) {
            wVar.c(cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0118  */
    @Override // com.bytedance.msdk.api.sr.c.ev.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.p.c():void");
    }

    @Override // com.bytedance.msdk.api.sr.c.ev.c
    public void c(com.bytedance.msdk.api.xv.c cVar) {
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.c(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 4, 1, 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 4, 0, 0, s.sr() ? i.c(Thread.currentThread().getStackTrace()) : null);
            }
            if (a()) {
                return;
            }
            com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar = this.bs;
            if (xvVar != null) {
                xvVar.w();
            }
            if (this.be.c()) {
                this.be.sr();
                return;
            }
            com.bytedance.msdk.api.sr.c.ev.c cVar2 = this.xv;
            if (cVar2 != null) {
                cVar2.c(c(this.f28155k, cVar, this.bm));
                c((com.bytedance.msdk.api.xv.c) null, 0);
                return;
            }
            return;
        }
        com.bytedance.msdk.core.admanager.reward.rewardagain.xv xvVar2 = this.bs;
        if (xvVar2 != null) {
            xvVar2.w();
        }
        if (this.be.c()) {
            this.be.sr();
            return;
        }
        com.bytedance.msdk.api.sr.c.ev.c cVar3 = this.xv;
        if (cVar3 != null) {
            cVar3.c(c(this.f28155k, cVar, this.bm));
            c((com.bytedance.msdk.api.xv.c) null, 0);
        }
    }

    public static com.bytedance.msdk.api.xv.c c(final com.bytedance.msdk.api.c.w wVar, final com.bytedance.msdk.api.xv.c cVar, final com.bytedance.msdk.c.ux uxVar) {
        if (cVar == null) {
            return null;
        }
        return new com.bytedance.msdk.api.xv.c() { // from class: com.bytedance.msdk.core.admanager.p.6
            @Override // com.bytedance.msdk.api.xv.c
            public float getAmount() {
                return com.bytedance.msdk.api.xv.c.this.getAmount();
            }

            @Override // com.bytedance.msdk.api.xv.c
            public Map<String, Object> getCustomData() {
                Map<String, Object> customData = com.bytedance.msdk.api.xv.c.this.getCustomData();
                if (customData == null) {
                    customData = new HashMap<>();
                }
                com.bytedance.msdk.api.xv c4 = fp.c(wVar, uxVar, true);
                customData.put("adnName", c4 != null ? c4.k() : "");
                customData.put("ecpm", c4 != null ? c4.a() : "");
                return customData;
            }

            @Override // com.bytedance.msdk.api.xv.c
            public String getRewardName() {
                return com.bytedance.msdk.api.xv.c.this.getRewardName();
            }

            @Override // com.bytedance.msdk.api.xv.c
            public boolean rewardVerify() {
                return com.bytedance.msdk.api.xv.c.this.rewardVerify();
            }
        };
    }
}
