package xyz.adscope.amps.adapter.ks;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.util.Map;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class KSSplashAdapter extends AMPSSplashAdapter {
    private KsSplashScreenAd ksSplashScreenAd;
    private String mBidResponse;
    private String mBidResponseV2;
    private final KsSplashScreenAd.SplashScreenAdInteractionListener mInteractionListener = new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: xyz.adscope.amps.adapter.ks.KSSplashAdapter.2
        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdClicked() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdClicked");
            KSSplashAdapter.this.onAdClicked();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowEnd() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowEnd");
            KSSplashAdapter.this.onAdDismiss();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowError(int i4, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowError code:" + i4 + ";extra:" + str);
            KSSplashAdapter.this.onAdShowFailed(String.valueOf(i4), str);
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onAdShowStart() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onAdShowStart");
            KSSplashAdapter.this.onAdShow();
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogCancel() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onDownloadTipsDialogCancel");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogDismiss() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd  onDownloadTipsDialogDismiss");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onDownloadTipsDialogShow() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onDownloadTipsDialogShow");
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public void onSkippedAd() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onSkippedAd");
            KSSplashAdapter.this.onAdDismiss();
        }
    };

    private void initSDK() {
        KSInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadSplashAd();
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
        splashAdExtraData.setDisableShakeStatus(!KSInitMediation.getInstance().isCanUseShakeAd());
        KsScene.Builder splashExtraData = new KsScene.Builder(Long.parseLong(this.mSpaceId)).setSplashExtraData(splashAdExtraData);
        if (!TextUtils.isEmpty(this.mBidResponse)) {
            splashExtraData.setBidResponse(this.mBidResponse);
        } else if (!TextUtils.isEmpty(this.mBidResponseV2)) {
            splashExtraData.setBidResponseV2(this.mBidResponseV2);
        }
        KsAdSDK.getLoadManager().loadSplashScreenAd(splashExtraData.build(), new KsLoadManager.SplashScreenAdListener() { // from class: xyz.adscope.amps.adapter.ks.KSSplashAdapter.1
            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onError code : " + i4 + " , msg : " + str);
                KSSplashAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onRequestResult adNumber :" + i4);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(@NonNull KsSplashScreenAd ksSplashScreenAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "KSSDK loadSplashAd onSplashScreenAdLoad");
                KSSplashAdapter.this.ksSplashScreenAd = ksSplashScreenAd;
                int ecpm = KSSplashAdapter.this.ksSplashScreenAd != null ? KSSplashAdapter.this.ksSplashScreenAd.getECPM() : 0;
                KSSplashAdapter kSSplashAdapter = KSSplashAdapter.this;
                if (kSSplashAdapter.isBidding) {
                    kSSplashAdapter.onC2SBiddingSuccess(ecpm);
                } else {
                    kSSplashAdapter.onAdLoad();
                }
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.ksSplashScreenAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
        if (ksSplashScreenAd != null) {
            ksSplashScreenAd.getMediaExtraInfo();
            return null;
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.ksSplashScreenAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        if (!this.isBidding || this.ksSplashScreenAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
            if (ksSplashScreenAd != null && aMPSBidResult != null) {
                KSAdManagerHolder.sendLossNotification(ksSplashScreenAd, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
            if (ksSplashScreenAd == null) {
                return;
            }
            KSAdManagerHolder.sendWinNotification(this.ksSplashScreenAd, ksSplashScreenAd.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
        if (ksSplashScreenAd == null || viewGroup == null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
            onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
            return;
        }
        View view = ksSplashScreenAd.getView(viewGroup.getContext(), this.mInteractionListener);
        viewGroup.removeAllViews();
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(view);
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
