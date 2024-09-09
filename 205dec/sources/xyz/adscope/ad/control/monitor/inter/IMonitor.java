package xyz.adscope.ad.control.monitor.inter;

import android.view.View;
import xyz.adscope.ad.control.track.inter.TrackEventEnum;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface IMonitor {
    void addShowOnScreenTracker(View view, IMonitor iMonitor);

    void checkClickMonitoring();

    void checkExposureMonitoring();

    void checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent);

    void destroy();

    void initWithRouter(AdScopeCycleModel adScopeCycleModel);

    void setIMonitorEvent(IMonitorEvent iMonitorEvent);

    void stopScheduleMonitorTask();
}
