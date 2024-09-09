package xyz.adscope.amps.ad.interstitial.adapter;

import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSInterstitialAdAdapterListener<T> extends AMPSBaseAdAdapterListener {
    void onSkippedAd();

    void onVideoPlayEnd();

    void onVideoPlayStart();
}
