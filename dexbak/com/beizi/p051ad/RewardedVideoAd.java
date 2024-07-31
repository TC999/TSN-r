package com.beizi.p051ad;

import android.content.Context;

/* renamed from: com.beizi.ad.RewardedVideoAd */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface RewardedVideoAd {
    void destroy(Context context);

    String getPrice();

    RewardedVideoAdListener getRewardedVideoAdListener();

    boolean isLoaded();

    void loadAd(String str, AdRequest adRequest);

    void pause(Context context);

    void resume(Context context);

    void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener);

    void show();
}
