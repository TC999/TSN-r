package xyz.adscope.amps.ad.interstitial;

import android.content.Context;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInterstitialOpenApiManager extends AMPSBaseOpenApiManager implements AMPSInterstitialAdAdapterListener {
    private AMPSInterstitialLoadEventListener ampsIntersititialLoadEventListener;

    public AMPSInterstitialOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSInterstitialLoadEventListener);
        this.ampsIntersititialLoadEventListener = aMPSInterstitialLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onSkippedAd() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsSkippedAd();
        }
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onVideoPlayEnd() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsVideoPlayEnd();
        }
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener
    public void onVideoPlayStart() {
        AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener = this.ampsIntersititialLoadEventListener;
        if (aMPSInterstitialLoadEventListener != null) {
            aMPSInterstitialLoadEventListener.onAmpsVideoPlayStart();
        }
    }

    public void refreshLoadEventListener(AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener) {
        this.ampsIntersititialLoadEventListener = aMPSInterstitialLoadEventListener;
        refreshListener(aMPSInterstitialLoadEventListener);
    }
}
