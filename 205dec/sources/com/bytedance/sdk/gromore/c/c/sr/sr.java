package com.bytedance.sdk.gromore.c.c.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends com.bytedance.sdk.openadsdk.ys.w.w.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.msdk.api.sr.c.r.c f31201c;

    public sr(com.bytedance.msdk.api.sr.c.r.c cVar) {
        this.f31201c = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ux
    public void c() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31201c;
        if (cVar != null) {
            if (cVar.eq() == 3) {
                this.f31201c.ba();
            } else if (this.f31201c.eq() == 2) {
                this.f31201c.z();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.ux
    public void w() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31201c;
        if (cVar != null) {
            cVar.y();
        }
    }
}
