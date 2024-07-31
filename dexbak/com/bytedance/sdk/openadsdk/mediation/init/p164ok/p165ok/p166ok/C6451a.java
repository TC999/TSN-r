package com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6451a {
    /* renamed from: ok */
    public static final ValueSet m36242ok(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        C5930a m37925b = C5930a.m37925b();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        m37925b.m37919h(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.1
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        m37925b.m37919h(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.2
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        m37925b.m37919h(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.3
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        m37925b.m37919h(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.4
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        m37925b.m37919h(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.5
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return m37925b.m37926a();
    }
}
