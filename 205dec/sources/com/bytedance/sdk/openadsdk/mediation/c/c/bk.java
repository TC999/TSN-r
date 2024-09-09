package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class bk extends com.bytedance.sdk.openadsdk.ys.c.c.a {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f36097c;

    public bk(Bridge bridge) {
        super(bridge);
        this.f36097c = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c.a, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        b b4 = b.b(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            b4.h(0, new com.bytedance.sdk.openadsdk.mediation.c.c.w.w((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            b4.e(1, 1);
        } else {
            b4.h(0, new com.bytedance.sdk.openadsdk.q.c.c.c.c(fullScreenVideoAdInteractionListener));
            b4.e(1, 0);
        }
        Bridge bridge = this.f36097c;
        if (bridge != null) {
            bridge.call(130101, b4.l(), Void.class);
        }
    }
}
