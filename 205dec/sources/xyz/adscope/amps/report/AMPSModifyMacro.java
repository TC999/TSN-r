package xyz.adscope.amps.report;

import android.text.TextUtils;
import xyz.adscope.amps.report.model.request.AMPSReportRequestModel;
import xyz.adscope.amps.report.model.request.AdModel;
import xyz.adscope.amps.report.model.request.AppModel;
import xyz.adscope.amps.report.model.request.DeviceModel;
import xyz.adscope.amps.report.model.request.EventModel;
import xyz.adscope.amps.report.model.request.SdkModel;
import xyz.adscope.amps.report.model.request.UserModel;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSModifyMacro {
    private static final String accessKey = "__ACCESS_KEY__";
    private static final String accessType = "__ACCESS_TYPE__";
    private static final String adSdkVersion = "__AD_SDK_VERSION__";
    private static final String adSourceAppId = "__SEAT_APP_ID__";
    private static final String adSourceId = "__SEAT_ID__";
    private static final String adSourceSpaceId = "__SEAT_SPACE_ID__";
    private static final String adType = "__AD_TYPE__";
    private static final String adsCustomData = "__ADS_CUSTOM_DATA__";
    private static final String affiliated = "__AFFILIATED__";
    private static final String appInstallTime = "__INSTALL_TIME__";
    private static final String appName = "__APP_NAME__";
    private static final String appUpdateTime = "__UPDATE_TIME__";
    private static final String appVersion = "__APP_VERSION__";
    private static final String bidType = "__BID_TYPE__";
    private static final String biddingType = "__BIDDING_TYPE__";
    private static final String bootMark = "__BOOT_MARK__";
    private static final String brand = "__BRAND__";
    private static final String bundleId = "__BUNDLE_ID__";
    private static final String carrier = "__CARRIER__";
    private static final String cfgCustomData = "__CFG_CUSTOM_DATA__";
    private static final String cfgVersion = "__AD_CFG_VERSION__";
    private static final String cgaid = "__CGAID__";
    private static final String cidfa = "__CIDFA__";
    private static final String coaid = "__COAID__";
    private static final String contype = "__CONNECTION_TYPE__";
    private static final String country = "__COUNTRY__";
    private static final String csjSdkVersion = "__CSJ_SDK_VERSION__";
    private static final String customId = "__CUSTOM_ID__";
    private static final String customLogger = "__CUSTOM_LOGGER__";
    private static final String deviceName = "__DEVICE_NAME__";
    private static final String ecpm = "__ECPM__";
    private static final String errorCode = "__AD_ERROR_CODE__";
    private static final String errorInfo = "__AD_ERROR_INFO__";
    private static final String eventCode = "__EVENT_CODE__";
    private static final String eventCustomData = "__EVENT_CUSTOM_DATA__";
    private static final String eventId = "__EVENT_ID__";
    private static final String eventTime = "__EVENT_TIME__";
    private static final String eventVersion = "__AD_EVENT_VERSION__";
    private static final String exception = "__EXCEPTION__";
    private static final String expPrice = "__EXP_PRICE__";
    private static final String fileMark = "__FILE_MARK__";
    private static final String floorPrice = "__FLOOR_PRICE__";
    private static final String gaid = "__GAID__";
    private static final String gdtSdkVersion = "__gdt_SDK_VERSION__";
    private static final String gmSdkVersion = "__gm_SDK_VERSION__";

    /* renamed from: h  reason: collision with root package name */
    private static final String f64551h = "__H__";
    private static final String harddiskSize = "__HARD_DISK_SIZE__";
    private static final String hwModel = "__HW_MODEL__";
    private static final String idfa = "__IDFA__";
    private static final String ksSdkVersion = "__KS_SDK_VERSION__";
    private static final String lang = "__LANG__";
    private static final String lmt = "__LMT__";
    private static final String loadType = "__LOAD_TYPE__";
    private static final String logTime = "__LOG_TIME__";
    private static final String logVersion = "__LOG_VERSION__";
    private static final String make = "__MAKE__";
    private static final String maxWaitTime = "__MAX_WAIT_TIME__";
    private static final String mdCustomData = "__MD_CUSTOM_DATA__";
    private static final String mdVersion = "__MD_VERSION__";
    private static final String mediationAppId = "__APP_ID__";
    private static final String mediationSpaceId = "__SPACE_ID__";
    private static final String model = "__MODEL__";
    private static final String oaid = "__OAID__";
    private static final String ogaid = "__OGAID__";
    private static final String ooaid = "__OOAID__";
    private static final String os = "__OS__";
    private static final String osv = "__OSV__";
    private static final String physicalMemory = "__PHYSICAL_MEMORY__";
    private static final String quantity = "__QUANTITY__";
    private static final String roundTripTime = "__COST_TIME__";
    private static final String said = "__SAID__";
    private static final String sdkArray = "__SDK_ARRAY__";
    private static final String sdkVersion = "__AD_SDK_VERSION__";
    private static final String sessionId = "__SESSION_ID__";
    private static final String startId = "__START_ID__";
    private static final String sysUpdateMark = "__SYS_UPDATE_MARK__";
    private static final String type = "__DEVICE_TYPE__";
    private static final String updateMark = "__UPDATE_MARK__";
    private static final String userCustomData = "__USER_CUSTOM_DATA__";
    private static final String userId = "__USER_ID__";

    /* renamed from: w  reason: collision with root package name */
    private static final String f64552w = "__W__";
    private static final String yj4SdkVersion = "__yj4_SDK_VERSION__";
    private static final String yj5SdkVersion = "__yj5_SDK_VERSION__";
    private static final String zone = "__ZONE__";

    public static String modifyMacroWithModel(AMPSReportRequestModel aMPSReportRequestModel, String str) {
        if (aMPSReportRequestModel == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (aMPSReportRequestModel.getEventModel() != null) {
            EventModel eventModel = aMPSReportRequestModel.getEventModel();
            if (!TextUtils.isEmpty(eventModel.getStartId())) {
                str = str.replace(startId, eventModel.getStartId());
            }
            if (!TextUtils.isEmpty(eventModel.getSessionId())) {
                str = str.replace(sessionId, eventModel.getSessionId());
            }
            if (!TextUtils.isEmpty(eventModel.getAccessKey())) {
                str = str.replace(accessKey, eventModel.getAccessKey());
            }
            if (!TextUtils.isEmpty(eventModel.getCustomId())) {
                str = str.replace(customId, eventModel.getCustomId());
            }
            if (!TextUtils.isEmpty(eventModel.getCustomLogger())) {
                str = str.replace(customLogger, eventModel.getCustomLogger());
            }
            if (!TextUtils.isEmpty(eventModel.getLogVersion())) {
                str = str.replace(logVersion, eventModel.getLogVersion());
            }
            if (!TextUtils.isEmpty(eventModel.getMediationAppId())) {
                str = str.replace(mediationAppId, eventModel.getMediationAppId());
            }
            if (!TextUtils.isEmpty(eventModel.getMediationSpaceId())) {
                str = str.replace(mediationSpaceId, eventModel.getMediationSpaceId());
            }
            if (!TextUtils.isEmpty(eventModel.getAdSourceId())) {
                str = str.replace(adSourceId, eventModel.getAdSourceId());
            }
            if (!TextUtils.isEmpty(eventModel.getAdSourceAppId())) {
                str = str.replace(adSourceAppId, eventModel.getAdSourceAppId());
            }
            if (!TextUtils.isEmpty(eventModel.getAdSourceSpaceId())) {
                str = str.replace(adSourceSpaceId, eventModel.getAdSourceSpaceId());
            }
            if (!TextUtils.isEmpty(eventModel.getEcpm())) {
                str = str.replace(ecpm, eventModel.getEcpm());
            }
            if (!TextUtils.isEmpty(eventModel.getEventCode())) {
                str = str.replace(eventCode, eventModel.getEventCode());
            }
            if (!TextUtils.isEmpty(eventModel.getEventId())) {
                str = str.replace(eventId, eventModel.getEventId());
            }
            if (!TextUtils.isEmpty(eventModel.getEventTime() + "")) {
                str = str.replace(eventTime, eventModel.getEventTime() + "");
            }
            if (!TextUtils.isEmpty(eventModel.getErrorCode())) {
                str = str.replace(errorCode, eventModel.getErrorCode());
            }
            if (!TextUtils.isEmpty(eventModel.getErrorInfo())) {
                str = str.replace(errorInfo, eventModel.getErrorInfo());
            }
            if (!TextUtils.isEmpty(eventModel.getLogTime())) {
                str = str.replace(logTime, eventModel.getLogTime());
            }
            if (!TextUtils.isEmpty(eventModel.getCfgCustomData())) {
                str = str.replace(cfgCustomData, eventModel.getCfgCustomData());
            }
            if (!TextUtils.isEmpty(eventModel.getCfgVersion())) {
                str = str.replace(cfgVersion, eventModel.getCfgVersion());
            }
            if (!TextUtils.isEmpty(eventModel.getEventCustomData())) {
                str = str.replace(eventCustomData, eventModel.getEventCustomData());
            }
            if (!TextUtils.isEmpty(eventModel.getEventVersion())) {
                str = str.replace(eventVersion, eventModel.getEventVersion());
            }
            if (!TextUtils.isEmpty(eventModel.getMdCustomData())) {
                str = str.replace(mdCustomData, eventModel.getMdCustomData());
            }
            if (!TextUtils.isEmpty(eventModel.getMdVersion())) {
                str = str.replace(mdVersion, eventModel.getMdVersion());
            }
            if (!TextUtils.isEmpty(eventModel.getRoundTripTime()) && !"0".equals(eventModel.getRoundTripTime())) {
                str = str.replace(roundTripTime, eventModel.getRoundTripTime());
            }
            if (!TextUtils.isEmpty(eventModel.getBiddingType())) {
                str = str.replace(biddingType, eventModel.getBiddingType());
            }
            if (!TextUtils.isEmpty(eventModel.getAdsCustomData())) {
                str = str.replace(adsCustomData, eventModel.getAdsCustomData());
            }
            if (!TextUtils.isEmpty(eventModel.getAffiliated())) {
                str = str.replace(affiliated, eventModel.getAffiliated());
            }
            if (!TextUtils.isEmpty(eventModel.getException())) {
                str = str.replace(exception, eventModel.getException());
            }
        }
        if (aMPSReportRequestModel.getApp() != null) {
            AppModel app = aMPSReportRequestModel.getApp();
            if (!TextUtils.isEmpty(app.getName())) {
                str = str.replace(appName, app.getName());
            }
            if (!TextUtils.isEmpty(app.getBundleId())) {
                str = str.replace(bundleId, app.getBundleId());
            }
            if (!TextUtils.isEmpty(app.getVersion())) {
                str = str.replace(appVersion, app.getVersion());
            }
            if (!TextUtils.isEmpty(app.getInstall())) {
                str = str.replace(appInstallTime, app.getInstall());
            }
            if (!TextUtils.isEmpty(app.getUpdate())) {
                str = str.replace(appUpdateTime, app.getUpdate());
            }
        }
        if (aMPSReportRequestModel.getDevice() != null) {
            DeviceModel device = aMPSReportRequestModel.getDevice();
            if (!TextUtils.isEmpty(device.getType())) {
                str = str.replace(type, device.getType());
            }
            if (!TextUtils.isEmpty(device.getDeviceName())) {
                str = str.replace(deviceName, device.getDeviceName());
            }
            if (!TextUtils.isEmpty(device.getSaid())) {
                str = str.replace(said, device.getSaid());
            }
            if (!TextUtils.isEmpty(device.getOs())) {
                str = str.replace(os, device.getOs());
            }
            if (!TextUtils.isEmpty(device.getCountry())) {
                str = str.replace(country, device.getCountry());
            }
            if (!TextUtils.isEmpty(device.getZone())) {
                str = str.replace(zone, device.getZone());
            }
            if (!TextUtils.isEmpty(device.getLang())) {
                str = str.replace(lang, device.getLang());
            }
            if (!TextUtils.isEmpty(device.getLmt())) {
                str = str.replace(lmt, device.getLmt());
            }
            if (!TextUtils.isEmpty(device.getContype())) {
                str = str.replace(contype, device.getContype());
            }
            if (!TextUtils.isEmpty(device.getCarrier())) {
                str = str.replace(carrier, device.getCarrier());
            }
            if (!TextUtils.isEmpty(device.getOsv())) {
                str = str.replace(osv, device.getOsv());
            }
            if (!TextUtils.isEmpty(device.getIdfa())) {
                str = str.replace(idfa, device.getIdfa());
            }
            if (!TextUtils.isEmpty(device.getOaid())) {
                str = str.replace(oaid, device.getOaid());
            }
            if (!TextUtils.isEmpty(device.getGaid())) {
                str = str.replace(gaid, device.getGaid());
            }
            if (!TextUtils.isEmpty(device.getCidfa())) {
                str = str.replace(cidfa, device.getCidfa());
            }
            if (!TextUtils.isEmpty(device.getCoaid())) {
                str = str.replace(coaid, device.getCoaid());
            }
            if (!TextUtils.isEmpty(device.getCgaid())) {
                str = str.replace(cgaid, device.getCgaid());
            }
            if (!TextUtils.isEmpty(device.getOgaid())) {
                str = str.replace(ogaid, device.getOgaid());
            }
            if (!TextUtils.isEmpty(device.getOoaid())) {
                str = str.replace(ooaid, device.getOoaid());
            }
            if (!TextUtils.isEmpty(device.getModel())) {
                str = str.replace(model, device.getModel());
            }
            if (!TextUtils.isEmpty(device.getW())) {
                str = str.replace(f64552w, device.getW());
            }
            if (!TextUtils.isEmpty(device.getH())) {
                str = str.replace(f64551h, device.getH());
            }
            if (!TextUtils.isEmpty(device.getMake())) {
                str = str.replace(make, device.getMake());
            }
            if (!TextUtils.isEmpty(device.getBrand())) {
                str = str.replace(brand, device.getBrand());
            }
            if (!TextUtils.isEmpty(device.getBootMark())) {
                str = str.replace(bootMark, device.getBootMark());
            }
            if (!TextUtils.isEmpty(device.getUpdateMark())) {
                str = str.replace(updateMark, device.getUpdateMark());
            }
            if (!TextUtils.isEmpty(device.getFileMark())) {
                str = str.replace(fileMark, device.getFileMark());
            }
            if (!TextUtils.isEmpty(device.getSysUpdateMark())) {
                str = str.replace(sysUpdateMark, device.getSysUpdateMark());
            }
            if (!TextUtils.isEmpty(device.getHarddiskSize())) {
                str = str.replace(harddiskSize, device.getHarddiskSize());
            }
            if (!TextUtils.isEmpty(device.getPhysicalMemory())) {
                str = str.replace(physicalMemory, device.getPhysicalMemory());
            }
            if (!TextUtils.isEmpty(device.getHwModel())) {
                str = str.replace(hwModel, device.getHwModel());
            }
        }
        if (aMPSReportRequestModel.getUser() != null) {
            UserModel user = aMPSReportRequestModel.getUser();
            if (!TextUtils.isEmpty(user.getUserId())) {
                str = str.replace(userId, user.getUserId());
            }
            if (!TextUtils.isEmpty(user.getCustomData())) {
                str = str.replace(userCustomData, user.getCustomData());
            }
        }
        if (aMPSReportRequestModel.getSdk() != null) {
            SdkModel sdk = aMPSReportRequestModel.getSdk();
            if (!TextUtils.isEmpty(sdk.getSdkVersion())) {
                str = str.replace("__AD_SDK_VERSION__", sdk.getSdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getKsSdkVersion())) {
                str = str.replace(ksSdkVersion, sdk.getKsSdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getCsjSdkVersion())) {
                str = str.replace(csjSdkVersion, sdk.getCsjSdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getGmSdkVersion())) {
                str = str.replace(gmSdkVersion, sdk.getGmSdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getGdtSdkVersion())) {
                str = str.replace(gdtSdkVersion, sdk.getGdtSdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getYj4SdkVersion())) {
                str = str.replace(yj4SdkVersion, sdk.getYj4SdkVersion());
            }
            if (!TextUtils.isEmpty(sdk.getYj5SdkVersion())) {
                str = str.replace(yj5SdkVersion, sdk.getYj5SdkVersion());
            }
        }
        if (aMPSReportRequestModel.getAd() != null) {
            AdModel ad = aMPSReportRequestModel.getAd();
            if (!TextUtils.isEmpty(ad.getAccessType())) {
                str = str.replace(accessType, ad.getAccessType());
            }
            if (!TextUtils.isEmpty(ad.getAdSdkVersion())) {
                str = str.replace("__AD_SDK_VERSION__", ad.getAdSdkVersion());
            }
            if (!TextUtils.isEmpty(ad.getLoadType())) {
                str = str.replace(loadType, ad.getLoadType());
            }
            if (!TextUtils.isEmpty(ad.getBidType())) {
                str = str.replace(bidType, ad.getBidType());
            }
            if (!TextUtils.isEmpty(ad.getMaxWaitTime())) {
                str = str.replace(maxWaitTime, ad.getMaxWaitTime());
            }
            if (!TextUtils.isEmpty(ad.getAdType())) {
                str = str.replace(adType, ad.getAdType());
            }
            if (!TextUtils.isEmpty(ad.getFloorPrice())) {
                str = str.replace(floorPrice, ad.getFloorPrice());
            }
            if (!TextUtils.isEmpty(ad.getQuantity())) {
                str = str.replace(quantity, ad.getQuantity());
            }
            return !TextUtils.isEmpty(ad.getExpPrice()) ? str.replace(expPrice, ad.getExpPrice()) : str;
        }
        return str;
    }
}
