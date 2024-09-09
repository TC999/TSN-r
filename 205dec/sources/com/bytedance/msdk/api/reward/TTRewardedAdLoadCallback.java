package com.bytedance.msdk.api.reward;

import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTRewardedAdLoadCallback {
    void onRewardVideoAdLoad();

    void onRewardVideoCached();

    void onRewardVideoLoadFail(AdError adError);
}
