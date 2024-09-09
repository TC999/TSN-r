package xyz.adscope.amps.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.common.AMPSErrorCode;
import xyz.adscope.amps.init.AMPSInitAdapterConfig;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.inner.AMPSBaseAdAdapterListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class AMPSBaseAdapter<T extends AMPSBaseAdAdapterListener> {
    private static final int REQUEST_TIME_OUT_MESSAGE = 10001;
    public int isSendBidData;
    public Context mContext;
    public String mExtra;
    public AMPSInitAdapterConfig mInitAdapterConfig;
    private Timer mRequestTimeoutTimer;
    private TimerTask mRequestTimeoutTimerTask;
    public String mUserId;
    public String mAppId = null;
    public String mSpaceId = null;
    public int mTimeout = 5000;
    public AMPSBaseAdAdapterListener mAMPSBaseAdAdapterListener = null;
    public AMPSAdBiddingListener mAMPSAdBiddingListener = null;
    public boolean isBidding = false;
    public boolean isHasLoadResult = false;
    public boolean isHasBiddingResult = false;
    public boolean isLoadSuccess = false;
    private boolean isShow = false;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.amps.base.AMPSBaseAdapter.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 10001) {
                return;
            }
            AMPSBaseAdapter aMPSBaseAdapter = AMPSBaseAdapter.this;
            if (aMPSBaseAdapter.isHasLoadResult) {
                return;
            }
            AMPSErrorCode.ChannelErrorEnum channelErrorEnum = AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT;
            aMPSBaseAdapter.onAdFailed(channelErrorEnum.getErrorCode(), channelErrorEnum.getErrorMsg());
        }
    };

    public void buildRequestedTimerTask() {
        TimerTask timerTask;
        try {
            if (this.mRequestTimeoutTimer == null) {
                this.mRequestTimeoutTimer = new Timer();
            }
            if (this.mRequestTimeoutTimerTask == null) {
                this.mRequestTimeoutTimerTask = new TimerTask() { // from class: xyz.adscope.amps.base.AMPSBaseAdapter.2
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        if (AMPSBaseAdapter.this.mHandler != null) {
                            AMPSBaseAdapter.this.mHandler.sendEmptyMessage(10001);
                        }
                    }
                };
            }
            Timer timer = this.mRequestTimeoutTimer;
            if (timer != null && (timerTask = this.mRequestTimeoutTimerTask) != null) {
                timer.schedule(timerTask, this.mTimeout);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void cancelRequestedTimerTask() {
        try {
            TimerTask timerTask = this.mRequestTimeoutTimerTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.mRequestTimeoutTimerTask = null;
            }
            Timer timer = this.mRequestTimeoutTimer;
            if (timer != null) {
                timer.cancel();
                this.mRequestTimeoutTimer = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void destroy() {
        this.mContext = null;
        this.mAMPSBaseAdAdapterListener = null;
        this.mAMPSAdBiddingListener = null;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public String getNetworkSpaceId() {
        return this.mSpaceId;
    }

    public abstract boolean isValid();

    public abstract void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, T t3);

    public void onAdClicked() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdClicked(this);
        }
    }

    public void onAdDismiss() {
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdDismiss(this);
        }
    }

    public void onAdFailed(String str, String str2) {
        if (this.isLoadSuccess && !AMPSErrorCode.ChannelErrorEnum.CHANNEL_ERROR_REQUEST_TIMEOUT.getErrorCode().equals(str)) {
            onAdShowFailed(str, str2);
        } else if (this.isHasLoadResult) {
        } else {
            this.isHasLoadResult = true;
            cancelRequestedTimerTask();
            if (this.isBidding && !this.isHasBiddingResult) {
                onC2SBiddingFail(str, str2);
                return;
            }
            AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
            if (aMPSBaseAdAdapterListener != null) {
                aMPSBaseAdAdapterListener.onAdFailed(this, new AMPSError(String.valueOf(str), str2));
            }
        }
    }

    public void onAdLoad() {
        if (this.isHasLoadResult) {
            return;
        }
        this.isLoadSuccess = true;
        this.isHasLoadResult = true;
        cancelRequestedTimerTask();
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdLoaded(this);
        }
    }

    public void onAdShow() {
        if (this.isShow) {
            return;
        }
        this.isShow = true;
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShow(this);
        }
    }

    public void onAdShowFailed(String str, String str2) {
        if (!this.isLoadSuccess) {
            onAdFailed(str, str2);
            return;
        }
        AMPSBaseAdAdapterListener aMPSBaseAdAdapterListener = this.mAMPSBaseAdAdapterListener;
        if (aMPSBaseAdAdapterListener != null) {
            aMPSBaseAdAdapterListener.onAdShowFailed(this, new AMPSError(String.valueOf(str), str2));
        }
    }

    public void onC2SBiddingFail(String str, String str2) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onC2SBiddingFail(this, AMPSBaseBiddingResult.biddingFail(str, str2));
    }

    public void onC2SBiddingSuccess(int i4) {
        AMPSAdBiddingListener aMPSAdBiddingListener;
        this.isHasBiddingResult = true;
        cancelRequestedTimerTask();
        if (!this.isBidding || (aMPSAdBiddingListener = this.mAMPSAdBiddingListener) == null) {
            return;
        }
        aMPSAdBiddingListener.onC2SBiddingSuccess(this, AMPSBaseBiddingResult.biddingSuccess(i4));
    }

    public void refreshAMPSAdAdapterListener(T t3) {
    }

    public void sendLossNotice(AMPSBidResult aMPSBidResult) {
    }

    public void sendWinNotice(AMPSBidResult aMPSBidResult) {
    }

    public abstract void showAd(Activity activity);

    public abstract void showAd(ViewGroup viewGroup);

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
    }
}
