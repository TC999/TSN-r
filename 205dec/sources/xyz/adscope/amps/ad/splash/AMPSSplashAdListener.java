package xyz.adscope.amps.ad.splash;

import xyz.adscope.amps.base.AMPSBaseListener;
import xyz.adscope.amps.common.AMPSError;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSSplashAdListener implements AMPSBaseListener {
    public abstract void onAdClicked();

    public abstract void onAdDismiss();

    public abstract void onAdFailed(AMPSError aMPSError);

    public abstract void onAdLoaded();

    public abstract void onAdShow();
}
