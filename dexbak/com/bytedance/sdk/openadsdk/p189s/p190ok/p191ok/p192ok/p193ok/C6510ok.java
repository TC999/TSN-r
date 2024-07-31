package com.bytedance.sdk.openadsdk.p189s.p190ok.p191ok.p192ok.p193ok;

import android.os.Bundle;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* renamed from: com.bytedance.sdk.openadsdk.s.ok.ok.ok.ok.ok */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6510ok implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: ok */
    private final Bridge f22891ok;

    public C6510ok(Bridge bridge) {
        this.f22891ok = bridge == null ? C5930a.f21280d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        C5930a m37924c = C5930a.m37924c(1);
        m37924c.m37919h(0, bundle);
        this.f22891ok.call(123101, m37924c.m37926a(), Void.class);
    }
}
