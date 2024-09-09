package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class k extends t implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36497c;

    private ValueSet n() {
        b k4 = b.k(super.values());
        k4.h(160001, new ValueSet.ValueGetter<Double>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.k.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Double get() {
                return Double.valueOf(k.this.c());
            }
        });
        k4.h(160002, new ValueSet.ValueGetter<com.bytedance.sdk.openadsdk.i.c.w.w.c>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.k.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public com.bytedance.sdk.openadsdk.i.c.w.w.c get() {
                return k.this.w();
            }
        });
        k4.h(160003, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.k.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(k.this.xv());
            }
        });
        k4.h(160004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.k.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(k.this.sr());
            }
        });
        return k4.l();
    }

    public abstract double c();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd
    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    public abstract void c(com.bytedance.sdk.openadsdk.i.c.w.c.c cVar);

    public abstract void c(com.bytedance.sdk.openadsdk.i.c.w.c.w wVar);

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 160101:
                c(new com.bytedance.sdk.openadsdk.i.c.w.c.c((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 160102:
                c(new com.bytedance.sdk.openadsdk.i.c.w.c.w((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return (T) super.call(i4, valueSet, cls);
    }

    public abstract int sr();

    @Override // com.bytedance.sdk.openadsdk.ys.w.w.t, com.bytedance.sdk.openadsdk.ys.w.w.gd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36497c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet n4 = n();
        this.f36497c = n4;
        return n4;
    }

    public abstract com.bytedance.sdk.openadsdk.i.c.w.w.c w();

    public abstract int xv();
}
