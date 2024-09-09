package com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements IMediationNativeTokenInfo {
    private final Bridge ok;

    public bl(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(2);
        c4.i(0, str);
        c4.h(1, new com.bytedance.sdk.openadsdk.h.ok.ok.ok.a(feedAdListener));
        this.ok.call(270028, c4.a(), Void.class);
    }
}
