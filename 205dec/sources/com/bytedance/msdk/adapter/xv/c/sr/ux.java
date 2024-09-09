package com.bytedance.msdk.adapter.xv.c.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux extends com.bytedance.sdk.openadsdk.mediation.c.w.xv {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.s.c.w.c.c f27252c;

    public ux(com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        this.f27252c = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.xv
    public void c(int i4, String str) {
        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar = this.f27252c;
        if (cVar != null) {
            cVar.onSelected(i4, str, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.xv
    public void w() {
        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar = this.f27252c;
        if (cVar != null) {
            cVar.onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.c.w.xv
    public void c() {
        com.bytedance.sdk.openadsdk.s.c.w.c.c cVar = this.f27252c;
        if (cVar != null) {
            cVar.onCancel();
        }
    }
}
