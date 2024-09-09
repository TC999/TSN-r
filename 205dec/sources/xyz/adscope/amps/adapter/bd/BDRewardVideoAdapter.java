package xyz.adscope.amps.adapter.bd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter;
import xyz.adscope.amps.ad.reward.adapter.AMPSRewardVideoAdAdapterListener;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BDRewardVideoAdapter extends AMPSRewardAdapter {
    private RewardVideoAd mRewardVideoAd;
    private RewardVideoAd.RewardVideoAdListener mRewardVideoAdListener = new RewardVideoAd.RewardVideoAdListener() { // from class: xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.1
        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDRewardVideoAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdClose(float f4) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClose");
            BDRewardVideoAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdFailed(String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed message:" + str);
            BDRewardVideoAdapter.this.onAdFailed(str, str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdShow() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdShow");
            BDRewardVideoAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onAdSkip(float f4) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdSkip");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        public void onRewardVerify(boolean z3) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onRewardVerify flag:" + z3);
            BDRewardVideoAdapter.this.onRewardArrived(z3, 0, null);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadFailed");
            BDRewardVideoAdapter bDRewardVideoAdapter = BDRewardVideoAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDRewardVideoAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onVideoDownloadSuccess() {
            /*
                r3 = this;
                java.lang.String r0 = "amps_log_tag"
                java.lang.String r1 = "BDSDK onVideoDownloadSuccess"
                xyz.adscope.amps.tool.AMPSLogUtil.d(r0, r1)
                xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter r0 = xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.RewardVideoAd r0 = xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                if (r0 == 0) goto L22
                xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter r0 = xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.RewardVideoAd r0 = xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Throwable -> L1e
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L1e
                goto L23
            L1e:
                r0 = move-exception
                r0.printStackTrace()
            L22:
                r0 = 0
            L23:
                xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter r1 = xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.this
                boolean r2 = r1.isBidding
                if (r2 == 0) goto L2d
                r1.onC2SBiddingSuccess(r0)
                goto L30
            L2d:
                r1.onAdLoad()
            L30:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.bd.BDRewardVideoAdapter.AnonymousClass1.onVideoDownloadSuccess():void");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void playCompletion() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK playCompletion");
            BDRewardVideoAdapter.this.onVideoComplete();
        }
    };

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadRewardVideoAd();
    }

    private void loadRewardVideoAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadRewardVideoAd spaceId:" + this.mSpaceId);
        RewardVideoAd rewardVideoAd = new RewardVideoAd(this.mContext, this.mSpaceId, this.mRewardVideoAdListener);
        this.mRewardVideoAd = rewardVideoAd;
        rewardVideoAd.setUserId(this.mUserId);
        this.mRewardVideoAd.setExtraInfo(this.mExtra);
        this.mRewardVideoAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mRewardVideoAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd == null) {
            return false;
        }
        return rewardVideoAd.isReady();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.reward.adapter.AMPSRewardAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSRewardVideoAdAdapterListener);
        if (!this.isBidding || this.mRewardVideoAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
            if (rewardVideoAd != null && aMPSBidResult != null) {
                if (this.isSendBidData == AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    rewardVideoAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())));
                } else {
                    rewardVideoAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())), BDInitMediation.getInstance().getWinInfo(aMPSBidResult));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
            if (rewardVideoAd != null && aMPSBidResult != null) {
                if (this.isSendBidData != AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    this.mRewardVideoAd.biddingSuccess(String.valueOf(aMPSBidResult.getEcpm()), BDInitMediation.getInstance().getSecondInfo(aMPSBidResult));
                    return;
                }
                String eCPMLevel = rewardVideoAd.getECPMLevel();
                if (TextUtils.isEmpty(eCPMLevel)) {
                    return;
                }
                this.mRewardVideoAd.biddingSuccess(eCPMLevel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null && activity != null && rewardVideoAd.isReady()) {
            this.mRewardVideoAd.show();
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
