package xyz.adscope.ad.config.task.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.config.AdConfigManager;
import xyz.adscope.ad.config.inter.ISchedulerTask;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.config.model.ConfigResponseInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdConfigSchedulerTask implements ISchedulerTask {
    private static final long INITIAL_DELAY_TIME = 10000;
    private static final int UPDATE_THREAD_COUNT = 2;
    private AdConfigManager adConfigManager;
    private AdScopeGlobalModel adScopeGlobalModel;
    private long heartbeatTime = 60000;
    private boolean isStart = false;
    private ScheduledExecutorService mHeartTask = Executors.newScheduledThreadPool(2);

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class ConfigTaskRunnable implements Runnable {
        public ConfigTaskRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AdConfigSchedulerTask.this.adConfigManager == null || !AdConfigSchedulerTask.this.adConfigManager.checkConfig()) {
                return;
            }
            AdConfigSchedulerTask.this.adConfigManager.requestConfigureWithChannel(AdConfigSchedulerTask.this.adScopeGlobalModel, null);
        }
    }

    public AdConfigSchedulerTask(AdConfigManager adConfigManager) {
        this.adConfigManager = adConfigManager;
    }

    public long getHeartbeatTime() {
        return this.heartbeatTime;
    }

    public void setAdScopeGlobalModel(AdScopeGlobalModel adScopeGlobalModel) {
        this.adScopeGlobalModel = adScopeGlobalModel;
    }

    public void setHeartBeatTime(long j4) {
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void startSchedulerTask() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        this.heartbeatTime = Math.max(this.heartbeatTime, ConfigResponseInfo.getInstance().getCheckTime());
        this.mHeartTask.scheduleWithFixedDelay(new ConfigTaskRunnable(), 10000L, this.heartbeatTime, TimeUnit.MILLISECONDS);
    }

    @Override // xyz.adscope.ad.config.inter.ISchedulerTask
    public void stopSchedulerTask() {
        ScheduledExecutorService scheduledExecutorService = this.mHeartTask;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
