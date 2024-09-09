package com.bytedance.sdk.openadsdk.core.fz;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class ev implements com.bytedance.sdk.component.r.c.c.w {

    /* renamed from: c  reason: collision with root package name */
    com.bytedance.sdk.component.ev.w.w f33674c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(com.bytedance.sdk.component.ev.w.w wVar) {
        this.f33674c = wVar;
    }

    @Override // com.bytedance.sdk.component.r.c.c.w
    public void c(String str) {
        com.bytedance.sdk.component.ev.w.w wVar = this.f33674c;
        if (wVar != null) {
            wVar.c(str);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.w
    public void c(String str, String str2) {
        com.bytedance.sdk.component.ev.w.w wVar = this.f33674c;
        if (wVar != null) {
            wVar.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.r.c.c.w
    public com.bytedance.sdk.component.r.c.c.ux c() {
        com.bytedance.sdk.component.ev.w.w wVar = this.f33674c;
        if (wVar == null) {
            return null;
        }
        return new gd(wVar.c());
    }
}
