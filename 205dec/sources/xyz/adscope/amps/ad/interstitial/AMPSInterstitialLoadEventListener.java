package xyz.adscope.amps.ad.interstitial;

import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSInterstitialLoadEventListener extends AMPSLoadEventListener {
    void onAmpsAdClicked();

    void onAmpsAdDismiss();

    void onAmpsAdFailed(AMPSError aMPSError);

    void onAmpsAdLoaded();

    void onAmpsAdShow();

    void onAmpsSkippedAd();

    void onAmpsVideoPlayEnd();

    void onAmpsVideoPlayStart();
}
