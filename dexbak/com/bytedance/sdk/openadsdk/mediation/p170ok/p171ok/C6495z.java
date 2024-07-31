package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p172a.C6476a;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6376j;
import com.bytedance.sdk.openadsdk.p151k.p152ok.p153ok.p154ok.C6422ok;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.z */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6495z extends C6376j {

    /* renamed from: ok */
    private Bridge f22863ok;

    public C6495z(Bridge bridge) {
        super(bridge);
        this.f22863ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6376j, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        C5930a m37924c = C5930a.m37924c(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            m37924c.m37919h(0, new C6476a((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            m37924c.m37921f(1, 1);
        } else {
            m37924c.m37919h(0, new C6422ok(fullScreenVideoAdInteractionListener));
            m37924c.m37921f(1, 0);
        }
        Bridge bridge = this.f22863ok;
        if (bridge != null) {
            bridge.call(130101, m37924c.m37926a(), Void.class);
        }
    }
}
