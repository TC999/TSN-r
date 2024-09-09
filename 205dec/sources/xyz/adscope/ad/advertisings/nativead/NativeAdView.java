package xyz.adscope.ad.advertisings.nativead;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import xyz.adscope.ad.advertisings.nativead.config.NativeViewItemType;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.advertisings.nativead.listener.INativeDislikeListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeExpressAdListener;
import xyz.adscope.ad.bidding.AdBidding;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.monitor.AdScopeBaseMonitoring;
import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.control.monitor.inter.IMonitorEvent;
import xyz.adscope.ad.control.render.inter.IRender;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.control.track.AdScopeTrackEventStatusImpl;
import xyz.adscope.ad.control.track.inter.ITrackEventStatus;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NativeAdView implements INativeAdView, IMonitorEvent {
    public AdScopeCycleModel adScopeCycleModel;
    private AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel;
    public BidModel bidModel;
    public Context context;
    private IAdBidding iAdBidding;
    private IMonitor iMonitor;
    private INativeDislikeListener iNativeDislikeListener;
    public INativeExpressAdListener iNativeExpressAdListener;
    public IRender iRender;
    private ITrackEventStatus iTrackEventStatus;
    public ViewGroup viewGroup;

    public NativeAdView(Context context, IRender iRender) {
        this.context = context;
        this.iRender = iRender;
    }

    private ViewGroup buildViewGroup() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        IRender iRender = this.iRender;
        if (iRender != null) {
            iRender.setAutoHeight(true);
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null && adScopeCycleModel.getNativeAdViewWidth() > 0.0f && this.adScopeCycleModel.getNativeAdViewHeight() > 0.0f) {
            int dip2px = DeviceInfoUtil.dip2px(this.context, this.adScopeCycleModel.getNativeAdViewWidth());
            int dip2px2 = DeviceInfoUtil.dip2px(this.context, this.adScopeCycleModel.getNativeAdViewHeight());
            IRender iRender2 = this.iRender;
            if (iRender2 != null) {
                iRender2.setAutoHeight(false);
            }
            layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px2);
        }
        layoutParams.addRule(13);
        AdTotalView adTotalView = new AdTotalView(this.context);
        adTotalView.setLayoutParams(layoutParams);
        return adTotalView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDislikeDialog$0() {
        INativeDislikeListener iNativeDislikeListener = this.iNativeDislikeListener;
        if (iNativeDislikeListener != null) {
            iNativeDislikeListener.onAdCloseButtonClick(getExpressAdView());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDislikeDialog(Context context) {
        DislikeDialog.Builder builder = new DislikeDialog.Builder(context);
        builder.setDialogItemCallback(new DislikeDialog.DialogItemCallback() { // from class: xyz.adscope.ad.advertisings.nativead.a
            @Override // xyz.adscope.ad.tool.widget.dialog.dislike.DislikeDialog.DialogItemCallback
            public final void onDialogItemClick() {
                NativeAdView.this.lambda$showDislikeDialog$0();
            }
        });
        builder.create().show();
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackClick() {
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CALL_CLICK_CODE, "");
        INativeExpressAdListener iNativeExpressAdListener = this.iNativeExpressAdListener;
        if (iNativeExpressAdListener != null) {
            iNativeExpressAdListener.onAdClicked(getExpressAdView(), 0);
        }
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackDidShow() {
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_SHOW_CODE, "");
        INativeExpressAdListener iNativeExpressAdListener = this.iNativeExpressAdListener;
        if (iNativeExpressAdListener != null) {
            iNativeExpressAdListener.onAdShow(getExpressAdView(), 0);
        }
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void adnTrackExposured() {
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CALL_EXPOSURE_CODE, "");
        INativeExpressAdListener iNativeExpressAdListener = this.iNativeExpressAdListener;
        if (iNativeExpressAdListener != null) {
            iNativeExpressAdListener.onAdExposure(getExpressAdView(), 0);
        }
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public View getExpressAdView() {
        return this.viewGroup;
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public IAdBidding getIAdBidding() {
        return this.iAdBidding;
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public NativeViewItemType getItemModel() {
        return NativeViewItemType.ITEM_VIEW_TYPE_LARGE_PIC;
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public void render() {
        this.viewGroup = buildViewGroup();
        this.iMonitor = new AdScopeBaseMonitoring();
        AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = new AdScopeRenderCustomTrackerModel();
        this.adScopeRenderCustomTrackerModel = adScopeRenderCustomTrackerModel;
        this.adScopeCycleModel.setAdScopeRenderCustomTrackerModel(adScopeRenderCustomTrackerModel);
        this.adScopeCycleModel.setAdListener(this.iNativeExpressAdListener);
        this.adScopeCycleModel.setBidModel(this.bidModel);
        this.iMonitor.setIMonitorEvent(this);
        this.iMonitor.initWithRouter(this.adScopeCycleModel);
        AdScopeTrackEventStatusImpl adScopeTrackEventStatusImpl = new AdScopeTrackEventStatusImpl(this.iMonitor);
        this.iTrackEventStatus = adScopeTrackEventStatusImpl;
        this.iRender.setITrackEventStatus(adScopeTrackEventStatusImpl);
        this.iRender.setInteractionExecute(new IInteractionExecute() { // from class: xyz.adscope.ad.advertisings.nativead.NativeAdView.1
            @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
            public void customClick() {
                if (NativeAdView.this.iMonitor != null) {
                    NativeAdView.this.iMonitor.checkClickMonitoring();
                }
            }

            @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
            public void customClose() {
                NativeAdView nativeAdView = NativeAdView.this;
                INativeExpressAdListener iNativeExpressAdListener = nativeAdView.iNativeExpressAdListener;
                if (iNativeExpressAdListener != null) {
                    iNativeExpressAdListener.onAdClose(nativeAdView.viewGroup);
                }
            }

            @Override // xyz.adscope.ad.control.interaction.inter.IInteractionExecute
            public void customDislike() {
                try {
                    NativeAdView.this.showDislikeDialog(SystemUtil.findActivityContext(NativeAdView.this.viewGroup).get());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        });
        this.iRender.rendAd(this.context, this.viewGroup, this.bidModel, this.adScopeCycleModel, new IRenderCallback() { // from class: xyz.adscope.ad.advertisings.nativead.NativeAdView.2
            @Override // xyz.adscope.ad.control.render.inter.IRenderCallback
            public void failCallback(int i4, String str) {
                NativeAdView nativeAdView = NativeAdView.this;
                INativeExpressAdListener iNativeExpressAdListener = nativeAdView.iNativeExpressAdListener;
                if (iNativeExpressAdListener != null) {
                    iNativeExpressAdListener.onRenderFail(nativeAdView.viewGroup, str, i4);
                }
            }

            @Override // xyz.adscope.ad.control.render.inter.IRenderCallback
            public void successCallback() {
                NativeAdView nativeAdView = NativeAdView.this;
                INativeExpressAdListener iNativeExpressAdListener = nativeAdView.iNativeExpressAdListener;
                if (iNativeExpressAdListener != null) {
                    iNativeExpressAdListener.onRenderSuccess(nativeAdView.viewGroup, 300.0f, 200.0f);
                }
            }
        });
        IMonitor iMonitor = this.iMonitor;
        iMonitor.addShowOnScreenTracker(this.viewGroup, iMonitor);
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeClick() {
        StrategyEventCacheManager.getInstance().asyncInsertStrategyEventModel(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_CLICK_CODE.getCodeStr());
    }

    @Override // xyz.adscope.ad.control.monitor.inter.IMonitorEvent
    public void saveEventCodeExposured() {
        StrategyEventCacheManager.getInstance().asyncInsertStrategyEventModel(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_EXPOSURE_CODE.getCodeStr());
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public void setBidModel(BidModel bidModel) {
        this.bidModel = bidModel;
        this.iAdBidding = new AdBidding(bidModel, this.adScopeCycleModel);
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public void setINativeDislikeListener(INativeDislikeListener iNativeDislikeListener) {
        this.iNativeDislikeListener = iNativeDislikeListener;
    }

    @Override // xyz.adscope.ad.advertisings.nativead.listener.INativeAdView
    public void setINativeExpressAdListener(INativeExpressAdListener iNativeExpressAdListener) {
        this.iNativeExpressAdListener = iNativeExpressAdListener;
    }
}
