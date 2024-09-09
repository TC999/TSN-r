package xyz.adscope.amps.ad.banner.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSBannerAdapter extends AMPSBaseAdapter<AMPSBannerAdAdapterListener> {
    public int expressViewHeight;
    public int expressViewHeightDp;
    public int expressViewWidth;
    public int expressViewWidthDp;
    public int adCount = 1;
    private boolean isFirst = true;

    private void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        if (aMPSAdapterModel != null) {
            if (!TextUtils.isEmpty(aMPSAdapterModel.getAppId())) {
                this.mAppId = aMPSAdapterModel.getAppId();
            }
            if (!TextUtils.isEmpty(aMPSAdapterModel.getSpaceId())) {
                this.mSpaceId = aMPSAdapterModel.getSpaceId();
            }
            this.mTimeout = aMPSAdapterModel.getTimeOut();
            this.expressViewWidth = aMPSAdapterModel.getExpressViewWidth();
            this.expressViewHeight = aMPSAdapterModel.getExpressViewHeight();
            this.expressViewWidthDp = DeviceInfoUtil.px2dip(context, this.expressViewWidth);
            this.expressViewHeightDp = DeviceInfoUtil.px2dip(context, this.expressViewHeight);
            this.adCount = aMPSAdapterModel.getAdCount();
            this.mUserId = aMPSAdapterModel.getUserId();
            this.mExtra = aMPSAdapterModel.getExtra();
            this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
            this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdFailed(String str, String str2) {
        if (this.isFirst) {
            super.onAdFailed(str, str2);
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(String.valueOf(str), str2));
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdLoad() {
        if (this.isFirst) {
            this.isFirst = false;
            super.onAdLoad();
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdLoaded(this);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onAdShow() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShow(this);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void onC2SBiddingSuccess(int i4) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener;
        if (this.isFirst) {
            this.isFirst = false;
            super.onC2SBiddingSuccess(i4);
        } else if (this.isBidding && (aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener) != null) {
            aMPSBaseAdAdapterListener.onAdLoaded(this);
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(ViewGroup viewGroup) {
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSAdBiddingListener = aMPSAdBiddingListener;
        this.isBidding = true;
        if (context == null || TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSpaceId)) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
            onC2SBiddingFail(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSBannerAdAdapterListener;
        if (context != null && !TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mSpaceId)) {
            buildRequestedTimerTask();
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSBannerAdAdapterListener aMPSBannerAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSBannerAdAdapterListener;
    }
}
