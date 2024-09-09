package com.bytedance.sdk.openadsdk.core.fz;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class ux implements com.bytedance.sdk.component.r.c.c.ux {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.component.ev.w f33685c;

    public ux(com.bytedance.sdk.component.ev.w wVar) {
        this.f33685c = wVar;
    }

    @Override // com.bytedance.sdk.component.r.c.c.ux
    public boolean c() {
        com.bytedance.sdk.component.ev.w wVar = this.f33685c;
        if (wVar != null) {
            return wVar.ev();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.r.c.c.ux
    public String sr() {
        com.bytedance.sdk.component.ev.w wVar = this.f33685c;
        return wVar != null ? wVar.w() : "";
    }

    @Override // com.bytedance.sdk.component.r.c.c.ux
    public Map<String, String> ux() {
        com.bytedance.sdk.component.ev.w wVar = this.f33685c;
        if (wVar != null) {
            return wVar.xv();
        }
        return new HashMap();
    }

    @Override // com.bytedance.sdk.component.r.c.c.ux
    public String w() {
        com.bytedance.sdk.component.ev.w wVar = this.f33685c;
        return wVar != null ? wVar.sr() : "";
    }

    @Override // com.bytedance.sdk.component.r.c.c.ux
    public int xv() {
        com.bytedance.sdk.component.ev.w wVar = this.f33685c;
        if (wVar != null) {
            return wVar.c();
        }
        return -1;
    }
}
