package xyz.adscope.amps.ad.interstitial;

import xyz.adscope.amps.base.AMPSBaseListener;
import xyz.adscope.amps.common.AMPSError;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSInterstitialAdListener implements AMPSBaseListener {
    public abstract void onInterstitialAdClicked();

    public abstract void onInterstitialAdClose();

    public abstract void onInterstitialAdLoadFail(AMPSError aMPSError);

    public abstract void onInterstitialAdLoaded();

    public abstract void onInterstitialAdShow();

    public abstract void onInterstitialAdVideoEnd();

    public abstract void onInterstitialAdVideoError(AMPSError aMPSError);

    public abstract void onInterstitialAdVideoStart();
}
