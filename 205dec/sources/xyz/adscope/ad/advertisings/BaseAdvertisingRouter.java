package xyz.adscope.ad.advertisings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.base.IBaseAdListener;
import xyz.adscope.ad.advertisings.constants.ConstantAd;
import xyz.adscope.ad.advertisings.constants.ErrorCode;
import xyz.adscope.ad.advertisings.inter.AdListener;
import xyz.adscope.ad.advertisings.inter.IAdvertising;
import xyz.adscope.ad.advertisings.model.AdParameters;
import xyz.adscope.ad.advertisings.model.AdType;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdListener;
import xyz.adscope.ad.advertisings.nativead.listener.INativeAdView;
import xyz.adscope.ad.bidding.inter.IAdBidding;
import xyz.adscope.ad.config.AdConfigManager;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.config.model.ConfigResponseInfo;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.cache.ad.AdCacheManager;
import xyz.adscope.ad.control.interaction.inter.IInteractionExecute;
import xyz.adscope.ad.control.monitor.AdScopeBaseMonitoring;
import xyz.adscope.ad.control.monitor.inter.IMonitor;
import xyz.adscope.ad.control.monitor.inter.IMonitorEvent;
import xyz.adscope.ad.control.render.RenderView;
import xyz.adscope.ad.control.render.inter.IRender;
import xyz.adscope.ad.control.render.inter.IRenderCallback;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.control.strategy.StrategyEventCacheManager;
import xyz.adscope.ad.control.strategy.StrategyFrequency;
import xyz.adscope.ad.control.strategy.StrategyQuality;
import xyz.adscope.ad.control.strategy.inter.IStrategy;
import xyz.adscope.ad.control.track.AdScopeTrackEventStatusImpl;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.init.inter.InitCallback;
import xyz.adscope.ad.init.inter.InitInterface;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.request.ad.AdRequestInfo;
import xyz.adscope.ad.model.http.request.ad.AdRequestModel;
import xyz.adscope.ad.model.http.response.ad.AdResponseModel;
import xyz.adscope.ad.model.http.response.ad.BidModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.task.TimerOutTask;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class BaseAdvertisingRouter implements IAdvertising, IInteractionExecute, IMonitorEvent {
    public AdParameters adParameters;
    public AdResponseModel adResponseModel;
    public AdScopeCycleModel adScopeCycleModel;
    private AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel;
    public BidModel bidModel;
    private Context context;
    public IAdBidding iAdBidding;
    public IBaseAdListener iBaseLoadAdListener;
    private IMonitor iMonitor;
    public IRender iRender;
    private ViewGroup parentView;
    private InitInterface initInterface = InitImplement.getInstance();
    private IHttpRequest iHttpRequest = new AdScopeHttpRequest();
    private IStrategy iStrategyQuality = new StrategyQuality();
    private IStrategy iStrategyFrequency = new StrategyFrequency();
    public boolean renderResult = false;
    private String apiKey = "";
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: xyz.adscope.ad.advertisings.BaseAdvertisingRouter.1
        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what == 10030) {
                LogUtil.i(Constants.TAG, "cacheLog_ handleMessage : ");
                BaseAdvertisingRouter.this.doSuccessResult((String) message.obj);
            }
        }
    };
    private TimerOutTask timerOutTask = new TimerOutTask();

    public BaseAdvertisingRouter(Context context) {
        this.context = context;
        this.adParameters = new AdParameters(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSuccessResult(String str) {
        this.adResponseModel = AdResponseManager.parseAdResponse(str);
        if (!checkAdvertisingData()) {
            ErrorCode.ErrorCodeAdListener errorCodeAdListener = ErrorCode.ErrorCodeAdListener.ERROR_CODE_AD_NOT_EXIST_ERROR;
            doFailCallbackEvent(errorCodeAdListener.getCode(), errorCodeAdListener.getMessage());
            return;
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            adScopeCycleModel.setAdResponseModel(this.adResponseModel);
            this.adScopeCycleModel.setTimeOutCallback(true);
            this.adScopeCycleModel.setServerResponse(true);
            this.adScopeCycleModel.setDspId(AdResponseManager.getDSPId(this.adResponseModel));
            this.adScopeCycleModel.setPrice(AdResponseManager.getPrice(this.adResponseModel));
            this.adScopeCycleModel.setRenderPlanId(AdResponseManager.getRenderPlanId(this.adResponseModel));
            this.adScopeCycleModel.setInteractPlanId(AdResponseManager.getInteractPlanId(this.adResponseModel));
            this.adScopeCycleModel.setOrderId(AdResponseManager.getOrderId(this.adResponseModel));
            this.adScopeCycleModel.setCreateId(AdResponseManager.getCreateId(this.adResponseModel));
            this.adScopeCycleModel.setMaterialId(AdResponseManager.getMaterialId(this.adResponseModel));
            this.adScopeCycleModel.setMaterialMd5Value(AdResponseManager.getMaterialMd5Value(this.adResponseModel));
            this.adScopeRenderCustomTrackerModel = new AdScopeRenderCustomTrackerModel();
            this.bidModel = AdResponseManager.getBidModel(this.adResponseModel);
            this.adScopeCycleModel.setAdListener(this.iBaseLoadAdListener);
            this.adScopeCycleModel.setBidModel(this.bidModel);
            this.adScopeCycleModel.setAdScopeRenderCustomTrackerModel(this.adScopeRenderCustomTrackerModel);
        }
        this.timerOutTask.cancelTimerTask();
        String str2 = (System.currentTimeMillis() - this.adScopeCycleModel.getRequestStartTime()) + "";
        LogUtil.i(Constants.TAG, "roundTripTimeASNP \u5e7f\u544a\u8bf7\u6c42\u6700\u7ec8\u8017\u65f6\u7ed3\u679c: " + str2);
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_REQUEST_SUCCESS_CODE, str2);
        this.adScopeCycleModel.setRequestStartTime(0L);
        needUpdateConfigure();
        loadAdResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$needUpdateConfigure$0() {
        AdScopeGlobalModel apiModelWithApiKey;
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel == null || adScopeCycleModel.getAdResponseModel() == null || this.adScopeCycleModel.getAdResponseModel().getExt() == null || !this.adScopeCycleModel.getAdResponseModel().getExt().isUpdateCfg() || (apiModelWithApiKey = InitImplement.getInstance().getApiModelWithApiKey(this.adScopeCycleModel.getApiKey())) == null || apiModelWithApiKey.getConfigureModel() == null || apiModelWithApiKey.getConfigureModel().getLastUpdateTime() >= this.adScopeCycleModel.getAdResponseModel().getExt().getUpdateTime()) {
            return;
        }
        new AdConfigManager().requestConfigureWithChannel(apiModelWithApiKey, null);
    }

    private void nativeAdFailed(int i4, String str) {
        IBaseAdListener iBaseAdListener = this.iBaseLoadAdListener;
        if (iBaseAdListener == null || !(iBaseAdListener instanceof INativeAdListener)) {
            return;
        }
        ((INativeAdListener) iBaseAdListener).onAdFailedToLoad(i4, str);
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public boolean checkAdvertisingData() {
        return AdResponseManager.checkAdvertisingData(this.adResponseModel);
    }

    public void clearView() {
        ViewGroup viewGroup = this.parentView;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.parentView.setVisibility(8);
            this.parentView = null;
        }
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void destroyAd() {
        clearView();
        IMonitor iMonitor = this.iMonitor;
        if (iMonitor != null) {
            iMonitor.destroy();
            this.iMonitor = null;
        }
        this.initInterface = null;
        this.iHttpRequest = null;
        this.iBaseLoadAdListener = null;
        this.context = null;
        this.adParameters = null;
        IRender iRender = this.iRender;
        if (iRender != null) {
            iRender.destroy();
            this.iRender = null;
        }
        this.adScopeCycleModel = null;
        this.adScopeRenderCustomTrackerModel = null;
        TimerOutTask timerOutTask = this.timerOutTask;
        if (timerOutTask != null) {
            timerOutTask.cancelTimerTask();
        }
        TimerOutTask timerOutTask2 = this.timerOutTask;
        if (timerOutTask2 != null) {
            timerOutTask2.cancelAdCacheTimerTask();
        }
        this.timerOutTask = null;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.handler = null;
        }
    }

    public void doFailCallbackEvent(int i4, String str) {
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            adScopeCycleModel.setErrorCode(i4 + "");
            this.adScopeCycleModel.setErrorInfo(str);
            this.adScopeCycleModel.setTimeOutCallback(true);
            AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_REQUEST_FAIL_CODE, (System.currentTimeMillis() - this.adScopeCycleModel.getRequestStartTime()) + "");
            this.adScopeCycleModel.setRequestStartTime(0L);
        }
        AdScopeCycleModel adScopeCycleModel2 = this.adScopeCycleModel;
        if (adScopeCycleModel2 != null && adScopeCycleModel2.getSpaceType().equals(AdType.NATIVE.getValue())) {
            nativeAdFailed(i4, str);
        } else {
            IBaseAdListener iBaseAdListener = this.iBaseLoadAdListener;
            if (iBaseAdListener != null && (iBaseAdListener instanceof AdListener)) {
                ((AdListener) iBaseAdListener).onAdFailedToLoad(i4, str);
            }
        }
        TimerOutTask timerOutTask = this.timerOutTask;
        if (timerOutTask != null) {
            timerOutTask.cancelTimerTask();
        }
        TimerOutTask timerOutTask2 = this.timerOutTask;
        if (timerOutTask2 != null) {
            timerOutTask2.cancelAdCacheTimerTask();
        }
    }

    public IAdBidding getIAdBidding() {
        return this.iAdBidding;
    }

    public IMonitor getIMonitor() {
        return this.iMonitor;
    }

    public abstract List<INativeAdView> getINativeAdView(AdResponseModel adResponseModel, AdScopeCycleModel adScopeCycleModel);

    public View getParentView() {
        return this.parentView;
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void httpRequestAds(IHttpResponseCallback iHttpResponseCallback) {
        AdRequestInfo adRequestInfo = AdRequestInfo.getInstance();
        this.adParameters.setAdUnitId(this.adScopeCycleModel.getSpaceId());
        this.adParameters.setAdType(this.adScopeCycleModel.getSpaceType());
        this.adParameters.setAdCount(this.adScopeCycleModel.getAdCount());
        this.adParameters.setBidToken(this.adScopeCycleModel.getBidToken());
        this.adParameters.setCountryCN(this.adScopeCycleModel.getCountryCN());
        this.adParameters.setTestAd(this.adScopeCycleModel.getTestAd());
        adRequestInfo.setAdParameters(this.adParameters);
        if (!adRequestInfo.isInit) {
            adRequestInfo.init(this.apiKey);
        }
        AdRequestModel adRequestModel = adRequestInfo.getAdRequestModel();
        String str = null;
        try {
            str = new JSONParse().toJson(adRequestModel);
        } catch (Exception e4) {
            String str2 = Constants.TAG;
            LogUtil.e(str2, "e : " + e4);
        }
        ConfigResponseInfo configResponseInfo = ConfigResponseInfo.getInstance();
        if (!configResponseInfo.isInit()) {
            configResponseInfo.init();
        }
        String decode = Base64Util.decode(InitImplement.getInstance().isUseHttps() ? ConstantAd.AD_REQUEST_HOST_TRANSFER_PROTOCOL : ConstantAd.AD_REQUEST_HOST);
        String str3 = Constants.TAG;
        LogUtil.i(str3, "isUseHttps : " + InitImplement.getInstance().isUseHttps());
        if (configResponseInfo.getRequestUrlModel() != null && !TextUtils.isEmpty(configResponseInfo.getRequestUrlModel().getAdUrl())) {
            decode = configResponseInfo.getRequestUrlModel().getAdUrl();
        }
        if (this.adScopeCycleModel != null && adRequestModel != null && adRequestModel.getCur() != null) {
            this.adScopeCycleModel.setCurrency(StringUtil.ListToString(adRequestModel.getCur()));
        }
        String str4 = Constants.TAG;
        LogUtil.i(str4, "\u5e7f\u544a\u8bf7\u6c42URL requestUrl : " + decode + " , parameters : " + str);
        this.iHttpRequest.doRequestWithJson(decode, str, iHttpResponseCallback);
    }

    public void loadAd() {
        if (checkAdvertisingData()) {
            if (renderAd(this.adResponseModel)) {
                showAdInRootViewController();
                return;
            }
            IBaseAdListener iBaseAdListener = this.iBaseLoadAdListener;
            if (iBaseAdListener == null || !(iBaseAdListener instanceof AdListener)) {
                return;
            }
            ((AdListener) iBaseAdListener).onAdRenderFail();
            return;
        }
        IBaseAdListener iBaseAdListener2 = this.iBaseLoadAdListener;
        if (iBaseAdListener2 != null && (iBaseAdListener2 instanceof AdListener)) {
            ((AdListener) iBaseAdListener2).onAdRenderFail();
        }
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        IRender.RENDER_ERROR_TYPE render_error_type = IRender.RENDER_ERROR_TYPE.RENDER_FAIL_LOAD_AD_DATA;
        adScopeCycleModel.setErrorInfo(render_error_type.getMsg());
        AdScopeCycleModel adScopeCycleModel2 = this.adScopeCycleModel;
        adScopeCycleModel2.setErrorInfo(render_error_type.getCode() + "");
        AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_RENDER_FAIL_CODE, (System.currentTimeMillis() - this.adScopeCycleModel.getRequestStartTime()) + "");
        this.adScopeCycleModel.setRequestStartTime(0L);
    }

    public abstract void loadAdResult();

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void needUpdateConfigure() {
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.ad.advertisings.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseAdvertisingRouter.this.lambda$needUpdateConfigure$0();
            }
        });
    }

    public void onAdShow() {
        IBaseAdListener iBaseAdListener = this.iBaseLoadAdListener;
        if (iBaseAdListener == null || !(iBaseAdListener instanceof AdListener)) {
            return;
        }
        ((AdListener) iBaseAdListener).onAdShown();
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public boolean renderAd(AdResponseModel adResponseModel) {
        AdScopeBaseMonitoring adScopeBaseMonitoring = new AdScopeBaseMonitoring();
        this.iMonitor = adScopeBaseMonitoring;
        adScopeBaseMonitoring.setIMonitorEvent(this);
        this.iMonitor.initWithRouter(this.adScopeCycleModel);
        AdScopeTrackEventStatusImpl adScopeTrackEventStatusImpl = new AdScopeTrackEventStatusImpl(this.iMonitor);
        RenderView renderView = new RenderView();
        this.iRender = renderView;
        renderView.setAdListener(this.iBaseLoadAdListener);
        this.iRender.setInteractionExecute(this);
        this.iRender.setITrackEventStatus(adScopeTrackEventStatusImpl);
        this.iRender.rendAd(this.context, this.parentView, this.bidModel, this.adScopeCycleModel, new IRenderCallback() { // from class: xyz.adscope.ad.advertisings.BaseAdvertisingRouter.4
            @Override // xyz.adscope.ad.control.render.inter.IRenderCallback
            public void failCallback(int i4, String str) {
                BaseAdvertisingRouter.this.renderResult = false;
            }

            @Override // xyz.adscope.ad.control.render.inter.IRenderCallback
            public void successCallback() {
                BaseAdvertisingRouter.this.renderResult = true;
            }
        });
        return this.renderResult;
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public void requestAd() {
        AdScopeCycleModel adScopeCycleModel = this.adScopeCycleModel;
        if (adScopeCycleModel != null) {
            this.apiKey = adScopeCycleModel.getApiKey();
            this.adScopeCycleModel.setServerResponse(false);
        }
        AdCacheManager.getInstance().updateAdCacheConfig(this.adScopeCycleModel);
        final AdScopeGlobalModel apiModelWithApiKey = InitImplement.getInstance().getApiModelWithApiKey(this.apiKey);
        if (apiModelWithApiKey != null && !apiModelWithApiKey.isInitSuccess()) {
            new AdConfigManager().requestConfigureWithChannel(apiModelWithApiKey, new InitCallback() { // from class: xyz.adscope.ad.advertisings.BaseAdvertisingRouter.2
                @Override // xyz.adscope.ad.init.inter.InitCallback
                public void fail(int i4, String str) {
                    String str2 = Constants.TAG;
                    LogUtil.i(str2, "msg : " + str);
                }

                @Override // xyz.adscope.ad.init.inter.InitCallback
                public void success() {
                    apiModelWithApiKey.setInitSuccess(true);
                    BaseAdvertisingRouter.this.requestAd();
                }
            });
            return;
        }
        this.timerOutTask.setAdListener(this.iBaseLoadAdListener);
        this.timerOutTask.setAdScopeCycleModel(this.adScopeCycleModel);
        this.timerOutTask.buildAdRequestTimeOutTask();
        if (!requestMonitoringControl(this.adScopeCycleModel)) {
            ErrorCode.ErrorCodeAdListener errorCodeAdListener = ErrorCode.ErrorCodeAdListener.ERROR_CODE_REQUEST_FREQUENT;
            doFailCallbackEvent(errorCodeAdListener.getCode(), errorCodeAdListener.getMessage());
        } else if (AdResponseManager.isComplainAd(this.adScopeCycleModel)) {
            ErrorCode.ErrorCodeAdListener errorCodeAdListener2 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_AD_BEEN_COMPLAIN;
            doFailCallbackEvent(errorCodeAdListener2.getCode(), errorCodeAdListener2.getMessage());
        } else if (!AdResponseManager.isPassUnitControl(this.adScopeCycleModel)) {
            ErrorCode.ErrorCodeAdListener errorCodeAdListener3 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_UNITE_CONTROL;
            doFailCallbackEvent(errorCodeAdListener3.getCode(), errorCodeAdListener3.getMessage());
        } else {
            StrategyEventCacheManager.getInstance().asyncInsertStrategyEventModel(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_LOAD_CODE.getCodeStr());
            String str = (System.currentTimeMillis() - this.adScopeCycleModel.getLoadStartTime()) + "";
            LogUtil.i(Constants.TAG, "roundTripTimeASNP \u5e7f\u544a\u52a0\u8f7d-\u8bf7\u6c42\u6700\u7ec8\u8017\u65f6 \uff1a" + str);
            AdScopeEventReport.getInstance().reportAdEvent(this.adScopeCycleModel, EventReportCode.EVENT_REPORT_REQUEST_CODE, str);
            this.adScopeCycleModel.setLoadStartTime(0L);
            this.adScopeCycleModel.setRequestStartTime(System.currentTimeMillis());
            httpRequestAds(new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.advertisings.BaseAdvertisingRouter.3
                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void failCallback(String str2, int i4) {
                    BaseAdvertisingRouter baseAdvertisingRouter = BaseAdvertisingRouter.this;
                    ErrorCode.ErrorCodeAdListener errorCodeAdListener4 = ErrorCode.ErrorCodeAdListener.ERROR_CODE_SERVER_REQUEST_ERROR;
                    baseAdvertisingRouter.doFailCallbackEvent(errorCodeAdListener4.getCode(), errorCodeAdListener4.getMessage());
                    String str3 = Constants.TAG;
                    LogUtil.i(str3, "msg : " + str2 + " code : " + i4);
                }

                @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                public void successCallback(String str2) {
                    System.currentTimeMillis();
                    String str3 = Constants.TAG;
                    LogUtil.i(str3, "result : " + str2);
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 200) {
                            String optString = jSONObject.optString("data");
                            LogUtil.i(Constants.TAG, "cache_ad_user \u4f7f\u7528\u4e86\u5b9e\u65f6\u8bf7\u6c42\u7684\u5e7f\u544a");
                            if (BaseAdvertisingRouter.this.adScopeCycleModel.isServerResponse()) {
                                AdCacheManager.getInstance().cacheAdData(BaseAdvertisingRouter.this.adScopeCycleModel, optString);
                            } else {
                                BaseAdvertisingRouter.this.doSuccessResult(optString);
                            }
                        } else {
                            BaseAdvertisingRouter.this.doFailCallbackEvent(optInt, jSONObject.optString("msg"));
                        }
                    } catch (Exception e4) {
                        BaseAdvertisingRouter.this.doFailCallbackEvent(ErrorCode.ErrorCodeAdListener.ERROR_CODE_AD_LISTENER_PARSE_JSON_EXCEPTION.getCode(), e4.toString());
                        String str4 = Constants.TAG;
                        LogUtil.i(str4, "e : " + e4);
                    }
                }
            });
            AdScopeCycleModel adScopeCycleModel2 = this.adScopeCycleModel;
            if (adScopeCycleModel2 == null || adScopeCycleModel2.isOpenCache()) {
                String readCacheAdStr = AdCacheManager.getInstance().readCacheAdStr(this.adScopeCycleModel);
                if (!TextUtils.isEmpty(readCacheAdStr)) {
                    AdCacheManager.getInstance().buildAdCacheTimerTask(this.timerOutTask, this.handler, this.adScopeCycleModel, readCacheAdStr);
                } else {
                    AdCacheManager.getInstance().requestForCache(this.adScopeCycleModel, this);
                }
            }
        }
    }

    @Override // xyz.adscope.ad.advertisings.inter.IAdvertising
    public boolean requestMonitoringControl(AdScopeCycleModel adScopeCycleModel) {
        return AdResponseManager.passStrategyControlWithCycleModel(adScopeCycleModel, this.iStrategyFrequency, this.iStrategyQuality);
    }

    public void setAdListener(IBaseAdListener iBaseAdListener) {
        this.iBaseLoadAdListener = iBaseAdListener;
    }

    public void setAdScopeCycleModel(AdScopeCycleModel adScopeCycleModel) {
        this.adScopeCycleModel = adScopeCycleModel;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.parentView = viewGroup;
    }
}
