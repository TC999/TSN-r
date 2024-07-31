package com.bytedance.msdk.api.reward;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface TTRewardedAdLoadCallback {
    void onRewardVideoAdLoad();

    void onRewardVideoCached();

    void onRewardVideoLoadFail(AdError adError);
}
