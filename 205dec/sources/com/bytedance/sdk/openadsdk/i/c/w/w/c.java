package com.bytedance.sdk.openadsdk.i.c.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35900c;

    private ValueSet ux() {
        return b.a().l();
    }

    public abstract String c();

    public abstract void c(int i4, int i5);

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(long j4);

    public abstract void c(long j4, int i4, int i5);

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 162101:
                return (T) c();
            case 162102:
                w();
                break;
            case 162103:
                c(valueSet.longValue(0));
                break;
            case 162104:
                w(valueSet.longValue(0));
                break;
            case 162105:
                xv();
                break;
            case 162106:
                xv(valueSet.longValue(0));
                break;
            case 162107:
                sr();
                break;
            case 162108:
                c(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 162109:
                c(valueSet.longValue(0), valueSet.intValue(1), valueSet.intValue(2));
                break;
        }
        c(i4, valueSet, cls);
        return null;
    }

    public abstract void sr();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f35900c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet ux = ux();
        this.f35900c = ux;
        return ux;
    }

    public abstract void w();

    public abstract void w(long j4);

    public abstract void xv();

    public abstract void xv(long j4);
}
