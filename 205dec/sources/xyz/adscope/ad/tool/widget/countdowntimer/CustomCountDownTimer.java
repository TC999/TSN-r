package xyz.adscope.ad.tool.widget.countdowntimer;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CustomCountDownTimer implements ICountDownTimer {
    private long mCountDownInterval;
    private CountDownTimerListener mCountDownTimerListener;
    private Handler mHandler;
    private long mMillisInFuture;
    private long mMillisUntilFinished;
    private Timer mTimer;
    private TimerState mTimerState = TimerState.FINISH;

    public CustomCountDownTimer(long j4, long j5) {
        setMillisInFuture(j4);
        setCountDownInterval(j5);
        this.mHandler = new Handler();
    }

    private void cancelTimer() {
        this.mTimer.cancel();
        this.mTimer.purge();
        this.mTimer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer(final boolean z3) {
        if (this.mTimer != null) {
            cancelTimer();
            this.mMillisUntilFinished = this.mMillisInFuture;
            this.mTimerState = TimerState.FINISH;
            this.mHandler.post(new Runnable() { // from class: xyz.adscope.ad.tool.widget.countdowntimer.CustomCountDownTimer.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CustomCountDownTimer.this.mCountDownTimerListener != null) {
                        if (z3) {
                            CustomCountDownTimer.this.mCountDownTimerListener.onCancel();
                        } else {
                            CustomCountDownTimer.this.mCountDownTimerListener.onFinish();
                        }
                    }
                }
            });
        }
    }

    public TimerTask createTimerTask() {
        return new TimerTask() { // from class: xyz.adscope.ad.tool.widget.countdowntimer.CustomCountDownTimer.2
            private long startTime = -1;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (this.startTime < 0) {
                    this.startTime = scheduledExecutionTime() - (CustomCountDownTimer.this.mMillisInFuture - CustomCountDownTimer.this.mMillisUntilFinished);
                    CustomCountDownTimer.this.mHandler.post(new Runnable() { // from class: xyz.adscope.ad.tool.widget.countdowntimer.CustomCountDownTimer.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (CustomCountDownTimer.this.mCountDownTimerListener != null) {
                                CustomCountDownTimer.this.mCountDownTimerListener.onTick(CustomCountDownTimer.this.mMillisUntilFinished);
                            }
                        }
                    });
                    return;
                }
                CustomCountDownTimer customCountDownTimer = CustomCountDownTimer.this;
                customCountDownTimer.mMillisUntilFinished = customCountDownTimer.mMillisInFuture - (scheduledExecutionTime() - this.startTime);
                CustomCountDownTimer.this.mHandler.post(new Runnable() { // from class: xyz.adscope.ad.tool.widget.countdowntimer.CustomCountDownTimer.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CustomCountDownTimer.this.mCountDownTimerListener == null || CustomCountDownTimer.this.mTimerState == TimerState.FINISH) {
                            return;
                        }
                        CustomCountDownTimer.this.mCountDownTimerListener.onTick(CustomCountDownTimer.this.mMillisUntilFinished);
                    }
                });
                if (CustomCountDownTimer.this.mMillisUntilFinished <= 0) {
                    CustomCountDownTimer.this.stopTimer(false);
                }
            }
        };
    }

    public long getMillisUntilFinished() {
        return this.mMillisUntilFinished;
    }

    public TimerState getTimerState() {
        return this.mTimerState;
    }

    public boolean isFinish() {
        return this.mTimerState == TimerState.FINISH;
    }

    public boolean isStart() {
        return this.mTimerState == TimerState.START;
    }

    @Override // xyz.adscope.ad.tool.widget.countdowntimer.ICountDownTimer
    public void pause() {
        if (this.mTimer != null) {
            TimerState timerState = this.mTimerState;
            TimerState timerState2 = TimerState.PAUSE;
            if (timerState != timerState2) {
                cancelTimer();
                this.mTimerState = timerState2;
            }
        }
    }

    @Override // xyz.adscope.ad.tool.widget.countdowntimer.ICountDownTimer
    public void reset() {
        if (this.mTimer != null) {
            cancelTimer();
        }
        this.mMillisUntilFinished = this.mMillisInFuture;
        this.mTimerState = TimerState.FINISH;
    }

    @Override // xyz.adscope.ad.tool.widget.countdowntimer.ICountDownTimer
    public void resume() {
        if (this.mTimerState == TimerState.PAUSE) {
            start();
        }
    }

    public void setCountDownInterval(long j4) {
        this.mCountDownInterval = j4;
    }

    public void setCountDownTimerListener(CountDownTimerListener countDownTimerListener) {
        this.mCountDownTimerListener = countDownTimerListener;
    }

    public void setMillisInFuture(long j4) {
        this.mMillisInFuture = j4;
        this.mMillisUntilFinished = j4;
    }

    @Override // xyz.adscope.ad.tool.widget.countdowntimer.ICountDownTimer
    public void start() {
        if (this.mTimer == null) {
            TimerState timerState = this.mTimerState;
            TimerState timerState2 = TimerState.START;
            if (timerState != timerState2) {
                Timer timer = new Timer();
                this.mTimer = timer;
                timer.scheduleAtFixedRate(createTimerTask(), 0L, this.mCountDownInterval);
                this.mTimerState = timerState2;
            }
        }
    }

    @Override // xyz.adscope.ad.tool.widget.countdowntimer.ICountDownTimer
    public void stop() {
        stopTimer(true);
    }
}
