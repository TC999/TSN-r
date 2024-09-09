package xyz.adscope.amps.ad.nativead.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.List;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;
import xyz.adscope.amps.tool.AMPSLogUtil;
import xyz.adscope.amps.tool.util.AMPSScreenUtil;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSNativeAdapter extends AMPSBaseAdapter<AMPSNativeAdAdapterListener> {
    public int adCount = 1;
    public int expressViewHeight;
    public int expressViewHeightDp;
    public int expressViewWidth;
    public int expressViewWidthDp;
    public List<Integer> templateTypes;

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
                this.expressViewWidth = aMPSAdapterModel.getExpressViewWidth();
                this.expressViewHeight = aMPSAdapterModel.getExpressViewHeight();
                if (this.expressViewWidth <= 0) {
                    this.expressViewWidth = AMPSScreenUtil.getScreenWidth(this.mContext);
                }
                this.expressViewWidthDp = DeviceInfoUtil.px2dip(context, this.expressViewWidth);
                this.expressViewHeightDp = DeviceInfoUtil.px2dip(context, this.expressViewHeightDp);
                this.adCount = aMPSAdapterModel.getAdCount();
                this.templateTypes = aMPSAdapterModel.getTemplateTypes();
                this.mUserId = aMPSAdapterModel.getUserId();
                this.mExtra = aMPSAdapterModel.getExtra();
                this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
                this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
            } catch (Exception e4) {
                AMPSLogUtil.e(AMPSConstants.AMPS_LOG_TAG, "e : " + e4);
            }
        }
    }

    public abstract List<AMPSNativeAdExpressInfo> getNativeListInfo();

    public void onRender() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRender();
    }

    public void onRenderFail(AMPSError aMPSError) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRenderFail(aMPSError);
    }

    public void onRenderSuccess() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSNativeAdAdapterListener)) {
            return;
        }
        ((AMPSNativeAdAdapterListener) aMPSBaseAdAdapterListener).onRenderSuccess();
    }

    public void pause() {
    }

    public void resume() {
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
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSNativeAdAdapterListener;
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
    public void refreshAMPSAdAdapterListener(AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSNativeAdAdapterListener;
    }
}
