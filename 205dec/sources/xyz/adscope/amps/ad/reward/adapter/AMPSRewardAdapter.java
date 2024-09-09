package xyz.adscope.amps.ad.reward.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import java.util.Map;
import xyz.adscope.amps.base.AMPSBaseAdapter;
import xyz.adscope.amps.common.AMPSEnum;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSRewardAdapter extends AMPSBaseAdapter<AMPSRewardVideoAdAdapterListener> {
    public boolean isLandScape = false;
    public boolean isVolumeOn = true;
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
            this.mInitAdapterConfig = aMPSAdapterModel.getAmpsInitAdapterConfig();
            this.isSendBidData = aMPSAdapterModel.getIsSendBidData();
        }
    }

    public void onRewardArrived(boolean z3, int i4, Map<String, Object> map) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onRewardArrived(z3, i4, map);
    }

    public void onRewardVideoCached() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onRewardVideoCached(this);
    }

    public void onVideoComplete() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onVideoComplete();
    }

    public void onVideoError() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener == null || !(aMPSBaseAdAdapterListener instanceof AMPSRewardVideoAdAdapterListener)) {
            return;
        }
        ((AMPSRewardVideoAdAdapterListener) aMPSBaseAdAdapterListener).onVideoError();
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
    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener;
        getRequestParameters(context, aMPSAdapterModel);
        this.mContext = context;
        this.mAMPSBaseAdAdapterListener = aMPSRewardVideoAdAdapterListener;
        if ((context == null || TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSpaceId)) && (aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener) != null) {
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_PARAM_ERROR;
            aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg()));
        }
    }

    @Override // xyz.adscope.amps.base.AMPSBaseAdapter
    public void refreshAMPSAdAdapterListener(AMPSRewardVideoAdAdapterListener aMPSRewardVideoAdAdapterListener) {
        this.mAMPSBaseAdAdapterListener = aMPSRewardVideoAdAdapterListener;
    }
}
