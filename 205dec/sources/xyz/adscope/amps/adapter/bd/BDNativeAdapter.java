package xyz.adscope.amps.adapter.bd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.adapter.bd.data.BDNativeAd;
import xyz.adscope.amps.base.AMPSBidResult;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BDNativeAdapter extends AMPSNativeAdapter {
    private BaiduNativeManager mBaiduNativeManager;
    private BaiduNativeManager.ExpressAdListener mExpressAdListener = new BaiduNativeManager.ExpressAdListener() { // from class: xyz.adscope.amps.adapter.bd.BDNativeAdapter.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onLpClosed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeFail(int i4, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNativeFail code:" + i4 + ", message:" + str);
            BDNativeAdapter bDNativeAdapter = BDNativeAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append("");
            bDNativeAdapter.onAdFailed(sb.toString(), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNativeLoad(List<ExpressResponse> list) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNativeExpressAdLoad");
            if (list == null || list.size() == 0) {
                BDNativeAdapter bDNativeAdapter = BDNativeAdapter.this;
                AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_AD_IS_NULL;
                bDNativeAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
                return;
            }
            BDNativeAdapter.this.mExpressResponseList = list;
            int i4 = 0;
            try {
                ExpressResponse expressResponse = list.get(0);
                if (expressResponse != null) {
                    i4 = Integer.parseInt(expressResponse.getECPMLevel());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            BDNativeAdapter bDNativeAdapter2 = BDNativeAdapter.this;
            if (bDNativeAdapter2.isBidding) {
                bDNativeAdapter2.onC2SBiddingSuccess(i4);
            } else {
                bDNativeAdapter2.onAdLoad();
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onNoAd(int i4, String str) {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onNoAd code:" + i4 + ", message:" + str);
            BDNativeAdapter bDNativeAdapter = BDNativeAdapter.this;
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append("");
            bDNativeAdapter.onAdFailed(sb.toString(), str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadFailed");
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
            AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK onVideoDownloadSuccess");
        }
    };
    private List<ExpressResponse> mExpressResponseList;

    private void initSDK() {
        BDInitMediation.getInstance().initSDK(this.mInitAdapterConfig, null);
        loadNativeAd();
    }

    private void loadNativeAd() {
        AMPSLogUtil.d(AMPSConstants.AMPS_LOG_TAG, "BDSDK start loadNativeAd spaceId:" + this.mSpaceId);
        if (this.expressViewHeightDp <= 0) {
            this.expressViewHeightDp = 0;
        }
        this.mBaiduNativeManager = new BaiduNativeManager(this.mContext, this.mSpaceId);
        this.mBaiduNativeManager.loadExpressAd(new RequestParameters.Builder().setHeight(this.expressViewHeightDp).setWidth(this.expressViewWidthDp).build(), this.mExpressAdListener);
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void destroy() {
        try {
            super.destroy();
            if (this.mBaiduNativeManager != null) {
                this.mBaiduNativeManager = null;
            }
            List<ExpressResponse> list = this.mExpressResponseList;
            if (list != null) {
                list.clear();
                this.mExpressResponseList = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter
    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        List<ExpressResponse> list = this.mExpressResponseList;
        if (list != null && list.size() > 0) {
            for (ExpressResponse expressResponse : this.mExpressResponseList) {
                arrayList.add(new BDNativeAd(expressResponse, this));
            }
        }
        return arrayList;
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public boolean isValid() {
        return this.mBaiduNativeManager != null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter, xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        List<ExpressResponse> list;
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (!this.isBidding || (list = this.mExpressResponseList) == null || list.size() <= 0) {
            initSDK();
        } else {
            onAdLoad();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<ExpressResponse> list = this.mExpressResponseList;
            if (list != null && aMPSBidResult != null) {
                ExpressResponse expressResponse = list.size() > 0 ? this.mExpressResponseList.get(0) : null;
                if (expressResponse == null) {
                    return;
                }
                if (this.isSendBidData == AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    expressResponse.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())));
                } else {
                    expressResponse.biddingFail(String.valueOf(BDInitMediation.getInstance().getLossReason(aMPSBidResult.getReason())), BDInitMediation.getInstance().getWinInfo(aMPSBidResult));
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
        try {
            List<ExpressResponse> list = this.mExpressResponseList;
            if (list != null && aMPSBidResult != null) {
                ExpressResponse expressResponse = list.size() > 0 ? this.mExpressResponseList.get(0) : null;
                if (expressResponse == null) {
                    return;
                }
                if (this.isSendBidData != AMPSConstants.AMPS_SEND_BID_DATA_TYPE_0) {
                    expressResponse.biddingSuccess(String.valueOf(aMPSBidResult.getEcpm()), BDInitMediation.getInstance().getSecondInfo(aMPSBidResult));
                } else if (TextUtils.isEmpty(expressResponse.getECPMLevel())) {
                } else {
                    expressResponse.biddingSuccess(expressResponse.getECPMLevel());
                }
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
