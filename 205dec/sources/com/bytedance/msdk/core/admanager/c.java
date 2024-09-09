package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.r.sr;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.s;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    private com.bytedance.msdk.api.sr.c.f.c be;

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.msdk.adapter.w.w f27695c;
    private com.bytedance.msdk.api.sr.c.f.w eu;

    /* renamed from: w  reason: collision with root package name */
    com.bytedance.msdk.adapter.w.xv f27696w;

    public c(Context context, String str) {
        super(context, str, 10);
        this.f27695c = new com.bytedance.msdk.adapter.w.w() { // from class: com.bytedance.msdk.core.admanager.c.3
            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void b_(@NonNull com.bytedance.msdk.api.c cVar) {
                String str2;
                long j4;
                long currentTimeMillis = System.currentTimeMillis();
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str2 = null;
                    j4 = -1;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, cVar, 1, c.this.r() ? 1 : 0, str2, j4);
                c.this.ux(cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00be  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0130  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x015f  */
            @Override // com.bytedance.msdk.api.sr.c.sr.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void c() {
                /*
                    Method dump skipped, instructions count: 459
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.c.AnonymousClass3.c():void");
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void f() {
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) c.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 3, 1, c.this.r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        }
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 3, 0, c.this.r() ? 1 : 0, (String) null);
                    }
                    if (c.this.a()) {
                        return;
                    }
                    c.this.t();
                    if (c.this.be != null) {
                        c.this.be.f();
                        return;
                    }
                    return;
                }
                c.this.t();
                if (c.this.be != null) {
                    c.this.be.f();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void o_() {
                String str2;
                String str3;
                c.this.p();
                String str4 = null;
                if (!s.c()) {
                    if (c.this.be != null) {
                        c.this.be.w();
                    }
                    str2 = null;
                } else {
                    if (((com.bytedance.msdk.core.r.ux) c.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 5, 1, c.this.r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        } else if (s.f()) {
                            str3 = i.c(Thread.currentThread().getStackTrace());
                            if (!c.this.a() && c.this.be != null) {
                                c.this.be.w();
                            }
                            str2 = str3;
                        }
                    }
                    str3 = null;
                    if (!c.this.a()) {
                        c.this.be.w();
                    }
                    str2 = str3;
                }
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = -1;
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str4 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                }
                long j5 = j4;
                com.bytedance.msdk.core.w.c.ux(((com.bytedance.msdk.core.r.xv) c.this).gd);
                com.bytedance.msdk.c.ux uxVar = ((com.bytedance.msdk.core.r.ux) c.this).bm;
                com.bytedance.msdk.api.c.w wVar = ((com.bytedance.msdk.core.r.xv) c.this).f28155k;
                boolean r3 = c.this.r();
                com.bytedance.msdk.xv.r.w(uxVar, wVar, r3 ? 1 : 0, str4, j5, str2, ((com.bytedance.msdk.core.r.ux) c.this).bm.isClickListenRepeatOnce());
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void p_() {
                c.this.f_();
                if (((w) c.this).xv) {
                    if (s.c()) {
                        if (((com.bytedance.msdk.core.r.ux) c.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetWorkName())) {
                            if (!s.w(Thread.currentThread().getStackTrace())) {
                                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 2, 1, c.this.r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                                return;
                            }
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 2, 0, c.this.r() ? 1 : 0, (String) null);
                        }
                        if (c.this.a()) {
                            return;
                        }
                        c.this.t();
                        if (c.this.be != null) {
                            c.this.be.xv();
                            return;
                        }
                        return;
                    }
                    c.this.t();
                    if (c.this.be != null) {
                        c.this.be.xv();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void q_() {
                if (s.c()) {
                    if (((com.bytedance.msdk.core.r.ux) c.this).bm != null && "pangle".equals(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetWorkName())) {
                        if (!s.w(Thread.currentThread().getStackTrace())) {
                            com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 1, 1, c.this.r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                            return;
                        }
                        com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, 1, 0, c.this.r() ? 1 : 0, (String) null);
                    }
                    if (c.this.a()) {
                        return;
                    }
                    c.this.t();
                    if (c.this.be != null) {
                        c.this.be.sr();
                        return;
                    }
                    return;
                }
                c.this.t();
                if (c.this.be != null) {
                    c.this.be.sr();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void ux() {
                String str2;
                long j4;
                long currentTimeMillis = System.currentTimeMillis();
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str2 = null;
                    j4 = -1;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, (com.bytedance.msdk.api.c) null, 2, c.this.r() ? 1 : 0, str2, j4);
                if (c.this.be != null) {
                    c.this.be.ux();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
                if (c.this.be != null) {
                    c.this.be.c(p.c(((com.bytedance.msdk.core.r.xv) c.this).f28155k, cVar, ((com.bytedance.msdk.core.r.ux) c.this).bm));
                }
            }
        };
        this.f27696w = new com.bytedance.msdk.adapter.w.xv() { // from class: com.bytedance.msdk.core.admanager.c.4
            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void c() {
                c.this.e_();
                if (c.this.be != null) {
                    c.this.be.c();
                }
                bk c4 = bk.c();
                c4.r(((com.bytedance.msdk.core.r.xv) c.this).gd + "");
                if (((com.bytedance.msdk.core.r.ux) c.this).bm != null) {
                    com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(((com.bytedance.msdk.core.r.xv) c.this).gd, TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + ((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetworkPlatformId()));
                    com.bytedance.msdk.core.gd.k.c().w(((com.bytedance.msdk.core.r.xv) c.this).gd, ((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetworkSlotId());
                }
                c.this.ys();
                c cVar = c.this;
                cVar.xv(((com.bytedance.msdk.core.r.ux) cVar).bm);
                if (((com.bytedance.msdk.core.r.ux) c.this).bm != null) {
                    com.bytedance.msdk.core.xv.xv.c(((com.bytedance.msdk.core.r.ux) c.this).bm.getAdnName(), ((com.bytedance.msdk.core.r.xv) c.this).gd, ((com.bytedance.msdk.core.r.ux) c.this).bm.getAdNetworkSlotId());
                }
                String str2 = null;
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = -1;
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, c.this.r() ? 1 : 0, str2, j4, false);
                com.bytedance.msdk.core.r.r.c(((com.bytedance.msdk.core.r.xv) c.this).gd, ((com.bytedance.msdk.core.r.ux) c.this).bm);
            }

            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void sr() {
                if (c.this.be != null) {
                    c.this.be.r();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void ux() {
                if (c.this.be != null) {
                    c.this.be.ev();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void w() {
                c.this.p();
                if (c.this.be != null) {
                    c.this.be.w();
                }
                String str2 = null;
                long currentTimeMillis = System.currentTimeMillis();
                long j4 = -1;
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                }
                com.bytedance.msdk.c.ux uxVar = ((com.bytedance.msdk.core.r.ux) c.this).bm;
                com.bytedance.msdk.api.c.w wVar = ((com.bytedance.msdk.core.r.xv) c.this).f28155k;
                boolean r3 = c.this.r();
                boolean isClickListenRepeatOnce = ((com.bytedance.msdk.core.r.ux) c.this).bm.isClickListenRepeatOnce();
                com.bytedance.msdk.xv.r.w(uxVar, wVar, r3 ? 1 : 0, str2, j4, isClickListenRepeatOnce);
            }

            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void xv() {
                c.this.f_();
                c cVar = c.this;
                if (((w) cVar).xv) {
                    cVar.t();
                    if (c.this.be != null) {
                        c.this.be.xv();
                    }
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.ux.c
            public void c(@NonNull com.bytedance.msdk.api.c cVar) {
                String str2;
                long j4;
                long currentTimeMillis = System.currentTimeMillis();
                if (i.c(((com.bytedance.msdk.core.r.ux) c.this).bm)) {
                    str2 = i.w(Thread.currentThread().getStackTrace());
                    j4 = System.currentTimeMillis() - currentTimeMillis;
                } else {
                    str2 = null;
                    j4 = -1;
                }
                com.bytedance.msdk.xv.r.c(((com.bytedance.msdk.core.r.ux) c.this).bm, ((com.bytedance.msdk.core.r.xv) c.this).f28155k, cVar, 1, c.this.r() ? 1 : 0, str2, j4);
                c.this.ux(cVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.be != null) {
                    c.this.be.c(cVar);
                }
            }
        });
    }

    private void w(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.f.w wVar2) {
        if (k()) {
            this.f28155k = wVar;
            this.eu = wVar2;
            this.up = this.f27695c;
            g_();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
        com.bytedance.msdk.api.sr.c.f.w wVar = this.eu;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        com.bytedance.msdk.api.sr.c.f.w wVar = this.eu;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, com.bytedance.msdk.api.sr.c.f.w wVar2) {
        if (!com.bytedance.msdk.core.c.w().c(pr(), 10) && wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
        } else if (com.bytedance.msdk.core.c.w().a()) {
            w(wVar, wVar2);
        } else if (wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840033, com.bytedance.msdk.api.c.c(840033)));
        }
    }

    private void w(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        super.c(activity, ritScenes, str, new sr.c() { // from class: com.bytedance.msdk.core.admanager.c.1
            @Override // com.bytedance.msdk.core.r.sr.c
            public void c() {
                c.this.ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            }
        });
    }

    public void c(Activity activity) {
        c(activity, (TTAdConstant.RitScenes) null, (String) null);
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        if (this.bm == null) {
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        }
        super.w();
        this.be = null;
        this.eu = null;
    }

    @Override // com.bytedance.msdk.core.admanager.w
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (activity == null) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "activity can not be null !");
            return;
        }
        w(activity, ritScenes, str);
        w((com.bytedance.msdk.c.ux) null);
    }

    public void c(com.bytedance.msdk.api.sr.c.f.c cVar) {
        this.be = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.f.w wVar = this.eu;
        if (wVar != null) {
            wVar.c(cVar);
        }
    }

    @Override // com.bytedance.msdk.core.admanager.w, com.bytedance.msdk.core.r.sr
    public void c(com.bytedance.msdk.c.ux uxVar, Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        if (uxVar != null) {
            if (uxVar.getSubAdType() == 1) {
                this.up = this.f27696w;
            } else if (uxVar.getSubAdType() == 2) {
                this.up = this.f27695c;
            }
        }
        super.c(uxVar, activity, ritScenes, str);
    }
}
