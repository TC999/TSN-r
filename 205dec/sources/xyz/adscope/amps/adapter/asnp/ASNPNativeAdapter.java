package xyz.adscope.amps.adapter.asnp;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.ad.advertisings.nativead.NativeAd;
import xyz.adscope.ad.advertisings.nativead.config.NativeAdConfig;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestEnum;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.asnp.data.ASNPNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASNPNativeAdapter extends AMPSNativeAdapter {
    private List<INativeAdView> iNativeAdViews;
    private NativeAd mANSPNativeAd;

    private void initSDK() {
        ASNPInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    private void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK start loadNativeAd spaceId:" + this.mSpaceId);
        NativeAd nativeAd = new NativeAd(this.mContext, new INativeAdListener() { // from class: xyz.adscope.amps.adapter.asnp.ASNPNativeAdapter.1
            @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener
            public void onAdFailedToLoad(int i4, String str) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onNativeLoadFail code:" + i4 + " message:" + str);
                ASNPNativeAdapter aSNPNativeAdapter = ASNPNativeAdapter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(i4);
                sb.append("");
                aSNPNativeAdapter.onAdFailed(sb.toString(), str);
            }

            @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener
            public void onAdLoad(List<INativeAdView> list) {
                AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "ASNPSDK loadNativeAd onAdLoad");
                if (list == null || list.size() < 1) {
                    ASNPNativeAdapter aSNPNativeAdapter = ASNPNativeAdapter.this;
                    AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                    aSNPNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                    return;
                }
                ASNPNativeAdapter.this.iNativeAdViews = list;
                int i4 = 0;
                try {
                    INativeAdView iNativeAdView = list.get(0);
                    if (iNativeAdView != null && iNativeAdView.getIAdBidding() != null) {
                        i4 = iNativeAdView.getIAdBidding().getECPM();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                ASNPNativeAdapter aSNPNativeAdapter2 = ASNPNativeAdapter.this;
                if (aSNPNativeAdapter2.isBidding) {
                    aSNPNativeAdapter2.onC2SBiddingSuccess(i4);
                } else {
                    aSNPNativeAdapter2.onAdLoad();
                }
            }
        }, new NativeAdConfig.Builder().adCount(this.adCount).spaceId(this.mSpaceId).intervalTime((long) this.mTimeout).testAd(AdRequestEnum.TEST_TYPE.TEST_FORMAL_MODEL.getCode()).countryCn(AdRequestEnum.DEVICE_COUNTRY_TYPE.COUNTRY_CHINA_TYPE.getCode()).expressViewAcceptedSize((float) this.expressViewWidth, (float) this.expressViewHeight).build());
        this.mANSPNativeAd = nativeAd;
        nativeAd.loadAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        super.destroy();
        try {
            if (this.mANSPNativeAd != null) {
                this.mANSPNativeAd = null;
            }
            List<INativeAdView> list = this.iNativeAdViews;
            if (list != null) {
                list.clear();
                this.iNativeAdViews = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<INativeAdView> list = this.iNativeAdViews;
        if (list != null && list.size() > 0) {
            for (INativeAdView iNativeAdView : this.iNativeAdViews) {
                arrayList.add(new ASNPNativeAd(iNativeAdView, this));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mANSPNativeAd != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || this.mANSPNativeAd == null) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        INativeAdView iNativeAdView;
        try {
            List<INativeAdView> list = this.iNativeAdViews;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iNativeAdView = this.iNativeAdViews.get(0)) != null && iNativeAdView.getIAdBidding() != null) {
                ASNPAdManagerHolder.sendLossNotification(iNativeAdView.getIAdBidding(), aMPSBidResult.getEcpm(), aMPSBidResult.getReason());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        INativeAdView iNativeAdView;
        try {
            List<INativeAdView> list = this.iNativeAdViews;
            if (list != null && list.size() != 0 && aMPSBidResult != null && (iNativeAdView = this.iNativeAdViews.get(0)) != null && iNativeAdView.getIAdBidding() != null) {
                ASNPAdManagerHolder.sendWinNotification(iNativeAdView.getIAdBidding(), iNativeAdView.getIAdBidding().getECPM());
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }
}
