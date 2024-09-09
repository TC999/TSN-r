package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GDTInterstitialAdapter extends AMPSInterstitialAdapter {
    private int autoPlayPolicy = 1;
    private String mS2SBiddingToken;
    private UnifiedInterstitialAD mUnifiedInterstitialAD;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class GDTUnifiedInterstitialADListener implements UnifiedInterstitialADListener {
        private GDTUnifiedInterstitialADListener() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADClicked");
            GDTInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADClosed");
            GDTInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADExposure");
            GDTInterstitialAdapter.this.onAdShow();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADLeftApplication");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onADReceive");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            String str;
            String str2 = "";
            if (adError != null) {
                str2 = String.valueOf(adError.getErrorCode());
                str = adError.getErrorMsg();
            } else {
                str = "";
            }
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onNoAD code : " + str2 + " , msg : " + str);
            GDTInterstitialAdapter.this.onAdFailed(str2, str);
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onRenderFail");
            GDTInterstitialAdapter gDTInterstitialAdapter = GDTInterstitialAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_RENDER_FAIL;
            gDTInterstitialAdapter.onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onRenderSuccess");
            int ecpm = GDTInterstitialAdapter.this.mUnifiedInterstitialAD != null ? GDTInterstitialAdapter.this.mUnifiedInterstitialAD.getECPM() : 0;
            GDTInterstitialAdapter gDTInterstitialAdapter = GDTInterstitialAdapter.this;
            if (gDTInterstitialAdapter.isBidding) {
                gDTInterstitialAdapter.onC2SBiddingSuccess(ecpm);
            } else {
                gDTInterstitialAdapter.onAdLoad();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoCached");
        }
    }

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        this.mUnifiedInterstitialAD = !TextUtils.isEmpty(this.mS2SBiddingToken) ? new UnifiedInterstitialAD((Activity) this.mContext, this.mSpaceId, new GDTUnifiedInterstitialADListener(), null, this.mS2SBiddingToken) : new UnifiedInterstitialAD((Activity) this.mContext, this.mSpaceId, new GDTUnifiedInterstitialADListener());
        setMediaListener();
        setVideoOption();
        this.mUnifiedInterstitialAD.loadAD();
    }

    private void setMediaListener() {
        this.mUnifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTInterstitialAdapter.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoComplete");
                GDTInterstitialAdapter.this.onVideoPlayEnd();
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j4) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadInterstitialAd onVideoStart");
                GDTInterstitialAdapter.this.onVideoPlayStart();
            }
        });
    }

    private void setVideoOption() {
        VideoOption build = new VideoOption.Builder().setAutoPlayMuted(this.isVolumeOn).setAutoPlayPolicy(this.autoPlayPolicy).setDetailPageMuted(this.isVolumeOn).build();
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setVideoOption(build);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.close();
            this.mUnifiedInterstitialAD.destroy();
        }
        this.mUnifiedInterstitialAD = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD == null) {
            return false;
        }
        return unifiedInterstitialAD.isValid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (aMPSAdapterModel != null) {
            this.autoPlayPolicy = AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY.getAutoPlayValue() == aMPSAdapterModel.getVideoAutoPlay() ? 2 : AMPSEnum.AutoPlayEnum.WIFI_AUTO_PLAY.getAutoPlayValue() == aMPSAdapterModel.getVideoAutoPlay() ? 0 : 1;
        }
        if (!this.isBidding || this.mUnifiedInterstitialAD == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
            if (unifiedInterstitialAD != null && aMPSBidResult != null) {
                GDTAdManagerHolder.sendLossNotification(unifiedInterstitialAD, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
            if (unifiedInterstitialAD == null) {
                return;
            }
            GDTAdManagerHolder.sendWinNotification(this.mUnifiedInterstitialAD, unifiedInterstitialAD.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.mUnifiedInterstitialAD;
        if (unifiedInterstitialAD != null && activity != null && unifiedInterstitialAD.isValid()) {
            this.mUnifiedInterstitialAD.show();
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        if (aMPSAdapterModel != null) {
            this.autoPlayPolicy = AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY.getAutoPlayValue() == aMPSAdapterModel.getVideoAutoPlay() ? 2 : AMPSEnum.AutoPlayEnum.WIFI_AUTO_PLAY.getAutoPlayValue() == aMPSAdapterModel.getVideoAutoPlay() ? 0 : 1;
        }
        initSDK();
    }
}
