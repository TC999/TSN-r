package com.bytedance.sdk.openadsdk.s.ok.ok.ok.ok;

import android.os.Bundle;
import com.bykv.ok.ok.ok.ok.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ok implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? a.f24748d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        a c4 = a.c(1);
        c4.h(0, bundle);
        this.ok.call(123101, c4.a(), Void.class);
    }
}
