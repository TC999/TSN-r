package com.bytedance.sdk.openadsdk.ys.w.w;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36533c;

    private ValueSet ev() {
        b a4 = b.a();
        a4.h(250001, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.c();
            }
        });
        a4.h(250002, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.w();
            }
        });
        a4.h(250003, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.xv();
            }
        });
        a4.h(250004, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.sr();
            }
        });
        a4.h(250006, new ValueSet.ValueGetter<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, String> get() {
                return xv.this.ux();
            }
        });
        a4.h(250005, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.f();
            }
        });
        a4.h(250007, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.ys.w.w.xv.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return xv.this.r();
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

    public abstract String f();

    public abstract String r();

    public abstract String sr();

    public abstract Map<String, String> ux();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36533c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet ev = ev();
        this.f36533c = ev;
        return ev;
    }

    public abstract String w();

    public abstract String xv();
}
