package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class gd implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36496c;

    private ValueSet c() {
        return b.a().l();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(com.bytedance.sdk.openadsdk.ys.w.c.c cVar);

    public abstract void c(Double d4);

    public abstract void c(Double d4, String str, String str2);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 210101:
                c(Double.valueOf(valueSet.doubleValue(0)));
                break;
            case 210102:
                c(Double.valueOf(valueSet.doubleValue(0)), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 210103:
                w(Double.valueOf(valueSet.doubleValue(0)));
                break;
            case 210104:
                c(new com.bytedance.sdk.openadsdk.ys.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36496c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36496c = c4;
        return c4;
    }

    public abstract void w(Double d4);
}
