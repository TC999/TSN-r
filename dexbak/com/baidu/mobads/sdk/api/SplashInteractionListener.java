package com.baidu.mobads.sdk.api;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface SplashInteractionListener extends SplashAdListener {
    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdDismissed();

    void onAdPresent();

    void onLpClosed();
}
