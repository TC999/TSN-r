package xyz.adscope.amps.adapter.bd;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BDSplashAdapter extends AMPSSplashAdapter {
    private SplashInteractionListener mInteractionListener = new SplashInteractionListener() { // from class: xyz.adscope.amps.adapter.bd.BDSplashAdapter.1
        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onADLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onADLoaded");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdCacheFailed");
            BDSplashAdapter bDSplashAdapter = BDSplashAdapter.this;
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_CACHE_FAIL;
            bDSplashAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
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
                xyz.adscope.amps.adapter.bd.BDSplashAdapter r0 = xyz.adscope.amps.adapter.bd.BDSplashAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.SplashAd r0 = xyz.adscope.amps.adapter.bd.BDSplashAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                if (r0 == 0) goto L22
                xyz.adscope.amps.adapter.bd.BDSplashAdapter r0 = xyz.adscope.amps.adapter.bd.BDSplashAdapter.this     // Catch: java.lang.Throwable -> L1e
                com.baidu.mobads.sdk.api.SplashAd r0 = xyz.adscope.amps.adapter.bd.BDSplashAdapter.access$000(r0)     // Catch: java.lang.Throwable -> L1e
                java.lang.String r0 = r0.getECPMLevel()     // Catch: java.lang.Throwable -> L1e
                int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L1e
                goto L23
            L1e:
                r0 = move-exception
                r0.printStackTrace()
            L22:
                r0 = 0
            L23:
                xyz.adscope.amps.adapter.bd.BDSplashAdapter r1 = xyz.adscope.amps.adapter.bd.BDSplashAdapter.this
                boolean r2 = r1.isBidding
                if (r2 == 0) goto L2d
                r1.onC2SBiddingSuccess(r0)
                goto L30
            L2d:
                r1.onAdLoad()
            L30:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.bd.BDSplashAdapter.AnonymousClass1.onAdCacheSuccess():void");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdClick");
            BDSplashAdapter.this.onAdClicked();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdDismissed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdDismissed");
            BDSplashAdapter.this.onAdDismiss();
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdExposed");
            BDSplashAdapter.this.onAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        public void onAdFailed(String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdFailed message:" + str);
            BDSplashAdapter.this.onAdFailed(str, str);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdPresent() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdPresent");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onAdSkip");
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }
    };
    private SplashAd mSplashAd;

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadSplashAd();
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadSplashAd spaceId:" + this.mSpaceId);
        RequestParameters.Builder builder = new RequestParameters.Builder();
        builder.addExtra("timeout", String.valueOf(this.mTimeout));
        builder.setWidth(this.viewWidthDp);
        builder.setHeight(this.viewHeightDp);
        SplashAd splashAd = new SplashAd(this.mContext, this.mSpaceId, builder.build(), this.mInteractionListener);
        this.mSplashAd = splashAd;
        splashAd.load();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null) {
                splashAd.destroy();
            }
            this.mSplashAd = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd == null) {
            return false;
        }
        return splashAd.isReady();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        if (!this.isBidding || this.mSplashAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null && aMPSBidResult != null) {
                if (this.isSendBidData == AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    splashAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())));
                } else {
                    splashAd.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())), BDInitMediation.getInstance().getWinInfo(aMPSBidResult));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null && aMPSBidResult != null) {
                if (this.isSendBidData != AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    this.mSplashAd.biddingSuccess(String.valueOf(aMPSBidResult.getEcpm()), BDInitMediation.getInstance().getSecondInfo(aMPSBidResult));
                    return;
                }
                String eCPMLevel = splashAd.getECPMLevel();
                if (TextUtils.isEmpty(eCPMLevel)) {
                    return;
                }
                this.mSplashAd.biddingSuccess(eCPMLevel);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null && viewGroup != null && splashAd.isReady()) {
            this.mSplashAd.show(viewGroup);
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
