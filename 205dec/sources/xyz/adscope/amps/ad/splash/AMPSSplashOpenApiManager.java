package xyz.adscope.amps.ad.splash;

import android.content.Context;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.config.AMPSRequestParameters;
import xyz.adscope.amps.manager.AMPSBaseOpenApiManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSSplashOpenApiManager extends AMPSBaseOpenApiManager implements AMPSSplashAdAdapterListener {
    private AMPSSplashLoadEventListener ampsSplashLoadEventListener;

    public AMPSSplashOpenApiManager(Context context, AMPSRequestParameters aMPSRequestParameters, AMPSSplashLoadEventListener aMPSSplashLoadEventListener) {
        super(context, aMPSRequestParameters, aMPSSplashLoadEventListener);
        this.ampsSplashLoadEventListener = aMPSSplashLoadEventListener;
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener
    public void onSkippedAd() {
        AMPSSplashLoadEventListener aMPSSplashLoadEventListener = this.ampsSplashLoadEventListener;
        if (aMPSSplashLoadEventListener != null) {
            aMPSSplashLoadEventListener.onAmpsAdDismiss();
        }
    }

    public void refreshLoadEventListener(AMPSSplashLoadEventListener aMPSSplashLoadEventListener) {
        this.ampsSplashLoadEventListener = aMPSSplashLoadEventListener;
        refreshListener(aMPSSplashLoadEventListener);
    }
}
