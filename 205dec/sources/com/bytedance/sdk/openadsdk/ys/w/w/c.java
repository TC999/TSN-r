package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36485c;

    private ValueSet xv() {
        b a4 = b.a();
        a4.h(263001, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(c.this.c());
            }
        });
        a4.h(263002, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.c.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.w();
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

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36485c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet xv = xv();
        this.f36485c = xv;
        return xv;
    }

    public abstract String w();
}
