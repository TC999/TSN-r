package xyz.adscope.ad.tool.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.advertisings.constants.ErrorCode;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener;
import xyz.adscope.ad.init.inter.InitCallback;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.task.inter.ITimerTaskCallback;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TimerOutTask {
    private static final int AD_REQUEST_TIME_OUT_MESSAGE = 100010;
    private static final int CONFIG_TIME_OUT = 10000;
    private static final int CONFIG_TIME_OUT_MESSAGE = 100012;
    private static final int INIT_ASYNC_TIME_OUT = 5000;
    private static final int INIT_SYNC_TIME_OUT = 3000;
    private static final int INIT_TIME_OUT_MESSAGE = 100011;
    private static final String TAG = "TimerOutTask";
    private TimerTask adCacheTimeOutTask;
    private Timer adCacheTimer;
    private AdScopeCycleModel adScopeCycleModel;
    private long adTimeOut;
    private TimerTask adTimerOutTask;
    private long configTimeOut;
    private TimerTask configTimeOutTask;
    private Timer configTimer;
    private IBaseAdListener iBaseLoadAdListener;
    private InitCallback initCallback;
    private long initTimeOut;
    private TimerTask initTimeTask;
    private Timer initTimer;
    private boolean isExecuteConfig;
    private boolean isExecuteInit;
    private TimerTask reportTrackTimeTask;
    private Timer reportTrackTimer;
    private Timer adTimeOutTimer = null;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.tool.task.TimerOutTask.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case TimerOutTask.AD_REQUEST_TIME_OUT_MESSAGE /* 100010 */:
                    LogUtil.i(TimerOutTask.TAG, "ad request time out adScopeCycleModel.isTimeOutCallback() : " + TimerOutTask.this.adScopeCycleModel.isTimeOutCallback());
                    if (!TimerOutTask.this.adScopeCycleModel.isTimeOutCallback() && TimerOutTask.this.iBaseLoadAdListener != null) {
                        if (TimerOutTask.this.iBaseLoadAdListener instanceof AdListener) {
                            ErrorCode.ErrorCodeAdListener errorCodeAdListener = ErrorCode.ErrorCodeAdListener.ERROR_CODE_AD_LISTENER_REQUEST_TIME_OUT_EXCEPTION;
                            ((AdListener) TimerOutTask.this.iBaseLoadAdListener).onAdFailedToLoad(errorCodeAdListener.getCode(), errorCodeAdListener.getMessage());
                        } else if (TimerOutTask.this.iBaseLoadAdListener instanceof INativeAdListener) {
                            ErrorCode.ErrorCodeAdListener errorCodeAdListener2 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_AD_LISTENER_REQUEST_NATIVE_TIME_OUT_EXCEPTION;
                            ((INativeAdListener) TimerOutTask.this.iBaseLoadAdListener).onAdFailedToLoad(errorCodeAdListener2.getCode(), errorCodeAdListener2.getMessage());
                        }
                    }
                    TimerOutTask.this.cancelTimerTask();
                    return;
                case TimerOutTask.INIT_TIME_OUT_MESSAGE /* 100011 */:
                    LogUtil.i(TimerOutTask.TAG, "init request time out isExecuteInit : " + TimerOutTask.this.isExecuteInit);
                    if (!TimerOutTask.this.isExecuteInit && TimerOutTask.this.initCallback != null) {
                        InitCallback initCallback = TimerOutTask.this.initCallback;
                        ErrorCode.ErrorCodeAdListener errorCodeAdListener3 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_INIT_TIME_OUT_EXCEPTION;
                        initCallback.fail(errorCodeAdListener3.getCode(), errorCodeAdListener3.getMessage());
                    }
                    TimerOutTask.this.cancelTimerTask();
                    return;
                case TimerOutTask.CONFIG_TIME_OUT_MESSAGE /* 100012 */:
                    LogUtil.i(TimerOutTask.TAG, "config request time out isExecuteConfig : " + TimerOutTask.this.isExecuteConfig);
                    if (!TimerOutTask.this.isExecuteConfig && TimerOutTask.this.initCallback != null) {
                        InitCallback initCallback2 = TimerOutTask.this.initCallback;
                        ErrorCode.ErrorCodeAdListener errorCodeAdListener4 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_CONFIG_TIME_OUT_EXCEPTION;
                        initCallback2.fail(errorCodeAdListener4.getCode(), errorCodeAdListener4.getMessage());
                    }
                    TimerOutTask.this.cancelTimerTask();
                    return;
                default:
                    return;
            }
        }
    };

    public void buildAdCacheTimerTask(long j4, final ITimerTaskCallback iTimerTaskCallback) {
        if (this.adCacheTimer == null) {
            this.adCacheTimer = new Timer();
        }
        if (this.adCacheTimeOutTask == null) {
            this.adCacheTimeOutTask = new TimerTask() { // from class: xyz.adscope.ad.tool.task.TimerOutTask.5
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ITimerTaskCallback iTimerTaskCallback2 = iTimerTaskCallback;
                    if (iTimerTaskCallback2 != null) {
                        iTimerTaskCallback2.scheduleTimeEndCall();
                    }
                }
            };
        }
        this.adCacheTimer.schedule(this.adCacheTimeOutTask, j4);
    }

    public void buildAdRequestTimeOutTask() {
        if (this.adTimeOutTimer == null) {
            this.adTimeOutTimer = new Timer();
        }
        if (this.adTimerOutTask == null) {
            this.adTimerOutTask = new TimerTask() { // from class: xyz.adscope.ad.tool.task.TimerOutTask.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    TimerOutTask.this.mHandler.sendEmptyMessage(TimerOutTask.AD_REQUEST_TIME_OUT_MESSAGE);
                }
            };
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            this.adTimeOut = adScopeCycleModel.getTimeoutInterval();
        }
        this.adTimeOutTimer.schedule(this.adTimerOutTask, this.adTimeOut);
    }

    public void buildConfigTimerTask() {
        if (this.configTimer == null) {
            this.configTimer = new Timer();
        }
        if (this.configTimeOutTask == null) {
            this.configTimeOutTask = new TimerTask() { // from class: xyz.adscope.ad.tool.task.TimerOutTask.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    TimerOutTask.this.mHandler.sendEmptyMessage(TimerOutTask.CONFIG_TIME_OUT_MESSAGE);
                }
            };
        }
        this.configTimeOut = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        this.configTimer.schedule(this.configTimeOutTask, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void buildInitTimerTask(boolean z3) {
        if (this.initTimer == null) {
            this.initTimer = new Timer();
        }
        if (this.initTimeTask == null) {
            this.initTimeTask = new TimerTask() { // from class: xyz.adscope.ad.tool.task.TimerOutTask.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    TimerOutTask.this.mHandler.sendEmptyMessage(TimerOutTask.INIT_TIME_OUT_MESSAGE);
                }
            };
        }
        if (z3) {
            this.initTimeOut = 3000L;
        } else {
            this.initTimeOut = 5000L;
        }
        this.initTimer.schedule(this.initTimeTask, this.initTimeOut);
    }

    public void buildReportTrackTimerTask(long j4, final ITimerTaskCallback iTimerTaskCallback) {
        try {
            this.reportTrackTimer = new Timer();
            TimerTask timerTask = new TimerTask() { // from class: xyz.adscope.ad.tool.task.TimerOutTask.6
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    ITimerTaskCallback iTimerTaskCallback2 = iTimerTaskCallback;
                    if (iTimerTaskCallback2 != null) {
                        iTimerTaskCallback2.scheduleTimeEndCall();
                    }
                }
            };
            this.reportTrackTimeTask = timerTask;
            Timer timer = this.reportTrackTimer;
            if (timer != null) {
                timer.schedule(timerTask, j4);
            }
        } catch (Exception e4) {
            LogUtil.i(TAG, "e : " + e4);
        }
    }

    public void cancelAdCacheTimerTask() {
        Timer timer = this.adCacheTimer;
        if (timer != null) {
            timer.cancel();
            this.adCacheTimer = null;
        }
        TimerTask timerTask = this.adCacheTimeOutTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.adCacheTimeOutTask = null;
        }
    }

    public void cancelReportTrackTimer() {
        try {
            Timer timer = this.reportTrackTimer;
            if (timer != null) {
                timer.cancel();
                this.reportTrackTimer.purge();
                this.reportTrackTimer = null;
            }
            TimerTask timerTask = this.reportTrackTimeTask;
            if (timerTask != null) {
                timerTask.cancel();
                this.reportTrackTimeTask = null;
            }
        } catch (Exception unused) {
            LogUtil.e(TAG, "e : ");
        }
    }

    public void cancelTimerTask() {
        TimerTask timerTask = this.adTimerOutTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.adTimerOutTask = null;
        }
        Timer timer = this.adTimeOutTimer;
        if (timer != null) {
            timer.cancel();
            this.adTimeOutTimer = null;
        }
        TimerTask timerTask2 = this.initTimeTask;
        if (timerTask2 != null) {
            timerTask2.cancel();
            this.initTimeTask = null;
        }
        Timer timer2 = this.initTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.initTimer = null;
        }
        TimerTask timerTask3 = this.configTimeOutTask;
        if (timerTask3 != null) {
            timerTask3.cancel();
            this.configTimeOutTask = null;
        }
        Timer timer3 = this.configTimer;
        if (timer3 != null) {
            timer3.cancel();
            this.configTimer = null;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        Timer timer4 = this.reportTrackTimer;
        if (timer4 != null) {
            timer4.cancel();
            this.reportTrackTimer = null;
        }
        TimerTask timerTask4 = this.reportTrackTimeTask;
        if (timerTask4 != null) {
            timerTask4.cancel();
            this.reportTrackTimeTask = null;
        }
        this.initCallback = null;
    }

    public void setAdListener(IBaseAdListener iBaseAdListener) {
        this.iBaseLoadAdListener = iBaseAdListener;
    }

    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
    }

    public void setInitCallback(InitCallback initCallback) {
        this.initCallback = initCallback;
    }

    public void setIsExecuteConfig(boolean z3) {
        this.isExecuteConfig = z3;
    }

    public void setIsExecuteInit(boolean z3) {
        this.isExecuteInit = z3;
    }
}
