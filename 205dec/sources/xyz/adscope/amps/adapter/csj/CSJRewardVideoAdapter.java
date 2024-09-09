package xyz.adscope.amps.adapter.csj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdLoadType;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CSJRewardVideoAdapter extends AMPSRewardAdapter {
    private TTAdNative csjAdNative;
    private TTRewardVideoAd csjRewardVideoAd;

    private void initSDK() {
        CSJInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadRewardVideoAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                CSJRewardVideoAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                CSJRewardVideoAdapter.this.loadRewardVideoAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK start loadRewardVideoAd  spaceId:" + this.mSpaceId);
        this.csjAdNative = CSJInitMediation.get().createAdNative(this.mContext);
        this.csjAdNative.loadRewardVideoAd(new AdSlot.Builder().setCodeId(this.mSpaceId).setAdLoadType(TTAdLoadType.LOAD).setUserData(this.mExtra).setUserID(this.mUserId).setIsAutoPlay(this.isAutoPlay).build(), new TTAdNative.RewardVideoAdListener() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onError(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onError code:" + i4 + " message:" + str);
                CSJRewardVideoAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVideoAdLoad");
                CSJRewardVideoAdapter.this.csjRewardVideoAd = tTRewardVideoAd;
                CSJRewardVideoAdapter.this.csjRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: xyz.adscope.amps.adapter.csj.CSJRewardVideoAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdClose");
                        CSJRewardVideoAdapter.this.onAdDismiss();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdShow");
                        CSJRewardVideoAdapter.this.onAdShow();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onAdVideoBarClick");
                        CSJRewardVideoAdapter.this.onAdClicked();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean z3, int i4, Bundle bundle) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardArrived");
                        CSJRewardVideoAdapter.this.onRewardArrived(z3, i4, null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z3, int i4, String str, int i5, String str2) {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVerify");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onSkippedVideo");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onVideoComplete");
                        CSJRewardVideoAdapter.this.onVideoComplete();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onVideoError");
                        CSJRewardVideoAdapter.this.onVideoError();
                    }
                });
                CSJRewardVideoAdapter.this.onAdLoad();
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "CSJSDK loadRewardVideoAd onRewardVideoCached");
                CSJRewardVideoAdapter.this.onRewardVideoCached();
            }
        });
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.csjAdNative = null;
        TTRewardVideoAd tTRewardVideoAd = this.csjRewardVideoAd;
        if (tTRewardVideoAd == null || tTRewardVideoAd.getMediationManager() == null) {
            return;
        }
        this.csjRewardVideoAd.getMediationManager().destroy();
        this.csjRewardVideoAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        TTRewardVideoAd tTRewardVideoAd = this.csjRewardVideoAd;
        if (tTRewardVideoAd != null) {
            return tTRewardVideoAd.getMediaExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.csjAdNative != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        initSDK();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd;
        if (this.csjAdNative != null && (tTRewardVideoAd = this.csjRewardVideoAd) != null && activity != null) {
            tTRewardVideoAd.showRewardVideoAd(activity);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }
}
