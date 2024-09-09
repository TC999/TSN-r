package xyz.adscope.amps.adapter.gdt;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GDTRewardVideoAdapter extends AMPSRewardAdapter {
    private RewardVideoAD mRewardVideoAD;

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadRewardVideoAd();
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(this.mContext, this.mSpaceId, new RewardVideoADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTRewardVideoAdapter.1
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADClick");
                GDTRewardVideoAdapter.this.onAdClicked();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADClose() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADClose");
                GDTRewardVideoAdapter.this.onAdDismiss();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADExpose");
                GDTRewardVideoAdapter.this.onAdShow();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADLoad() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADLoad");
                int ecpm = GDTRewardVideoAdapter.this.mRewardVideoAD != null ? GDTRewardVideoAdapter.this.mRewardVideoAD.getECPM() : 0;
                GDTRewardVideoAdapter gDTRewardVideoAdapter = GDTRewardVideoAdapter.this;
                if (gDTRewardVideoAdapter.isBidding) {
                    gDTRewardVideoAdapter.onC2SBiddingSuccess(ecpm);
                } else {
                    gDTRewardVideoAdapter.onAdLoad();
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADShow() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onADShow");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onError(AdError adError) {
                String str;
                String str2 = "";
                if (adError != null) {
                    str2 = String.valueOf(adError.getErrorCode());
                    str = adError.getErrorMsg();
                } else {
                    str = "";
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideo onRewardVideoLoadFail code:" + str2 + " message:" + str);
                GDTRewardVideoAdapter.this.onAdFailed(str2, str);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onReward(Map<String, Object> map) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onReward map:" + map);
                GDTRewardVideoAdapter.this.onRewardArrived(true, 0, map);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoCached() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onVideoCached");
                GDTRewardVideoAdapter.this.onRewardVideoCached();
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onVideoComplete() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onVideoComplete");
                GDTRewardVideoAdapter.this.onVideoComplete();
            }
        }, this.isVolumeOn);
        this.mRewardVideoAD = rewardVideoAD;
        rewardVideoAD.setNegativeFeedbackListener(new NegativeFeedbackListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTRewardVideoAdapter.2
            @Override // com.qq.e.comm.listeners.NegativeFeedbackListener
            public void onComplainSuccess() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadRewardVideoAd onComplainSuccess");
            }
        });
        this.mRewardVideoAD.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setCustomData(this.mExtra).setUserId(this.mUserId).build());
        this.mRewardVideoAD.loadAD();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mRewardVideoAD = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD != null) {
            return rewardVideoAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD == null) {
            return false;
        }
        return rewardVideoAD.isValid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (!this.isBidding || this.mRewardVideoAD == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
            if (rewardVideoAD != null && aMPSBidResult != null) {
                GDTAdManagerHolder.sendLossNotification(rewardVideoAD, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
            if (rewardVideoAD == null) {
                return;
            }
            GDTAdManagerHolder.sendWinNotification(this.mRewardVideoAD, rewardVideoAD.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        RewardVideoAD rewardVideoAD = this.mRewardVideoAD;
        if (rewardVideoAD != null && activity != null && rewardVideoAD.isValid()) {
            this.mRewardVideoAD.showAD(activity);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
