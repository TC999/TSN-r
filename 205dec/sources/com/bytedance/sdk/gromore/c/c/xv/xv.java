package com.bytedance.sdk.gromore.c.c.xv;

import android.app.Activity;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.r f31240c;
    private c sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31241w;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.sr xv;

    public xv(Activity activity, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar) {
        this.f31241w = cVar;
        if (cVar != null) {
            this.f31240c = new com.bytedance.msdk.core.admanager.r(activity, cVar.f());
            this.xv = srVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        this.f31240c.c(new com.bytedance.msdk.api.c.w(8, this.f31241w.w()), new com.bytedance.msdk.api.sr.c.sr.w() { // from class: com.bytedance.sdk.gromore.c.c.xv.xv.1
            @Override // com.bytedance.msdk.api.sr.c.sr.w
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || xv.this.xv == null) {
                    return;
                }
                xv.this.xv.onError(cVar.f27444c, cVar.f27445w);
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.w
            public void w() {
                if (xv.this.xv != null) {
                    xv.this.xv.onFullScreenVideoCached();
                    if (xv.this.sr == null) {
                        xv xvVar = xv.this;
                        xvVar.sr = new c(xvVar.f31240c);
                    }
                    xv.this.xv.onFullScreenVideoCached(xv.this.sr);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.sr.w
            public void c() {
                if (xv.this.xv != null) {
                    if (xv.this.sr == null) {
                        xv xvVar = xv.this;
                        xvVar.sr = new c(xvVar.f31240c);
                    }
                    xv.this.xv.onFullScreenVideoAdLoad(xv.this.sr);
                }
            }
        });
    }
}
