package com.beizi.fusion;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface RewardedVideoAdListener extends BaseAdListener {
    void onRewarded();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdFailedToLoad(int i);

    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdShown();

    void onRewardedVideoClick();

    void onRewardedVideoComplete();
}
