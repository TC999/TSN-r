package com.bytedance.sdk.openadsdk.mediation.manager.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36227c;

    private ValueSet f() {
        b a4 = b.a();
        a4.h(271001, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return w.this.c();
            }
        });
        a4.h(271002, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return w.this.w();
            }
        });
        a4.h(271003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return w.this.xv();
            }
        });
        a4.h(271004, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(w.this.sr());
            }
        });
        a4.h(271005, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.w.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return w.this.ux();
            }
        });
        return a4.l();
    }

    public abstract String c();

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        c(i4, valueSet, cls);
        return null;
    }

    public abstract int sr();

    public abstract String ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36227c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet f4 = f();
        this.f36227c = f4;
        return f4;
    }

    public abstract String w();

    public abstract String xv();
}
