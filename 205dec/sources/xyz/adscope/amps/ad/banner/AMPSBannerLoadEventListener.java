package xyz.adscope.amps.ad.banner;

import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSBannerLoadEventListener extends AMPSLoadEventListener {
    void onAmpsAdClicked();

    void onAmpsAdDismiss();

    void onAmpsAdFailed(AMPSError aMPSError);

    void onAmpsAdLoaded();

    void onAmpsAdShow();
}
