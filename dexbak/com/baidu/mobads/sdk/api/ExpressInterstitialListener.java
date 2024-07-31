package com.baidu.mobads.sdk.api;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i, String str);

    void onLpClosed();

    void onNoAd(int i, String str);

    @Deprecated
    void onVideoDownloadFailed();

    @Deprecated
    void onVideoDownloadSuccess();
}
