package xyz.adscope.ad.config.task.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.config.inter.ISchedulerTask;
import xyz.adscope.ad.control.monitor.AdScopeBaseMonitoring;
import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdMonitorSchedulerTask implements ISchedulerTask {
    private static final long INITIAL_DELAY_TIME = 0;
    private AdScopeBaseMonitoring adScopeBaseMonitoring;
    private long monitorCheckTime = 100;
    private ScheduledExecutorService monitorTask = AdScopeThreadPool.getScheduledExecutorService();

    public AdMonitorSchedulerTask(IMonitor iMonitor) {
        this.adScopeBaseMonitoring = (AdScopeBaseMonitoring) iMonitor;
    }

    public long getMonitorCheckTime() {
        return this.monitorCheckTime;
    }

    public void setMonitorCheckTime(long j4) {
        this.monitorCheckTime = j4;
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void startSchedulerTask() {
        AdScopeBaseMonitoring adScopeBaseMonitoring = this.adScopeBaseMonitoring;
        adScopeBaseMonitoring.getClass();
        this.monitorTask.scheduleAtFixedRate(new AdScopeBaseMonitoring.MonitorTaskRunnable(), 0L, this.monitorCheckTime, TimeUnit.MILLISECONDS);
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.monitorTask;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
