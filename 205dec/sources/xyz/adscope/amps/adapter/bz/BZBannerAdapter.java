package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.BannerAd;
import com.beizi.fusion.BannerAdListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdAdapterListener;
import xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BZBannerAdapter extends AMPSBannerAdapter {
    private ViewGroup mAdContainer;
    private BannerAd mBanner;

    private ViewGroup.LayoutParams getBannerSize() {
        return new ViewGroup.LayoutParams(this.expressViewWidth, this.expressViewHeight);
    }

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadBannerAd();
    }

    private void loadBannerAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadBannerAd spaceId:" + this.mSpaceId);
        BannerAd bannerAd = this.mBanner;
        if (bannerAd != null) {
            bannerAd.destroy();
            this.mBanner = null;
        }
        this.mAdContainer = new FrameLayout(this.mContext);
        this.mBanner = new BannerAd(this.mContext, this.mSpaceId, new BannerAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZBannerAdapter.1
            @Override // com.beizi.fusion.BannerAdListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClick");
                BZBannerAdapter.this.onAdClicked();
            }

            @Override // com.beizi.fusion.BannerAdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdClosed");
                BZBannerAdapter.this.onAdDismiss();
            }

            @Override // com.beizi.fusion.BannerAdListener
            public void onAdFailed(int i4) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadBannerAd onAdFailed code:" + i4);
                BZBannerAdapter.this.onAdFailed(String.valueOf(i4), "");
            }

            @Override // com.beizi.fusion.BannerAdListener
            public void onAdLoaded() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdLoaded");
                BZBannerAdapter.this.onAdLoad();
            }

            @Override // com.beizi.fusion.BannerAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadInterstitialAd onAdShown");
                BZBannerAdapter.this.onAdShow();
            }
        }, this.mTimeout);
        float screenWidthDp = getScreenWidthDp(this.mContext);
        this.mBanner.loadAd(screenWidthDp, Math.round(screenWidthDp / 6.4f), this.mAdContainer);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        BannerAd bannerAd = this.mBanner;
        if (bannerAd != null) {
            bannerAd.destroy();
        }
        this.mBanner = null;
    }

    public float getScreenWidthDp(Context context) {
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = context.getResources().getDisplayMetrics().widthPixels;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        return (f5 / f4) + 0.5f;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mBanner != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSBannerAdAdapterListener);
        initSDK();
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
        if (this.mBanner != null && viewGroup != null) {
            viewGroup.addView(this.mAdContainer, getBannerSize());
            return;
        }
        AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_CONTAINER_NULL;
        onAdShowFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
    }

    @Override // xyz.adscope.amps.ad.banner.adapter.AMPSBannerAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
