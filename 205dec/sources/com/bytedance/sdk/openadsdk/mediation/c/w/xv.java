package com.bytedance.sdk.openadsdk.mediation.c.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36133c;

    private ValueSet xv() {
        return b.a().l();
    }

    public abstract void c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(int i4, String str);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 268013:
                c(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 268014:
                c();
                break;
            case 268015:
                w();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36133c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet xv = xv();
        this.f36133c = xv;
        return xv;
    }

    public abstract void w();
}
