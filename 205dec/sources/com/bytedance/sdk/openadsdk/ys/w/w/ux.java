package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ux implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36525c;

    private ValueSet xv() {
        return b.a().l();
    }

    public abstract void c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 222101:
                c();
                break;
            case 222102:
                w();
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36525c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet xv = xv();
        this.f36525c = xv;
        return xv;
    }

    public abstract void w();
}
