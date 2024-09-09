package com.bytedance.sdk.gromore.c.c.xv;

import android.app.Activity;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements com.bytedance.sdk.gromore.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.core.admanager.c f31233c;
    private ux sr;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.c.w.c f31234w;
    private com.bytedance.sdk.openadsdk.fz.c.w.c.sr xv;

    public r(Activity activity, com.bytedance.sdk.openadsdk.mediation.c.w.c cVar, com.bytedance.sdk.openadsdk.fz.c.w.c.sr srVar) {
        this.f31234w = cVar;
        if (cVar != null) {
            this.f31233c = new com.bytedance.msdk.core.admanager.c(activity, cVar.f());
            this.xv = srVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.c.c.ux
    public void c() {
        this.f31233c.c(new com.bytedance.msdk.api.c.w(10, this.f31234w.w()), new com.bytedance.msdk.api.sr.c.f.w() { // from class: com.bytedance.sdk.gromore.c.c.xv.r.1
            @Override // com.bytedance.msdk.api.sr.c.f.w
            public void c(com.bytedance.msdk.api.c cVar) {
                if (cVar == null || r.this.xv == null) {
                    return;
                }
                r.this.xv.onError(cVar.f27444c, cVar.f27445w);
            }

            @Override // com.bytedance.msdk.api.sr.c.f.w
            public void w() {
                if (r.this.xv != null) {
                    r.this.xv.onFullScreenVideoCached();
                    if (r.this.sr == null) {
                        r rVar = r.this;
                        rVar.sr = new ux(rVar.f31233c);
                    }
                    r.this.xv.onFullScreenVideoCached(r.this.sr);
                }
            }

            @Override // com.bytedance.msdk.api.sr.c.f.w
            public void c() {
                if (r.this.xv != null) {
                    if (r.this.sr == null) {
                        r rVar = r.this;
                        rVar.sr = new ux(rVar.f31233c);
                    }
                    r.this.xv.onFullScreenVideoAdLoad(r.this.sr);
                }
            }
        });
    }
}
