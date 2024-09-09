package xyz.adscope.ad.advertisings.nativead;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.advertisings.nativead.config.NativeAdConfig;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.event.ASNPUtil;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NativeAd {
    private INativeAdListener INativeAdListener;
    private AdScopeCycleModel adScopeCycleModel;
    private NativeAdConfig nativeAdConfig;
    private NativeAdRouter nativeAdRouter;

    public NativeAd(Context context, INativeAdListener iNativeAdListener, NativeAdConfig nativeAdConfig) {
        initNativeAd(context, iNativeAdListener, nativeAdConfig);
        setNativeAdRouterConfig();
    }

    private void initNativeAd(Context context, INativeAdListener iNativeAdListener, NativeAdConfig nativeAdConfig) {
        this.nativeAdRouter = new NativeAdRouter(context);
        this.INativeAdListener = iNativeAdListener;
        this.nativeAdConfig = nativeAdConfig;
        AdScopeCycleModel adScopeCycleModel = new AdScopeCycleModel();
        this.adScopeCycleModel = adScopeCycleModel;
        adScopeCycleModel.setLoadStartTime(System.currentTimeMillis());
    }

    private void setNativeAdRouterConfig() {
        this.nativeAdRouter.setAdListener(this.INativeAdListener);
        this.nativeAdRouter.setAdScopeCycleModel(this.adScopeCycleModel);
    }

    public void destroy() {
        NativeAdRouter nativeAdRouter = this.nativeAdRouter;
        if (nativeAdRouter != null) {
            nativeAdRouter.destroyAd();
        }
    }

    public void loadAd() {
        NativeAdConfig nativeAdConfig = this.nativeAdConfig;
        if (nativeAdConfig != null) {
            this.adScopeCycleModel.setSpaceId(nativeAdConfig.getSpaceId());
            this.adScopeCycleModel.setSessionId(ASNPUtil.createRequestId());
            this.adScopeCycleModel.setTimeoutInterval(this.nativeAdConfig.getIntervalTime());
            this.adScopeCycleModel.setAdCount(this.nativeAdConfig.getAdCount());
            this.adScopeCycleModel.setBidToken(this.nativeAdConfig.getBidToken());
            this.adScopeCycleModel.setNativeAdViewWidth(this.nativeAdConfig.getNativeAdViewWidth());
            this.adScopeCycleModel.setNativeAdViewHeight(this.nativeAdConfig.getNativeAdViewHeight());
            this.adScopeCycleModel.setCountryCN(this.nativeAdConfig.getCountryCN());
            this.adScopeCycleModel.setTestAd(this.nativeAdConfig.getTestAd());
            if (TextUtils.isEmpty(this.nativeAdConfig.getApiKey())) {
                this.adScopeCycleModel.setApiKey("AdScopeADN");
            } else {
                this.adScopeCycleModel.setApiKey(this.nativeAdConfig.getApiKey());
            }
        }
        this.adScopeCycleModel.setSpaceType(AdType.NATIVE.getValue());
        StrategyEventCacheManager.getInstance().asyncQueryStrategyEventList(this.adScopeCycleModel);
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_LOAD_CODE, "");
        this.nativeAdRouter.requestAd();
    }

    public void resume() {
    }

    public void show(ViewGroup viewGroup) {
        NativeAdRouter nativeAdRouter = this.nativeAdRouter;
        if (nativeAdRouter != null) {
            nativeAdRouter.onAdShow();
        }
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_SHOW_CODE, "");
    }
}
