package com.bytedance.sdk.openadsdk.mediation.ad.c.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36049c;

    private ValueSet w() {
        return b.a().l();
    }

    public abstract void c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c cVar);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 270032:
                c();
                break;
            case 270033:
                c(new com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36049c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet w3 = w();
        this.f36049c = w3;
        return w3;
    }
}
