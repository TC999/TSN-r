package xyz.adscope.amps.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.preload.AMPSPreLoad;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSRewardVideoAd extends AMPSBaseAd implements AMPSRewardVideoLoadEventListener {
    public AMPSRewardVideoAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSRewardVideoLoadEventListener aMPSRewardVideoLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSRewardVideoLoadEventListener);
        this.loadEventListener = aMPSRewardVideoLoadEventListener;
    }

    public void addPreLoadAdInfo() {
        if (this.mAdPreLoadManager == null || TextUtils.isEmpty(this.mSpaceId)) {
            return;
        }
        AMPSPreLoad.getInstance().addPreLoadAdInfo(this.mSpaceId, this.mAdPreLoadManager);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSRewardVideoOpenApiManager(this.mContext, this.parameters, this);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getPreloadAMPSOpenApiManager() {
        return new AMPSRewardVideoOpenApiManager(this.mContext, this.parameters, new AMPSRewardVideoLoadEventListener() { // from class: xyz.adscope.amps.ad.reward.AMPSRewardVideoAd.1
            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdCached() {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdDismiss() {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdFailed(AMPSError aMPSError) {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdLoad() {
                AMPSRewardVideoAd.this.addPreLoadAdInfo();
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdRewardArrived(boolean z3, int i4, Map<String, Object> map) {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdShow() {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdVideoClick() {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdVideoComplete() {
            }

            @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
            public void onAmpsAdVideoError() {
            }
        });
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdCached() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener)) {
            return;
        }
        ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdCached();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdDismiss() {
        onAdDismiss();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdFailed(AMPSError aMPSError) {
        onAdFailed(aMPSError);
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdLoad() {
        onAdLoaded();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdRewardArrived(boolean z3, int i4, Map<String, Object> map) {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener)) {
            return;
        }
        ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdRewardArrived(z3, i4, map);
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdShow() {
        onAdShow();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdVideoClick() {
        onAdClicked();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdVideoComplete() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener)) {
            return;
        }
        ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdVideoComplete();
    }

    @Override // xyz.adscope.amps.ad.reward.AMPSRewardVideoLoadEventListener
    public void onAmpsAdVideoError() {
        AMPSLoadEventListener aMPSLoadEventListener = this.loadEventListener;
        if (aMPSLoadEventListener == null || !(aMPSLoadEventListener instanceof AMPSRewardVideoLoadEventListener)) {
            return;
        }
        ((AMPSRewardVideoLoadEventListener) aMPSLoadEventListener).onAmpsAdVideoError();
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
