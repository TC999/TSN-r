package xyz.adscope.amps.adapter.bd;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BDInterstitialAdapter extends AMPSInterstitialAdapter {
    private ExpressInterstitialAd mExpressInterstitialAd;
    private ExpressInterstitialListener mExpressInterstitialListener = new ExpressInterstitialListener() { // from class: xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.1
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposed");
            BDInterstitialAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADExposureFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADExposureFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onADLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdCacheFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheFailed");
            BDInterstitialAdapter bDInterstitialAdapter = BDInterstitialAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDInterstitialAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAdCacheSuccess() {
            /*
                r3 = this;
                java.lang.String r0 = "amps_log_tag"
                java.lang.String r1 = "BDSDK onAdCacheSuccess"
                xyz.adscope.amps.tool.AMPSLogUtil.d(r0, r1)
                xyz.adscope.amps.adapter.bd.BDInterstitialAdapter r0 = xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                if (r0 == 0) goto L22
                xyz.adscope.amps.adapter.bd.BDInterstitialAdapter r0 = xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.ExpressInterstitialAd r0 = xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Throwable -> L1e
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L1e
                goto L23
            L1e:
                r0 = move-exception
                r0.printStackTrace()
            L22:
                r0 = 0
            L23:
                xyz.adscope.amps.adapter.bd.BDInterstitialAdapter r1 = xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.this
                boolean r2 = r1.isBidding
                if (r2 == 0) goto L2d
                r1.onC2SBiddingSuccess(r0)
                goto L30
            L2d:
                r1.onAdLoad()
            L30:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.bd.BDInterstitialAdapter.AnonymousClass1.onAdCacheSuccess():void");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdClose() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClose");
            BDInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onAdFailed(int i4, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed msg:" + str);
            BDInterstitialAdapter.this.onAdFailed(String.valueOf(i4), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onNoAd(int i4, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNoAd msg:" + str);
            BDInterstitialAdapter.this.onAdFailed(String.valueOf(i4), str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        public void onVideoDownloadSuccess() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadSuccess");
        }
    };

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(this.mContext, this.mSpaceId);
        this.mExpressInterstitialAd = expressInterstitialAd;
        expressInterstitialAd.setLoadListener(this.mExpressInterstitialListener);
        this.mExpressInterstitialAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.destroy();
            }
            this.mExpressInterstitialAd = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
        if (expressInterstitialAd == null) {
            return false;
        }
        return expressInterstitialAd.isReady();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (!this.isBidding || this.mExpressInterstitialAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
            if (expressInterstitialAd != null && aMPSBidResult != null) {
                if (this.isSendBidData == AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    expressInterstitialAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())));
                } else {
                    expressInterstitialAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())), BDInitMediation.getInstance().getWinInfo(aMPSBidResult));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
            if (expressInterstitialAd != null && aMPSBidResult != null) {
                if (this.isSendBidData != AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    this.mExpressInterstitialAd.biddingSuccess(String.valueOf(aMPSBidResult.getEcpm()), BDInitMediation.getInstance().getSecondInfo(aMPSBidResult));
                    return;
                }
                String eCPMLevel = expressInterstitialAd.getECPMLevel();
                if (TextUtils.isEmpty(eCPMLevel)) {
                    return;
                }
                this.mExpressInterstitialAd.biddingSuccess(eCPMLevel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        ExpressInterstitialAd expressInterstitialAd = this.mExpressInterstitialAd;
        if (expressInterstitialAd != null && activity != null && expressInterstitialAd.isReady()) {
            this.mExpressInterstitialAd.show(activity);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
