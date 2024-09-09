package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {
    public static final ValueSet ok(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        b4.h(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomAppList();
            }
        });
        b4.h(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public List get() {
                return IMediationPrivacyConfig.this.getCustomDevImeis();
            }
        });
        b4.h(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isCanUseOaid());
            }
        });
        b4.h(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isLimitPersonalAds());
            }
        });
        b4.h(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Boolean get() {
                return Boolean.valueOf(IMediationPrivacyConfig.this.isProgrammaticRecommend());
            }
        });
        return b4.a();
    }
}
