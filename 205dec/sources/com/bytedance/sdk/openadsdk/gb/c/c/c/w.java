package com.bytedance.sdk.openadsdk.gb.c.c.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private ValueSet f35883c = b.f24740c;

    /* renamed from: w  reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdPlayAgainController f35884w;

    public w(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f35884w = rewardAdPlayAgainController;
    }

    protected void c(int i4, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (this.f35884w == null) {
            return null;
        }
        if (i4 == 122101) {
            this.f35884w.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.fp.c.c.c.c.c((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        c(i4, valueSet, cls);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f35883c;
    }
}
