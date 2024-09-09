package xyz.adscope.amps.ad.reward;

import java.util.Map;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.manager.inter.AMPSLoadEventListener;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface AMPSRewardVideoLoadEventListener extends AMPSLoadEventListener {
    void onAmpsAdCached();

    void onAmpsAdDismiss();

    void onAmpsAdFailed(AMPSError aMPSError);

    void onAmpsAdLoad();

    void onAmpsAdRewardArrived(boolean z3, int i4, Map<String, Object> map);

    void onAmpsAdShow();

    void onAmpsAdVideoClick();

    void onAmpsAdVideoComplete();

    void onAmpsAdVideoError();
}
