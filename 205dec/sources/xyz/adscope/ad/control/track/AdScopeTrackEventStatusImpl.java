package xyz.adscope.ad.control.track;

import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.control.track.inter.TrackEventEnum;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeTrackEventStatusImpl implements ITrackEventStatus {
    private IMonitor iMonitor;

    public AdScopeTrackEventStatusImpl(IMonitor iMonitor) {
        this.iMonitor = iMonitor;
    }

    private IMonitor getIMonitor() {
        return this.iMonitor;
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void adClose() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_AD_CLOSE);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void downloadComplete() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_DOWNLOAD_COMPLETE);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void downloadContinue() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_DOWNLOAD_CONTINUE);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void installComplete() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_INSTALL_COMPLETE);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void installStart() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_INSTALL_START);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void installedApp() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_INSTALL_APP);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void invokeFail() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_INVOKE_FAIL);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void invokeSuccess() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_INVOKE_SUCCESS);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void notInstall() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_NOT_INSTALL_APP);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void openAppSuccess() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_OPEN_APP_SUCCESS);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void pauseDownload() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_PAUSE_DOWNLOAD);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void startDownload() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_START_DOWNLOAD);
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEventStatus
    public void startInvoke() {
        getIMonitor().checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_START_INVOKE);
    }
}
