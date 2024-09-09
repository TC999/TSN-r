package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import android.view.ViewGroup;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.splash.SplashAd;
import xyz.adscope.ad.advertisings.splash.config.SplashAdConfig;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestEnum;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPSplashAdapter extends AMPSSplashAdapter {
    private SplashAd mSplashAd;

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.1
            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void failCallBack(AMPSError aMPSError) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GMSDK loadSplashAd onSplashLoadFail code:" + aMPSError.getCode() + " message:" + aMPSError.getMessage());
                ASNPSplashAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            @Override // xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack
            public void successCallBack() {
                ASNPSplashAdapter.this.loadSplashAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashAd splashAd = new SplashAd(this.mContext, new AdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.2
            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdClicked");
                ASNPSplashAdapter.this.onAdClicked();
            }

            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdClosed");
                ASNPSplashAdapter.this.onAdDismiss();
            }

            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdExposure() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdExposure");
                ASNPSplashAdapter.this.onAdShow();
            }

            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdFailedToLoad(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdFailedToLoad code : " + i4 + " , message : " + str);
                ASNPSplashAdapter.this.onAdFailed(String.valueOf(i4), str);
            }

            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdLoaded");
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
            /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onAdRenderSuccess() {
                /*
                    r3 = this;
                    java.lang.String r0 = "amps_log_tag"
                    java.lang.String r1 = "ASNPSDK loadSplashAd onAdRenderSuccess"
                    xyz.adscope.amps.tool.AMPSLogUtil.d(r0, r1)
                    xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter r0 = xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.this     // Catch: java.lang.Exception -> L20
                    xyz.adscope.ad.advertisings.splash.SplashAd r0 = xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.access$100(r0)     // Catch: java.lang.Exception -> L20
                    if (r0 == 0) goto L24
                    xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter r0 = xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.this     // Catch: java.lang.Exception -> L20
                    xyz.adscope.ad.advertisings.splash.SplashAd r0 = xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.access$100(r0)     // Catch: java.lang.Exception -> L20
                    xyz.adscope.ad.bidding.inter.IAdBidding r0 = r0.getAdBid()     // Catch: java.lang.Exception -> L20
                    if (r0 == 0) goto L24
                    int r0 = r0.getECPM()     // Catch: java.lang.Exception -> L20
                    goto L25
                L20:
                    r0 = move-exception
                    r0.printStackTrace()
                L24:
                    r0 = 0
                L25:
                    xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter r1 = xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.this
                    boolean r2 = r1.isBidding
                    if (r2 == 0) goto L2f
                    r1.onC2SBiddingSuccess(r0)
                    goto L32
                L2f:
                    r1.onAdLoad()
                L32:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.amps.adapter.asnp.ASNPSplashAdapter.AnonymousClass2.onAdRenderSuccess():void");
            }

            @Override // xyz.adscope.ad.advertisings.inter.AdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadSplashAd onAdShown");
            }
        }, new SplashAdConfig.Builder().spaceId(this.mSpaceId).intervalTime((long) this.mTimeout).apiKey("AdScopeADN").testAd(AdRequestEnum.TEST_TYPE.TEST_FORMAL_MODEL.getCode()).countryCn(AdRequestEnum.DEVICE_COUNTRY_TYPE.COUNTRY_CHINA_TYPE.getCode()).build());
        this.mSplashAd = splashAd;
        splashAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null) {
                splashAd.destroy();
            }
            this.mSplashAd = null;
            super.destroy();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mSplashAd != null;
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
            if (splashAd != null && splashAd.getAdBid() != null && aMPSBidResult != null) {
                ASNPAdManagerHolder.sendLossNotification(this.mSplashAd.getAdBid(), aMPSBidResult.getEcpm(), aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAd splashAd = this.mSplashAd;
            if (splashAd != null && splashAd.getAdBid() != null) {
                ASNPAdManagerHolder.sendWinNotification(this.mSplashAd.getAdBid(), this.mSplashAd.getAdBid().getECPM());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null && viewGroup != null) {
            splashAd.show(viewGroup);
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
