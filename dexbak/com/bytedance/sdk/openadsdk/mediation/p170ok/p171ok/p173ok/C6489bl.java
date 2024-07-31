package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.p173ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import com.bytedance.sdk.openadsdk.p143h.p144ok.p145ok.p146ok.C6413a;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6489bl implements IMediationNativeTokenInfo {

    /* renamed from: ok */
    private final Bridge f22857ok;

    public C6489bl(Bridge bridge) {
        this.f22857ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37918i(0, str);
        m37924c.m37919h(1, new C6413a(feedAdListener));
        this.f22857ok.call(270028, m37924c.m37926a(), Void.class);
    }
}
