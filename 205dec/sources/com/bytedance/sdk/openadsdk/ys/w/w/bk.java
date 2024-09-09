package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class bk implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36479c;

    private ValueSet f() {
        b a4 = b.a();
        a4.h(230002, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.bk.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(bk.this.c());
            }
        });
        a4.h(230001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.bk.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(bk.this.w());
            }
        });
        a4.h(230003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.bk.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return bk.this.xv();
            }
        });
        a4.h(230004, new ValueSet.ValueGetter<Double>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.bk.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Double get() {
                return Double.valueOf(bk.this.sr());
            }
        });
        a4.h(230005, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.bk.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(bk.this.ux());
            }
        });
        return a4.l();
    }

    public abstract int c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        c(i4, valueSet, cls);
        return null;
    }

    public abstract double sr();

    public abstract boolean ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36479c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet f4 = f();
        this.f36479c = f4;
        return f4;
    }

    public abstract int w();

    public abstract String xv();
}
