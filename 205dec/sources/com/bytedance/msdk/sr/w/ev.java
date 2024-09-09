package com.bytedance.msdk.sr.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv f28424c;

    public ev(com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar) {
        this.f28424c = xvVar;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        b a4 = b.a();
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar = this.f28424c;
        a4.h(8468, xvVar != null ? xvVar.c() : new HashMap<>());
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar2 = this.f28424c;
        a4.e(8469, xvVar2 != null ? xvVar2.ux() : 0);
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar3 = this.f28424c;
        a4.i(8470, xvVar3 != null ? xvVar3.xv() : "");
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar4 = this.f28424c;
        a4.i(8471, xvVar4 != null ? xvVar4.sr() : "");
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar5 = this.f28424c;
        a4.i(8472, xvVar5 != null ? xvVar5.w() : "");
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar6 = this.f28424c;
        a4.i(8473, xvVar6 != null ? xvVar6.f() : "");
        com.bytedance.sdk.openadsdk.mediation.init.c.w.c.xv xvVar7 = this.f28424c;
        a4.i(8474, xvVar7 != null ? xvVar7.r() : "");
        return a4.l();
    }
}
