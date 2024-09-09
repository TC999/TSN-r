package xyz.adscope.ad.advertisings.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.advertisings.splash.config.SplashAdConfig;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.event.ASNPUtil;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SplashAd {
    private AdScopeCycleModel adScopeCycleModel;
    private AdListener listener;
    private ViewGroup parentView;
    private SplashAdConfig splashAdConfig;
    private SplashAdRouter splashAdRouter;

    public SplashAd(Context context, AdListener adListener, String str, long j4) {
        this.splashAdConfig = new SplashAdConfig.Builder().spaceId(str).intervalTime(j4).build();
        this.listener = adListener;
        this.splashAdRouter = new SplashAdRouter(context);
        this.adScopeCycleModel = new AdScopeCycleModel();
        initParentView(context);
        setSplashAdRouterConfig();
    }

    private void initParentView(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        AdTotalView adTotalView = new AdTotalView(context);
        this.parentView = adTotalView;
        adTotalView.setLayoutParams(layoutParams);
    }

    private void initSplashAd(Context context, AdListener adListener, SplashAdConfig splashAdConfig) {
        this.splashAdConfig = splashAdConfig;
        this.listener = adListener;
        this.splashAdRouter = new SplashAdRouter(context);
        AdScopeCycleModel adScopeCycleModel = new AdScopeCycleModel();
        this.adScopeCycleModel = adScopeCycleModel;
        adScopeCycleModel.setLoadStartTime(System.currentTimeMillis());
    }

    private void setSplashAdRouterConfig() {
        this.splashAdRouter.setAdListener(this.listener);
        this.splashAdRouter.setParentView(this.parentView);
        this.splashAdRouter.setAdScopeCycleModel(this.adScopeCycleModel);
    }

    public void destroy() {
        SplashAdRouter splashAdRouter = this.splashAdRouter;
        if (splashAdRouter != null) {
            splashAdRouter.destroyAd();
        }
    }

    public IAdBidding getAdBid() {
        SplashAdRouter splashAdRouter = this.splashAdRouter;
        if (splashAdRouter != null) {
            return splashAdRouter.getIAdBidding();
        }
        return null;
    }

    public void loadAd() {
        SplashAdConfig splashAdConfig = this.splashAdConfig;
        if (splashAdConfig != null) {
            this.adScopeCycleModel.setSpaceId(splashAdConfig.getSpaceId());
            this.adScopeCycleModel.setSessionId(ASNPUtil.createRequestId());
            this.adScopeCycleModel.setTimeoutInterval(this.splashAdConfig.getIntervalTime());
            this.adScopeCycleModel.setBidToken(this.splashAdConfig.getBidToken());
            this.adScopeCycleModel.setCountryCN(this.splashAdConfig.getCountryCN());
            this.adScopeCycleModel.setTestAd(this.splashAdConfig.getTestAd());
            if (TextUtils.isEmpty(this.splashAdConfig.getApiKey())) {
                this.adScopeCycleModel.setApiKey("AdScopeADN");
            } else {
                this.adScopeCycleModel.setApiKey(this.splashAdConfig.getApiKey());
            }
        }
        this.adScopeCycleModel.setSpaceType(AdType.SPLASH.getValue());
        StrategyEventCacheManager.getInstance().asyncQueryStrategyEventList(this.adScopeCycleModel);
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_LOAD_CODE, "");
        this.splashAdRouter.requestAd();
    }

    public void show(ViewGroup viewGroup) {
        SplashAdRouter splashAdRouter = this.splashAdRouter;
        if (splashAdRouter != null) {
            splashAdRouter.onAdShow();
        }
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_SHOW_CODE, "");
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(this.parentView);
        }
    }

    public SplashAd(Context context, AdListener adListener, SplashAdConfig splashAdConfig) {
        initSplashAd(context, adListener, splashAdConfig);
        initParentView(context);
        setSplashAdRouterConfig();
    }
}
