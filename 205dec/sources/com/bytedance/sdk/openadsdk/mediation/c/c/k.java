package com.bytedance.sdk.openadsdk.mediation.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class k extends com.bytedance.sdk.openadsdk.ys.c.c.p {

    /* renamed from: c  reason: collision with root package name */
    private Bridge f36104c;

    public k(Bridge bridge) {
        super(bridge);
        this.f36104c = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c.p, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        b b4 = b.b(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            b4.h(0, new com.bytedance.sdk.openadsdk.mediation.ad.c.c.w.f((MediationExpressRenderListener) expressRenderListener));
            b4.e(1, 1);
        } else {
            b4.h(0, new com.bytedance.sdk.openadsdk.j.c.c.c.w(expressRenderListener));
            b4.e(1, 0);
        }
        Bridge bridge = this.f36104c;
        if (bridge != null) {
            bridge.call(140111, b4.l(), Void.class);
        }
    }
}
