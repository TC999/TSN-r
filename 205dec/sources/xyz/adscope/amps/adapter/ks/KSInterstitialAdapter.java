package xyz.adscope.amps.adapter.ks;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSInterstitialAdapter extends AMPSInterstitialAdapter {
    private String mBidResponse;
    private String mBidResponseV2;
    private KsInterstitialAd mKsInterstitialAd;

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        KsScene.Builder builder = new KsScene.Builder(Long.parseLong(this.mSpaceId));
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            builder.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            builder.setBidResponseV2(this.mBidResponseV2);
        }
        KsAdSDK.getLoadManager().loadInterstitialAd(builder.build(), new KsLoadManager.InterstitialAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSInterstitialAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onError code : " + i4 + " , msg : " + str);
                KSInterstitialAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onInterstitialAdLoad");
                if (list == null || list.size() == 0) {
                    KSInterstitialAdapter kSInterstitialAdapter = KSInterstitialAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    kSInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                KSInterstitialAdapter.this.mKsInterstitialAd = list.get(0);
                int ecpm = KSInterstitialAdapter.this.mKsInterstitialAd != null ? KSInterstitialAdapter.this.mKsInterstitialAd.getECPM() : 0;
                KSInterstitialAdapter kSInterstitialAdapter2 = KSInterstitialAdapter.this;
                if (kSInterstitialAdapter2.isBidding) {
                    kSInterstitialAdapter2.onC2SBiddingSuccess(ecpm);
                } else {
                    kSInterstitialAdapter2.onAdLoad();
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onRequestResult adNumber :" + i4);
            }
        });
    }

    private void setAdInteractionListener() {
        this.mKsInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSInterstitialAdapter.2
            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onAdClicked");
                KSInterstitialAdapter.this.onAdClicked();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onAdClosed");
                KSInterstitialAdapter.this.onAdDismiss();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onAdShow");
                KSInterstitialAdapter.this.onAdShow();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onPageDismiss() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onPageDismiss");
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onSkippedAd() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onSkippedAd");
                KSInterstitialAdapter.this.onSkippedAd();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayEnd() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onVideoPlayEnd");
                KSInterstitialAdapter.this.onVideoPlayEnd();
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayError(int i4, int i5) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onVideoPlayError");
            }

            @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
            public void onVideoPlayStart() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadInterstitialAd onVideoPlayStart");
                KSInterstitialAdapter.this.onVideoPlayStart();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mKsInterstitialAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsInterstitialAd ksInterstitialAd = this.mKsInterstitialAd;
        if (ksInterstitialAd != null) {
            return ksInterstitialAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mKsInterstitialAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (!this.isBidding || this.mKsInterstitialAd == null) {
            loadInterstitialAd();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsInterstitialAd ksInterstitialAd = this.mKsInterstitialAd;
            if (ksInterstitialAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksInterstitialAd, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsInterstitialAd ksInterstitialAd = this.mKsInterstitialAd;
            if (ksInterstitialAd == null) {
                return;
            }
            KSAdManagerHolder.sendWinNotification(this.mKsInterstitialAd, ksInterstitialAd.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        if (this.mKsInterstitialAd == null || activity == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.isVolumeOn).showLandscape(this.isLandScape).build();
        setAdInteractionListener();
        this.mKsInterstitialAd.showInterstitialAd(activity, build);
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        loadInterstitialAd();
    }
}
