package xyz.adscope.amps.adapter.gdt;

import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
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
public class GDTSplashAdapter extends AMPSSplashAdapter {
    private SplashAD mSplashAd;
    private String supportZoomOut = "";

    private void initSDK() {
        GDTInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadSplashAd();
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashAD splashAD = new SplashAD(this.mContext, this.mSpaceId, new SplashADListener() { // from class: xyz.adscope.amps.adapter.gdt.GDTSplashAdapter.1
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADClicked");
                GDTSplashAdapter.this.onAdClicked();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onAdClosed");
                GDTSplashAdapter.this.onAdDismiss();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADExposure");
                GDTSplashAdapter.this.onAdShow();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onAdLoaded");
                int ecpm = GDTSplashAdapter.this.mSplashAd != null ? GDTSplashAdapter.this.mSplashAd.getECPM() : 0;
                GDTSplashAdapter gDTSplashAdapter = GDTSplashAdapter.this;
                if (gDTSplashAdapter.isBidding) {
                    gDTSplashAdapter.onC2SBiddingSuccess(ecpm);
                } else {
                    gDTSplashAdapter.onAdLoad();
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onADPresent");
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j4) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                String str;
                String str2 = "";
                if (adError != null) {
                    str2 = String.valueOf(adError.getErrorCode());
                    str = adError.getErrorMsg();
                } else {
                    str = "";
                }
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "GDTSDK loadSplashAd onNoAD code:" + str2 + ";msg:" + str);
                GDTSplashAdapter.this.onAdFailed(str2, str);
            }
        }, this.mTimeout);
        this.mSplashAd = splashAD;
        splashAD.fetchAdOnly();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        this.mSplashAd = null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public Map<String, Object> getMediaExtraInfo() {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD != null) {
            return splashAD.getExtraInfo();
        }
        return null;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD == null) {
            return false;
        }
        return splashAD.isValid();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSSplashAdAdapterListener);
        this.supportZoomOut = aMPSAdapterModel.getZoomOut();
        if (!this.isBidding || this.mSplashAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAD splashAD = this.mSplashAd;
            if (splashAD != null && aMPSBidResult != null) {
                GDTAdManagerHolder.sendLossNotification(splashAD, aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            SplashAD splashAD = this.mSplashAd;
            if (splashAD == null) {
                return;
            }
            GDTAdManagerHolder.sendWinNotification(this.mSplashAd, splashAD.getECPM());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        SplashAD splashAD = this.mSplashAd;
        if (splashAD != null && viewGroup != null) {
            splashAD.showAd(viewGroup);
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
