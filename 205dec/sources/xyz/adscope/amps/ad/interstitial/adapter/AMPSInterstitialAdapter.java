package xyz.adscope.amps.ad.interstitial.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSInterstitialAdapter extends AMPSBaseAdapter<AMPSInterstitialAdAdapterListener> {
    public int expressViewHeight;
    public int expressViewWidth;
    public boolean isLandScape = false;
    public boolean isVolumeOn = false;
    public boolean isAutoPlay = true;

    private void getRequestParameters(Context context, AMPSAdapterModel aMPSAdapterModel) {
        if (aMPSAdapterModel != null) {
            if (!TextUtils.isEmpty(aMPSAdapterModel.getAppId())) {
                this.mAppId = aMPSAdapterModel.getAppId();
            }
            if (!TextUtils.isEmpty(aMPSAdapterModel.getSpaceId())) {
                this.mSpaceId = aMPSAdapterModel.getSpaceId();
            }
            this.mTimeout = aMPSAdapterModel.getTimeOut();
            if (!TextUtils.isEmpty(aMPSAdapterModel.getOrientation())) {
                this.isLandScape = aMPSAdapterModel.getOrientation().equals(AMPSEnum.OrientationEnum.ORIENTATION_LANDSCAPE.getOrientation());
            }
            this.isVolumeOn = aMPSAdapterModel.getVideoSound() == AMPSEnum.VideoSoundEnum.SUPPORT_VIDEO_SOUND.getHasSound();
            this.isAutoPlay = aMPSAdapterModel.getVideoAutoPlay() != AMPSEnum.AutoPlayEnum.NO_AUTO_PLAY.getAutoPlayValue();
            this.mUserId = aMPSAdapterModel.getUserId();
            this.mExtra = aMPSAdapterModel.getExtra();
            this.expressViewWidth = aMPSAdapterModel.getExpressViewWidth();
            this.expressViewHeight = aMPSAdapterModel.getExpressViewHeight();
            this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
            this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
        }
    }

    public void onSkippedAd() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onSkippedAd();
    }

    public void onVideoPlayEnd() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onVideoPlayEnd();
    }

    public void onVideoPlayStart() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSInterstitialAdAdapterListener)) {
            return;
        }
        ((AMPSInterstitialAdAdapterListener) aMPSBaseAdAdapterListener).onVideoPlayStart();
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
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSInterstitialAdAdapterListener;
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
    public void refreshAMPSAdAdapterListener(AMPSInterstitialAdAdapterListener aMPSInterstitialAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSInterstitialAdAdapterListener;
    }
}
