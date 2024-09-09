package com.bytedance.sdk.openadsdk.mediation.manager.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public abstract class c implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f36205c;

    private ValueSet c() {
        b a4 = b.a();
        a4.h(271006, new ValueSet.ValueGetter<Map<String, String>>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Map<String, String> get() {
                return c.this.getCustomData();
            }
        });
        a4.h(271007, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getSdkName();
            }
        });
        a4.h(271008, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getCustomSdkName();
            }
        });
        a4.h(271009, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getSlotId();
            }
        });
        a4.h(271010, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getLevelTag();
            }
        });
        a4.h(271011, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getEcpm();
            }
        });
        a4.h(271012, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.13
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(c.this.getReqBiddingType());
            }
        });
        a4.h(271013, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.14
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getErrorMsg();
            }
        });
        a4.h(271014, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.15
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getRequestId();
            }
        });
        a4.h(271015, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getRitType();
            }
        });
        a4.h(271016, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getSegmentId();
            }
        });
        a4.h(271017, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getChannel();
            }
        });
        a4.h(271018, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getSubChannel();
            }
        });
        a4.h(271019, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getAbTestId();
            }
        });
        a4.h(271020, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.manager.c.w.c.c.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public String get() {
                return c.this.getScenarioId();
            }
        });
        return a4.l();
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        c(i4, valueSet, cls);
        return null;
    }

    public abstract String getAbTestId();

    public abstract String getChannel();

    public abstract Map<String, String> getCustomData();

    public abstract String getCustomSdkName();

    public abstract String getEcpm();

    public abstract String getErrorMsg();

    public abstract String getLevelTag();

    public abstract int getReqBiddingType();

    public abstract String getRequestId();

    public abstract String getRitType();

    public abstract String getScenarioId();

    public abstract String getSdkName();

    public abstract String getSegmentId();

    public abstract String getSlotId();

    public abstract String getSubChannel();

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f36205c;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet c4 = c();
        this.f36205c = c4;
        return c4;
    }
}
