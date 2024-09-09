package xyz.adscope.ad.control.track;

import java.util.List;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.control.track.inter.BaseTrackEvent;
import xyz.adscope.ad.control.track.inter.TrackEventEnum;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.ReportModel;
import xyz.adscope.ad.model.http.response.ad.RuleModel;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeCallBack extends BaseTrackEvent {
    private IBaseAdListener adListener;
    private AdScopeCycleModel adScopeCycleModel;
    private BidModel bidModel;
    private ReportModel reportModel;

    public AdScopeCallBack(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
        this.bidModel = adScopeCycleModel.getBidModel();
        this.adListener = adScopeCycleModel.getAdListener();
    }

    private void realCallBackEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
        LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "track_monitor \u56de\u8c03\u6765\u4e86\uff1a , \u4e8b\u4ef6\u7c7b\u578b\uff1a" + adScopeTrackerEvent.getCode());
        int code = adScopeTrackerEvent.getCode();
        TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent2 = TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_EXPOSURE;
        if (code == adScopeTrackerEvent2.getCode() && !isExposure()) {
            setExposure(true);
            if (getiMonitorEvent() != null) {
                getiMonitorEvent().adnTrackExposured();
                LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "track_monitor \u66dd\u5149\u56de\u8c03\u6765\u4e86\uff1a , \u4e8b\u4ef6\u7c7b\u578b\uff1a" + adScopeTrackerEvent.getCode());
            }
        } else if (adScopeTrackerEvent.getCode() != TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_CLICK.getCode() || isClick()) {
        } else {
            setClick(true);
            if (!isExposure()) {
                realCallBackEventWithType(adScopeTrackerEvent2);
            }
            if (getiMonitorEvent() != null) {
                getiMonitorEvent().adnTrackClick();
                LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "track_monitor \u70b9\u51fb\u56de\u8c03\u6765\u4e86\uff1a , \u4e8b\u4ef6\u7c7b\u578b\uff1a" + adScopeTrackerEvent.getCode());
            }
        }
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    public void callBackEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
        RuleModel ruleModel;
        List<RuleModel> rule;
        this.reportModel = AdResponseManager.getReportModel(this.bidModel);
        LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 11111 \uff1a" + adScopeTrackerEvent.getCode());
        ReportModel reportModel = this.reportModel;
        if (reportModel != null && (rule = reportModel.getRule()) != null && rule.size() > 0) {
            for (int i4 = 0; i4 < rule.size(); i4++) {
                ruleModel = rule.get(i4);
                if (ruleModel.getType() == adScopeTrackerEvent.getCode()) {
                    break;
                }
            }
        }
        ruleModel = null;
        if (ruleModel == null) {
            LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 22222 \uff1a" + adScopeTrackerEvent.getCode());
            realCallBackEventWithType(adScopeTrackerEvent);
            return;
        }
        LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 33333 \uff1a" + adScopeTrackerEvent.getCode() + " , getShowTime() : " + getShowTime() + " , tempRuleModel.getCalExposureTime()  " + ruleModel.getCalExposureTime());
        if (getShowTime() >= ruleModel.getCalExposureTime()) {
            if (ruleModel.getCalRandomNum() < ((int) (Math.random() * 100.0d)) + 1 && ruleModel.getCalRandomNum() != 0) {
                int code = adScopeTrackerEvent.getCode();
                TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent2 = TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_EXPOSURE;
                if (code == adScopeTrackerEvent2.getCode()) {
                    setExposure(true);
                    LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 55555 \uff1a" + adScopeTrackerEvent.getCode());
                    return;
                } else if (adScopeTrackerEvent.getCode() == TrackEventEnum.AdScopeTrackerEvent.TRACKER_EVENT_CLICK.getCode()) {
                    setClick(true);
                    if (isExposure()) {
                        return;
                    }
                    realCallBackEventWithType(adScopeTrackerEvent2);
                    LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 66666 \uff1a" + adScopeTrackerEvent.getCode());
                    return;
                } else {
                    return;
                }
            }
            LogUtil.e(AdScopeTracker.ADSCOPE_TAG, "asnp_track callBackEventWithType 44444 \uff1a" + adScopeTrackerEvent.getCode());
            realCallBackEventWithType(adScopeTrackerEvent);
        }
    }

    @Override // xyz.adscope.ad.control.track.inter.BaseTrackEvent
    public int getMaxTime() {
        List<RuleModel> rule;
        ReportModel reportModel = AdResponseManager.getReportModel(this.bidModel);
        this.reportModel = reportModel;
        if (reportModel != null && (rule = reportModel.getRule()) != null && rule.size() > 0) {
            for (int i4 = 0; i4 < rule.size(); i4++) {
                RuleModel ruleModel = rule.get(i4);
                if (ruleModel.getCalExposureTime() > this.maxTime) {
                    this.maxTime = ruleModel.getCalExposureTime();
                }
            }
        }
        return this.maxTime;
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    public void initWithRouter() {
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    public void reportTrackerEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
    }
}
