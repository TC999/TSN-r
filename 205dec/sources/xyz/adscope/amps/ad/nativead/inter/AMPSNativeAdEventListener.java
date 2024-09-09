package xyz.adscope.amps.ad.nativead.inter;

import java.util.List;
import xyz.adscope.amps.ad.nativead.view.AMPSNativeAdView;
import xyz.adscope.amps.base.AMPSBaseListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSNativeAdEventListener implements AMPSBaseListener {
    public abstract void onAdClicked(AMPSNativeAdView aMPSNativeAdView);

    public abstract void onAdImpressed(List<AMPSNativeAdView> list);

    public abstract void onAdVideoEnd(AMPSNativeAdView aMPSNativeAdView);

    public abstract void onAdVideoProgress(AMPSNativeAdView aMPSNativeAdView, int i4);

    public abstract void onAdVideoStart(AMPSNativeAdView aMPSNativeAdView);
}
