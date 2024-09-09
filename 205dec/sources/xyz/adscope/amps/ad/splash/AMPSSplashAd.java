package xyz.adscope.amps.ad.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.control.preload.AMPSPreLoad;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;
import xyz.adscope.amps.report.AMPSReportConstants;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSplashAd extends AMPSBaseAd implements AMPSSplashLoadEventListener {
    public AMPSSplashAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSSplashLoadEventListener aMPSSplashLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSSplashLoadEventListener);
        this.loadEventListener = aMPSSplashLoadEventListener;
    }

    public void addPreLoadAdInfo() {
        if (this.mAdPreLoadManager == null || TextUtils.isEmpty(this.mSpaceId)) {
            return;
        }
        AMPSPreLoad.getInstance().addPreLoadAdInfo(this.mSpaceId, this.mAdPreLoadManager);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSSplashOpenApiManager(this.mContext, this.parameters, this);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getPreloadAMPSOpenApiManager() {
        return new AMPSSplashOpenApiManager(this.mContext, this.parameters, new AMPSSplashLoadEventListener() { // from class: xyz.adscope.amps.ad.splash.AMPSSplashAd.1
            @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
            public void onAmpsAdClicked() {
            }

            @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
            public void onAmpsAdDismiss() {
            }

            @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
            public void onAmpsAdFailed(AMPSError aMPSError) {
            }

            @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
            public void onAmpsAdLoaded() {
                AMPSSplashAd.this.addPreLoadAdInfo();
            }

            @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
            public void onAmpsAdShow() {
            }
        });
    }

    @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
    public void onAmpsAdClicked() {
        onAdClicked();
    }

    @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
    public void onAmpsAdDismiss() {
        onAdDismiss();
        autoRefreshAd();
    }

    @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
    public void onAmpsAdFailed(AMPSError aMPSError) {
        onAdFailed(aMPSError);
    }

    @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
    public void onAmpsAdLoaded() {
        onAdLoaded();
    }

    @Override // xyz.adscope.amps.ad.splash.AMPSSplashLoadEventListener
    public void onAmpsAdShow() {
        onAdShow();
    }

    public void preLoad() {
        if (this.mAdPreLoadManager != null) {
            return;
        }
        AMPSRequestParameters aMPSRequestParameters = this.parameters;
        if (aMPSRequestParameters != null) {
            aMPSRequestParameters.setLoadType(AMPSReportConstants.LOAD_TYPE.LOAD_TYPE_PRELOAD.getValue());
        }
        AMPSBaseOpenApiManager preloadAMPSOpenApiManager = getPreloadAMPSOpenApiManager();
        this.mAdPreLoadManager = preloadAMPSOpenApiManager;
        preloadAMPSOpenApiManager.startLoad();
    }

    public void show(ViewGroup viewGroup) {
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null) {
            onAdFailed();
        } else {
            aMPSBaseOpenApiManager.show(viewGroup);
        }
    }
}
