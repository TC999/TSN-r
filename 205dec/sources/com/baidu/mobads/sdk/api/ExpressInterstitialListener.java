package com.baidu.mobads.sdk.api;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface ExpressInterstitialListener {
    void onADExposed();

    void onADExposureFailed();

    void onADLoaded();

    void onAdCacheFailed();

    void onAdCacheSuccess();

    void onAdClick();

    void onAdClose();

    void onAdFailed(int i4, String str);

    void onLpClosed();

    void onNoAd(int i4, String str);

    @Deprecated
    void onVideoDownloadFailed();

    @Deprecated
    void onVideoDownloadSuccess();
}
