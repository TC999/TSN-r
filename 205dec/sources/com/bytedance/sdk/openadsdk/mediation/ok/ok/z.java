package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class z extends com.bytedance.sdk.openadsdk.bl.ok.ok.j {
    private Bridge ok;

    public z(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.bl.ok.ok.j, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            c4.h(0, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.a((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            c4.f(1, 1);
        } else {
            c4.h(0, new com.bytedance.sdk.openadsdk.k.ok.ok.ok.ok(fullScreenVideoAdInteractionListener));
            c4.f(1, 0);
        }
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(130101, c4.a(), Void.class);
        }
    }
}
