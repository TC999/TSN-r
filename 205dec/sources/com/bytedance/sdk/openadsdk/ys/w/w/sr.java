package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36503c;

    private ValueSet xv() {
        b a4 = b.a();
        a4.h(243001, new ValueSet.ValueGetter<List<f>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.sr.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public List<f> get() {
                return sr.this.c();
            }
        });
        a4.h(243002, new ValueSet.ValueGetter<r>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.sr.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public r get() {
                return sr.this.w();
            }
        });
        return a4.l();
    }

    public abstract List<f> c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36503c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet xv = xv();
        this.f36503c = xv;
        return xv;
    }

    public abstract r w();
}
