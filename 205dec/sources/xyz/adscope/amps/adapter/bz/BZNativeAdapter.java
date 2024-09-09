package xyz.adscope.amps.adapter.bz;

import android.content.Context;
import android.view.View;
import com.beizi.fusion.NativeAd;
import com.beizi.fusion.NativeAdListener;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.bz.data.BZNativeAd;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BZNativeAdapter extends AMPSNativeAdapter {
    private NativeAd mNativeAd;
    private View nativeView;
    private AMPSNativeAdExpressListener ampsNativeAdExpressListener = null;
    private int modelType = 1;

    private void initSDK() {
        BZInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    private void loadNativeAd() {
        int i4;
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK start loadNativeAd spaceId:" + this.mSpaceId);
        List<Integer> list = this.templateTypes;
        if (list != null && list.size() > 0) {
            if (this.templateTypes.contains(1)) {
                i4 = 4;
            } else {
                i4 = this.templateTypes.contains(2) ? 5 : 5;
            }
            this.modelType = i4;
        }
        NativeAd nativeAd = new NativeAd(this.mContext, this.mSpaceId, new NativeAdListener() { // from class: xyz.adscope.amps.adapter.bz.BZNativeAdapter.1
            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClick() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClick");
                BZNativeAdapter.this.onAdClicked();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClicked();
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClosed");
                BZNativeAdapter.this.onAdDismiss();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClosed(BZNativeAdapter.this.nativeView);
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdClosed(View view) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdClosed");
                BZNativeAdapter.this.onAdDismiss();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdClosed(view);
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdFailed(int i5) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdFailed  code:" + i5);
                BZNativeAdapter bZNativeAdapter = BZNativeAdapter.this;
                bZNativeAdapter.onAdFailed(i5 + "", AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_BZ_LOAD_FAIL.getErrorMsg());
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdLoaded(View view) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdLoaded");
                BZNativeAdapter.this.nativeView = view;
                int i5 = 0;
                try {
                    int ecpm = BZNativeAdapter.this.mNativeAd != null ? BZNativeAdapter.this.mNativeAd.getECPM() : 0;
                    if (ecpm >= 0) {
                        i5 = ecpm;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                BZNativeAdapter bZNativeAdapter = BZNativeAdapter.this;
                if (bZNativeAdapter.isBidding) {
                    bZNativeAdapter.onC2SBiddingSuccess(i5);
                } else {
                    bZNativeAdapter.onAdLoad();
                }
            }

            @Override // com.beizi.fusion.NativeAdListener
            public void onAdShown() {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BZSDK loadNativeAd onAdShown");
                BZNativeAdapter.this.onAdShow();
                if (BZNativeAdapter.this.ampsNativeAdExpressListener != null) {
                    BZNativeAdapter.this.ampsNativeAdExpressListener.onAdShow();
                }
            }
        }, this.mTimeout, this.modelType);
        this.mNativeAd = nativeAd;
        nativeAd.loadAd(this.expressViewWidthDp, this.expressViewHeightDp);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
        this.ampsNativeAdExpressListener = null;
    }

    public View getAdView() {
        return this.nativeView;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BZNativeAd(this));
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mNativeAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || this.mNativeAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    public void renderView() {
        if (this.nativeView == null) {
            return;
        }
        onRenderSuccess();
        AMPSNativeAdExpressListener aMPSNativeAdExpressListener = this.ampsNativeAdExpressListener;
        if (aMPSNativeAdExpressListener != null) {
            aMPSNativeAdExpressListener.onRenderSuccess(this.nativeView, this.expressViewWidth, this.expressViewHeight);
        }
    }

    public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
        this.ampsNativeAdExpressListener = aMPSNativeAdExpressListener;
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
