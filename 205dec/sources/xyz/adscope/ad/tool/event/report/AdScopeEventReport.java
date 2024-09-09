package xyz.adscope.ad.tool.event.report;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.ad.config.AdInitConfig;
import xyz.adscope.ad.config.model.AdScopeGlobalModel;
import xyz.adscope.ad.constants.Constants;
import xyz.adscope.ad.control.render.model.AdScopeRenderCustomTrackerModel;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.model.custom.AdScopeCycleModel;
import xyz.adscope.ad.model.http.request.crash.CrashRequestModel;
import xyz.adscope.ad.model.http.response.config.ConfigureResponseModel;
import xyz.adscope.ad.model.http.response.config.EventModel;
import xyz.adscope.ad.tool.crash.CrashHandler;
import xyz.adscope.ad.tool.event.ASNPUtil;
import xyz.adscope.ad.tool.event.inter.IEventReportInterface;
import xyz.adscope.ad.tool.event.model.ASNPReportConfigModel;
import xyz.adscope.ad.tool.event.model.ASNPReportDBModel;
import xyz.adscope.ad.tool.event.model.AdScopeEventReportModel;
import xyz.adscope.ad.tool.event.model.EventReportCode;
import xyz.adscope.ad.tool.persistent.db.ASNPDataBaseManager;
import xyz.adscope.ad.tool.persistent.sp.AdScopeSpUtil;
import xyz.adscope.ad.tool.request.AdScopeHttpRequest;
import xyz.adscope.ad.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.ad.tool.thread.AdScopeThreadPool;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.info.deviceinfo.DeviceInfoUtil;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeEventReport implements IEventReportInterface {
    private static final String ACCESS_KEY = "ASNP";
    private static final String ACCESS_TYPE = "sdk";
    private static final String API_KEY = "apiKey";
    private static final String CUSTOM_ID = "adn";
    private static final String CUSTOM_LOGGER = "xyz.adscope.ad";
    private static final String EVENT_TIME_KEY = "eventTime";
    private static final String KEY_TABLE_NAME = "asnp_event_report_table";
    private static final String LMT_NO_PERMIT = "0";
    private static final String LMT_PERMIT = "1";
    private static final String LOG_VERSION = "5.0.0";
    private static AdScopeEventReport mInstance;
    private ASNPDataBaseManager asnpDataBaseManager;
    private AdScopeGlobalModel asnpGlobalModel;
    private boolean hasSendReport;
    private volatile Map<String, ASNPReportConfigModel> asnpReportConfigModelMap = null;
    private volatile List<AdScopeEventReportModel> asnpTempModelList = new ArrayList();
    private Timer timer = null;
    private TimerTask timerTask = null;
    private int INIT_TIME = 300;
    private int PERIOD_TIME = 300;

    private AdScopeEventReport() {
        if (AdScopeSDK.getContext() != null) {
            this.asnpDataBaseManager = new ASNPDataBaseManager(AdScopeSDK.getContext());
        }
        ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
        if (aSNPDataBaseManager != null) {
            aSNPDataBaseManager.setTableNameAndModel(KEY_TABLE_NAME, ASNPReportDBModel.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AdScopeEventReportModel> dbModelsToRequestModels(List<ASNPReportDBModel> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ASNPReportDBModel aSNPReportDBModel : list) {
            String decode = Base64Util.decode(aSNPReportDBModel.getEventJsonStr());
            if (!TextUtils.isEmpty(decode)) {
                decode = decode.replace("\\", "").replace("\"{", "{").replace("}\"", "}").replace("\"[", "[").replace("]\"", "]");
            }
            arrayList.add((AdScopeEventReportModel) new JSONParse().fromJson(decode, AdScopeEventReportModel.class));
        }
        return arrayList;
    }

    private List<AdScopeEventReportModel> deepCopyList(List<AdScopeEventReportModel> list) {
        ArrayList arrayList = new ArrayList();
        for (AdScopeEventReportModel adScopeEventReportModel : list) {
            arrayList.add(new AdScopeEventReportModel(adScopeEventReportModel));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOutTimeData() {
        long timeMillisBeforeDay = ASNPUtil.getTimeMillisBeforeDay(3);
        HashMap hashMap = new HashMap();
        hashMap.put("eventTime", Long.valueOf(timeMillisBeforeDay));
        ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
        if (aSNPDataBaseManager != null) {
            int deleteOutTime = aSNPDataBaseManager.deleteOutTime(hashMap);
            String str = Constants.TAG_REPORT;
            LogUtil.i(str, "deleteOutTimeResult : " + deleteOutTime);
        }
    }

    private void executeSendReport(List<AdScopeEventReportModel> list, ASNPReportConfigModel aSNPReportConfigModel, String str, String str2) {
        String macro = aSNPReportConfigModel.getMacro();
        String reportURL = aSNPReportConfigModel.getReportURL();
        String acceptEncrypt = aSNPReportConfigModel.getAcceptEncrypt();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            AdScopeEventReportModel adScopeEventReportModel = list.get(i4);
            if (adScopeEventReportModel != null && EventReportCode.EVENT_REPORT_CRASH_CODE.getCodeStr().equals(adScopeEventReportModel.getEvent_code())) {
                List<CrashRequestModel> crashData = CrashHandler.getInstance().getCrashData();
                if (crashData != null && crashData.size() > 0) {
                    for (CrashRequestModel crashRequestModel : crashData) {
                        adScopeEventReportModel.setAffiliated(crashRequestModel.getAffiliated());
                        adScopeEventReportModel.setException(crashRequestModel.getException());
                        adScopeEventReportModel.setLogTime(crashRequestModel.getLog_time());
                        arrayList.add(AdScopeModifyMacro.modifyMacroWithModel(adScopeEventReportModel, macro));
                    }
                }
            } else if (adScopeEventReportModel != null) {
                arrayList.add(AdScopeModifyMacro.modifyMacroWithModel(adScopeEventReportModel, macro));
            }
        }
        if (arrayList.size() > 0) {
            sendReportRequest(reportURL, arrayList.toString(), acceptEncrypt, str, list, str2);
        }
    }

    private ASNPReportConfigModel getASNPReportLoaderModel(String str) {
        if (this.asnpReportConfigModelMap != null && !this.asnpReportConfigModelMap.isEmpty()) {
            for (Map.Entry<String, ASNPReportConfigModel> entry : this.asnpReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        loadLogModelFromConfig();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ASNPReportDBModel> getEventCodeReportDBModels(String str) {
        if (this.asnpDataBaseManager == null || TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(API_KEY, str);
        return this.asnpDataBaseManager.query(hashMap);
    }

    public static AdScopeEventReport getInstance() {
        if (mInstance == null) {
            synchronized (AdScopeEventReport.class) {
                if (mInstance == null) {
                    mInstance = new AdScopeEventReport();
                }
            }
        }
        return mInstance;
    }

    private String getKeyByEventCode(String str) {
        if (this.asnpReportConfigModelMap != null && !this.asnpReportConfigModelMap.isEmpty()) {
            for (Map.Entry<String, ASNPReportConfigModel> entry : this.asnpReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private long getTimerDuration(AdScopeEventReportModel adScopeEventReportModel) {
        if (adScopeEventReportModel == null) {
            return 0L;
        }
        String event_code = adScopeEventReportModel.getEvent_code();
        if (this.asnpReportConfigModelMap != null && !this.asnpReportConfigModelMap.isEmpty()) {
            ASNPReportConfigModel aSNPReportConfigModel = null;
            for (Map.Entry<String, ASNPReportConfigModel> entry : this.asnpReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(event_code)) {
                    aSNPReportConfigModel = entry.getValue();
                }
            }
            if (aSNPReportConfigModel == null || TextUtils.isEmpty(aSNPReportConfigModel.getTime())) {
                return 0L;
            }
            return Long.parseLong(aSNPReportConfigModel.getTime());
        }
        loadLogModelFromConfig();
        return 0L;
    }

    private AdScopeEventReportModel initAdScopeEventReportModel(String str) {
        AdScopeEventReportModel adScopeEventReportModel = new AdScopeEventReportModel();
        adScopeEventReportModel.setLog_version("5.0.0");
        adScopeEventReportModel.setAccessKey("ASNP");
        adScopeEventReportModel.setCustomId("adn");
        adScopeEventReportModel.setCustomLogger("xyz.adscope.ad");
        adScopeEventReportModel.setAccessType("sdk");
        adScopeEventReportModel.setAdSdkVersion("5.1.0.13");
        AdInitConfig globalAdInitConfig = InitImplement.getInstance().getGlobalAdInitConfig(str);
        if (globalAdInitConfig != null) {
            setKeywordArray(adScopeEventReportModel, globalAdInitConfig);
            if (!TextUtils.isEmpty(globalAdInitConfig.getCoaid())) {
                adScopeEventReportModel.setCustom_oaid(globalAdInitConfig.getCoaid());
            }
            if (!TextUtils.isEmpty(globalAdInitConfig.getCgaid())) {
                adScopeEventReportModel.setCustom_gaid(globalAdInitConfig.getCgaid());
            }
        }
        DeviceInfo deviceInfo = AdScopeSDK.getContext() != null ? DeviceInfo.getInstance(AdScopeSDK.getContext()) : null;
        if (deviceInfo != null) {
            adScopeEventReportModel.setSaid(deviceInfo.getSdkid());
            adScopeEventReportModel.setDevice_name(deviceInfo.getDeviceName());
            adScopeEventReportModel.setDevice_type(deviceInfo.getDeviceType());
            adScopeEventReportModel.setBrand(deviceInfo.getBrand());
            adScopeEventReportModel.setModel(deviceInfo.getModel());
            adScopeEventReportModel.setMake(deviceInfo.getManufacturer());
            adScopeEventReportModel.setRam_byte(deviceInfo.getPhysicalMemory());
            adScopeEventReportModel.setStorage_byte(deviceInfo.getHardDiskSize());
            adScopeEventReportModel.setResolution_width(deviceInfo.getResolutionWidth());
            adScopeEventReportModel.setResolution_height(deviceInfo.getResolutionHeight());
            if (!TextUtils.isEmpty(deviceInfo.getDensity())) {
                adScopeEventReportModel.setDensity(Float.valueOf(Float.parseFloat(deviceInfo.getDensity())));
            }
            adScopeEventReportModel.setOrientation(deviceInfo.getOrientation());
            adScopeEventReportModel.setOs(deviceInfo.getOs());
            adScopeEventReportModel.setOs_version(deviceInfo.getOsVersion());
            adScopeEventReportModel.setUa(deviceInfo.getUserAgent());
            adScopeEventReportModel.setTime_zone(deviceInfo.getTimeZone());
            adScopeEventReportModel.setLanguage(deviceInfo.getLanguage());
            adScopeEventReportModel.setCountry(deviceInfo.getCountry());
            adScopeEventReportModel.setCarrier(deviceInfo.getCarrier());
            adScopeEventReportModel.setUpdateMark(deviceInfo.getUpdateMark());
            if (!TextUtils.isEmpty(deviceInfo.getConnectType())) {
                adScopeEventReportModel.setConnect_type(Integer.parseInt(deviceInfo.getConnectType()));
            }
            adScopeEventReportModel.setSystem_boot_mark(deviceInfo.getBootMark());
            adScopeEventReportModel.setSystem_update_mark(deviceInfo.getUpdateMark());
            adScopeEventReportModel.setSystem_file_mark(deviceInfo.getFileMark());
            if (globalAdInitConfig != null ? globalAdInitConfig.getPersonalRecommend() : true) {
                adScopeEventReportModel.setOaid(deviceInfo.getOaid());
                adScopeEventReportModel.setGaid(deviceInfo.getGaid());
                setOaidAndGaid(adScopeEventReportModel);
            }
        }
        if (AdScopeSDK.getContext() != null) {
            adScopeEventReportModel.setApp_name(AppInfo.getAppName(AdScopeSDK.getContext()));
            adScopeEventReportModel.setApp_version(AppInfo.getAppVersionName(AdScopeSDK.getContext()));
            adScopeEventReportModel.setApp_bundle(AppInfo.getPackName(AdScopeSDK.getContext()));
            adScopeEventReportModel.setInstallTime(AppInfo.getInstallDate(AdScopeSDK.getContext()) + "");
            adScopeEventReportModel.setUpdateTime(AppInfo.getLastUpdateTime(AdScopeSDK.getContext()) + "");
        }
        return adScopeEventReportModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportAdEvent$1(AdScopeCycleModel adScopeCycleModel, EventReportCode eventReportCode, String str) {
        reportEvent(adScopeCycleModel, eventReportCode.getCodeStr(), str, adScopeCycleModel.getApiKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reportInitEvent$0(EventReportCode eventReportCode, String str, String str2) {
        reportEvent(null, eventReportCode.getCodeStr(), str, str2);
    }

    private synchronized void reportEvent(AdScopeCycleModel adScopeCycleModel, String str, String str2, String str3) {
        uploadLog(buildASNPRequestReportModel(adScopeCycleModel, str, str2, str3), str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendRealTimeReport(String str, String str2) {
        if (this.hasSendReport) {
            return;
        }
        this.hasSendReport = true;
        String str3 = Constants.TAG_REPORT;
        LogUtil.i(str3, "report_timer_log\uff0c\u6700\u7ec8\u7684evenCode : " + str);
        List<AdScopeEventReportModel> deepCopyList = deepCopyList(this.asnpTempModelList);
        this.asnpTempModelList.clear();
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.timerTask = null;
        }
        sendReportLog(deepCopyList, str, str2);
        this.hasSendReport = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReportLocalLog(List<AdScopeEventReportModel> list, String str, String str2) {
        ASNPReportConfigModel aSNPReportLoaderModel = getASNPReportLoaderModel(str);
        if (aSNPReportLoaderModel == null || TextUtils.isEmpty(getKeyByEventCode(str))) {
            return;
        }
        executeSendReport(list, aSNPReportLoaderModel, str, str2);
    }

    private void sendReportLog(List<AdScopeEventReportModel> list, String str, String str2) {
        ASNPReportConfigModel aSNPReportLoaderModel = getASNPReportLoaderModel(str);
        if (aSNPReportLoaderModel == null || TextUtils.isEmpty(getKeyByEventCode(str))) {
            return;
        }
        executeSendReport(list, aSNPReportLoaderModel, str, str2);
    }

    private void sendReportRequest(final String str, final String str2, final String str3, String str4, final List<AdScopeEventReportModel> list, final String str5) {
        String str6 = Constants.TAG_REPORT;
        LogUtil.i(str6, "sendReportRequest : eventCode : " + str4 + " , url " + str + " , macro : " + str2);
        AdScopeThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.ad.tool.event.report.AdScopeEventReport.2
            @Override // java.lang.Runnable
            public void run() {
                ASNPUtil.updateNetWorkConfig(str3);
                AdScopeHttpRequest adScopeHttpRequest = new AdScopeHttpRequest();
                adScopeHttpRequest.setAcceptEncrypt(str3);
                adScopeHttpRequest.requestWithPostMethod(str, str2, new IHttpResponseCallback<String>() { // from class: xyz.adscope.ad.tool.event.report.AdScopeEventReport.2.1
                    @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                    public void failCallback(String str7, int i4) {
                        String str8 = Constants.TAG_REPORT;
                        LogUtil.i(str8, "sendReportRequest failed message : " + str7 + " , code : " + i4);
                    }

                    @Override // xyz.adscope.ad.tool.request.inter.IHttpResponseCallback
                    public void successCallback(String str7) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AdScopeEventReport.this.deleteLog(list, str5);
                        LogUtil.i(Constants.TAG_REPORT, "sendReportRequest success");
                    }
                });
            }
        });
    }

    private void setKeywordArray(AdScopeEventReportModel adScopeEventReportModel, AdInitConfig adInitConfig) {
        Map<String, String> optionalFields;
        if (adInitConfig == null || (optionalFields = adInitConfig.getOptionalFields()) == null || optionalFields.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : optionalFields.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(jSONObject.toString()) || "null".equals(jSONObject.toString())) {
            return;
        }
        adScopeEventReportModel.setKeywordArray(jSONObject.toString());
    }

    private void setOaidAndGaid(AdScopeEventReportModel adScopeEventReportModel) {
        String str;
        String str2 = "";
        if (AdScopeSDK.getContext() != null) {
            str2 = AdScopeSpUtil.getString(CommonConstants.DEVICE_OAID_KEY);
            str = AdScopeSpUtil.getString(CommonConstants.DEVICE_GAID_KEY);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str2)) {
            adScopeEventReportModel.setOoaid(str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        adScopeEventReportModel.setOgaid(str);
    }

    private boolean shouldUploadLog(AdScopeEventReportModel adScopeEventReportModel) {
        if (adScopeEventReportModel == null) {
            return false;
        }
        String event_code = adScopeEventReportModel.getEvent_code();
        if (this.asnpReportConfigModelMap != null && !this.asnpReportConfigModelMap.isEmpty()) {
            ASNPReportConfigModel aSNPReportConfigModel = null;
            for (Map.Entry<String, ASNPReportConfigModel> entry : this.asnpReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(event_code)) {
                    aSNPReportConfigModel = entry.getValue();
                }
            }
            return (aSNPReportConfigModel == null || this.asnpTempModelList == null || this.asnpTempModelList.isEmpty() || this.asnpTempModelList.size() < Integer.parseInt(aSNPReportConfigModel.getCount())) ? false : true;
        }
        loadLogModelFromConfig();
        return false;
    }

    public AdScopeEventReportModel buildASNPRequestReportModel(AdScopeCycleModel adScopeCycleModel, String str, String str2, String str3) {
        AdScopeGlobalModel apiModelWithApiKey = InitImplement.getInstance().getApiModelWithApiKey(str3);
        AdScopeEventReportModel initAdScopeEventReportModel = initAdScopeEventReportModel(str3);
        initAdScopeEventReportModel.setRoundTripTime(str2);
        if (apiModelWithApiKey != null) {
            initAdScopeEventReportModel.setStartId(apiModelWithApiKey.getStartId());
            initAdScopeEventReportModel.setSessionId(apiModelWithApiKey.getSessionId());
            initAdScopeEventReportModel.setOrg_key(str3);
            initAdScopeEventReportModel.setApp_lmt(apiModelWithApiKey.getSettings().getPersonalRecommend() ? "1" : "0");
            initAdScopeEventReportModel.setEvent_id(apiModelWithApiKey.getEventId());
            initAdScopeEventReportModel.setEvent_time(DeviceInfoUtil.getTimeStamp() + "");
            if (str.equals(EventReportCode.EVENT_REPORT_INIT_CODE.getCodeStr())) {
                initAdScopeEventReportModel.setEvent_time(apiModelWithApiKey.getSdkInitStartTime() + "");
            }
            initAdScopeEventReportModel.setApp_id(apiModelWithApiKey.getAppId());
            ConfigureResponseModel configureModel = apiModelWithApiKey.getConfigureModel();
            if (configureModel != null) {
                initAdScopeEventReportModel.setUpdate_md5(configureModel.getUpdateMD5());
                initAdScopeEventReportModel.setRequestUrl_md5(configureModel.getRequestUrlMD5());
                initAdScopeEventReportModel.setStrategy_md5(configureModel.getStrategyMD5());
                initAdScopeEventReportModel.setTemplate_md5(configureModel.getTemplateMD5());
                initAdScopeEventReportModel.setPreload_md5(configureModel.getPreloadMD5());
                initAdScopeEventReportModel.setStatistics_md5(configureModel.getStatisticsMD5());
            }
        }
        initAdScopeEventReportModel.setEvent_code(str);
        initAdScopeEventReportModel.setLog_time(DeviceInfoUtil.getTimeStamp() + "");
        if (adScopeCycleModel != null) {
            initAdScopeEventReportModel.setSessionId(adScopeCycleModel.getSessionId());
            initAdScopeEventReportModel.setEvent_id(adScopeCycleModel.getEventId());
            initAdScopeEventReportModel.setEvent_time(DeviceInfoUtil.getTimeStamp() + "");
            initAdScopeEventReportModel.setTimeout(adScopeCycleModel.getTimeoutInterval());
            initAdScopeEventReportModel.setAd_space_id(adScopeCycleModel.getSpaceId());
            initAdScopeEventReportModel.setAd_space_type(adScopeCycleModel.getSpaceType());
            initAdScopeEventReportModel.setDsp_id(adScopeCycleModel.getDspId());
            initAdScopeEventReportModel.setPrice(adScopeCycleModel.getPrice());
            initAdScopeEventReportModel.setRender_plan_id(adScopeCycleModel.getRenderPlanId());
            initAdScopeEventReportModel.setInteraction_plan_id(adScopeCycleModel.getInteractPlanId());
            AdScopeRenderCustomTrackerModel adScopeRenderCustomTrackerModel = adScopeCycleModel.getAdScopeRenderCustomTrackerModel();
            if (adScopeRenderCustomTrackerModel != null) {
                initAdScopeEventReportModel.setClick_type(adScopeRenderCustomTrackerModel.getClickType() + "");
            }
            initAdScopeEventReportModel.setClick_results(adScopeCycleModel.getClickResults());
            initAdScopeEventReportModel.setError_code(adScopeCycleModel.getErrorCode());
            initAdScopeEventReportModel.setError_info(adScopeCycleModel.getErrorInfo());
            initAdScopeEventReportModel.setOrderId(adScopeCycleModel.getOrderId());
            initAdScopeEventReportModel.setCreateId(adScopeCycleModel.getCreateId());
            initAdScopeEventReportModel.setMaterialId(adScopeCycleModel.getMaterialId());
            initAdScopeEventReportModel.setMaxWaitTime(adScopeCycleModel.getTimeoutInterval() + "");
            initAdScopeEventReportModel.setAdType(adScopeCycleModel.getSpaceType());
            initAdScopeEventReportModel.setCurrency(adScopeCycleModel.getCurrency());
            initAdScopeEventReportModel.setQuantity(adScopeCycleModel.getAdCount() + "");
            initAdScopeEventReportModel.setIsWin(adScopeCycleModel.getIsWin());
            initAdScopeEventReportModel.setWinPrice(adScopeCycleModel.getWinPrice());
            initAdScopeEventReportModel.setExpPrice(adScopeCycleModel.getPrice());
            initAdScopeEventReportModel.setComplain(adScopeCycleModel.getComplainContent());
        }
        return initAdScopeEventReportModel;
    }

    public Map<String, List<AdScopeEventReportModel>> buildEventCodeMap(List<AdScopeEventReportModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (AdScopeEventReportModel adScopeEventReportModel : list) {
            String event_code = adScopeEventReportModel.getEvent_code();
            List list2 = (List) hashMap.get(event_code);
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(event_code, list2);
            }
            list2.add(adScopeEventReportModel);
        }
        return hashMap;
    }

    @Override // xyz.adscope.ad.tool.event.inter.IEventReportInterface
    public void deleteLog(List<AdScopeEventReportModel> list, String str) {
        if (list == null || list.size() < 1) {
            return;
        }
        for (AdScopeEventReportModel adScopeEventReportModel : list) {
            HashMap hashMap = new HashMap();
            if (adScopeEventReportModel != null && !TextUtils.isEmpty(adScopeEventReportModel.getEvent_time())) {
                hashMap.put("eventTime", Long.valueOf(Long.parseLong(adScopeEventReportModel.getEvent_time())));
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(API_KEY, str);
            }
            ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
            if (aSNPDataBaseManager != null) {
                aSNPDataBaseManager.delete(hashMap);
            }
        }
    }

    public void loadLogModelFromConfig() {
        ConfigureResponseModel configureModel;
        List<EventModel> event;
        EventModel next;
        List<String> codes;
        AdScopeGlobalModel globalModel = InitImplement.getInstance().getGlobalModel();
        this.asnpGlobalModel = globalModel;
        if (globalModel == null || (configureModel = globalModel.getConfigureModel()) == null || configureModel.getStatistics() == null || configureModel.getStatistics().getEvent() == null || (event = configureModel.getStatistics().getEvent()) == null || event.size() < 1) {
            return;
        }
        this.asnpReportConfigModelMap = new HashMap();
        Iterator<EventModel> it = event.iterator();
        while (it.hasNext() && (codes = (next = it.next()).getCodes()) != null && !codes.isEmpty()) {
            String obj = codes.toString();
            ASNPReportConfigModel aSNPReportConfigModel = new ASNPReportConfigModel();
            aSNPReportConfigModel.setReportURL(next.getUploadUrl());
            aSNPReportConfigModel.setCode(obj);
            aSNPReportConfigModel.setCount(next.getCount() + "");
            aSNPReportConfigModel.setMacro(next.getMacros());
            aSNPReportConfigModel.setAcceptEncrypt(next.getAcceptEncrypt());
            aSNPReportConfigModel.setTime(next.getTime());
            this.asnpReportConfigModelMap.put(obj, aSNPReportConfigModel);
        }
    }

    public void loadLogsFromDatabase(final String str) {
        AdScopeThreadPool.getSingleExecutorService().scheduleWithFixedDelay(new Runnable() { // from class: xyz.adscope.ad.tool.event.report.AdScopeEventReport.1
            @Override // java.lang.Runnable
            public void run() {
                List<AdScopeEventReportModel> dbModelsToRequestModels;
                Map<String, List<AdScopeEventReportModel>> buildEventCodeMap;
                LogUtil.i(Constants.TAG_REPORT, "report_timer_log\uff0c\u672c\u5730\u4efb\u52a1\u67e5\u8be2\u6570\u636e\u5e93");
                AdScopeEventReport.this.deleteOutTimeData();
                List eventCodeReportDBModels = AdScopeEventReport.this.getEventCodeReportDBModels(str);
                if (eventCodeReportDBModels == null || eventCodeReportDBModels.isEmpty() || (dbModelsToRequestModels = AdScopeEventReport.this.dbModelsToRequestModels(eventCodeReportDBModels)) == null || dbModelsToRequestModels.isEmpty() || (buildEventCodeMap = AdScopeEventReport.this.buildEventCodeMap(dbModelsToRequestModels)) == null || buildEventCodeMap.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, List<AdScopeEventReportModel>> entry : buildEventCodeMap.entrySet()) {
                    AdScopeEventReport.this.sendReportLocalLog(entry.getValue(), entry.getKey(), "");
                }
            }
        }, this.INIT_TIME, this.PERIOD_TIME, TimeUnit.SECONDS);
    }

    public synchronized void reportAdEvent(final AdScopeCycleModel adScopeCycleModel, final EventReportCode eventReportCode, final String str) {
        AdScopeThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.ad.tool.event.report.a
            @Override // java.lang.Runnable
            public final void run() {
                AdScopeEventReport.this.lambda$reportAdEvent$1(adScopeCycleModel, eventReportCode, str);
            }
        });
    }

    public synchronized void reportInitEvent(AdScopeGlobalModel adScopeGlobalModel, final EventReportCode eventReportCode, final String str, final String str2) {
        AdScopeThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.ad.tool.event.report.b
            @Override // java.lang.Runnable
            public final void run() {
                AdScopeEventReport.this.lambda$reportInitEvent$0(eventReportCode, str, str2);
            }
        });
    }

    @Override // xyz.adscope.ad.tool.event.inter.IEventReportInterface
    public void saveLog(AdScopeEventReportModel adScopeEventReportModel, String str) {
        ASNPReportDBModel aSNPReportDBModel = new ASNPReportDBModel();
        aSNPReportDBModel.setEventJsonStr(Base64Util.encode(new JSONParse().toJson(adScopeEventReportModel)));
        aSNPReportDBModel.setEventCode(adScopeEventReportModel.getEvent_code());
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEvent_time())) {
            aSNPReportDBModel.setEventTime(Long.parseLong(adScopeEventReportModel.getEvent_time()));
        }
        if (!TextUtils.isEmpty(str)) {
            aSNPReportDBModel.setApiKey(str);
        }
        aSNPReportDBModel.setEventId(adScopeEventReportModel.getEvent_id());
        ASNPDataBaseManager aSNPDataBaseManager = this.asnpDataBaseManager;
        if (aSNPDataBaseManager != null) {
            long longValue = aSNPDataBaseManager.insert(aSNPReportDBModel).longValue();
            String str2 = Constants.TAG_REPORT;
            LogUtil.i(str2, "insertResult : " + longValue);
        }
    }

    @Override // xyz.adscope.ad.tool.event.inter.IEventReportInterface
    public void uploadLog(final AdScopeEventReportModel adScopeEventReportModel, final String str) {
        if (adScopeEventReportModel != null) {
            String str2 = Constants.TAG_REPORT;
            LogUtil.i(str2, " code : " + adScopeEventReportModel.getEvent_code());
        }
        saveLog(adScopeEventReportModel, str);
        if (this.asnpTempModelList != null) {
            this.asnpTempModelList.add(adScopeEventReportModel);
        }
        if (this.asnpTempModelList.size() > 0) {
            if (this.asnpTempModelList.size() == 1) {
                long timerDuration = getTimerDuration(adScopeEventReportModel);
                this.timer = new Timer();
                TimerTask timerTask = new TimerTask() { // from class: xyz.adscope.ad.tool.event.report.AdScopeEventReport.3
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        AdScopeEventReport.this.sendRealTimeReport(adScopeEventReportModel.getEvent_code(), str);
                    }
                };
                this.timerTask = timerTask;
                this.timer.schedule(timerTask, timerDuration);
            } else if (shouldUploadLog(adScopeEventReportModel)) {
                sendRealTimeReport(adScopeEventReportModel.getEvent_code(), str);
            }
        }
    }
}
