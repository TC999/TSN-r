package com.bytedance.sdk.gromore.c.c.xv;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends com.bytedance.sdk.openadsdk.mediation.c.w.gd {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.r f31228c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.q.c.w.c.c f31229w;

    public c(com.bytedance.msdk.core.admanager.r rVar) {
        this.f31228c = rVar;
        f();
    }

    private void f() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31228c;
        if (rVar == null) {
            return;
        }
        rVar.c(new com.bytedance.msdk.api.sr.c.sr.c() { // from class: com.bytedance.sdk.gromore.c.c.xv.c.1
            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void b_(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || !(c.this.f31229w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w)) {
                    return;
                }
                ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) c.this.f31229w).c(cVar.f27444c, cVar.f27445w);
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void c() {
                if (c.this.f31229w != null) {
                    c.this.f31229w.onAdShow();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void f() {
                if (c.this.f31229w != null) {
                    c.this.f31229w.onSkippedVideo();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void o_() {
                if (c.this.f31229w != null) {
                    c.this.f31229w.onAdVideoBarClick();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void p_() {
                if (c.this.f31229w != null) {
                    c.this.f31229w.onAdClose();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void q_() {
                if (c.this.f31229w != null) {
                    c.this.f31229w.onVideoComplete();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void ux() {
                if (c.this.f31229w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) c.this.f31229w).c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.c
            public void c(com.bytedance.msdk.api.xv.c cVar) {
                if (c.this.f31229w instanceof com.bytedance.sdk.openadsdk.mediation.c.w.c.w) {
                    ((com.bytedance.sdk.openadsdk.mediation.c.w.c.w) c.this.f31229w).c(sr.c(cVar));
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
        return new gd(new w(this.f31228c));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public Map<String, Object> w() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31228c;
        if (rVar != null) {
            return rVar.ta();
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
        this.f31229w = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public int c() {
        com.bytedance.msdk.core.admanager.r rVar = this.f31228c;
        if (rVar != null) {
            return rVar.eu();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity) {
        com.bytedance.msdk.core.admanager.r rVar = this.f31228c;
        if (rVar != null) {
            rVar.c(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.a
    public void c(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        com.bytedance.msdk.core.admanager.r rVar = this.f31228c;
        if (rVar != null) {
            rVar.w(activity, ritScenes, str);
        }
    }
}
