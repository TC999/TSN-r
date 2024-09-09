package xyz.adscope.amps.ad.banner;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSBannerAd extends AMPSBaseAd {
    private AMPSBannerLoadEventListener ampsBannerLoadEventListener;

    public AMPSBannerAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSBannerLoadEventListener aMPSBannerLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSBannerLoadEventListener);
        this.ampsBannerLoadEventListener = aMPSBannerLoadEventListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSBannerOpenApiManager(this.mContext, this.parameters, this.ampsBannerLoadEventListener);
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
