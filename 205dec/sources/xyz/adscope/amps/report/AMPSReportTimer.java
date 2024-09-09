package xyz.adscope.amps.report;

import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSReportTimer {
    private AMPSReportTimerListener reportTimerListener;
    private long time;
    private TimerTask timeTask;
    private Timer timer;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface AMPSReportTimerListener {
        void onTrigger();
    }

    public AMPSReportTimer(AMPSReportTimerListener aMPSReportTimerListener, String str) {
        this.time = 5000L;
        this.reportTimerListener = aMPSReportTimerListener;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.time = Long.parseLong(str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void buildReportTimerTask() {
        if (this.timer == null) {
            this.timer = new Timer();
        }
        if (this.timeTask == null) {
            this.timeTask = new TimerTask() { // from class: xyz.adscope.amps.report.AMPSReportTimer.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (AMPSReportTimer.this.reportTimerListener != null) {
                        AMPSReportTimer.this.reportTimerListener.onTrigger();
                    }
                }
            };
        }
        this.timer.schedule(this.timeTask, this.time);
    }

    public void cancelTimerTask() {
        TimerTask timerTask = this.timeTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timeTask = null;
        }
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        this.reportTimerListener = null;
    }
}
