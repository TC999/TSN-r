package xyz.adscope.ad.control.monitor;

import android.view.View;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.config.inter.ISchedulerTask;
import xyz.adscope.ad.config.task.scheduler.AdMonitorSchedulerTask;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.control.monitor.inter.IMonitorEvent;
import xyz.adscope.ad.control.track.AdScopeCallBack;
import xyz.adscope.ad.control.track.AdScopeTracker;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;
import xyz.adscope.ad.control.track.inter.BaseTrackEvent;
import xyz.adscope.ad.control.track.inter.TrackEventEnum;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.ReportModel;
import xyz.adscope.ad.tool.monitor.AdScopeADNScreenTool;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeBaseMonitoring implements IMonitor {
    private static final int DEFAULT_CLICK_AREA = 20;
    private static final int DEFAULT_EXPOSURE_AREA = 50;
    private static final int DEFAULT_SCHEDULER_SPACE = 100;
    private static AdScopeBaseMonitoring mInstance;
    private IBaseAdListener adListener;
    private AdScopeCycleModel adScopeCycleModel = null;
    private BidModel bidModel;
    private int clickArea;
    private int exposureArea;
    private BaseTrackEvent iCallbackImplement;
    private IMonitorEvent iMonitorEvent;
    private BaseTrackEvent iTrackImplement;
    private boolean isCallBackShow;
    private boolean isClickEvent;
    private boolean isSaveClick;
    private boolean isSaveExposure;
    private ISchedulerTask monitorCheckTask;
    private View trackView;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public class MonitorTaskRunnable implements Runnable {
        public MonitorTaskRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdScopeBaseMonitoring.this.checkTimerTarget();
        }
    }

    private void didMoveToWindow() {
        IMonitorEvent iMonitorEvent;
        if (!this.isSaveExposure && (iMonitorEvent = this.iMonitorEvent) != null) {
            this.isSaveExposure = true;
            iMonitorEvent.saveEventCodeExposured();
        }
        if (!this.iTrackImplement.isExposure()) {
            monitoringExposureReport();
        }
        if (this.iCallbackImplement.isExposure()) {
            return;
        }
        monitoringExposureCallback();
    }

    public static AdScopeBaseMonitoring getInstance() {
        if (mInstance == null) {
            synchronized (AdScopeBaseMonitoring.class) {
                if (mInstance == null) {
                    mInstance = new AdScopeBaseMonitoring();
                }
            }
        }
        return mInstance;
    }

    private void monitoringClickCallBack() {
        this.iCallbackImplement.callBackEventWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_CLICK);
    }

    private void monitoringClickReport() {
        this.iTrackImplement.setAdScopeCycleModel(AdScopeTrackerTool.convertAdClickPointWithView(this.trackView, this.adScopeCycleModel));
        this.iTrackImplement.reportTrackerEventWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_CLICK);
    }

    private void monitoringExposureCallback() {
        this.iCallbackImplement.callBackEventWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_EXPOSURE);
    }

    private void monitoringExposureReport() {
        this.iTrackImplement.setAdScopeCycleModel(AdScopeTrackerTool.convertAdViewPointWithView(this.trackView, this.adScopeCycleModel));
        this.iTrackImplement.reportTrackerEventWithType(TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_EXPOSURE);
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void addShowOnScreenTracker(View view, IMonitor iMonitor) {
        this.trackView = view;
        AdMonitorSchedulerTask adMonitorSchedulerTask = new AdMonitorSchedulerTask(iMonitor);
        this.monitorCheckTask = adMonitorSchedulerTask;
        adMonitorSchedulerTask.startSchedulerTask();
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void checkClickMonitoring() {
        IMonitorEvent iMonitorEvent;
        this.isClickEvent = true;
        ReportModel reportModel = AdResponseManager.getReportModel(this.bidModel);
        if (reportModel != null) {
            this.clickArea = reportModel.getExposureArea();
        }
        if (AdScopeADNScreenTool.isVisible(this.trackView, this.clickArea)) {
            if (!this.isSaveClick && (iMonitorEvent = this.iMonitorEvent) != null) {
                this.isSaveClick = true;
                iMonitorEvent.saveEventCodeClick();
            }
            monitoringClickReport();
            String str = Constants.TAG;
            LogUtil.i(str, "asnp_track checkClickMonitoring : iCallbackImplement.isClick() : " + this.iCallbackImplement.isClick() + " \uff0c iMonitorEvent : " + this.iMonitorEvent);
            if (!this.iCallbackImplement.isClick()) {
                monitoringClickCallBack();
                return;
            }
            this.isClickEvent = false;
            IMonitorEvent iMonitorEvent2 = this.iMonitorEvent;
            if (iMonitorEvent2 != null) {
                iMonitorEvent2.adnTrackClick();
            }
        }
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void checkExposureMonitoring() {
        ReportModel reportModel = AdResponseManager.getReportModel(this.bidModel);
        if (reportModel != null && reportModel.getExposureArea() != 0) {
            this.exposureArea = reportModel.getExposureArea();
        }
        if (AdScopeADNScreenTool.isVisible(this.trackView, this.exposureArea)) {
            didMoveToWindow();
        }
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void checkMonitoringWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
        this.iTrackImplement.reportTrackerEventWithType(adScopeTrackerEvent);
    }

    public void checkTimerTarget() {
        IMonitorEvent iMonitorEvent;
        ReportModel reportModel = AdResponseManager.getReportModel(this.bidModel);
        if (reportModel != null && reportModel.getExposureArea() != 0) {
            this.exposureArea = reportModel.getExposureArea();
        }
        if (AdScopeADNScreenTool.isVisible(this.trackView, 10) && !this.isCallBackShow && (iMonitorEvent = this.iMonitorEvent) != null) {
            this.isCallBackShow = true;
            iMonitorEvent.adnTrackDidShow();
        }
        if (AdScopeADNScreenTool.isVisible(this.trackView, this.exposureArea) || this.isClickEvent) {
            int showTime = this.iTrackImplement.getShowTime() + 100;
            this.iTrackImplement.setShowTime(showTime);
            this.iCallbackImplement.setShowTime(this.iCallbackImplement.getShowTime() + 100);
            String str = Constants.TAG;
            LogUtil.i(str, "asnp_track trackShowTime : " + showTime);
            didMoveToWindow();
        }
        if (this.isClickEvent && !this.iCallbackImplement.isClick()) {
            monitoringClickCallBack();
        }
        if (this.iCallbackImplement.getShowTime() < this.iCallbackImplement.getMaxTime() || this.iTrackImplement.getShowTime() < this.iTrackImplement.getMaxTime()) {
            return;
        }
        stopScheduleMonitorTask();
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void destroy() {
        this.trackView = null;
        this.adScopeCycleModel = null;
        this.iCallbackImplement = null;
        this.iTrackImplement = null;
        this.bidModel = null;
        this.iMonitorEvent = null;
        mInstance = null;
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void initWithRouter(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        this.bidModel = adScopeCycleModel.getBidModel();
        this.adListener = adScopeCycleModel.getAdListener();
        this.iTrackImplement = new AdScopeTracker(adScopeCycleModel);
        AdScopeCallBack adScopeCallBack = new AdScopeCallBack(adScopeCycleModel);
        this.iCallbackImplement = adScopeCallBack;
        adScopeCallBack.setIMonitorEvent(this.iMonitorEvent);
        this.exposureArea = 50;
        this.clickArea = 20;
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void setIMonitorEvent(IMonitorEvent iMonitorEvent) {
        this.iMonitorEvent = iMonitorEvent;
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitor
    public void stopScheduleMonitorTask() {
        ISchedulerTask iSchedulerTask = this.monitorCheckTask;
        if (iSchedulerTask != null) {
            iSchedulerTask.stopSchedulerTask();
        }
    }
}
