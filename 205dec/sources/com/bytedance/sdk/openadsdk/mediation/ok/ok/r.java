package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class r extends com.bytedance.sdk.openadsdk.bl.ok.ok.k {
    private Bridge ok;

    public r(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.bl.ok.ok.k, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        com.bykv.ok.ok.ok.ok.a c4 = com.bykv.ok.ok.ok.ok.a.c(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            c4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.kf((MediationExpressRenderListener) expressRenderListener));
            c4.f(1, 1);
        } else {
            c4.h(0, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.a(expressRenderListener));
            c4.f(1, 0);
        }
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(140111, c4.a(), Void.class);
        }
    }
}
