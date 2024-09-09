package com.bytedance.sdk.openadsdk.fp.c.c.c.c;

import android.os.Bundle;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {

    /* renamed from: c  reason: collision with root package name */
    private final Bridge f35860c;

    public c(Bridge bridge) {
        this.f35860c = bridge == null ? b.f24741d : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        b b4 = b.b(1);
        b4.h(0, bundle);
        this.f35860c.call(123101, b4.l(), Void.class);
    }
}
