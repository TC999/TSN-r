package xyz.adscope.amps.report;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.init.AMPSInitConfig;
import xyz.adscope.amps.manager.AMPSSDKManager;
import xyz.adscope.amps.model.AMPSCycleModel;
import xyz.adscope.amps.model.AMPSGlobalModel;
import xyz.adscope.amps.model.config.response.AMPSConfigResponseModel;
import xyz.adscope.amps.model.config.response.ConfigModel;
import xyz.adscope.amps.model.config.response.EventLevelModel;
import xyz.adscope.amps.model.config.response.MediationModel;
import xyz.adscope.amps.model.crash.AMPSCrashRequestModel;
import xyz.adscope.amps.report.AMPSReportConstants;
import xyz.adscope.amps.report.AMPSReportTimer;
import xyz.adscope.amps.report.inter.IReportInterface;
import xyz.adscope.amps.report.model.AMPSReportConfigModel;
import xyz.adscope.amps.report.model.AMPSReportDBModel;
import xyz.adscope.amps.report.model.request.AMPSReportRequestModel;
import xyz.adscope.amps.report.model.request.AdModel;
import xyz.adscope.amps.report.model.request.AppModel;
import xyz.adscope.amps.report.model.request.DeviceModel;
import xyz.adscope.amps.report.model.request.EventModel;
import xyz.adscope.amps.report.model.request.SdkModel;
import xyz.adscope.amps.report.model.request.UserModel;
import xyz.adscope.amps.tool.crash.AMPSCrashHandler;
import xyz.adscope.amps.tool.persistent.db.AMPSDataBaseManager;
import xyz.adscope.amps.tool.persistent.sp.AMPSSpUtil;
import xyz.adscope.amps.tool.request.AMPSHttpRequest;
import xyz.adscope.amps.tool.request.inter.IHttpResponseCallback;
import xyz.adscope.amps.tool.thread.AMPSThreadPool;
import xyz.adscope.amps.tool.util.AMPSDateUtil;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.AppInfo;
import xyz.adscope.common.info.DeviceInfo;
import xyz.adscope.common.json.JSONParse;
import xyz.adscope.common.tool.LogUtil;
import xyz.adscope.common.tool.security.Base64Util;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSReportLoader implements IReportInterface {
    static final String KEY_TABLE_NAME = "amps_event_report_table";
    private static AMPSReportLoader ampsReportLoader;
    private AMPSDataBaseManager ampsDataBaseManager;
    private AMPSGlobalModel ampsGlobalModel;
    private volatile Map<String, AMPSReportConfigModel> ampsReportConfigModelMap = null;
    private volatile Map<String, List<AMPSReportRequestModel>> ampsTempReportMap = new HashMap();
    private volatile Map<String, AMPSReportTimer> ampsTempReportTimerMap = new ConcurrentHashMap();
    private int INIT_TIME = 300;
    private int PERIOD_TIME = 300;

    private AMPSReportLoader() {
        if (AMPSSDKManager.getInstance().getContext() != null) {
            AMPSDataBaseManager aMPSDataBaseManager = new AMPSDataBaseManager(AMPSSDKManager.getInstance().getContext());
            this.ampsDataBaseManager = aMPSDataBaseManager;
            aMPSDataBaseManager.setTableNameAndModel(KEY_TABLE_NAME, AMPSReportDBModel.class);
        }
    }

    private AMPSReportRequestModel buildAMPSRequestReportModel(AMPSCycleModel aMPSCycleModel, String str, String str2) {
        this.ampsGlobalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
        AMPSInitConfig aMPSAdConfig = AMPSSDKManager.getInstance().getAMPSAdConfig();
        AMPSReportRequestModel aMPSReportRequestModel = new AMPSReportRequestModel();
        EventModel eventModel = new EventModel();
        eventModel.setLogVersion(AMPSReportConstants.LOG_VERSION);
        eventModel.setAccessKey("AMPS");
        eventModel.setCustomId(AMPSReportConstants.CUSTOM_ID);
        eventModel.setCustomLogger("xyz.adscope.amps");
        AMPSGlobalModel aMPSGlobalModel = this.ampsGlobalModel;
        if (aMPSGlobalModel != null) {
            eventModel.setStartId(aMPSGlobalModel.getStartId());
            eventModel.setErrorCode(this.ampsGlobalModel.getErrorCode());
            eventModel.setErrorInfo(this.ampsGlobalModel.getErrorMsg());
            this.ampsGlobalModel.setErrorCode("");
            this.ampsGlobalModel.setErrorMsg("");
            eventModel.setMediationAppId(this.ampsGlobalModel.getAppId());
            eventModel.setEventId(this.ampsGlobalModel.getEventId());
            if (str.equals(AMPSEventReportCode.EVENT_INIT_START_CODE.getCodeStr())) {
                eventModel.setEventTime(this.ampsGlobalModel.getInitStartTime());
                eventModel.setLogTime(this.ampsGlobalModel.getInitStartTime() + "");
                this.ampsGlobalModel.setInitStartTime(0L);
            } else {
                eventModel.setEventTime(this.ampsGlobalModel.getEventTime());
                eventModel.setLogTime(this.ampsGlobalModel.getLogTime() + "");
            }
            if (!TextUtils.isEmpty(str2)) {
                eventModel.setRoundTripTime(str2);
            }
            if (this.ampsGlobalModel.getConfigureResponseModel() != null) {
                AMPSConfigResponseModel configureResponseModel = this.ampsGlobalModel.getConfigureResponseModel();
                ConfigModel config = configureResponseModel.getConfig();
                if (config != null) {
                    eventModel.setCfgCustomData(config.getCustomData());
                    eventModel.setCfgVersion(config.getVersion());
                }
                xyz.adscope.amps.model.config.response.EventModel event = configureResponseModel.getEvent();
                if (event != null) {
                    eventModel.setEventCustomData(event.getCustomData());
                    eventModel.setEventVersion(event.getVersion());
                }
                MediationModel mediation = configureResponseModel.getMediation();
                if (mediation != null) {
                    eventModel.setMdCustomData(mediation.getCustomData());
                    eventModel.setMdVersion(mediation.getVersion());
                }
            }
        }
        if (aMPSCycleModel != null) {
            eventModel.setSessionId(aMPSCycleModel.getSessionId());
            eventModel.setMediationAppId(aMPSCycleModel.getMediationAppId());
            eventModel.setMediationSpaceId(aMPSCycleModel.getMediationSpaceId());
            eventModel.setAdSourceId(aMPSCycleModel.getAdSourceId());
            eventModel.setAdSourceAppId(aMPSCycleModel.getAdSourceAppId());
            eventModel.setAdSourceSpaceId(aMPSCycleModel.getAdSourceSpaceId());
            eventModel.setEcpm(aMPSCycleModel.getEcpm());
            eventModel.setLogTime(aMPSCycleModel.getLogTime());
            eventModel.setRoundTripTime(aMPSCycleModel.getRoundTripTime() + "");
            eventModel.setEventTime(aMPSCycleModel.getEventTime());
            eventModel.setAdsCustomData(aMPSCycleModel.getAdSourceCustomData());
            eventModel.setErrorCode(aMPSCycleModel.getErrorCode());
            eventModel.setErrorInfo(aMPSCycleModel.getErrorMsg());
            eventModel.setMdCustomData(aMPSCycleModel.getSpaceCustomData());
        }
        eventModel.setEventCode(str);
        aMPSReportRequestModel.setEventModel(eventModel);
        Context context = AMPSSDKManager.getInstance().getContext();
        AppModel appModel = new AppModel();
        if (context != null) {
            appModel.setBundleId(AppInfo.getPackName(context));
            appModel.setInstall(AppInfo.getInstallDate(context) + "");
            appModel.setName(AppInfo.getAppName(context));
            appModel.setUpdate(AppInfo.getLastUpdateTime(context) + "");
            appModel.setVersion(AppInfo.getAppVersionName(context));
        }
        aMPSReportRequestModel.setApp(appModel);
        DeviceModel deviceModel = new DeviceModel();
        DeviceInfo deviceInfo = context != null ? DeviceInfo.getInstance(context) : null;
        if (deviceInfo != null) {
            deviceModel.setSaid(deviceInfo.getSdkid());
            deviceModel.setType(deviceInfo.getDeviceType() + "");
            deviceModel.setDeviceName(deviceInfo.getDeviceName());
            deviceModel.setBrand(deviceInfo.getBrand());
            deviceModel.setModel(deviceInfo.getModel());
            deviceModel.setOs(deviceInfo.getOs());
            deviceModel.setCountry(deviceInfo.getCountry());
            deviceModel.setZone(deviceInfo.getTimeZone());
            deviceModel.setLang(deviceInfo.getLanguage());
            deviceModel.setContype(deviceInfo.getConnectType());
            deviceModel.setCarrier(deviceInfo.getCarrier());
            deviceModel.setOsv(deviceInfo.getOsVersion());
            boolean z3 = true;
            if (aMPSAdConfig != null) {
                z3 = aMPSAdConfig.isPersonalRecommend();
                deviceModel.setCoaid(aMPSAdConfig.getCustomOAID());
                deviceModel.setCgaid(aMPSAdConfig.getCustomGAID());
            }
            if (z3) {
                deviceModel.setOaid(deviceInfo.getOaid());
                deviceModel.setOoaid(deviceInfo.getOaid());
                deviceModel.setGaid(deviceInfo.getGaid());
                deviceModel.setOgaid(deviceInfo.getGaid());
                deviceModel.setLmt("1");
            } else {
                deviceModel.setLmt("0");
            }
            deviceModel.setW(deviceInfo.getResolutionWidth() + "");
            deviceModel.setH(deviceInfo.getResolutionHeight() + "");
            deviceModel.setMake(deviceInfo.getManufacturer());
            deviceModel.setBootMark(deviceInfo.getBootMark());
            deviceModel.setUpdateMark(deviceInfo.getUpdateMark());
            deviceModel.setFileMark(deviceInfo.getFileMark());
            deviceModel.setSysUpdateMark(deviceInfo.getUpdateMark());
            deviceModel.setHarddiskSize(deviceInfo.getHardDiskSize());
            deviceModel.setPhysicalMemory(deviceInfo.getPhysicalMemory());
        }
        aMPSReportRequestModel.setDevice(deviceModel);
        UserModel userModel = new UserModel();
        if (aMPSAdConfig != null) {
            userModel.setCustomData(aMPSAdConfig.getOptionInfo());
            userModel.setUserId(aMPSAdConfig.getUserId());
        }
        aMPSReportRequestModel.setUser(userModel);
        SdkModel sdkModel = new SdkModel();
        updateSdkModelVersion(sdkModel);
        sdkModel.setSdkVersion(AMPSSDKManager.getInstance().getSdkVersion());
        aMPSReportRequestModel.setSdk(sdkModel);
        AdModel adModel = new AdModel();
        adModel.setAccessType("sdk");
        adModel.setAdSdkVersion(AMPSSDKManager.getInstance().getSdkVersion());
        if (aMPSCycleModel != null) {
            adModel.setAdType(getAdType(aMPSCycleModel.getAdType()));
            adModel.setMaxWaitTime(aMPSCycleModel.getMaxWaitTime());
            adModel.setBidType(aMPSCycleModel.getBidType());
            adModel.setLoadType(aMPSCycleModel.getLoadType());
            adModel.setFloorPrice(aMPSCycleModel.getFloorPrice());
            adModel.setExpPrice(aMPSCycleModel.getEcpm());
            adModel.setQuantity(aMPSCycleModel.getAdCount());
        }
        aMPSReportRequestModel.setAd(adModel);
        return aMPSReportRequestModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AMPSReportRequestModel> dbModelsToRequestModels(List<AMPSReportDBModel> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AMPSReportDBModel aMPSReportDBModel : list) {
            arrayList.add((AMPSReportRequestModel) new JSONParse().fromJson(Base64Util.decode(aMPSReportDBModel.getEventJsonStr()), AMPSReportRequestModel.class));
        }
        return arrayList;
    }

    private List<AMPSReportRequestModel> deepCopyList(List<AMPSReportRequestModel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (AMPSReportRequestModel aMPSReportRequestModel : list) {
                if (aMPSReportRequestModel != null) {
                    AMPSReportRequestModel aMPSReportRequestModel2 = new AMPSReportRequestModel(aMPSReportRequestModel);
                    EventModel eventModel = new EventModel(aMPSReportRequestModel.getEventModel());
                    AppModel appModel = new AppModel(aMPSReportRequestModel.getApp());
                    DeviceModel deviceModel = new DeviceModel(aMPSReportRequestModel.getDevice());
                    UserModel userModel = new UserModel(aMPSReportRequestModel.getUser());
                    SdkModel sdkModel = new SdkModel(aMPSReportRequestModel.getSdk());
                    AdModel adModel = new AdModel(aMPSReportRequestModel.getAd());
                    aMPSReportRequestModel2.setEventModel(eventModel);
                    aMPSReportRequestModel2.setApp(appModel);
                    aMPSReportRequestModel2.setUser(userModel);
                    aMPSReportRequestModel2.setDevice(deviceModel);
                    aMPSReportRequestModel2.setSdk(sdkModel);
                    aMPSReportRequestModel2.setAd(adModel);
                    arrayList.add(aMPSReportRequestModel2);
                }
            }
        }
        return arrayList;
    }

    private AMPSReportRequestModel deepCopyRequestModel(AMPSReportRequestModel aMPSReportRequestModel) {
        AMPSReportRequestModel aMPSReportRequestModel2 = new AMPSReportRequestModel(aMPSReportRequestModel);
        EventModel eventModel = new EventModel(aMPSReportRequestModel.getEventModel());
        AppModel appModel = new AppModel(aMPSReportRequestModel.getApp());
        DeviceModel deviceModel = new DeviceModel(aMPSReportRequestModel.getDevice());
        UserModel userModel = new UserModel(aMPSReportRequestModel.getUser());
        SdkModel sdkModel = new SdkModel(aMPSReportRequestModel.getSdk());
        AdModel adModel = new AdModel(aMPSReportRequestModel.getAd());
        aMPSReportRequestModel2.setEventModel(eventModel);
        aMPSReportRequestModel2.setApp(appModel);
        aMPSReportRequestModel2.setUser(userModel);
        aMPSReportRequestModel2.setDevice(deviceModel);
        aMPSReportRequestModel2.setSdk(sdkModel);
        aMPSReportRequestModel2.setAd(adModel);
        return aMPSReportRequestModel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteOutTimeData() {
        long timeMillisBeforeDay = AMPSDateUtil.getTimeMillisBeforeDay(3);
        HashMap hashMap = new HashMap();
        hashMap.put(AMPSReportConstants.EVENT_TIME_KEY, Long.valueOf(timeMillisBeforeDay));
        AMPSDataBaseManager aMPSDataBaseManager = this.ampsDataBaseManager;
        if (aMPSDataBaseManager != null) {
            int deleteOutTime = aMPSDataBaseManager.deleteOutTime(hashMap);
            LogUtil.i(AMPSConstants.AMPS_LOG_TAG_REPORT, "deleteOutTimeResult : " + deleteOutTime);
        }
    }

    private void executeReport(List<AMPSReportRequestModel> list, AMPSReportConfigModel aMPSReportConfigModel, String str) {
        String reportURL = aMPSReportConfigModel.getReportURL();
        String macro = aMPSReportConfigModel.getMacro();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            AMPSReportRequestModel aMPSReportRequestModel = list.get(i4);
            if (aMPSReportRequestModel.getEventModel() != null && AMPSEventReportCode.EVENT_CRASH_CODE.getCodeStr().equals(aMPSReportRequestModel.getEventModel().getEventCode())) {
                List<AMPSCrashRequestModel> crashData = AMPSCrashHandler.getInstance().getCrashData();
                if (crashData != null && crashData.size() > 0) {
                    for (AMPSCrashRequestModel aMPSCrashRequestModel : crashData) {
                        if (aMPSReportRequestModel.getEventModel() != null) {
                            aMPSReportRequestModel.getEventModel().setAffiliated(aMPSCrashRequestModel.getAffiliated());
                            aMPSReportRequestModel.getEventModel().setException(aMPSCrashRequestModel.getException());
                            aMPSReportRequestModel.getEventModel().setLogTime(aMPSCrashRequestModel.getLog_time());
                            arrayList.add(AMPSModifyMacro.modifyMacroWithModel(aMPSReportRequestModel, macro));
                        }
                    }
                }
            } else {
                arrayList.add(AMPSModifyMacro.modifyMacroWithModel(aMPSReportRequestModel, macro));
            }
        }
        if (arrayList.size() > 0) {
            sendReportRequest(reportURL, arrayList.toString(), str, list);
        }
    }

    private AMPSReportConfigModel getAMPSReportLoaderModel(String str) {
        if (this.ampsReportConfigModelMap != null && !this.ampsReportConfigModelMap.isEmpty()) {
            for (Map.Entry<String, AMPSReportConfigModel> entry : this.ampsReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
        loadLogModelFromConfig();
        return null;
    }

    private String getAdType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_SPLASH;
        if (report_ad_type.getCode().equals(str)) {
            return report_ad_type.getValue();
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type2 = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_NATIVE_EXPRESS;
        if (report_ad_type2.getCode().equals(str)) {
            return report_ad_type2.getValue();
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type3 = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_NATIVE_UNIFIED;
        if (report_ad_type3.getCode().equals(str)) {
            return report_ad_type3.getValue();
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type4 = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_INTERSTITIAL;
        if (report_ad_type4.getCode().equals(str)) {
            return report_ad_type4.getValue();
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type5 = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_REWARD_VIDEO;
        if (report_ad_type5.getCode().equals(str)) {
            return report_ad_type5.getValue();
        }
        AMPSReportConstants.REPORT_AD_TYPE report_ad_type6 = AMPSReportConstants.REPORT_AD_TYPE.AD_TYPE_BANNER;
        return report_ad_type6.getCode().equals(str) ? report_ad_type6.getValue() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AMPSReportDBModel> getEventCodeReportDBModels() {
        AMPSDataBaseManager aMPSDataBaseManager = this.ampsDataBaseManager;
        if (aMPSDataBaseManager != null) {
            return aMPSDataBaseManager.query(null);
        }
        return null;
    }

    public static AMPSReportLoader getInstance() {
        if (ampsReportLoader == null) {
            synchronized (AMPSReportLoader.class) {
                if (ampsReportLoader == null) {
                    ampsReportLoader = new AMPSReportLoader();
                }
            }
        }
        return ampsReportLoader;
    }

    private String getKeyByEventCode(String str) {
        if (this.ampsReportConfigModelMap != null && !this.ampsReportConfigModelMap.isEmpty()) {
            for (Map.Entry<String, AMPSReportConfigModel> entry : this.ampsReportConfigModelMap.entrySet()) {
                if (entry.getKey().contains(str)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private long getTimerDuration(AMPSReportRequestModel aMPSReportRequestModel) {
        if (aMPSReportRequestModel != null && aMPSReportRequestModel.getEventModel() != null) {
            String eventCode = aMPSReportRequestModel.getEventModel().getEventCode();
            if (this.ampsReportConfigModelMap != null && !this.ampsReportConfigModelMap.isEmpty()) {
                AMPSReportConfigModel aMPSReportConfigModel = null;
                for (Map.Entry<String, AMPSReportConfigModel> entry : this.ampsReportConfigModelMap.entrySet()) {
                    if (entry.getKey().contains(eventCode)) {
                        aMPSReportConfigModel = entry.getValue();
                    }
                }
                if (aMPSReportConfigModel == null || TextUtils.isEmpty(aMPSReportConfigModel.getTime())) {
                    return 0L;
                }
                return Long.parseLong(aMPSReportConfigModel.getTime());
            }
            loadLogModelFromConfig();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendReportRequest$2(String str, String str2, final List list) {
        new AMPSHttpRequest().requestWithPostMethod(str, str2, new IHttpResponseCallback<String>() { // from class: xyz.adscope.amps.report.AMPSReportLoader.3
            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void failCallback(String str3, int i4) {
            }

            @Override // xyz.adscope.amps.tool.request.inter.IHttpResponseCallback
            public void successCallback(String str3) {
                AMPSReportLoader.this.deleteLog(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportAdEvent */
    public synchronized void lambda$reportAdLog$1(AMPSCycleModel aMPSCycleModel, String str) {
        uploadLog(buildAMPSRequestReportModel(aMPSCycleModel, str, ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reportInitEvent */
    public synchronized void lambda$reportInitLog$0(String str, String str2) {
        uploadLog(buildAMPSRequestReportModel(null, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReportLocal(List<AMPSReportRequestModel> list, String str) {
        AMPSReportConfigModel aMPSReportLoaderModel = getAMPSReportLoaderModel(str);
        if (aMPSReportLoaderModel == null || TextUtils.isEmpty(getKeyByEventCode(str))) {
            return;
        }
        executeReport(list, aMPSReportLoaderModel, str);
    }

    private void sendReportLog(List<AMPSReportRequestModel> list, String str) {
        AMPSReportConfigModel aMPSReportLoaderModel = getAMPSReportLoaderModel(str);
        if (aMPSReportLoaderModel == null || TextUtils.isEmpty(getKeyByEventCode(str))) {
            return;
        }
        executeReport(list, aMPSReportLoaderModel, str);
    }

    private void sendReportRequest(final String str, final String str2, String str3, final List<AMPSReportRequestModel> list) {
        AMPSThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.amps.report.b
            @Override // java.lang.Runnable
            public final void run() {
                AMPSReportLoader.this.lambda$sendReportRequest$2(str, str2, list);
            }
        });
    }

    private void setOaidAndGaid(DeviceModel deviceModel) {
        String string = AMPSSpUtil.getString(CommonConstants.DEVICE_OAID_KEY);
        String string2 = AMPSSpUtil.getString(CommonConstants.DEVICE_GAID_KEY);
        if (!TextUtils.isEmpty(string)) {
            deviceModel.setOoaid(string);
        }
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        deviceModel.setOgaid(string2);
    }

    private void updateSdkModelVersion(SdkModel sdkModel) {
    }

    public Map<String, List<AMPSReportRequestModel>> buildEventCodeMap(List<AMPSReportRequestModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (AMPSReportRequestModel aMPSReportRequestModel : list) {
            String eventCode = aMPSReportRequestModel.getEventModel().getEventCode();
            List list2 = (List) hashMap.get(eventCode);
            if (list2 == null) {
                list2 = new ArrayList();
                hashMap.put(eventCode, list2);
            }
            list2.add(aMPSReportRequestModel);
        }
        return hashMap;
    }

    @Override // xyz.adscope.amps.report.inter.IReportInterface
    public void deleteLog(List<AMPSReportRequestModel> list) {
        if (list == null || list.size() < 1) {
            return;
        }
        for (AMPSReportRequestModel aMPSReportRequestModel : list) {
            HashMap hashMap = new HashMap();
            if (aMPSReportRequestModel != null && aMPSReportRequestModel.getEventModel() != null) {
                hashMap.put(AMPSReportConstants.EVENT_TIME_KEY, Long.valueOf(aMPSReportRequestModel.getEventModel().getEventTime()));
            }
            AMPSDataBaseManager aMPSDataBaseManager = this.ampsDataBaseManager;
            if (aMPSDataBaseManager != null) {
                aMPSDataBaseManager.delete(hashMap);
            }
        }
    }

    public void loadLogModelFromConfig() {
        AMPSConfigResponseModel configureResponseModel;
        List<EventLevelModel> eventLevel;
        AMPSGlobalModel globalModel = AMPSSDKManager.getInstance().getIAMPSInitInterface().getGlobalModel();
        this.ampsGlobalModel = globalModel;
        if (globalModel == null || (configureResponseModel = globalModel.getConfigureResponseModel()) == null || (eventLevel = configureResponseModel.getEvent().getEventLevel()) == null || eventLevel.isEmpty()) {
            return;
        }
        this.ampsReportConfigModelMap = new HashMap();
        for (EventLevelModel eventLevelModel : eventLevel) {
            List<String> codes = eventLevelModel.getCodes();
            if (codes != null && !codes.isEmpty()) {
                String obj = codes.toString();
                AMPSReportConfigModel aMPSReportConfigModel = new AMPSReportConfigModel();
                aMPSReportConfigModel.setReportURL(eventLevelModel.getReportURL());
                aMPSReportConfigModel.setCode(obj);
                aMPSReportConfigModel.setCount(eventLevelModel.getCount());
                aMPSReportConfigModel.setMacro(eventLevelModel.getMacro());
                aMPSReportConfigModel.setAcceptEncrypt(eventLevelModel.getAcceptEncrypt());
                aMPSReportConfigModel.setTime(eventLevelModel.getTime());
                this.ampsReportConfigModelMap.put(obj, aMPSReportConfigModel);
            }
        }
    }

    public void loadLogsFromDatabase() {
        AMPSThreadPool.getSingleExecutorService().scheduleWithFixedDelay(new Runnable() { // from class: xyz.adscope.amps.report.AMPSReportLoader.1
            @Override // java.lang.Runnable
            public void run() {
                List<AMPSReportRequestModel> dbModelsToRequestModels;
                Map<String, List<AMPSReportRequestModel>> buildEventCodeMap;
                LogUtil.i(AMPSConstants.AMPS_LOG_TAG_REPORT, "report_timer_log\uff0c\u672c\u5730\u4efb\u52a1\u67e5\u8be2\u6570\u636e\u5e93");
                AMPSReportLoader.this.deleteOutTimeData();
                List eventCodeReportDBModels = AMPSReportLoader.this.getEventCodeReportDBModels();
                if (eventCodeReportDBModels == null || eventCodeReportDBModels.isEmpty() || (dbModelsToRequestModels = AMPSReportLoader.this.dbModelsToRequestModels(eventCodeReportDBModels)) == null || dbModelsToRequestModels.isEmpty() || (buildEventCodeMap = AMPSReportLoader.this.buildEventCodeMap(dbModelsToRequestModels)) == null || buildEventCodeMap.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, List<AMPSReportRequestModel>> entry : buildEventCodeMap.entrySet()) {
                    AMPSReportLoader.this.sendReportLocal(entry.getValue(), entry.getKey());
                }
            }
        }, this.INIT_TIME, this.PERIOD_TIME, TimeUnit.SECONDS);
    }

    @Override // xyz.adscope.amps.report.inter.IReportInterface
    public synchronized void reportAdLog(final AMPSCycleModel aMPSCycleModel, final String str) {
        AMPSThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.amps.report.c
            @Override // java.lang.Runnable
            public final void run() {
                AMPSReportLoader.this.lambda$reportAdLog$1(aMPSCycleModel, str);
            }
        });
    }

    @Override // xyz.adscope.amps.report.inter.IReportInterface
    public synchronized void reportInitLog(final String str, final String str2) {
        AMPSThreadPool.getSingleExecutorService().execute(new Runnable() { // from class: xyz.adscope.amps.report.a
            @Override // java.lang.Runnable
            public final void run() {
                AMPSReportLoader.this.lambda$reportInitLog$0(str, str2);
            }
        });
    }

    @Override // xyz.adscope.amps.report.inter.IReportInterface
    public void saveLog(AMPSReportRequestModel aMPSReportRequestModel) {
        AMPSReportDBModel aMPSReportDBModel = new AMPSReportDBModel();
        aMPSReportDBModel.setEventJsonStr(Base64Util.encode(new JSONParse().toJson(aMPSReportRequestModel)));
        if (aMPSReportRequestModel.getEventModel() != null) {
            aMPSReportDBModel.setEventCode(aMPSReportRequestModel.getEventModel().getEventCode());
            aMPSReportDBModel.setEventTime(aMPSReportRequestModel.getEventModel().getEventTime());
            aMPSReportDBModel.setEventId(aMPSReportRequestModel.getEventModel().getEventId());
        }
        AMPSDataBaseManager aMPSDataBaseManager = this.ampsDataBaseManager;
        if (aMPSDataBaseManager != null) {
            long longValue = aMPSDataBaseManager.insert(aMPSReportDBModel).longValue();
            LogUtil.i(AMPSConstants.AMPS_LOG_TAG_REPORT, "insertResult : " + longValue);
        }
    }

    @Override // xyz.adscope.amps.report.inter.IReportInterface
    public void uploadLog(AMPSReportRequestModel aMPSReportRequestModel) {
        int i4;
        List<AMPSReportRequestModel> list;
        AMPSReportRequestModel deepCopyRequestModel = deepCopyRequestModel(aMPSReportRequestModel);
        saveLog(deepCopyRequestModel);
        if (deepCopyRequestModel == null || deepCopyRequestModel.getEventModel() == null) {
            return;
        }
        final String eventCode = deepCopyRequestModel.getEventModel().getEventCode();
        if (this.ampsReportConfigModelMap == null || this.ampsReportConfigModelMap.isEmpty()) {
            return;
        }
        AMPSReportConfigModel aMPSReportConfigModel = null;
        Iterator<Map.Entry<String, AMPSReportConfigModel>> it = this.ampsReportConfigModelMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, AMPSReportConfigModel> next = it.next();
            if (next.getKey().contains(eventCode)) {
                aMPSReportConfigModel = next.getValue();
                break;
            }
        }
        if (aMPSReportConfigModel == null) {
            loadLogModelFromConfig();
            return;
        }
        try {
            i4 = Integer.parseInt(aMPSReportConfigModel.getCount());
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
            i4 = 1;
        }
        if (i4 == 1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(deepCopyRequestModel);
            sendReportLog(arrayList, eventCode);
            return;
        }
        String code = aMPSReportConfigModel.getCode();
        if (!this.ampsTempReportMap.containsKey(code)) {
            list = new ArrayList<>();
            AMPSReportTimer aMPSReportTimer = new AMPSReportTimer(new AMPSReportTimer.AMPSReportTimerListener() { // from class: xyz.adscope.amps.report.AMPSReportLoader.2
                @Override // xyz.adscope.amps.report.AMPSReportTimer.AMPSReportTimerListener
                public void onTrigger() {
                    AMPSReportLoader.this.sendReportLog(eventCode);
                }
            }, aMPSReportConfigModel.getTime());
            aMPSReportTimer.buildReportTimerTask();
            this.ampsTempReportTimerMap.put(code, aMPSReportTimer);
        } else {
            list = this.ampsTempReportMap.get(code);
        }
        list.add(deepCopyRequestModel);
        this.ampsTempReportMap.put(code, list);
        if (list.size() < i4) {
            return;
        }
        sendReportLog(eventCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReportLog(String str) {
        try {
            AMPSReportConfigModel aMPSReportLoaderModel = getAMPSReportLoaderModel(str);
            if (aMPSReportLoaderModel == null) {
                return;
            }
            String keyByEventCode = getKeyByEventCode(str);
            if (!TextUtils.isEmpty(keyByEventCode) && this.ampsTempReportMap.containsKey(keyByEventCode)) {
                executeReport(this.ampsTempReportMap.get(keyByEventCode), aMPSReportLoaderModel, str);
                if (this.ampsTempReportMap != null && this.ampsTempReportMap.containsKey(keyByEventCode)) {
                    this.ampsTempReportMap.remove(keyByEventCode);
                }
                if (this.ampsTempReportTimerMap.containsKey(keyByEventCode)) {
                    this.ampsTempReportTimerMap.get(keyByEventCode).cancelTimerTask();
                    this.ampsTempReportTimerMap.remove(keyByEventCode);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
