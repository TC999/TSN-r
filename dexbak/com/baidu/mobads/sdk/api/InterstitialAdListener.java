package com.baidu.mobads.sdk.api;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterstitialAdListener {
    void onAdClick(InterstitialAd interstitialAd);

    void onAdDismissed();

    void onAdFailed(String str);

    void onAdPresent();

    void onAdReady();
}
