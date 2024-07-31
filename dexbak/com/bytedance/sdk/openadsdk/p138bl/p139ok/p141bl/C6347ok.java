package com.bytedance.sdk.openadsdk.p138bl.p139ok.p141bl;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.mediation.init.p164ok.p165ok.p166ok.C6458ok;

/* renamed from: com.bytedance.sdk.openadsdk.bl.ok.bl.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6347ok {
    /* renamed from: ok */
    public static final ValueSet m36531ok(final AdConfig adConfig) {
        C5930a m37925b = C5930a.m37925b();
        if (adConfig == null) {
            return null;
        }
        m37925b.m37918i(261001, adConfig.getAppId());
        m37925b.m37918i(261002, adConfig.getAppName());
        m37925b.m37917j(261003, adConfig.isPaid());
        m37925b.m37918i(261004, adConfig.getKeywords());
        m37925b.m37918i(261005, adConfig.getData());
        m37925b.m37921f(261006, adConfig.getTitleBarTheme());
        m37925b.m37917j(261007, adConfig.isAllowShowNotify());
        m37925b.m37917j(261008, adConfig.isDebug());
        m37925b.m37919h(261009, adConfig.getDirectDownloadNetworkType());
        m37925b.m37917j(261010, adConfig.isUseTextureView());
        m37925b.m37917j(261011, adConfig.isSupportMultiProcess());
        m37925b.m37919h(261012, adConfig.getCustomController() != null ? C6351s.m36527ok(adConfig.getCustomController()) : null);
        m37925b.m37919h(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.1
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        m37925b.m37919h(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.2
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        m37925b.m37919h(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.3
            @Override // com.bykv.p110vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        m37925b.m37919h(261016, adConfig.getMediationConfig() != null ? C6458ok.m36235ok(adConfig.getMediationConfig()) : null);
        m37925b.m37917j(261017, adConfig.isUseMediation());
        return m37925b.m37926a();
    }
}
