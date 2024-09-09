package xyz.adscope.amps.adapter.csj;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.Map;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CSJInterstitialAdapter extends AMPSInterstitialAdapter {
    private TTAdNative mTTAdNative;
    private TTFullScreenVideoAd mttFullVideoAd;

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJInterstitialAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadInterstitialAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                CSJInterstitialAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJInterstitialAdapter.this.loadInterstitialAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        this.mTTAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        this.mTTAdNative.loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdLoadType(TTAdLoadType.LOAD).build(), new TTAdNative.FullScreenVideoAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJInterstitialAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onError code : " + i4 + " , msg : " + str);
                CSJInterstitialAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onInterstitialAdLoad");
                if (tTFullScreenVideoAd == null) {
                    CSJInterstitialAdapter cSJInterstitialAdapter = CSJInterstitialAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    cSJInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                CSJInterstitialAdapter.this.mttFullVideoAd = tTFullScreenVideoAd;
                CSJInterstitialAdapter.this.onAdLoad();
                CSJInterstitialAdapter.this.setFullScreenVideoAdInteractionListener();
                CSJInterstitialAdapter.this.setDownloadListener();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
            public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadListener() {
        this.mttFullVideoAd.setDownloadListener(new TTAppDownloadListener() { // from class: xyz.adscope.amps.adapter.csj.CSJInterstitialAdapter.4
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j4, long j5, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j4, long j5, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j4, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j4, long j5, String str, String str2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullScreenVideoAdInteractionListener() {
        this.mttFullVideoAd.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.CSJInterstitialAdapter.3
            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdClose() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onAdClose");
                CSJInterstitialAdapter.this.onAdDismiss();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onAdShow");
                CSJInterstitialAdapter.this.onAdShow();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onAdVideoBarClick");
                CSJInterstitialAdapter.this.onAdClicked();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onSkippedVideo() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onSkippedVideo");
                CSJInterstitialAdapter.this.onSkippedAd();
            }

            @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
            public void onVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadInterstitialAd onVideoComplete");
                CSJInterstitialAdapter.this.onVideoPlayEnd();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mTTAdNative = null;
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediationManager() == null) {
            return;
        }
        this.mttFullVideoAd.getMediationManager().destroy();
        this.mttFullVideoAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.mttFullVideoAd;
        if (tTFullScreenVideoAd != null) {
            return tTFullScreenVideoAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mTTAdNative != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        initSDK();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        TTFullScreenVideoAd tTFullScreenVideoAd;
        if (this.mTTAdNative != null && (tTFullScreenVideoAd = this.mttFullVideoAd) != null && activity != null) {
            tTFullScreenVideoAd.showFullScreenVideoAd(activity, TTAdConstant.RitScenes.GAME_GIFT_BONUS, null);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }
}
