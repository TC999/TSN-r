package com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback;

/* renamed from: com.bytedance.sdk.openadsdk.mediation.ok.ok.kf */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6485kf implements IMediationDislikeCallback {

    /* renamed from: ok */
    private final Bridge f22854ok;

    public C6485kf(Bridge bridge) {
        this.f22854ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onCancel() {
        this.f22854ok.call(268014, C5930a.m37924c(0).m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onSelected(int i, String str) {
        C5930a m37924c = C5930a.m37924c(2);
        m37924c.m37921f(0, i);
        m37924c.m37918i(1, str);
        this.f22854ok.call(268013, m37924c.m37926a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.p159ad.IMediationDislikeCallback
    public void onShow() {
        this.f22854ok.call(268015, C5930a.m37924c(0).m37926a(), Void.class);
    }
}
