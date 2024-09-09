package com.bytedance.msdk.core.admanager;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.core.r.sr;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.f.s;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w implements com.bytedance.msdk.adapter.w.w {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.sr.w f27748c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.sr.c f27749w;

    public r(Context context, String str) {
        super(context, str, 8);
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void b_(com.bytedance.msdk.api.c cVar) {
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
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, cVar, 1, r() ? 1 : 0, str, j4);
        ux(cVar);
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void f() {
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.w(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 3, 1, r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 3, 0, r() ? 1 : 0, (String) null);
            }
            if (a()) {
                return;
            }
            t();
            com.bytedance.msdk.api.sr.c.sr.c cVar = this.f27749w;
            if (cVar != null) {
                cVar.f();
                return;
            }
            return;
        }
        t();
        com.bytedance.msdk.api.sr.c.sr.c cVar2 = this.f27749w;
        if (cVar2 != null) {
            cVar2.f();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void o_() {
        String str;
        String str2;
        com.bytedance.msdk.api.sr.c.sr.c cVar;
        p();
        String str3 = null;
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.w(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 5, 1, r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                } else if (s.f()) {
                    str2 = i.c(Thread.currentThread().getStackTrace());
                    if (!a() && (cVar = this.f27749w) != null) {
                        cVar.o_();
                    }
                    str = str2;
                }
            }
            str2 = null;
            if (!a()) {
                cVar.o_();
            }
            str = str2;
        } else {
            com.bytedance.msdk.api.sr.c.sr.c cVar2 = this.f27749w;
            if (cVar2 != null) {
                cVar2.o_();
            }
            str = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = -1;
        if (i.c(this.bm)) {
            str3 = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        }
        com.bytedance.msdk.core.w.c.ux(this.f28155k.u());
        com.bytedance.msdk.c.ux uxVar2 = this.bm;
        com.bytedance.msdk.api.c.w wVar = this.f28155k;
        com.bytedance.msdk.xv.r.w(uxVar2, wVar, r() ? 1 : 0, str3, j4, str, this.bm.isClickListenRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void p_() {
        f_();
        if (((w) this).xv) {
            if (s.c()) {
                com.bytedance.msdk.c.ux uxVar = this.bm;
                if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                    if (!s.w(Thread.currentThread().getStackTrace())) {
                        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 2, 1, r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                        return;
                    }
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 2, 0, r() ? 1 : 0, (String) null);
                }
                if (a()) {
                    return;
                }
                t();
                com.bytedance.msdk.api.sr.c.sr.c cVar = this.f27749w;
                if (cVar != null) {
                    cVar.p_();
                    return;
                }
                return;
            }
            t();
            com.bytedance.msdk.api.sr.c.sr.c cVar2 = this.f27749w;
            if (cVar2 != null) {
                cVar2.p_();
            }
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void q_() {
        if (s.c()) {
            com.bytedance.msdk.c.ux uxVar = this.bm;
            if (uxVar != null && "pangle".equals(uxVar.getAdNetWorkName())) {
                if (!s.w(Thread.currentThread().getStackTrace())) {
                    com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 1, 1, r() ? 1 : 0, i.c(Thread.currentThread().getStackTrace()));
                    return;
                }
                com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, 1, 0, r() ? 1 : 0, (String) null);
            }
            if (a()) {
                return;
            }
            t();
            com.bytedance.msdk.api.sr.c.sr.c cVar = this.f27749w;
            if (cVar != null) {
                cVar.q_();
                return;
            }
            return;
        }
        t();
        com.bytedance.msdk.api.sr.c.sr.c cVar2 = this.f27749w;
        if (cVar2 != null) {
            cVar2.q_();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void sr() {
        com.bytedance.msdk.api.sr.c.sr.w wVar = this.f27748c;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
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
        com.bytedance.msdk.xv.r.c(this.bm, this.f28155k, (com.bytedance.msdk.api.c) null, 2, r() ? 1 : 0, str, j4);
        com.bytedance.msdk.api.sr.c.sr.c cVar = this.f27749w;
        if (cVar != null) {
            cVar.ux();
        }
    }

    public void w(com.bytedance.msdk.api.c.w wVar, @NonNull com.bytedance.msdk.api.sr.c.sr.w wVar2) {
        if (k()) {
            this.f27748c = wVar2;
            this.f28155k = wVar;
            this.up = this;
            g_();
        }
    }

    @Override // com.bytedance.msdk.core.r.ux
    protected void xv() {
        com.bytedance.msdk.api.sr.c.sr.w wVar = this.f27748c;
        if (wVar != null) {
            wVar.c();
        }
    }

    public void c(com.bytedance.msdk.api.c.w wVar, @NonNull com.bytedance.msdk.api.sr.c.sr.w wVar2) {
        if (!com.bytedance.msdk.core.c.w().c(pr(), 8) && wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840031, com.bytedance.msdk.api.c.c(840031)));
        } else if (com.bytedance.msdk.core.c.w().fp()) {
            w(wVar, wVar2);
        } else if (wVar2 != null) {
            wVar2.c(new com.bytedance.msdk.api.c(840037, com.bytedance.msdk.api.c.c(840037)));
        }
    }

    public void w(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        c(activity, ritScenes, str);
    }

    @Override // com.bytedance.msdk.core.r.ux
    public void w() {
        if (this.bm == null) {
            com.bytedance.msdk.core.ux.c.c.c().c(gw(), this.gd, this.f28155k, u(), this.bm);
        }
        super.w();
        this.f27749w = null;
        this.f27748c = null;
    }

    public void c(Activity activity) {
        w(activity, null, null);
    }

    @Override // com.bytedance.msdk.core.admanager.w
    @MainThread
    protected void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        super.c(activity, ritScenes, str, new sr.c() { // from class: com.bytedance.msdk.core.admanager.r.1
            @Override // com.bytedance.msdk.core.r.sr.c
            public void c() {
                r.this.ux(new com.bytedance.msdk.api.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD, com.bytedance.msdk.api.c.c(AdError.ERROR_CODE_SHOW_FAIL_NO_AD)));
            }
        });
        if (this.f27749w == null) {
            com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", "\u6ce8\u610f\uff1a\u672a\u8bbe\u7f6eGMFullVideoAdListener\uff0c\u5c06\u6536\u4e0d\u5230\u5e7f\u544a\u64ad\u653e/\u70b9\u51fb/\u5173\u95ed\u7b49\u56de\u8c03\u4fe1\u606f");
        }
        w((com.bytedance.msdk.c.ux) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(final com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.adapter.sr.f.xv(new Runnable() { // from class: com.bytedance.msdk.core.admanager.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (r.this.f27749w != null) {
                    r.this.f27749w.b_(cVar);
                }
            }
        });
    }

    public void c(com.bytedance.msdk.api.sr.c.sr.c cVar) {
        this.f27749w = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.msdk.core.r.ux
    public void c(com.bytedance.msdk.api.c cVar) {
        com.bytedance.msdk.api.sr.c.sr.w wVar = this.f27748c;
        if (wVar != null) {
            wVar.c(cVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0103  */
    @Override // com.bytedance.msdk.api.sr.c.sr.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.admanager.r.c():void");
    }

    @Override // com.bytedance.msdk.api.sr.c.sr.c
    public void c(@NonNull com.bytedance.msdk.api.xv.c cVar) {
        com.bytedance.msdk.api.sr.c.sr.c cVar2 = this.f27749w;
        if (cVar2 != null) {
            cVar2.c(p.c(this.f28155k, cVar, this.bm));
        }
    }
}
