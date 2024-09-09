package com.bytedance.sdk.openadsdk.z.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a implements Bridge {

    /* renamed from: a  reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdPlayAgainController f36570a;
    private ValueSet ok = com.bykv.ok.ok.ok.ok.a.f24747c;

    public a(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f36570a = rewardAdPlayAgainController;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f36570a == null) {
            return null;
        }
        if (i4 == 122101) {
            this.f36570a.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.s.ok.ok.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        ok(i4, valueSet, cls);
        return null;
    }

    protected void ok(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
