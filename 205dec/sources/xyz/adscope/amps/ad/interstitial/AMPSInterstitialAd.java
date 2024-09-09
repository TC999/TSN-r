package xyz.adscope.amps.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.preload.AMPSPreLoad;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSInterstitialAd extends AMPSBaseAd implements AMPSInterstitialLoadEventListener {
    public AMPSInterstitialAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSInterstitialLoadEventListener aMPSInterstitialLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSInterstitialLoadEventListener);
        this.loadEventListener = aMPSInterstitialLoadEventListener;
    }

    public void addPreLoadAdInfo() {
        if (this.mAdPreLoadManager == null || TextUtils.isEmpty(this.mSpaceId)) {
            return;
        }
        AMPSPreLoad.getInstance().addPreLoadAdInfo(this.mSpaceId, this.mAdPreLoadManager);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSInterstitialOpenApiManager(this.mContext, this.parameters, this);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getPreloadAMPSOpenApiManager() {
        return new AMPSInterstitialOpenApiManager(this.mContext, this.parameters, new AMPSInterstitialLoadEventListener() { // from class: xyz.adscope.amps.ad.interstitial.AMPSInterstitialAd.1
            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsAdClicked() {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsAdDismiss() {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsAdFailed(AMPSError aMPSError) {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsAdLoaded() {
                AMPSInterstitialAd.this.addPreLoadAdInfo();
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsAdShow() {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsSkippedAd() {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsVideoPlayEnd() {
            }

            @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
            public void onAmpsVideoPlayStart() {
            }
        });
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsAdClicked() {
        onAdClicked();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsAdDismiss() {
        onAdDismiss();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsAdFailed(AMPSError aMPSError) {
        onAdFailed(aMPSError);
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsAdLoaded() {
        onAdLoaded();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsAdShow() {
        onAdShow();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsSkippedAd() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener)) {
            return;
        }
        ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsSkippedAd();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsVideoPlayEnd() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener)) {
            return;
        }
        ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsVideoPlayEnd();
    }

    @Override // xyz.adscope.amps.ad.interstitial.AMPSInterstitialLoadEventListener
    public void onAmpsVideoPlayStart() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSInterstitialLoadEventListener)) {
            return;
        }
        ((AMPSInterstitialLoadEventListener) aMPSLoadEventListener).onAmpsVideoPlayStart();
    }

    public void preLoad() {
        if (this.mAdPreLoadManager != null) {
            return;
        }
        AMPSBaseOpenApiManager preloadAMPSOpenApiManager = getPreloadAMPSOpenApiManager();
        this.mAdPreLoadManager = preloadAMPSOpenApiManager;
        preloadAMPSOpenApiManager.startLoad();
    }

    public void show(Activity activity) {
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null) {
            onAdFailed();
        } else {
            aMPSBaseOpenApiManager.show(activity);
        }
    }
}
