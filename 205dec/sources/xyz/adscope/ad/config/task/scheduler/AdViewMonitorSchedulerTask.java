package xyz.adscope.ad.config.task.scheduler;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.config.inter.ISchedulerTask;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdViewMonitorSchedulerTask implements ISchedulerTask {
    private static final long INITIAL_DELAY_TIME = 0;
    private long monitorCheckTime = 100;
    private ScheduledExecutorService monitorTask = AdScopeThreadPool.getScheduledExecutorService();
    private Runnable monitorTaskRunnable;
    private ScheduledFuture<?> scheduledFuture;

    public AdViewMonitorSchedulerTask(Runnable runnable) {
        this.monitorTaskRunnable = runnable;
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void startSchedulerTask() {
        this.monitorTask.scheduleAtFixedRate(this.monitorTaskRunnable, 0L, this.monitorCheckTime, TimeUnit.MILLISECONDS);
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.monitorTask;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
