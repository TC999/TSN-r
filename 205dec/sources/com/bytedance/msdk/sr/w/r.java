package com.bytedance.msdk.sr.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w f28426c;

    public r(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar) {
        this.f28426c = wVar;
    }

    public boolean c() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar = this.f28426c;
        if (wVar != null) {
            return wVar.sr();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    public List<String> sr() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar = this.f28426c;
        if (wVar != null) {
            return wVar.w();
        }
        return null;
    }

    public boolean ux() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar = this.f28426c;
        if (wVar != null) {
            return wVar.xv();
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        b a4 = b.a();
        a4.h(8476, xv());
        a4.h(8477, sr());
        a4.j(8478, ux());
        a4.j(8027, c());
        a4.j(8028, w());
        return a4.l();
    }

    public boolean w() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar = this.f28426c;
        if (wVar != null) {
            return wVar.ux();
        }
        return true;
    }

    public List<String> xv() {
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w wVar = this.f28426c;
        if (wVar != null) {
            return wVar.c();
        }
        return null;
    }
}
