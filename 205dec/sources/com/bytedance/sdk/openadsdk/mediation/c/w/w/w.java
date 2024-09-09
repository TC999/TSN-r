package com.bytedance.sdk.openadsdk.mediation.c.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.fz.c.w.c.xv;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36132c;

    private ValueSet c() {
        return b.a().l();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(String str, xv xvVar);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 270028) {
            c((String) valueSet.objectValue(0, String.class), new xv((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36132c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36132c = c4;
        return c4;
    }
}
