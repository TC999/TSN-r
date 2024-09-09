package xyz.adscope.amps.ad.splash.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSSplashAdapter extends AMPSBaseAdapter<AMPSSplashAdAdapterListener> {
    public int viewHeightDp;
    public int viewHeightPx;
    public int viewWidthDp;
    public int viewWidthPx;

    private void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        if (aMPSAdapterModel != null) {
            try {
                if (!TextUtils.isEmpty(aMPSAdapterModel.getAppId())) {
                    this.mAppId = aMPSAdapterModel.getAppId();
                }
                if (!TextUtils.isEmpty(aMPSAdapterModel.getSpaceId())) {
                    this.mSpaceId = aMPSAdapterModel.getSpaceId();
                }
                this.mTimeout = aMPSAdapterModel.getTimeOut();
                this.viewWidthPx = aMPSAdapterModel.getExpressViewWidth();
                this.viewHeightPx = aMPSAdapterModel.getExpressViewHeight();
                if (context != null) {
                    this.viewWidthDp = DeviceInfoUtil.px2dip(context, this.viewWidthPx);
                    this.viewHeightDp = DeviceInfoUtil.px2dip(context, this.viewHeightPx);
                }
                this.mUserId = aMPSAdapterModel.getUserId();
                this.mExtra = aMPSAdapterModel.getExtra();
                this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
                this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void onSkippedAd() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSSplashAdAdapterListener)) {
            return;
        }
        ((AMPSSplashAdAdapterListener) aMPSBaseAdAdapterListener).onSkippedAd();
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void showAd(Activity activity) {
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
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSSplashAdAdapterListener;
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
    public void refreshAMPSAdAdapterListener(AMPSSplashAdAdapterListener aMPSSplashAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSSplashAdAdapterListener;
    }
}
