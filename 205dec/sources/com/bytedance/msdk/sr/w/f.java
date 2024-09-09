package com.bytedance.msdk.sr.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.ys.w.xv.xv f28425c;

    public f(com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar) {
        this.f28425c = xvVar;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        b a4 = b.a();
        com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar = this.f28425c;
        a4.c(8481, xvVar != null ? xvVar.c() : 0.0d);
        com.bytedance.sdk.openadsdk.ys.w.xv.xv xvVar2 = this.f28425c;
        a4.c(8482, xvVar2 != null ? xvVar2.w() : 0.0d);
        return a4.l();
    }
}
