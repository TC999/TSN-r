package xyz.adscope.ad.control.track.inter;

import xyz.adscope.ad.control.monitor.inter.IMonitorEvent;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class BaseTrackEvent implements ITrackEvent {
    public AdScopeCycleModel adScopeCycleModel;
    private IMonitorEvent iMonitorEvent;
    public int maxTime = 100;
    private int showTime = 0;
    private boolean isExposure = false;
    private boolean isClick = false;

    public int getMaxTime() {
        return this.maxTime;
    }

    public int getShowTime() {
        return this.showTime;
    }

    public IMonitorEvent getiMonitorEvent() {
        return this.iMonitorEvent;
    }

    public boolean isClick() {
        return this.isClick;
    }

    public boolean isExposure() {
        return this.isExposure;
    }

    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
    }

    public void setClick(boolean z3) {
        this.isClick = z3;
    }

    public void setExposure(boolean z3) {
        this.isExposure = z3;
    }

    public void setIMonitorEvent(IMonitorEvent iMonitorEvent) {
        this.iMonitorEvent = iMonitorEvent;
    }

    public void setShowTime(int i4) {
        this.showTime = i4;
    }
}
