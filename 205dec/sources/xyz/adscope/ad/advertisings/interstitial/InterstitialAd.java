package xyz.adscope.ad.advertisings.interstitial;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import xyz.adscope.ad.advertisings.AdResponseManager;
import xyz.adscope.ad.advertisings.constants.ErrorCode;
import xyz.adscope.ad.advertisings.interstitial.config.InterstitialAdConfig;
import xyz.adscope.ad.advertisings.interstitial.listener.InterstitialAdListener;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.control.interaction.view.AdTotalView;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class InterstitialAd {
    private AdScopeCycleModel adScopeCycleModel;
    private InterstitialAdConfig interstitialAdConfig;
    private InterstitialAdRouter interstitialAdRouter;
    private InterstitialAdListener listener;
    private ViewGroup parentView;

    public InterstitialAd(Context context, InterstitialAdListener interstitialAdListener, InterstitialAdConfig interstitialAdConfig) {
        initInterstitialAd(context, interstitialAdListener, interstitialAdConfig);
        initParentView(context);
        setInterstitialAdRouterConfig();
    }

    private void initInterstitialAd(Context context, InterstitialAdListener interstitialAdListener, InterstitialAdConfig interstitialAdConfig) {
        this.interstitialAdConfig = interstitialAdConfig;
        this.listener = interstitialAdListener;
        this.interstitialAdRouter = new InterstitialAdRouter(context);
        this.adScopeCycleModel = new AdScopeCycleModel();
    }

    private void initParentView(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        AdTotalView adTotalView = new AdTotalView(context);
        this.parentView = adTotalView;
        adTotalView.setLayoutParams(layoutParams);
    }

    private void setInterstitialAdRouterConfig() {
        this.interstitialAdRouter.setAdListener(this.listener);
        this.interstitialAdRouter.setParentView(this.parentView);
        this.interstitialAdRouter.setAdScopeCycleModel(this.adScopeCycleModel);
    }

    public void destroy() {
        InterstitialAdRouter interstitialAdRouter = this.interstitialAdRouter;
        if (interstitialAdRouter != null) {
            interstitialAdRouter.destroyAd();
        }
    }

    public IAdBidding getAdBid() {
        InterstitialAdRouter interstitialAdRouter = this.interstitialAdRouter;
        if (interstitialAdRouter != null) {
            return interstitialAdRouter.getIAdBidding();
        }
        return null;
    }

    public void loadAd() {
        InterstitialAdConfig interstitialAdConfig = this.interstitialAdConfig;
        if (interstitialAdConfig != null) {
            this.adScopeCycleModel.setSpaceId(interstitialAdConfig.getSpaceId());
            this.adScopeCycleModel.setTimeoutInterval(this.interstitialAdConfig.getIntervalTime());
            this.adScopeCycleModel.setBidToken(this.interstitialAdConfig.getBidToken());
            this.adScopeCycleModel.setCountryCN(this.interstitialAdConfig.getCountryCN());
            this.adScopeCycleModel.setTestAd(this.interstitialAdConfig.getTestAd());
            this.adScopeCycleModel.setUniteRandom((int) ((Math.random() * 100.0d) + 1.0d));
            if (TextUtils.isEmpty(this.interstitialAdConfig.getApiKey())) {
                this.adScopeCycleModel.setApiKey("AdScopeADN");
            } else {
                this.adScopeCycleModel.setApiKey(this.interstitialAdConfig.getApiKey());
            }
        }
        this.adScopeCycleModel.setSpaceType(AdType.INTERSTITIAL.getValue());
        this.adScopeCycleModel.setLoadStartTime(System.currentTimeMillis());
        StrategyEventCacheManager.getInstance().asyncQueryStrategyEventList(this.adScopeCycleModel);
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_LOAD_CODE, "");
        this.interstitialAdRouter.requestAd();
    }

    public void show(Context context) {
        if (!AdResponseManager.isPassUnitControl(this.adScopeCycleModel)) {
            InterstitialAdRouter interstitialAdRouter = this.interstitialAdRouter;
            ErrorCode.ErrorCodeAdListener errorCodeAdListener = ErrorCode.ErrorCodeAdListener.ERROR_CODE_UNITE_CONTROL;
            interstitialAdRouter.doFailCallbackEvent(errorCodeAdListener.getCode(), errorCodeAdListener.getMessage());
            return;
        }
        InterstitialAdRouter interstitialAdRouter2 = this.interstitialAdRouter;
        if (interstitialAdRouter2 != null) {
            interstitialAdRouter2.onAdShow();
        }
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_SHOW_CODE, "");
        InterstitialAdViewSingleton.getInstance().setInterstitialAdView(this.parentView);
        if (this.parentView != null) {
            Intent intent = new Intent();
            intent.setClass(context, ASNPInterstitialActivity.class);
            context.startActivity(intent);
        }
    }
}
