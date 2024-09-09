package xyz.adscope.ad.advertisings.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.BaseAdvertisingRouter;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.bidding.AdBidding;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.control.track.AdScopeTrackEventStatusImpl;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SplashAdRouter extends BaseAdvertisingRouter {
    private static final String TAG = "SplashAdRouter";
    private AdScopeCycleModel adScopeCycleModel;
    private AdScopeTrackEventStatusImpl adScopeTrackEventStatusImpl;

    public SplashAdRouter(Context context) {
        super(context);
        this.adScopeTrackEventStatusImpl = new AdScopeTrackEventStatusImpl(getIMonitor());
    }

    private void addShowOnScreenTracker(View view) {
        getIMonitor().addShowOnScreenTracker(view, getIMonitor());
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackClick() {
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CALL_CLICK_CODE, "");
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            IBaseAdListener adListener = adScopeCycleModel.getAdListener();
            if (adListener instanceof AdListener) {
                ((AdListener) adListener).onAdClicked();
                LogUtil.i(TAG, "asnp_track adnTrackClick()");
            }
        }
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackDidShow() {
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackExposured() {
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CALL_EXPOSURE_CODE, "");
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            IBaseAdListener adListener = adScopeCycleModel.getAdListener();
            if (adListener instanceof AdListener) {
                ((AdListener) adListener).onAdExposure();
                LogUtil.i(TAG, "asnp_track adnTrackExposured()");
            }
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customClick() {
        AdScopeSpUtil.put(Constants.UNITE_CONTROL_KEY, Long.valueOf(System.currentTimeMillis()));
        getIMonitor().checkClickMonitoring();
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customClose() {
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel == null || adScopeCycleModel.isClosedAd()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.adScopeCycleModel.getExposureStartTime();
        AdScopeEventReport adScopeEventReport = AdScopeEventReport.getInstance();
        AdScopeCycleModel adScopeCycleModel2 = this.adScopeCycleModel;
        EventReportCode eventReportCode = EventReportCode.EVENT_REPORT_CLOSE_CODE;
        adScopeEventReport.reportAdEvent(adScopeCycleModel2, eventReportCode, currentTimeMillis + "");
        IMonitor iMonitor = getIMonitor();
        if (iMonitor != null) {
            iMonitor.stopScheduleMonitorTask();
        }
        AdScopeCycleModel adScopeCycleModel3 = this.adScopeCycleModel;
        if (adScopeCycleModel3 != null) {
            IBaseAdListener adListener = adScopeCycleModel3.getAdListener();
            if (adListener instanceof AdListener) {
                ((AdListener) adListener).onAdClosed();
                this.adScopeCycleModel.setClosedAd(true);
            }
        }
    }

    @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
    public void customDislike() {
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public List<INativeAdView> getINativeAdView(AdResponseModel adResponseModel, AdScopeCycleModel adScopeCycleModel) {
        return null;
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public void loadAdResult() {
        AdResponseModel adResponseModel = this.adResponseModel;
        if (adResponseModel != null) {
            BidModel bidModel = AdResponseManager.getBidModel(adResponseModel);
            this.bidModel = bidModel;
            this.iAdBidding = new AdBidding(bidModel, this.adScopeCycleModel);
            IBaseAdListener iBaseAdListener = this.iBaseLoadAdListener;
            if (iBaseAdListener != null && (iBaseAdListener instanceof AdListener)) {
                ((AdListener) iBaseAdListener).onAdLoaded();
            }
        }
        loadAd();
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter, xyz.adscope.ad.advertisings.inter.IAdvertising
    public boolean renderAd(AdResponseModel adResponseModel) {
        boolean renderAd = super.renderAd(adResponseModel);
        addShowOnScreenTracker(getParentView());
        return renderAd;
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeClick() {
        StrategyEventCacheManager.getInstance().asyncInsertStrategyEventModel(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CLICK_CODE.getCodeStr());
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeExposured() {
        StrategyEventCacheManager.getInstance().asyncInsertStrategyEventModel(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_EXPOSURE_CODE.getCodeStr());
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        super.setAdScopeCycleModel(adScopeCycleModel);
        this.adScopeCycleModel = adScopeCycleModel;
    }

    @Override // xyz.adscope.ad.advertisings.BaseAdvertisingRouter
    public void setParentView(ViewGroup viewGroup) {
        super.setParentView(viewGroup);
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void showAdInRootViewController() {
        getParentView().setVisibility(0);
        getIMonitor().checkExposureMonitoring();
    }
}
