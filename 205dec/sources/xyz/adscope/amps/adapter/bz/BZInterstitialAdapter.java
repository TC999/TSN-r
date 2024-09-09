package xyz.adscope.amps.adapter.bz;

import android.app.Activity;
import android.content.Context;
import com.beizi.fusion.InterstitialAd;
import com.beizi.fusion.InterstitialAdListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdAdapterListener;
import xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BZInterstitialAdapter extends AMPSInterstitialAdapter {
    private InterstitialAd mInterstitialAd;
    private InterstitialAdListener mInterstitialAdListener = new InterstitialAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZInterstitialAdapter.1
        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClick() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClick");
            BZInterstitialAdapter.this.onAdClicked();
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClosed");
            BZInterstitialAdapter.this.onAdDismiss();
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdFailed(int i4) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdFailed code:" + i4);
            BZInterstitialAdapter.this.onAdFailed(String.valueOf(i4), String.valueOf(i4));
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdLoaded() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdLoaded");
            int i4 = 0;
            try {
                int ecpm = BZInterstitialAdapter.this.mInterstitialAd != null ? BZInterstitialAdapter.this.mInterstitialAd.getECPM() : 0;
                if (ecpm >= 0) {
                    i4 = ecpm;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BZInterstitialAdapter bZInterstitialAdapter = BZInterstitialAdapter.this;
            if (bZInterstitialAdapter.isBidding) {
                bZInterstitialAdapter.onC2SBiddingSuccess(i4);
            } else {
                bZInterstitialAdapter.onAdLoad();
            }
        }

        @Override // com.beizi.fusion.InterstitialAdListener
        public void onAdShown() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdShown");
            BZInterstitialAdapter.this.onAdShow();
        }
    };

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadInterstitialAd();
    }

    private void loadInterstitialAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadInterstitialAd spaceId:" + this.mSpaceId);
        InterstitialAd interstitialAd = new InterstitialAd(this.mContext, this.mSpaceId, this.mInterstitialAdListener, (long) this.mTimeout);
        this.mInterstitialAd = interstitialAd;
        interstitialAd.setAdVersion(1);
        this.mInterstitialAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            InterstitialAd interstitialAd = this.mInterstitialAd;
            if (interstitialAd != null) {
                interstitialAd.destroy();
            }
            this.mInterstitialAd = null;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mInterstitialAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.interstitial.adapter.AMPSInterstitialAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSInterstitialAdAdapterListener);
        if (!this.isBidding || this.mInterstitialAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null && activity != null) {
            interstitialAd.showAd(activity);
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
