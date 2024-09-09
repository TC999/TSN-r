package com.beizi.ad;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
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
