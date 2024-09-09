package xyz.adscope.amps.ad.nativead.inter;

import android.view.View;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSNativeAdExpressInfo {
    void destroy();

    View getNativeExpressAdView();

    void render();

    void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener);
}
