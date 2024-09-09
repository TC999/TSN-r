package com.bytedance.sdk.openadsdk.ys.c.xv;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {
    public static final ValueSet c(final AdConfig adConfig) {
        b a4 = b.a();
        if (adConfig == null) {
            return null;
        }
        a4.i(261001, adConfig.getAppId());
        a4.i(261002, adConfig.getAppName());
        a4.j(261003, adConfig.isPaid());
        a4.i(261004, adConfig.getKeywords());
        a4.i(261005, adConfig.getData());
        a4.e(261006, adConfig.getTitleBarTheme());
        a4.j(261007, adConfig.isAllowShowNotify());
        a4.j(261008, adConfig.isDebug());
        a4.h(261009, adConfig.getDirectDownloadNetworkType());
        a4.j(261010, adConfig.isUseTextureView());
        a4.j(261011, adConfig.isSupportMultiProcess());
        a4.h(261012, adConfig.getCustomController() != null ? sr.c(adConfig.getCustomController()) : null);
        a4.h(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.c.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getPluginUpdateConfig());
            }
        });
        a4.h(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.c.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getAgeGroup());
            }
        });
        a4.h(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.ys.c.xv.c.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* renamed from: c */
            public Integer get() {
                return Integer.valueOf(AdConfig.this.getThemeStatus());
            }
        });
        a4.h(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.c.c.c.c.c(adConfig.getMediationConfig()) : null);
        a4.j(261017, adConfig.isUseMediation());
        return a4.l();
    }
}
