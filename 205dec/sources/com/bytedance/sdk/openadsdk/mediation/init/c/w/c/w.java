package com.bytedance.sdk.openadsdk.mediation.init.c.w.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    public final ValueSet f36184c;

    public w(ValueSet valueSet) {
        this.f36184c = valueSet == null ? b.f24740c : valueSet;
    }

    public List<String> c() {
        return (List) this.f36184c.objectValue(262114, List.class);
    }

    public boolean sr() {
        return this.f36184c.booleanValue(262117);
    }

    public boolean ux() {
        return this.f36184c.booleanValue(262118);
    }

    public List<String> w() {
        return (List) this.f36184c.objectValue(262115, List.class);
    }

    public boolean xv() {
        return this.f36184c.booleanValue(262116);
    }

    public static final ValueSet c(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        b a4 = b.a();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        a4.h(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        a4.h(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        a4.h(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        a4.h(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        a4.h(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.c.w.c.w.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return a4.l();
    }
}
