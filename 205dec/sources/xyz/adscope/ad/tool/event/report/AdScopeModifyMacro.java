package xyz.adscope.ad.tool.event.report;

import android.text.TextUtils;
import xyz.adscope.ad.init.InitImplement;
import xyz.adscope.ad.tool.event.model.AdScopeEventReportModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeModifyMacro {
    private static final String EVENT_SPACE_VALUE = "NSDK";
    private static final String accessKey = "__ACCESS_KEY__";
    private static final String accessType = "__ACCESS_TYPE__";
    private static final String adSdkVersion = "__AD_SDK_VERSION__";
    private static final String adSpaceType = "__AD_SPACE_TYPE__";
    private static final String adType = "__AD_TYPE__";
    private static final String affiliated = "__AFFILIATED__";
    private static final String appId = "__APP_ID__";
    private static final String appInstalls = "__APP_INSTALLS__";
    private static final String appName = "__APP_NAME__";
    private static final String appVersion = "__APP_VERSION__";
    private static final String bootMark = "__BOOT_MARK__";
    private static final String brand = "__BRAND__";
    private static final String bundleId = "__BUNDLE_ID__";
    private static final String carrier = "__CARRIER__";
    private static final String cgaid = "__CGAID__";
    private static final String cidfa = "__CIDFA__";
    private static final String clickType = "__CLICK_TYPE__";
    private static final String coaid = "__COAID__";
    private static final String complain = "__COMPLAIN__";
    private static final String conType = "__CONNECTION_TYPE__";
    private static final String country = "__DEVICE_COUNTRY__";
    private static final String createId = "__CREATIVE_ID__";
    private static final String currency = "__CURRENCY__";
    private static final String customId = "__CUSTOM_ID__";
    private static final String customLogger = "__CUSTOM_LOGGER__";
    private static final String density = "__DENSITY__";
    private static final String deviceName = "__DEVICE_NAME__";
    private static final String dspId = "__DSP_ID__";
    private static final String errorCode = "__AD_ERROR_CODE__";
    private static final String errorInfo = "__AD_ERROR_INFO__";
    private static final String eventCode = "__EVENT_CODE__";
    private static final String eventCustomData = "__EVENT_CUSTOM_DATA__";
    private static final String eventId = "__EVENT_ID__";
    private static final String eventSpace = "__EVENT_SPACE__";
    private static final String eventTime = "__EVENT_TIME__";
    private static final String eventVersion = "__EVENT_VERSION__";
    private static final String exception = "__EXCEPTION__";
    private static final String expPrice = "__EXP_PRICE__";
    private static final String fileMark = "__FILE_MARK__";
    private static final String gaid = "__GAID__";

    /* renamed from: h  reason: collision with root package name */
    private static final String f64531h = "__H__";
    private static final String harddiskSize = "__HARD_DISK_SIZE__";
    private static final String hwModel = "__HW_MODEL__";
    private static final String idfa = "__IDFA__";
    private static final String idfv = "__IDFV__";
    private static final String installTime = "__INSTALL_TIME__";
    private static final String interactionPlanId = "__ADN_INTERACTION_ID__";
    private static final String isWin = "__IS_WIN__";
    private static final String keywordArray = "__KEY_WORD_ARRAY__";
    private static final String lang = "__LANG__";
    private static final String lmt = "__LMT__";
    private static final String logTime = "__LOG_TIME__";
    private static final String logVersion = "__LOG_VERSION__";
    private static final String make = "__MAKE__";
    private static final String materialId = "__MATERIAL_ID__";
    private static final String maxWaitTime = "__MAX_WAIT_TIME__";
    private static final String model = "__MODEL__";
    private static final String oaid = "__OAID__";
    private static final String ogaid = "__OGAID__";
    private static final String ooaid = "__OOAID__";
    private static final String orderId = "__ORDER_ID__";
    private static final String orgKey = "__ORG_KEY__";
    private static final String orientation = "__ORIENTATION__";
    private static final String os = "__OS__";
    private static final String osV = "__OSV__";
    private static final String physicalMemory = "__PHYSICAL_MEMORY__";
    private static final String preloadMd5 = "__PRELOAD_MD5__";
    private static final String price = "__PRICE__";
    private static final String quantity = "__QUANTITY__";
    private static final String renderPlanId = "__ADN_RENDER_ID__";
    private static final String requestUrlMd5 = "__REQUESTURL_MD5__";
    private static final String roundTripTime = "__COST_TIME__";
    private static final String said = "__SAID__";
    private static final String sdkVersion = "__AD_SDK_VERSION__";
    private static final String sessionId = "__SESSION_ID__";
    private static final String spaceId = "__SPACE_ID__";
    private static final String startId = "__START_ID__";
    private static final String statisticsMd5 = "__STATISTICS_MD5__";
    private static final String strategyMd5 = "__STRATEGY_MD5__";
    private static final String sysUpdateMark = "__SYS_UPDATE_MARK__";
    private static final String templateMd5 = "__TEMPLATE_MD5__";
    private static final String timeout = "__TIMEOUT__";
    private static final String type = "__DEVICE_TYPE__";
    private static final String updateMark = "__UPDATE_MARK__";
    private static final String updateMd5 = "__UPDATE_MD5__";
    private static final String updateTime = "__UPDATE_TIME__";
    private static final String userAgent = "__USER_AGENT__";
    private static final String userId = "__USER_ID__";
    private static final String userYob = "__USER_YOB__";

    /* renamed from: w  reason: collision with root package name */
    private static final String f64532w = "__W__";
    private static final String winPrice = "__WIN_PRICE__";
    private static final String zone = "__ZONE__";

    public static String modifyMacroWithModel(AdScopeEventReportModel adScopeEventReportModel, String str) {
        InitImplement.getInstance().getGlobalModel();
        if (TextUtils.isEmpty(str) || adScopeEventReportModel == null) {
            return null;
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getLog_time())) {
            str = str.replace(logTime, adScopeEventReportModel.getLog_time());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getLog_version())) {
            str = str.replace(logVersion, adScopeEventReportModel.getLog_version());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getStartId())) {
            str = str.replace(startId, adScopeEventReportModel.getStartId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getSessionId())) {
            str = str.replace(sessionId, adScopeEventReportModel.getSessionId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEventCustomData())) {
            str = str.replace(eventCustomData, adScopeEventReportModel.getEventCustomData());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEventVersion())) {
            str = str.replace(eventVersion, adScopeEventReportModel.getEventVersion());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getRoundTripTime())) {
            str = str.replace(roundTripTime, adScopeEventReportModel.getRoundTripTime());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOrg_key())) {
            str = str.replace(orgKey, adScopeEventReportModel.getOrg_key());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAccessKey())) {
            str = str.replace(accessKey, adScopeEventReportModel.getAccessKey());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCustomId())) {
            str = str.replace(customId, adScopeEventReportModel.getCustomId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCustomLogger())) {
            str = str.replace(customLogger, adScopeEventReportModel.getCustomLogger());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getSaid())) {
            str = str.replace(said, adScopeEventReportModel.getSaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOaid())) {
            str = str.replace(oaid, adScopeEventReportModel.getOaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getGaid())) {
            str = str.replace(gaid, adScopeEventReportModel.getGaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getIdfa())) {
            str = str.replace(idfa, adScopeEventReportModel.getIdfa());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getIdfv())) {
            str = str.replace(idfv, adScopeEventReportModel.getIdfv());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getDevice_name())) {
            str = str.replace(deviceName, adScopeEventReportModel.getDevice_name());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getDevice_type() + "")) {
            str = str.replace(type, adScopeEventReportModel.getDevice_type() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getBrand())) {
            str = str.replace(brand, adScopeEventReportModel.getBrand());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getModel())) {
            str = str.replace(model, adScopeEventReportModel.getModel());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getHw_model())) {
            str = str.replace(hwModel, adScopeEventReportModel.getHw_model());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getRam_byte())) {
            str = str.replace(physicalMemory, adScopeEventReportModel.getRam_byte());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getStorage_byte())) {
            str = str.replace(harddiskSize, adScopeEventReportModel.getStorage_byte());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getResolution_width() + "")) {
            str = str.replace(f64532w, adScopeEventReportModel.getResolution_width() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getResolution_height() + "")) {
            str = str.replace(f64531h, adScopeEventReportModel.getResolution_height() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getDensity() + "")) {
            str = str.replace(density, adScopeEventReportModel.getDensity() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOrientation() + "")) {
            str = str.replace(orientation, adScopeEventReportModel.getOrientation() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOs())) {
            str = str.replace(os, adScopeEventReportModel.getOs());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOs_version())) {
            str = str.replace(osV, adScopeEventReportModel.getOs_version());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUa())) {
            str = str.replace(userAgent, adScopeEventReportModel.getUa());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getTime_zone())) {
            str = str.replace(zone, adScopeEventReportModel.getTime_zone());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getLanguage())) {
            str = str.replace(lang, adScopeEventReportModel.getLanguage());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCountry())) {
            str = str.replace(country, adScopeEventReportModel.getCountry());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCarrier())) {
            str = str.replace(carrier, adScopeEventReportModel.getCarrier());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getSystem_boot_mark())) {
            str = str.replace(bootMark, adScopeEventReportModel.getSystem_boot_mark());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getSystem_update_mark())) {
            str = str.replace(sysUpdateMark, adScopeEventReportModel.getSystem_update_mark());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getSystem_file_mark())) {
            str = str.replace(fileMark, adScopeEventReportModel.getSystem_file_mark());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getConnect_type() + "")) {
            str = str.replace(conType, adScopeEventReportModel.getConnect_type() + "");
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getApp_version())) {
            str = str.replace(appVersion, adScopeEventReportModel.getApp_version());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getApp_name())) {
            str = str.replace(appName, adScopeEventReportModel.getApp_name());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getApp_bundle())) {
            str = str.replace(bundleId, adScopeEventReportModel.getApp_bundle());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getApp_lmt())) {
            str = str.replace(lmt, adScopeEventReportModel.getApp_lmt());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getMake())) {
            str = str.replace(make, adScopeEventReportModel.getMake());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUser_id())) {
            str = str.replace(userId, adScopeEventReportModel.getUser_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUser_yob())) {
            str = str.replace(userYob, adScopeEventReportModel.getUser_yob());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEvent_id())) {
            str = str.replace(eventId, adScopeEventReportModel.getEvent_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEvent_time())) {
            str = str.replace(eventTime, adScopeEventReportModel.getEvent_time());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getEvent_code())) {
            str = str.replace(eventCode, adScopeEventReportModel.getEvent_code());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getTimeout() + "")) {
            str = str.replace(timeout, adScopeEventReportModel.getTimeout() + "");
        }
        String replace = str.replace(eventSpace, EVENT_SPACE_VALUE).replace("__AD_SDK_VERSION__", "5.1.0.13");
        if (!TextUtils.isEmpty(adScopeEventReportModel.getApp_id())) {
            replace = replace.replace(appId, adScopeEventReportModel.getApp_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAd_space_id())) {
            replace = replace.replace(spaceId, adScopeEventReportModel.getAd_space_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAd_space_type())) {
            replace = replace.replace(adSpaceType, adScopeEventReportModel.getAd_space_type());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getDsp_id())) {
            replace = replace.replace(dspId, adScopeEventReportModel.getDsp_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getPrice())) {
            replace = replace.replace(price, adScopeEventReportModel.getPrice());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getRender_plan_id())) {
            replace = replace.replace(renderPlanId, adScopeEventReportModel.getRender_plan_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getInteraction_plan_id())) {
            replace = replace.replace(interactionPlanId, adScopeEventReportModel.getInteraction_plan_id());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getClick_type())) {
            replace = replace.replace(clickType, adScopeEventReportModel.getClick_type());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getError_code())) {
            replace = replace.replace(errorCode, adScopeEventReportModel.getError_code());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getError_info())) {
            replace = replace.replace(errorInfo, adScopeEventReportModel.getError_info());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUpdate_md5())) {
            replace = replace.replace(updateMd5, adScopeEventReportModel.getUpdate_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getRequestUrl_md5())) {
            replace = replace.replace(requestUrlMd5, adScopeEventReportModel.getRequestUrl_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getStrategy_md5())) {
            replace = replace.replace(strategyMd5, adScopeEventReportModel.getStrategy_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getTemplate_md5())) {
            replace = replace.replace(templateMd5, adScopeEventReportModel.getTemplate_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getPreload_md5())) {
            replace = replace.replace(preloadMd5, adScopeEventReportModel.getPreload_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getStatistics_md5())) {
            replace = replace.replace(statisticsMd5, adScopeEventReportModel.getStatistics_md5());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCustom_oaid())) {
            replace = replace.replace(coaid, adScopeEventReportModel.getCustom_oaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCustom_gaid())) {
            replace = replace.replace(cgaid, adScopeEventReportModel.getCustom_gaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOoaid())) {
            replace = replace.replace(ooaid, adScopeEventReportModel.getOoaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOgaid())) {
            replace = replace.replace(ogaid, adScopeEventReportModel.getOgaid());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCustom_idfa())) {
            replace = replace.replace(cidfa, adScopeEventReportModel.getCustom_idfa());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAffiliated())) {
            replace = replace.replace(affiliated, adScopeEventReportModel.getAffiliated());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getKeywordArray())) {
            replace = replace.replace(keywordArray, adScopeEventReportModel.getKeywordArray());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getException())) {
            replace = replace.replace(exception, adScopeEventReportModel.getException());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getOrderId())) {
            replace = replace.replace(orderId, adScopeEventReportModel.getOrderId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCreateId())) {
            replace = replace.replace(createId, adScopeEventReportModel.getCreateId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getMaterialId())) {
            replace = replace.replace(materialId, adScopeEventReportModel.getMaterialId());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAccessType())) {
            replace = replace.replace(accessType, adScopeEventReportModel.getAccessType());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAdSdkVersion())) {
            replace = replace.replace("__AD_SDK_VERSION__", adScopeEventReportModel.getAdSdkVersion());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getMaxWaitTime())) {
            replace = replace.replace(maxWaitTime, adScopeEventReportModel.getMaxWaitTime());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getAdType())) {
            replace = replace.replace(adType, adScopeEventReportModel.getAdType());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getCurrency())) {
            replace = replace.replace(currency, adScopeEventReportModel.getCurrency());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getQuantity())) {
            replace = replace.replace(quantity, adScopeEventReportModel.getQuantity());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getIsWin())) {
            replace = replace.replace(isWin, adScopeEventReportModel.getIsWin());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getWinPrice())) {
            replace = replace.replace("__WIN_PRICE__", adScopeEventReportModel.getWinPrice());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getExpPrice())) {
            replace = replace.replace(expPrice, adScopeEventReportModel.getExpPrice());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getInstallTime())) {
            replace = replace.replace(installTime, adScopeEventReportModel.getInstallTime());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUpdateTime())) {
            replace = replace.replace(updateTime, adScopeEventReportModel.getUpdateTime());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getUpdateMark())) {
            replace = replace.replace(updateMark, adScopeEventReportModel.getUpdateMark());
        }
        if (!TextUtils.isEmpty(adScopeEventReportModel.getComplain())) {
            replace = replace.replace(complain, adScopeEventReportModel.getComplain());
        }
        return !TextUtils.isEmpty(adScopeEventReportModel.getAppInstalls()) ? replace.replace(appInstalls, adScopeEventReportModel.getAppInstalls()) : replace;
    }
}
