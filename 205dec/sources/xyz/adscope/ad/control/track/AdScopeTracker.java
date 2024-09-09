package xyz.adscope.ad.control.track;

import android.text.TextUtils;
import java.util.List;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.track.inter.BaseTrackEvent;
import xyz.adscope.ad.control.track.inter.TrackEventEnum;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.model.http.response.ad.DisplayModel;
import xyz.adscope.ad.model.http.response.ad.EventModel;
import xyz.adscope.ad.model.http.response.ad.MediaModel;
import xyz.adscope.ad.model.http.response.ad.ReportModel;
import xyz.adscope.ad.model.http.response.ad.RuleModel;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.task.TimerOutTask;
import xyz.adscope.ad.tool.task.inter.ITimerTaskCallback;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeTracker extends BaseTrackEvent {
    public static final String ADSCOPE_TAG = "ADCOPE_MONITORE";
    private BidModel bidModel;

    public AdScopeTracker(AdScopeCycleModel adScopeCycleModel) {
        this.bidModel = adScopeCycleModel.getBidModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportEventWithDelay$0(List list, TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent, TimerOutTask timerOutTask) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            EventModel eventModel = (EventModel) list.get(i4);
            if (eventModel.getType() == adScopeTrackerEvent.getCode()) {
                if (eventModel.getMethod() == 0) {
                    String url = eventModel.getUrl();
                    requestGetTrackerWithURL(url, adScopeTrackerEvent.getCode() + "");
                } else {
                    String url2 = eventModel.getUrl();
                    requestPostTrackerWithURL(url2, adScopeTrackerEvent.getCode() + "");
                }
            }
        }
        timerOutTask.cancelReportTrackTimer();
    }

    private void reportEventWithDelay(long j4, final TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
        final List<EventModel> event;
        LogUtil.e(ADSCOPE_TAG, "track_monitor \u76d1\u6d4b\u6765\u4e86\uff0c\u5ef6\u65f6\u65f6\u95f4\uff1a" + j4 + " , \u4e8b\u4ef6\u7c7b\u578b\uff1a" + adScopeTrackerEvent.getCode());
        DisplayModel displayModel = AdResponseManager.getDisplayModel(this.bidModel);
        if (displayModel == null || (event = displayModel.getEvent()) == null || event.size() <= 0) {
            return;
        }
        long max = Math.max(j4 - getShowTime(), 0L);
        LogUtil.e(ADSCOPE_TAG, "track_monitor \u76d1\u6d4b\u6765\u4e86\uff0c\u6700\u7ec8\u5ef6\u65f6\u65f6\u95f4\uff1a" + max + " , \u4e8b\u4ef6\u7c7b\u578b\uff1a" + adScopeTrackerEvent.getCode());
        final TimerOutTask timerOutTask = new TimerOutTask();
        timerOutTask.buildReportTrackTimerTask(max, new ITimerTaskCallback() { // from class: xyz.adscope.ad.control.track.a
            @Override // xyz.adscope.ad.tool.task.inter.ITimerTaskCallback
            public final void scheduleTimeEndCall() {
                AdScopeTracker.this.lambda$reportEventWithDelay$0(event, adScopeTrackerEvent, timerOutTask);
            }
        });
    }

    private void requestPostTrackerWithURL(String str, String str2) {
        String replaceM = AdScopeTrackerTool.replaceM(str, this.adScopeCycleModel, str2);
        String substring = replaceM.substring(replaceM.indexOf("?") + 1);
        new AdScopeHttpRequest().requestWithPostMethod(replaceM.substring(0, replaceM.indexOf("?")), substring, new IHttpResponseCallback<Object>() { // from class: xyz.adscope.ad.control.track.AdScopeTracker.2
            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str3, int i4) {
                String str4 = Constants.TAG;
                LogUtil.i(str4, "requestPostTrackerWithURL failCallback : msg : " + str3 + " , code : " + i4);
            }

            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void successCallback(Object obj) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "requestPostTrackerWithURL success : " + obj);
                if (obj instanceof Response) {
                    Response response = (Response) obj;
                    String locationUrl = response.locationUrl();
                    if (response.code() != 302 || TextUtils.isEmpty(locationUrl)) {
                        return;
                    }
                    new AdScopeHttpRequest().requestWithPostMethod(locationUrl, "", new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.control.track.AdScopeTracker.2.1
                        @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                        public void failCallback(String str4, int i4) {
                            String str5 = Constants.TAG;
                            LogUtil.i(str5, "requestWithPostMethod 302 failCallback : msg : " + str4 + " , code : " + i4);
                        }

                        @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                        public void successCallback(String str4) {
                            String str5 = Constants.TAG;
                            LogUtil.i(str5, "requestWithPostMethod 302 success : " + str4);
                        }
                    });
                }
            }
        });
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    public void callBackEventWithType(TrackEventEnum.AdScopeTrackerEvent adScopeTrackerEvent) {
    }

    @Override // xyz.adscope.ad.control.track.inter.BaseTrackEvent
    public int getMaxTime() {
        BidModel bidModel = this.bidModel;
        if (bidModel == null) {
            return this.maxTime;
        }
        MediaModel media = bidModel.getMedia();
        if (media == null) {
            return this.maxTime;
        }
        AdModel ad = media.getAd();
        if (ad == null) {
            return this.maxTime;
        }
        DisplayModel display = ad.getDisplay();
        if (display == null) {
            return this.maxTime;
        }
        ReportModel report = display.getReport();
        if (report == null) {
            return this.maxTime;
        }
        List<RuleModel> rule = report.getRule();
        if (rule != null && rule.size() >= 1) {
            for (RuleModel ruleModel : rule) {
                int parseInt = !TextUtils.isEmpty(ruleModel.getRepDelay()) ? Integer.parseInt(ruleModel.getRepDelay()) : 0;
                if (ruleModel.getRepRandomDelay() + parseInt > this.maxTime) {
                    this.maxTime = parseInt + ruleModel.getRepRandomDelay();
                }
            }
            return this.maxTime;
        }
        return this.maxTime;
    }

    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    public void initWithRouter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    @Override // xyz.adscope.ad.control.track.inter.ITrackEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportTrackerEventWithType(xyz.adscope.ad.control.track.inter.TrackEventEnum.AdScopeTrackerEvent r14) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.track.AdScopeTracker.reportTrackerEventWithType(xyz.adscope.ad.control.track.inter.TrackEventEnum$AdScopeTrackerEvent):void");
    }

    public void requestGetTrackerWithURL(String str, String str2) {
        String str3 = Constants.TAG;
        LogUtil.i(str3, "track_monitor requestGetTrackerWithURL : url " + str + " , action : " + str2);
        new AdScopeHttpRequest().requestWithGetMethod(AdScopeTrackerTool.replaceM(str, this.adScopeCycleModel, str2), new IHttpResponseCallback<Object>() { // from class: xyz.adscope.ad.control.track.AdScopeTracker.1
            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str4, int i4) {
                String str5 = Constants.TAG;
                LogUtil.i(str5, "requestGetTrackerWithURL failCallback : msg : " + str4 + " , code : " + i4);
            }

            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void successCallback(Object obj) {
                String str4 = Constants.TAG;
                LogUtil.i(str4, "track_monitor requestGetTrackerWithURL success : " + obj);
                if (obj instanceof Response) {
                    Response response = (Response) obj;
                    String locationUrl = response.locationUrl();
                    if (response.code() != 302 || TextUtils.isEmpty(locationUrl)) {
                        return;
                    }
                    new AdScopeHttpRequest().requestWithGetMethod(locationUrl, new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.control.track.AdScopeTracker.1.1
                        @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                        public void failCallback(String str5, int i4) {
                            String str6 = Constants.TAG;
                            LogUtil.i(str6, "track_monitor requestGetTrackerWithURL 302 failCallback : msg : " + str5 + " , code : " + i4);
                        }

                        @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                        public void successCallback(String str5) {
                            String str6 = Constants.TAG;
                            LogUtil.i(str6, "track_monitor requestGetTrackerWithURL 302 success : " + str5);
                        }
                    });
                }
            }
        });
    }
}
