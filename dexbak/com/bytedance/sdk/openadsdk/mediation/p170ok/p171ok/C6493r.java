package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationExpressRenderListener;
import com.bytedance.sdk.openadsdk.mediation.p159ad.p160ok.p161ok.p162a.C6440kf;
import com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6377k;
import com.bytedance.sdk.openadsdk.p185r.p186ok.p187ok.p188ok.C6508a;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.r */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6493r extends C6377k {

    /* renamed from: ok */
    private Bridge f22861ok;

    public C6493r(Bridge bridge) {
        super(bridge);
        this.f22861ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.p138bl.p139ok.p142ok.C6377k, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        C5930a m37924c = C5930a.m37924c(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            m37924c.m37919h(0, new C6440kf((MediationExpressRenderListener) expressRenderListener));
            m37924c.m37921f(1, 1);
        } else {
            m37924c.m37919h(0, new C6508a(expressRenderListener));
            m37924c.m37921f(1, 0);
        }
        Bridge bridge = this.f22861ok;
        if (bridge != null) {
            bridge.call(140111, m37924c.m37926a(), Void.class);
        }
    }
}
