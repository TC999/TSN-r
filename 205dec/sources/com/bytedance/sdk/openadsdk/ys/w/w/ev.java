package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class ev implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36488c;

    private ValueSet sr() {
        return b.a().l();
    }

    public abstract void c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(com.bytedance.sdk.openadsdk.s.c.w.c.c cVar);

    public abstract void c(String str);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 240101:
                c();
                break;
            case 240102:
                c(new com.bytedance.sdk.openadsdk.s.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 240103:
                c((String) valueSet.objectValue(0, String.class));
                break;
            case 240104:
                w();
                break;
            case 240105:
                return (T) Boolean.class.cast(Boolean.valueOf(xv()));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36488c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet sr = sr();
        this.f36488c = sr;
        return sr;
    }

    public abstract void w();

    public abstract boolean xv();
}
