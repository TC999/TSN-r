package com.bytedance.sdk.gromore.c.c.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.mediation.c.w.gd {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.c f31236c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.q.c.w.c.c f31237w;

    public ux(com.bytedance.msdk.core.admanager.c cVar) {
        this.f31236c = cVar;
        f();
    }

    private void f() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31236c;
        if (cVar == null) {
            return;
        }
        cVar.c(new com.bytedance.msdk.api.sr.c.f.c() { // from class: com.bytedance.sdk.gromore.c.c.xv.ux.1
            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void c() {
                if (ux.this.f31237w != null) {
                    ux.this.f31237w.onAdShow();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void ev() {
                if (ux.this.f31237w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) ux.this.f31237w).xv();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void f() {
                if (ux.this.f31237w != null) {
                    ux.this.f31237w.onSkippedVideo();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void r() {
                if (ux.this.f31237w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) ux.this.f31237w).w();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void sr() {
                if (ux.this.f31237w != null) {
                    ux.this.f31237w.onVideoComplete();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void ux() {
                if (ux.this.f31237w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) ux.this.f31237w).c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void w() {
                if (ux.this.f31237w != null) {
                    ux.this.f31237w.onAdVideoBarClick();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void xv() {
                if (ux.this.f31237w != null) {
                    ux.this.f31237w.onAdClose();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void c(com.bytedance.msdk.api.c cVar2) {
                if (cVar2 == null || !(ux.this.f31237w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) ux.this.f31237w).c(cVar2.f27444c, cVar2.f27445w);
            }

            @Override // com.bytedance.msdk.api.sr.c.f.c
            public void c(com.bytedance.msdk.api.xv.c cVar2) {
                if (ux.this.f31237w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) ux.this.f31237w).c(sr.c(cVar2));
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(com.bytedance.sdk.openadsdk.ys.w.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void c(Double d4, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(boolean z3) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public long sr() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.sr ux() {
        return new gd(new f(this.f31236c));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public Map<String, Object> w() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31236c;
        if (cVar != null) {
            return cVar.ta();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.gd
    public void w(Double d4) {
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public int xv() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(com.bytedance.sdk.openadsdk.q.c.w.c.c cVar) {
        this.f31237w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public int c() {
        com.bytedance.msdk.core.admanager.c cVar = this.f31236c;
        if (cVar != null) {
            return cVar.eu();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity) {
        com.bytedance.msdk.core.admanager.c cVar = this.f31236c;
        if (cVar != null) {
            cVar.c(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bytedance.msdk.core.admanager.c cVar = this.f31236c;
        if (cVar != null) {
            cVar.c(activity, ritScenes, str);
        }
    }
}
