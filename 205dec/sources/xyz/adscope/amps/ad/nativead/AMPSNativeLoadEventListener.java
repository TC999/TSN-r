package xyz.adscope.amps.ad.nativead;

import java.util.List;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSNativeLoadEventListener implements AMPSLoadEventListener {
    public abstract void onAmpsAdFailed(AMPSError aMPSError);

    public abstract void onAmpsAdLoad(List<AMPSNativeAdExpressInfo> list);
}
