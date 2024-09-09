package xyz.adscope.ad.config;

import android.text.TextUtils;
import org.json.JSONObject;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.config.inter.IAdConfig;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.config.model.ConfigResponseInfo;
import xyz.adscope.ad.config.task.AdScopeAppLinkTask;
import xyz.adscope.ad.config.task.AdScopeTemplateUpdateTask;
import xyz.adscope.ad.config.task.scheduler.AdConfigSchedulerTask;
import xyz.adscope.ad.constants.ConstantConfig;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.init.constant.InitError;
import xyz.adscope.ad.init.inter.InitCallback;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;
import xyz.adscope.ad.model.http.request.config.ConfigRequestInfo;
import xyz.adscope.ad.model.http.response.config.ConfigureResponseModel;
import xyz.adscope.ad.model.http.response.config.UpdateModel;
import xyz.adscope.ad.tool.crash.CrashRouter;
import xyz.adscope.ad.tool.crash.inter.ICrashRouter;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.event.report.AdScopeEventReport;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.task.TimerOutTask;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.AesUtil;
import xyz.adscope.common.tool.security.Base64Util;
import xyz.adscope.common.tool.security.GzipUtil;
import xyz.adscope.common.tool.security.KeyGenerator;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdConfigManager implements IAdConfig {
    private AdConfigSchedulerTask adConfigSchedulerTask;
    private ConfigResponseInfo responseInfo;
    private ICrashRouter iCrashRouter = new CrashRouter();
    private IHttpRequest iHttpRequest = new AdScopeHttpRequest();
    private String apiKey = "AdScopeADN";
    private TimerOutTask timerOutTask = new TimerOutTask();

    private void cacheLocalConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AdScopeSpUtil.putString(ConstantConfig.GLOBALCONFIG, AesUtil.encrypt(KeyGenerator.generateAesKey(), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFailCallback(AdScopeGlobalModel adScopeGlobalModel, InitCallback initCallback, int i4, String str) {
        if (initCallback != null) {
            long currentTimeMillis = System.currentTimeMillis() - adScopeGlobalModel.getSdkInitStartTime();
            AdScopeEventReport adScopeEventReport = AdScopeEventReport.getInstance();
            EventReportCode eventReportCode = EventReportCode.EVENT_REPORT_INIT_FAIL_CODE;
            adScopeEventReport.reportInitEvent(adScopeGlobalModel, eventReportCode, currentTimeMillis + "", this.apiKey);
            initCallback.fail(i4, str);
            this.timerOutTask.setIsExecuteConfig(true);
            this.timerOutTask.cancelTimerTask();
        }
        AdScopeEventReport.getInstance().loadLogModelFromConfig();
        AdScopeEventReport.getInstance().loadLogsFromDatabase(this.apiKey);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_CRASH_CODE, "", this.apiKey);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_INIT_CODE, "", this.apiKey);
        String str2 = Constants.TAG;
        LogUtil.i(str2, "msg : " + str + " code : " + i4);
    }

    private void syncLocalOrCacheConfig(AdScopeGlobalModel adScopeGlobalModel, InitCallback initCallback, String str) {
        if (checkConfig()) {
            requestConfigureWithChannel(adScopeGlobalModel, initCallback);
            return;
        }
        ConfigureResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
        adScopeGlobalModel.setConfigureModel(configureResponseModel);
        String str2 = Constants.TAG;
        LogUtil.i(str2, "configureResponseModel " + configureResponseModel);
        if (configureResponseModel != null) {
            if (initCallback != null) {
                long currentTimeMillis = System.currentTimeMillis() - adScopeGlobalModel.getSdkInitStartTime();
                AdScopeEventReport adScopeEventReport = AdScopeEventReport.getInstance();
                EventReportCode eventReportCode = EventReportCode.EVENT_REPORT_INIT_SUCCESS_CODE;
                adScopeEventReport.reportInitEvent(adScopeGlobalModel, eventReportCode, currentTimeMillis + "", str);
                String str3 = Constants.TAG;
                LogUtil.i(str3, "cost_time_ : initRoundTripTime 101010 \u6700\u540e\u65f6\u95f4 : " + currentTimeMillis);
                adScopeGlobalModel.setInitSuccess(true);
                initCallback.success();
                this.timerOutTask.cancelTimerTask();
            }
        } else if (initCallback != null) {
            long currentTimeMillis2 = System.currentTimeMillis() - adScopeGlobalModel.getSdkInitStartTime();
            AdScopeEventReport adScopeEventReport2 = AdScopeEventReport.getInstance();
            EventReportCode eventReportCode2 = EventReportCode.EVENT_REPORT_INIT_FAIL_CODE;
            adScopeEventReport2.reportInitEvent(adScopeGlobalModel, eventReportCode2, currentTimeMillis2 + "", str);
            InitError.INIT_ERROR init_error = InitError.INIT_ERROR.ERROR_INIT_FAIL;
            initCallback.fail(init_error.getCode(), init_error.getValue());
            this.timerOutTask.cancelTimerTask();
        }
        AdScopeEventReport.getInstance().loadLogModelFromConfig();
        AdScopeEventReport.getInstance().loadLogsFromDatabase(str);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_CRASH_CODE, "", str);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_INIT_CODE, "", str);
    }

    public boolean checkConfig() {
        try {
            ConfigureResponseModel configureResponseModel = this.responseInfo.getConfigureResponseModel();
            if (configureResponseModel == null) {
                return false;
            }
            long timeStamp = DeviceInfoUtil.getTimeStamp() / 1000;
            long lastUpdateTime = configureResponseModel.getLastUpdateTime();
            UpdateModel update = configureResponseModel.getUpdate();
            if (update == null) {
                return false;
            }
            return timeStamp > lastUpdateTime && timeStamp - lastUpdateTime > update.getMaxExpireTime();
        } catch (Exception e4) {
            String str = Constants.TAG;
            LogUtil.e(str, "e : " + e4);
            return false;
        }
    }

    @Override // xyz.adscope.ad.config.inter.IAdConfig
    public void initConfigureFileWithChannel(final AdInitConfig adInitConfig, InitCallback initCallback) {
        AdScopeGlobalModel adScopeGlobalModel;
        if (adInitConfig == null || TextUtils.isEmpty(adInitConfig.getApiKey())) {
            adScopeGlobalModel = null;
        } else {
            this.apiKey = adInitConfig.getApiKey();
            adScopeGlobalModel = InitImplement.getInstance().getApiModelWithApiKey(this.apiKey);
        }
        if (this.responseInfo == null) {
            this.responseInfo = ConfigResponseInfo.getInstance();
        }
        if (!this.responseInfo.isInit()) {
            this.responseInfo.init();
        }
        String str = Constants.TAG;
        LogUtil.i(str, "cost_time_ : initRoundTripTime 44444 : " + (System.currentTimeMillis() - adScopeGlobalModel.getSdkInitStartTime()));
        AdScopeThreadPool.getInitRequestPool().execute(new Runnable() { // from class: xyz.adscope.ad.config.AdConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                AdInitConfig adInitConfig2 = adInitConfig;
                if (adInitConfig2 == null || !adInitConfig2.getPersonalRecommend()) {
                    return;
                }
                DeviceInfoUtil.initOaid(AdScopeSDK.getContext());
            }
        });
        if (this.iCrashRouter.lastLaunchCrashedBecauseOfSDK()) {
            requestConfigureWithChannel(adScopeGlobalModel, initCallback);
            return;
        }
        syncLocalOrCacheConfig(adScopeGlobalModel, initCallback, this.apiKey);
        startConfigureServerWithChannel(adScopeGlobalModel);
    }

    @Override // xyz.adscope.ad.config.inter.IAdConfig
    public void requestConfigureWithChannel(final AdScopeGlobalModel adScopeGlobalModel, final InitCallback initCallback) {
        String decode;
        this.timerOutTask.buildConfigTimerTask();
        this.timerOutTask.setInitCallback(initCallback);
        ConfigResponseInfo configResponseInfo = this.responseInfo;
        if (configResponseInfo != null && configResponseInfo.getRequestUrlModel() != null && !TextUtils.isEmpty(this.responseInfo.getRequestUrlModel().getConfigUrl())) {
            decode = this.responseInfo.getRequestUrlModel().getConfigUrl();
        } else {
            decode = Base64Util.decode(InitImplement.getInstance().isUseHttps() ? ConstantConfig.CONFIG_REQUEST_URL_TRANSFER_PROTOCOL : ConstantConfig.CONFIG_REQUEST_URL);
        }
        ConfigRequestInfo configRequestInfo = ConfigRequestInfo.getInstance();
        if (!configRequestInfo.isInit) {
            configRequestInfo.init(adScopeGlobalModel.getSettings());
        }
        String json = new JSONParse().toJson(configRequestInfo.getConfigureRequestModel());
        String str = Constants.TAG;
        LogUtil.i(str, "\u914d\u7f6e\u8bf7\u6c42URL request : " + decode + " , requestParams : " + json);
        this.iHttpRequest.doRequestWithJson(decode, json, new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.config.AdConfigManager.2
            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str2, int i4) {
                AdConfigManager.this.doFailCallback(adScopeGlobalModel, initCallback, i4, str2);
            }

            @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str2) {
                String str3 = Constants.TAG;
                LogUtil.i(str3, "result : " + str2);
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.optInt("code") == 200) {
                        String decompressForGzip = GzipUtil.decompressForGzip(AesUtil.decrypt(KeyGenerator.generateAesKey(), jSONObject.optString("data")));
                        if (!TextUtils.isEmpty(decompressForGzip) && !decompressForGzip.equals("null") && !decompressForGzip.equals("{}")) {
                            LogUtil.i(Constants.TAG, "AdConfig successCallback ");
                            if (initCallback != null) {
                                long currentTimeMillis = System.currentTimeMillis() - adScopeGlobalModel.getSdkInitStartTime();
                                AdScopeEventReport adScopeEventReport = AdScopeEventReport.getInstance();
                                AdScopeGlobalModel adScopeGlobalModel2 = adScopeGlobalModel;
                                EventReportCode eventReportCode = EventReportCode.EVENT_REPORT_INIT_SUCCESS_CODE;
                                adScopeEventReport.reportInitEvent(adScopeGlobalModel2, eventReportCode, currentTimeMillis + "", AdConfigManager.this.apiKey);
                                initCallback.success();
                                adScopeGlobalModel.setInitSuccess(true);
                                AdConfigManager.this.timerOutTask.setIsExecuteConfig(true);
                                AdConfigManager.this.timerOutTask.cancelTimerTask();
                            }
                            AdConfigManager.this.updateConfigureWithChannel(adScopeGlobalModel, decompressForGzip);
                            return;
                        }
                        AdConfigManager adConfigManager = AdConfigManager.this;
                        AdScopeGlobalModel adScopeGlobalModel3 = adScopeGlobalModel;
                        InitCallback initCallback2 = initCallback;
                        InitError.INIT_ERROR init_error = InitError.INIT_ERROR.ERROR_CONFIG_RESPONSE_ERROR;
                        adConfigManager.doFailCallback(adScopeGlobalModel3, initCallback2, init_error.getCode(), init_error.getValue());
                    }
                } catch (Exception e4) {
                    AdConfigManager adConfigManager2 = AdConfigManager.this;
                    AdScopeGlobalModel adScopeGlobalModel4 = adScopeGlobalModel;
                    InitCallback initCallback3 = initCallback;
                    InitError.INIT_ERROR init_error2 = InitError.INIT_ERROR.ERROR_CONFIG_PARSE_FAIL;
                    adConfigManager2.doFailCallback(adScopeGlobalModel4, initCallback3, init_error2.getCode(), init_error2.getValue());
                    String str4 = Constants.TAG;
                    LogUtil.i(str4, "e : " + e4);
                }
            }
        });
    }

    @Override // xyz.adscope.ad.config.inter.IAdConfig
    public void startConfigureServerWithChannel(AdScopeGlobalModel adScopeGlobalModel) {
        if (this.adConfigSchedulerTask == null) {
            AdConfigSchedulerTask adConfigSchedulerTask = new AdConfigSchedulerTask(this);
            this.adConfigSchedulerTask = adConfigSchedulerTask;
            adConfigSchedulerTask.setAdScopeGlobalModel(adScopeGlobalModel);
        }
        this.adConfigSchedulerTask.startSchedulerTask();
    }

    @Override // xyz.adscope.ad.config.inter.IAdConfig
    public void updateConfigureWithChannel(AdScopeGlobalModel adScopeGlobalModel, String str) {
        this.responseInfo.parseResponse(str);
        AdScopeSpUtil.put(AdRequestConstant.CRASH_REASON_ADSCOPE_KEY, Boolean.FALSE);
        adScopeGlobalModel.setConfigureModel(this.responseInfo.getConfigureResponseModel());
        AdScopeEventReport.getInstance().loadLogModelFromConfig();
        AdScopeEventReport.getInstance().loadLogsFromDatabase(this.apiKey);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_CRASH_CODE, "", this.apiKey);
        AdScopeEventReport.getInstance().reportInitEvent(adScopeGlobalModel, EventReportCode.EVENT_REPORT_INIT_CODE, "", this.apiKey);
        if (this.responseInfo.getUpdateModel() != null) {
            long checkInterval = this.responseInfo.getUpdateModel().getCheckInterval();
            LogUtil.d(Constants.TAG, checkInterval + "===============heartbeat=============" + checkInterval);
            if (this.adConfigSchedulerTask == null) {
                AdConfigSchedulerTask adConfigSchedulerTask = new AdConfigSchedulerTask(this);
                this.adConfigSchedulerTask = adConfigSchedulerTask;
                adConfigSchedulerTask.setAdScopeGlobalModel(adScopeGlobalModel);
            }
            if (checkInterval != this.adConfigSchedulerTask.getHeartbeatTime() && checkInterval != 0) {
                this.adConfigSchedulerTask.setHeartBeatTime(checkInterval);
                this.adConfigSchedulerTask.startSchedulerTask();
            }
        }
        if (this.responseInfo.getStatisticsModel() != null) {
            AdScopeThreadPool.getInitRequestPool().execute(new AdScopeAppLinkTask(AdScopeSDK.getContext(), this.responseInfo.getStatisticsModel().getTask(), this.apiKey));
        }
        if (this.responseInfo.getTemplateModelList() == null || this.responseInfo.getTemplateModelList().size() <= 0) {
            return;
        }
        AdScopeThreadPool.getInitRequestPool().execute(new AdScopeTemplateUpdateTask(this.responseInfo.getTemplateModelList()));
    }
}
