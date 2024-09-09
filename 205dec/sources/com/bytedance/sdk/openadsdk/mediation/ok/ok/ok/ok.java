package com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements IMediationDrawTokenInfo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? com.bykv.ok.ok.ok.ok.a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(2);
        c4.i(0, str);
        c4.h(1, new com.bytedance.sdk.openadsdk.h.ok.ok.ok.ok(drawFeedAdListener));
        this.ok.call(270031, c4.a(), Void.class);
    }
}
