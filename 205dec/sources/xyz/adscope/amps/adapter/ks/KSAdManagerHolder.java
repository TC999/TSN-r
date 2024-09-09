package xyz.adscope.amps.adapter.ks;

import com.kwad.sdk.api.BaseKSAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSAdManagerHolder {
    public static void sendLossNotification(BaseKSAd baseKSAd, int i4) {
        if (baseKSAd == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK sendLossNotification reason:" + i4);
        int i5 = i4 == 1 ? 2 : 0;
        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
        if (baseKSAd instanceof KsSplashScreenAd) {
            ((KsSplashScreenAd) baseKSAd).reportAdExposureFailed(i5, adExposureFailedReason);
        } else if (baseKSAd instanceof KsFeedAd) {
            ((KsFeedAd) baseKSAd).reportAdExposureFailed(i5, adExposureFailedReason);
        } else if (baseKSAd instanceof KsInterstitialAd) {
            ((KsInterstitialAd) baseKSAd).reportAdExposureFailed(i5, adExposureFailedReason);
        } else if (baseKSAd instanceof KsRewardVideoAd) {
            ((KsRewardVideoAd) baseKSAd).reportAdExposureFailed(i5, adExposureFailedReason);
        }
    }

    public static void sendWinNotification(BaseKSAd baseKSAd, int i4) {
        if (baseKSAd == null) {
            return;
        }
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK sendWinNotification ecpm:" + i4);
        if (baseKSAd instanceof KsSplashScreenAd) {
            ((KsSplashScreenAd) baseKSAd).setBidEcpm(i4, i4 - 1);
        } else if (baseKSAd instanceof KsFeedAd) {
            ((KsFeedAd) baseKSAd).setBidEcpm(i4, i4 - 1);
        } else if (baseKSAd instanceof KsInterstitialAd) {
            ((KsInterstitialAd) baseKSAd).setBidEcpm(i4, i4 - 1);
        } else if (baseKSAd instanceof KsRewardVideoAd) {
            ((KsRewardVideoAd) baseKSAd).setBidEcpm(i4, i4 - 1);
        }
    }
}
