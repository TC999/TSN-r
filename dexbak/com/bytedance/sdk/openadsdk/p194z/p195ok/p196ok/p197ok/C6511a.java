package com.bytedance.sdk.openadsdk.p194z.p195ok.p196ok.p197ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.p189s.p190ok.p191ok.p192ok.p193ok.C6510ok;

/* renamed from: com.bytedance.sdk.openadsdk.z.ok.ok.ok.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6511a implements Bridge {

    /* renamed from: a */
    private final TTRewardVideoAd.RewardAdPlayAgainController f22892a;

    /* renamed from: ok */
    private ValueSet f22893ok = C5930a.f21279c;

    public C6511a(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f22892a = rewardAdPlayAgainController;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.f22892a == null) {
            return null;
        }
        if (i == 122101) {
            this.f22892a.getPlayAgainCondition(valueSet.intValue(0), new C6510ok((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        m36186ok(i, valueSet, cls);
        return null;
    }

    /* renamed from: ok */
    protected void m36186ok(int i, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f22893ok;
    }
}
