package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok {
    public static final ValueSet ok(final AdConfig adConfig) {
        com.bykv.ok.ok.ok.ok.a b4 = com.bykv.ok.ok.ok.ok.a.b();
        if (adConfig == null) {
            return null;
        }
        b4.i(261001, adConfig.getAppId());
        b4.i(261002, adConfig.getAppName());
        b4.j(261003, adConfig.isPaid());
        b4.i(261004, adConfig.getKeywords());
        b4.i(261005, adConfig.getData());
        b4.f(261006, adConfig.getTitleBarTheme());
        b4.j(261007, adConfig.isAllowShowNotify());
        b4.j(261008, adConfig.isDebug());
        b4.h(261009, adConfig.getDirectDownloadNetworkType());
        b4.j(261010, adConfig.isUseTextureView());
        b4.j(261011, adConfig.isSupportMultiProcess());
        b4.h(261012, adConfig.getCustomController() != null ? s.ok(adConfig.getCustomController()) : null);
        b4.h(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        b4.h(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        b4.h(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: ok */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        b4.h(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.ok(adConfig.getMediationConfig()) : null);
        b4.j(261017, adConfig.isUseMediation());
        return b4.a();
    }
}
