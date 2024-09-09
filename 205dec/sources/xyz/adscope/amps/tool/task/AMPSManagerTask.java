package xyz.adscope.amps.tool.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.Timer;
import java.util.TimerTask;
import xyz.adscope.amps.tool.task.inter.IBiddingTimeoutTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IDispatchFloorAdSourceTimerCallBack;
import xyz.adscope.amps.tool.task.inter.IRequestTimeoutTimerCallBack;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSManagerTask {
    private static final int BIDDING_TIME_OUT_MESSAGE = 200001;
    private static final int DISPATCH_FLOOR_AD_SOURCE_MESSAGE = 200003;
    private static final int REQUEST_TIME_OUT_MESSAGE = 200002;
    private long mBiddingTimeoutTime;
    private Timer mBiddingTimeoutTimer;
    private TimerTask mBiddingTimeoutTimerTask;
    private long mDispatchFloorAdSourceTime;
    private Timer mDispatchFloorAdSourceTimer;
    private TimerTask mDispatchFloorAdSourceTimerTask;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.amps.tool.task.AMPSManagerTask.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case AMPSManagerTask.BIDDING_TIME_OUT_MESSAGE /* 200001 */:
                    if (AMPSManagerTask.this.mIBiddingTimeoutTimerCallBack != null) {
                        AMPSManagerTask.this.mIBiddingTimeoutTimerCallBack.callBackBiddingTimeout();
                    }
                    AMPSManagerTask.this.cancelBiddingTimerTask();
                    return;
                case AMPSManagerTask.REQUEST_TIME_OUT_MESSAGE /* 200002 */:
                    if (AMPSManagerTask.this.mIRequestTimeoutTimerCallBack != null) {
                        AMPSManagerTask.this.mIRequestTimeoutTimerCallBack.callBackRequestedTimeout();
                    }
                    AMPSManagerTask.this.cancelRequestedTimerTask();
                    return;
                case AMPSManagerTask.DISPATCH_FLOOR_AD_SOURCE_MESSAGE /* 200003 */:
                    if (AMPSManagerTask.this.mIDispatchFloorAdSourceTimerCallBack != null) {
                        AMPSManagerTask.this.mIDispatchFloorAdSourceTimerCallBack.callBackDispatchFloorAdSource();
                    }
                    AMPSManagerTask.this.cancelDispatchFloorAdSourceTimerTask();
                    return;
                default:
                    return;
            }
        }
    };
    private IBiddingTimeoutTimerCallBack mIBiddingTimeoutTimerCallBack;
    private IDispatchFloorAdSourceTimerCallBack mIDispatchFloorAdSourceTimerCallBack;
    private IRequestTimeoutTimerCallBack mIRequestTimeoutTimerCallBack;
    private long mRequestTimeoutTime;
    private Timer mRequestTimeoutTimer;
    private TimerTask mRequestTimeoutTimerTask;

    private void buildBiddingTimerTask() {
        TimerTask timerTask;
        if (this.mBiddingTimeoutTimer == null) {
            this.mBiddingTimeoutTimer = new Timer();
        }
        if (this.mBiddingTimeoutTimerTask == null) {
            this.mBiddingTimeoutTimerTask = new TimerTask() { // from class: xyz.adscope.amps.tool.task.AMPSManagerTask.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AMPSManagerTask.this.mHandler != null) {
                        AMPSManagerTask.this.mHandler.sendEmptyMessage(AMPSManagerTask.BIDDING_TIME_OUT_MESSAGE);
                    }
                }
            };
        }
        Timer timer = this.mBiddingTimeoutTimer;
        if (timer == null || (timerTask = this.mBiddingTimeoutTimerTask) == null) {
            return;
        }
        timer.schedule(timerTask, this.mBiddingTimeoutTime);
    }

    private void buildDispatchFloorAdSourceTimerTask() {
        TimerTask timerTask;
        if (this.mDispatchFloorAdSourceTimer == null) {
            this.mDispatchFloorAdSourceTimer = new Timer();
        }
        if (this.mDispatchFloorAdSourceTimerTask == null) {
            this.mDispatchFloorAdSourceTimerTask = new TimerTask() { // from class: xyz.adscope.amps.tool.task.AMPSManagerTask.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AMPSManagerTask.this.mHandler != null) {
                        AMPSManagerTask.this.mHandler.sendEmptyMessage(AMPSManagerTask.DISPATCH_FLOOR_AD_SOURCE_MESSAGE);
                    }
                }
            };
        }
        Timer timer = this.mDispatchFloorAdSourceTimer;
        if (timer == null || (timerTask = this.mDispatchFloorAdSourceTimerTask) == null) {
            return;
        }
        timer.schedule(timerTask, this.mDispatchFloorAdSourceTime);
    }

    private void buildRequestedTimerTask() {
        TimerTask timerTask;
        if (this.mRequestTimeoutTimer == null) {
            this.mRequestTimeoutTimer = new Timer();
        }
        if (this.mRequestTimeoutTimerTask == null) {
            this.mRequestTimeoutTimerTask = new TimerTask() { // from class: xyz.adscope.amps.tool.task.AMPSManagerTask.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AMPSManagerTask.this.mHandler != null) {
                        AMPSManagerTask.this.mHandler.sendEmptyMessage(AMPSManagerTask.REQUEST_TIME_OUT_MESSAGE);
                    }
                }
            };
        }
        Timer timer = this.mRequestTimeoutTimer;
        if (timer == null || (timerTask = this.mRequestTimeoutTimerTask) == null) {
            return;
        }
        timer.schedule(timerTask, this.mRequestTimeoutTime);
    }

    public void cancelBiddingTimerTask() {
        TimerTask timerTask = this.mBiddingTimeoutTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mBiddingTimeoutTimerTask = null;
        }
        Timer timer = this.mBiddingTimeoutTimer;
        if (timer != null) {
            timer.cancel();
            this.mBiddingTimeoutTimer = null;
        }
    }

    public void cancelDispatchFloorAdSourceTimerTask() {
        TimerTask timerTask = this.mDispatchFloorAdSourceTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mDispatchFloorAdSourceTimerTask = null;
        }
        Timer timer = this.mDispatchFloorAdSourceTimer;
        if (timer != null) {
            timer.cancel();
            this.mDispatchFloorAdSourceTimer = null;
        }
    }

    public void cancelRequestedTimerTask() {
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
    }

    public void startBiddingTimerTask(long j4, IBiddingTimeoutTimerCallBack iBiddingTimeoutTimerCallBack) {
        this.mBiddingTimeoutTime = j4;
        this.mIBiddingTimeoutTimerCallBack = iBiddingTimeoutTimerCallBack;
        buildBiddingTimerTask();
    }

    public void startDispatchFloorAdSourceTimerTask(long j4, IDispatchFloorAdSourceTimerCallBack iDispatchFloorAdSourceTimerCallBack) {
        this.mDispatchFloorAdSourceTime = j4;
        this.mIDispatchFloorAdSourceTimerCallBack = iDispatchFloorAdSourceTimerCallBack;
        buildDispatchFloorAdSourceTimerTask();
    }

    public void startRequestedTimerTask(long j4, IRequestTimeoutTimerCallBack iRequestTimeoutTimerCallBack) {
        this.mRequestTimeoutTime = j4;
        this.mIRequestTimeoutTimerCallBack = iRequestTimeoutTimerCallBack;
        buildRequestedTimerTask();
    }
}
