package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.view.ViewGroup;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.SplashAd;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdAdapterListener;
import xyz.adscope.amps.ad.splash.adapter.AMPSSplashAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BZSplashAdapter extends AMPSSplashAdapter {
    private SplashAd mSplashAd;

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadSplashAd();
    }

    private void loadSplashAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadSplashAd spaceId:" + this.mSpaceId);
        SplashAd splashAd = new SplashAd(this.mContext, null, this.mSpaceId, new AdListener() { // from class: xyz.adscope.amps.adapter.bz.BZSplashAdapter.1
            @Override // com.beizi.fusion.AdListener
            public void onAdClicked() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadSplashAd onAdClicked ");
                BZSplashAdapter.this.onAdClicked();
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadSplashAd onAdClosed ");
                BZSplashAdapter.this.onAdDismiss();
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdFailedToLoad(int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadSplashAd onAdFailedToLoad code:" + i4);
                BZSplashAdapter.this.onAdFailed(String.valueOf(i4), "");
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadSplashAd onAdLoaded ");
                int i4 = 0;
                try {
                    int ecpm = BZSplashAdapter.this.mSplashAd != null ? BZSplashAdapter.this.mSplashAd.getECPM() : 0;
                    if (ecpm >= 0) {
                        i4 = ecpm;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BZSplashAdapter bZSplashAdapter = BZSplashAdapter.this;
                if (bZSplashAdapter.isBidding) {
                    bZSplashAdapter.onC2SBiddingSuccess(i4);
                } else {
                    bZSplashAdapter.onAdLoad();
                }
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadSplashAd onAdShown ");
                BZSplashAdapter.this.onAdShow();
            }

            @Override // com.beizi.fusion.AdListener
            public void onAdTick(long j4) {
            }
        }, (long) this.mTimeout);
        this.mSplashAd = splashAd;
        splashAd.loadAd(this.viewWidthDp, this.viewHeightDp);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null) {
            splashAd.cancel(this.mContext);
        }
        this.mSplashAd = null;
        super.destroy();
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
