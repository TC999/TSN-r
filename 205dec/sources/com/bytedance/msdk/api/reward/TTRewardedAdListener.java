package com.bytedance.msdk.api.reward;

import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.AdError;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface TTRewardedAdListener extends ITTAdatperCallback {
    void onRewardClick();

    void onRewardVerify(RewardItem rewardItem);

    void onRewardedAdClosed();

    void onRewardedAdShow();

    void onRewardedAdShowFail(AdError adError);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError();
}
