package xyz.adscope.amps.ad.nativead;

import android.content.Context;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.base.AMPSBaseAd;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSNativeAd extends AMPSBaseAd {
    private AMPSNativeLoadEventListener listener;

    public AMPSNativeAd(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSNativeLoadEventListener aMPSNativeLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSNativeLoadEventListener);
        this.listener = aMPSNativeLoadEventListener;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAd
    public AMPSBaseOpenApiManager getAMPSOpenApiManager() {
        return new AMPSNativeOpenApiManager(this.mContext, this.parameters, this.listener);
    }

    public void pause() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSNativeAdapter)) {
            return;
        }
        ((AMPSNativeAdapter) winAdSourceAdapter).pause();
    }

    public void resume() {
        AMPSBaseAdapter winAdSourceAdapter;
        AMPSBaseOpenApiManager aMPSBaseOpenApiManager = this.mAdLoadManager;
        if (aMPSBaseOpenApiManager == null || (winAdSourceAdapter = aMPSBaseOpenApiManager.getWinAdSourceAdapter()) == null || !(winAdSourceAdapter instanceof AMPSNativeAdapter)) {
            return;
        }
        ((AMPSNativeAdapter) winAdSourceAdapter).resume();
    }
}
