package com.bytedance.sdk.openadsdk.mediation.manager.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class sr extends xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36223c;

    private ValueSet c() {
        return b.k(super.values()).l();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 270007) {
            destroy();
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract void destroy();

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.xv, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36223c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36223c = c4;
        return c4;
    }
}
