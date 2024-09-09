package xyz.adscope.ad.tool.event.model;

import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeEventReportModel {
    private String accessKey;
    private String accessType;
    private String adSdkVersion;
    private String adType;
    private String ad_space_id;
    private String ad_space_type;
    private String affiliated;
    private String appInstalls;
    private String app_bundle;
    private String app_id;
    private String app_lmt;
    private String app_name;
    private String app_version;
    private String brand;
    private String carrier;
    private String click_results;
    private String click_type;
    private String complain;
    private int connect_type;
    private String country;
    private String createId;
    private String currency;
    private String customId;
    private String customLogger;
    private String custom_gaid;
    private String custom_idfa;
    private String custom_oaid;
    private Float density;
    private String device_name;
    private int device_type;
    private String dsp_id;
    private String error_code;
    private String error_info;
    private String eventCustomData;
    private String eventVersion;
    private String event_code;
    private String event_id;
    private String event_time;
    private String exception;
    private String expPrice;
    private String gaid;
    private String hw_model;
    private String idfa;
    private String idfv;
    private String installTime;
    private String interaction_plan_id;
    private boolean isReport;
    private String isWin;
    private String keywordArray;
    private String language;
    private String logTime;
    private String log_time;
    private String log_version;
    private String make;
    private String manufacturer;
    private String materialId;
    private String maxWaitTime;
    private String model;
    private String oaid;
    private String ogaid;
    private String ooaid;
    private String orderId;
    private String org_key;
    private int orientation;
    private String os;
    private String os_version;
    private String preload_md5;
    private String price;
    private String quantity;
    private String ram_byte;
    private String render_plan_id;
    private String requestUrl_md5;
    private int resolution_height;
    private int resolution_width;
    private String roundTripTime;
    private String said;
    private String sessionId;
    private String startId;
    private String statistics_md5;
    private String storage_byte;
    private String strategy_md5;
    private String system_boot_mark;
    private String system_file_mark;
    private String system_update_mark;
    private String template_md5;
    private String time_zone;
    private long timeout;
    private String ua;
    private String updateMark;
    private String updateTime;
    private String update_md5;
    private String user_id;
    private String user_yob;
    private String winPrice;

    public AdScopeEventReportModel() {
        this.log_time = "";
        this.log_version = "";
        this.startId = "";
        this.org_key = "";
        this.accessKey = "";
        this.customId = "";
        this.customLogger = "";
        this.said = "";
        this.oaid = "";
        this.gaid = "";
        this.idfa = "";
        this.idfv = "";
        this.device_name = "";
        this.manufacturer = "";
        this.brand = "";
        this.model = "";
        this.hw_model = "";
        this.ram_byte = "";
        this.storage_byte = "";
        this.os = "";
        this.os_version = "";
        this.ua = "";
        this.time_zone = "";
        this.language = "";
        this.country = "";
        this.carrier = "";
        this.system_boot_mark = "";
        this.system_update_mark = "";
        this.system_file_mark = "";
        this.app_version = "";
        this.app_name = "";
        this.app_bundle = "";
        this.app_lmt = "";
        this.make = "";
        this.user_id = "";
        this.user_yob = "";
        this.sessionId = "";
        this.roundTripTime = "";
        this.eventCustomData = "";
        this.eventVersion = "";
        this.event_id = "";
        this.event_time = "";
        this.event_code = "";
        this.app_id = "";
        this.ad_space_id = "";
        this.ad_space_type = "";
        this.dsp_id = "";
        this.price = "";
        this.render_plan_id = "";
        this.interaction_plan_id = "";
        this.click_type = "";
        this.click_results = "";
        this.error_code = "";
        this.error_info = "";
        this.update_md5 = "";
        this.requestUrl_md5 = "";
        this.strategy_md5 = "";
        this.template_md5 = "";
        this.preload_md5 = "";
        this.statistics_md5 = "";
        this.custom_oaid = "";
        this.custom_gaid = "";
        this.ooaid = "";
        this.ogaid = "";
        this.custom_idfa = "";
        this.affiliated = "";
        this.exception = "";
        this.logTime = "";
        this.orderId = "";
        this.createId = "";
        this.materialId = "";
        this.keywordArray = "";
        this.accessType = "";
        this.adSdkVersion = "";
        this.maxWaitTime = "";
        this.adType = "";
        this.currency = "";
        this.quantity = "";
        this.isWin = "";
        this.winPrice = "";
        this.expPrice = "";
        this.installTime = "";
        this.updateTime = "";
        this.updateMark = "";
        this.complain = "";
        this.appInstalls = "";
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getAccessType() {
        return this.accessType;
    }

    public String getAdSdkVersion() {
        return this.adSdkVersion;
    }

    public String getAdType() {
        return this.adType;
    }

    public String getAd_space_id() {
        return this.ad_space_id;
    }

    public String getAd_space_type() {
        return this.ad_space_type;
    }

    public String getAffiliated() {
        return this.affiliated;
    }

    public String getAppInstalls() {
        return this.appInstalls;
    }

    public String getApp_bundle() {
        return this.app_bundle;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public String getApp_lmt() {
        return this.app_lmt;
    }

    public String getApp_name() {
        return this.app_name;
    }

    public String getApp_version() {
        return this.app_version;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getClick_results() {
        return this.click_results;
    }

    public String getClick_type() {
        return this.click_type;
    }

    public String getComplain() {
        return this.complain;
    }

    public int getConnect_type() {
        return this.connect_type;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCreateId() {
        return this.createId;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCustomId() {
        return this.customId;
    }

    public String getCustomLogger() {
        return this.customLogger;
    }

    public String getCustom_gaid() {
        return this.custom_gaid;
    }

    public String getCustom_idfa() {
        return this.custom_idfa;
    }

    public String getCustom_oaid() {
        return this.custom_oaid;
    }

    public Float getDensity() {
        return this.density;
    }

    public String getDevice_name() {
        return this.device_name;
    }

    public int getDevice_type() {
        return this.device_type;
    }

    public String getDsp_id() {
        return this.dsp_id;
    }

    public String getError_code() {
        return this.error_code;
    }

    public String getError_info() {
        return this.error_info;
    }

    public String getEventCustomData() {
        return this.eventCustomData;
    }

    public String getEventVersion() {
        return this.eventVersion;
    }

    public String getEvent_code() {
        return this.event_code;
    }

    public String getEvent_id() {
        return this.event_id;
    }

    public String getEvent_time() {
        return this.event_time;
    }

    public String getException() {
        return this.exception;
    }

    public String getExpPrice() {
        return this.expPrice;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getHw_model() {
        return this.hw_model;
    }

    public String getIdfa() {
        return this.idfa;
    }

    public String getIdfv() {
        return this.idfv;
    }

    public String getInstallTime() {
        return this.installTime;
    }

    public String getInteraction_plan_id() {
        return this.interaction_plan_id;
    }

    public String getIsWin() {
        return this.isWin;
    }

    public String getKeywordArray() {
        return this.keywordArray;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getLogTime() {
        return this.logTime;
    }

    public String getLog_time() {
        return this.log_time;
    }

    public String getLog_version() {
        return this.log_version;
    }

    public String getMake() {
        return this.make;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getMaterialId() {
        return this.materialId;
    }

    public String getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public String getModel() {
        return this.model;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOgaid() {
        return this.ogaid;
    }

    public String getOoaid() {
        return this.ooaid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getOrg_key() {
        return this.org_key;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getOs() {
        return this.os;
    }

    public String getOs_version() {
        return this.os_version;
    }

    public String getPreload_md5() {
        return this.preload_md5;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getRam_byte() {
        return this.ram_byte;
    }

    public String getRender_plan_id() {
        return this.render_plan_id;
    }

    public String getRequestUrl_md5() {
        return this.requestUrl_md5;
    }

    public int getResolution_height() {
        return this.resolution_height;
    }

    public int getResolution_width() {
        return this.resolution_width;
    }

    public String getRoundTripTime() {
        return this.roundTripTime;
    }

    public String getSaid() {
        return this.said;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getStartId() {
        return this.startId;
    }

    public String getStatistics_md5() {
        return this.statistics_md5;
    }

    public String getStorage_byte() {
        return this.storage_byte;
    }

    public String getStrategy_md5() {
        return this.strategy_md5;
    }

    public String getSystem_boot_mark() {
        return this.system_boot_mark;
    }

    public String getSystem_file_mark() {
        return this.system_file_mark;
    }

    public String getSystem_update_mark() {
        return this.system_update_mark;
    }

    public String getTemplate_md5() {
        return this.template_md5;
    }

    public String getTime_zone() {
        return this.time_zone;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getUa() {
        return this.ua;
    }

    public String getUpdateMark() {
        return this.updateMark;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getUpdate_md5() {
        return this.update_md5;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getUser_yob() {
        return this.user_yob;
    }

    public String getWinPrice() {
        return this.winPrice;
    }

    public boolean isReport() {
        return this.isReport;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setAccessType(String str) {
        this.accessType = str;
    }

    public void setAdSdkVersion(String str) {
        this.adSdkVersion = str;
    }

    public void setAdType(String str) {
        this.adType = str;
    }

    public void setAd_space_id(String str) {
        this.ad_space_id = str;
    }

    public void setAd_space_type(String str) {
        this.ad_space_type = str;
    }

    public void setAffiliated(String str) {
        this.affiliated = str;
    }

    public void setAppInstalls(String str) {
        this.appInstalls = str;
    }

    public void setApp_bundle(String str) {
        this.app_bundle = str;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public void setApp_lmt(String str) {
        this.app_lmt = str;
    }

    public void setApp_name(String str) {
        this.app_name = str;
    }

    public void setApp_version(String str) {
        this.app_version = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCarrier(String str) {
        this.carrier = str;
    }

    public void setClick_results(String str) {
        this.click_results = str;
    }

    public void setClick_type(String str) {
        this.click_type = str;
    }

    public void setComplain(String str) {
        this.complain = str;
    }

    public void setConnect_type(int i4) {
        this.connect_type = i4;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreateId(String str) {
        this.createId = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCustomId(String str) {
        this.customId = str;
    }

    public void setCustomLogger(String str) {
        this.customLogger = str;
    }

    public void setCustom_gaid(String str) {
        this.custom_gaid = str;
    }

    public void setCustom_idfa(String str) {
        this.custom_idfa = str;
    }

    public void setCustom_oaid(String str) {
        this.custom_oaid = str;
    }

    public void setDensity(Float f4) {
        this.density = f4;
    }

    public void setDevice_name(String str) {
        this.device_name = str;
    }

    public void setDevice_type(int i4) {
        this.device_type = i4;
    }

    public void setDsp_id(String str) {
        this.dsp_id = str;
    }

    public void setError_code(String str) {
        this.error_code = str;
    }

    public void setError_info(String str) {
        this.error_info = str;
    }

    public void setEventCustomData(String str) {
        this.eventCustomData = str;
    }

    public void setEventVersion(String str) {
        this.eventVersion = str;
    }

    public void setEvent_code(String str) {
        this.event_code = str;
    }

    public void setEvent_id(String str) {
        this.event_id = str;
    }

    public void setEvent_time(String str) {
        this.event_time = str;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void setExpPrice(String str) {
        this.expPrice = str;
    }

    public void setGaid(String str) {
        this.gaid = str;
    }

    public void setHw_model(String str) {
        this.hw_model = str;
    }

    public void setIdfa(String str) {
        this.idfa = str;
    }

    public void setIdfv(String str) {
        this.idfv = str;
    }

    public void setInstallTime(String str) {
        this.installTime = str;
    }

    public void setInteraction_plan_id(String str) {
        this.interaction_plan_id = str;
    }

    public void setIsWin(String str) {
        this.isWin = str;
    }

    public void setKeywordArray(String str) {
        this.keywordArray = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLogTime(String str) {
        this.logTime = str;
    }

    public void setLog_time(String str) {
        this.log_time = str;
    }

    public void setLog_version(String str) {
        this.log_version = str;
    }

    public void setMake(String str) {
        this.make = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setMaterialId(String str) {
        this.materialId = str;
    }

    public void setMaxWaitTime(String str) {
        this.maxWaitTime = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOgaid(String str) {
        this.ogaid = str;
    }

    public void setOoaid(String str) {
        this.ooaid = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOrg_key(String str) {
        this.org_key = str;
    }

    public void setOrientation(int i4) {
        this.orientation = i4;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setOs_version(String str) {
        this.os_version = str;
    }

    public void setPreload_md5(String str) {
        this.preload_md5 = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setRam_byte(String str) {
        this.ram_byte = str;
    }

    public void setRender_plan_id(String str) {
        this.render_plan_id = str;
    }

    public void setReport(boolean z3) {
        this.isReport = z3;
    }

    public void setRequestUrl_md5(String str) {
        this.requestUrl_md5 = str;
    }

    public void setResolution_height(int i4) {
        this.resolution_height = i4;
    }

    public void setResolution_width(int i4) {
        this.resolution_width = i4;
    }

    public void setRoundTripTime(String str) {
        this.roundTripTime = str;
    }

    public void setSaid(String str) {
        this.said = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setStartId(String str) {
        this.startId = str;
    }

    public void setStatistics_md5(String str) {
        this.statistics_md5 = str;
    }

    public void setStorage_byte(String str) {
        this.storage_byte = str;
    }

    public void setStrategy_md5(String str) {
        this.strategy_md5 = str;
    }

    public void setSystem_boot_mark(String str) {
        this.system_boot_mark = str;
    }

    public void setSystem_file_mark(String str) {
        this.system_file_mark = str;
    }

    public void setSystem_update_mark(String str) {
        this.system_update_mark = str;
    }

    public void setTemplate_md5(String str) {
        this.template_md5 = str;
    }

    public void setTime_zone(String str) {
        this.time_zone = str;
    }

    public void setTimeout(long j4) {
        this.timeout = j4;
    }

    public void setUa(String str) {
        this.ua = str;
    }

    public void setUpdateMark(String str) {
        this.updateMark = str;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public void setUpdate_md5(String str) {
        this.update_md5 = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public void setUser_yob(String str) {
        this.user_yob = str;
    }

    public void setWinPrice(String str) {
        this.winPrice = str;
    }

    public String toString() {
        return "{\"log_time\":\"" + this.log_time + "\", \"log_version\":\"" + this.log_version + "\", \"startId\":\"" + this.startId + "\", \"org_key\":\"" + this.org_key + "\", \"accessKey\":\"" + this.accessKey + "\", \"customId\":\"" + this.customId + "\", \"customLogger\":\"" + this.customLogger + "\", \"said\":\"" + this.said + "\", \"oaid\":\"" + this.oaid + "\", \"gaid\":\"" + this.gaid + "\", \"idfa\":\"" + this.idfa + "\", \"idfv\":\"" + this.idfv + "\", \"device_name\":\"" + this.device_name + "\", \"device_type\":" + this.device_type + ", \"manufacturer\":\"" + this.manufacturer + "\", \"brand\":\"" + this.brand + "\", \"model\":\"" + this.model + "\", \"hw_model\":\"" + this.hw_model + "\", \"ram_byte\":\"" + this.ram_byte + "\", \"make\":\"" + this.make + "\", \"storage_byte\":\"" + this.storage_byte + "\", \"resolution_width\":" + this.resolution_width + ", \"resolution_height\":" + this.resolution_height + ", \"density\":" + this.density + ", \"orientation\":" + this.orientation + ", \"os\":\"" + this.os + "\", \"os_version\":\"" + this.os_version + "\", \"ua\":\"" + this.ua + "\", \"time_zone\":\"" + this.time_zone + "\", \"language\":\"" + this.language + "\", \"country\":\"" + this.country + "\", \"carrier\":\"" + this.carrier + "\", \"system_boot_mark\":\"" + this.system_boot_mark + "\", \"system_update_mark\":\"" + this.system_update_mark + "\", \"system_file_mark\":\"" + this.system_file_mark + "\", \"connect_type\":" + this.connect_type + ", \"app_version\":\"" + this.app_version + "\", \"app_name\":\"" + this.app_name + "\", \"app_bundle\":\"" + this.app_bundle + "\", \"app_lmt\":\"" + this.app_lmt + "\", \"user_id\":\"" + this.user_id + "\", \"user_yob\":\"" + this.user_yob + "\", \"event_id\":\"" + this.event_id + "\", \"event_time\":\"" + this.event_time + "\", \"event_code\":\"" + this.event_code + "\", \"timeout\":" + this.timeout + ", \"app_id\":\"" + this.app_id + "\", \"ad_space_id\":\"" + this.ad_space_id + "\", \"ad_space_type\":\"" + this.ad_space_type + "\", \"dsp_id\":\"" + this.dsp_id + "\", \"price\":\"" + this.price + "\", \"render_plan_id\":\"" + this.render_plan_id + "\", \"interaction_plan_id\":\"" + this.interaction_plan_id + "\", \"click_type\":\"" + this.click_type + "\", \"click_results\":\"" + this.click_results + "\", \"error_code\":\"" + this.error_code + "\", \"error_info\":\"" + this.error_info + "\", \"update_md5\":\"" + this.update_md5 + "\", \"requestUrl_md5\":\"" + this.requestUrl_md5 + "\", \"strategy_md5\":\"" + this.strategy_md5 + "\", \"template_md5\":\"" + this.template_md5 + "\", \"preload_md5\":\"" + this.preload_md5 + "\", \"statistics_md5\":\"" + this.statistics_md5 + "\", \"custom_oaid\":\"" + this.custom_oaid + "\", \"custom_gaid\":\"" + this.custom_gaid + "\", \"ooaid\":\"" + this.ooaid + "\", \"ogaid\":\"" + this.ogaid + "\", \"custom_idfa\":\"" + this.custom_idfa + "\", \"affiliated\":\"" + this.affiliated + "\", \"exception\":\"" + this.exception + "\", \"orderId\":\"" + this.orderId + "\", \"createId\":\"" + this.createId + "\", \"materialId\":\"" + this.materialId + "\", \"logTime\":\"" + this.logTime + "\", \"keywordArray\":\"" + JsonUtil.addEscapeChar(this.keywordArray) + "\", \"accessType\":\"" + this.accessType + "\", \"adSdkVersion\":\"" + this.adSdkVersion + "\", \"maxWaitTime\":\"" + this.maxWaitTime + "\", \"adType\":\"" + this.adType + "\", \"currency\":\"" + this.currency + "\", \"quantity\":\"" + this.quantity + "\", \"updateMark\":\"" + this.updateMark + "\", \"isWin\":\"" + this.isWin + "\", \"winPrice\":\"" + this.winPrice + "\", \"expPrice\":\"" + this.expPrice + "\", \"installTime\":\"" + this.installTime + "\", \"updateTime\":\"" + this.updateTime + "\", \"complain\":\"" + this.complain + "\", \"sessionId\":\"" + this.sessionId + "\", \"appInstalls\":\"" + this.appInstalls + "\", \"roundTripTime\":\"" + this.roundTripTime + "\", \"eventCustomData\":\"" + this.eventCustomData + "\", \"eventVersion\":\"" + this.eventVersion + "\", \"isReport\":" + this.isReport + '}';
    }

    public AdScopeEventReportModel(AdScopeEventReportModel adScopeEventReportModel) {
        this.log_time = "";
        this.log_version = "";
        this.startId = "";
        this.org_key = "";
        this.accessKey = "";
        this.customId = "";
        this.customLogger = "";
        this.said = "";
        this.oaid = "";
        this.gaid = "";
        this.idfa = "";
        this.idfv = "";
        this.device_name = "";
        this.manufacturer = "";
        this.brand = "";
        this.model = "";
        this.hw_model = "";
        this.ram_byte = "";
        this.storage_byte = "";
        this.os = "";
        this.os_version = "";
        this.ua = "";
        this.time_zone = "";
        this.language = "";
        this.country = "";
        this.carrier = "";
        this.system_boot_mark = "";
        this.system_update_mark = "";
        this.system_file_mark = "";
        this.app_version = "";
        this.app_name = "";
        this.app_bundle = "";
        this.app_lmt = "";
        this.make = "";
        this.user_id = "";
        this.user_yob = "";
        this.sessionId = "";
        this.roundTripTime = "";
        this.eventCustomData = "";
        this.eventVersion = "";
        this.event_id = "";
        this.event_time = "";
        this.event_code = "";
        this.app_id = "";
        this.ad_space_id = "";
        this.ad_space_type = "";
        this.dsp_id = "";
        this.price = "";
        this.render_plan_id = "";
        this.interaction_plan_id = "";
        this.click_type = "";
        this.click_results = "";
        this.error_code = "";
        this.error_info = "";
        this.update_md5 = "";
        this.requestUrl_md5 = "";
        this.strategy_md5 = "";
        this.template_md5 = "";
        this.preload_md5 = "";
        this.statistics_md5 = "";
        this.custom_oaid = "";
        this.custom_gaid = "";
        this.ooaid = "";
        this.ogaid = "";
        this.custom_idfa = "";
        this.affiliated = "";
        this.exception = "";
        this.logTime = "";
        this.orderId = "";
        this.createId = "";
        this.materialId = "";
        this.keywordArray = "";
        this.accessType = "";
        this.adSdkVersion = "";
        this.maxWaitTime = "";
        this.adType = "";
        this.currency = "";
        this.quantity = "";
        this.isWin = "";
        this.winPrice = "";
        this.expPrice = "";
        this.installTime = "";
        this.updateTime = "";
        this.updateMark = "";
        this.complain = "";
        this.appInstalls = "";
        this.log_time = adScopeEventReportModel.getLog_time();
        this.log_version = adScopeEventReportModel.getLog_version();
        this.startId = adScopeEventReportModel.getStartId();
        this.org_key = adScopeEventReportModel.getOrg_key();
        this.accessKey = adScopeEventReportModel.getAccessKey();
        this.customId = adScopeEventReportModel.getCustomId();
        this.customLogger = adScopeEventReportModel.getCustomLogger();
        this.said = adScopeEventReportModel.getSaid();
        this.oaid = adScopeEventReportModel.getOaid();
        this.gaid = adScopeEventReportModel.getGaid();
        this.idfa = adScopeEventReportModel.getIdfa();
        this.idfv = adScopeEventReportModel.getIdfv();
        this.device_name = adScopeEventReportModel.getDevice_name();
        this.device_type = adScopeEventReportModel.getDevice_type();
        this.manufacturer = adScopeEventReportModel.getManufacturer();
        this.brand = adScopeEventReportModel.getBrand();
        this.model = adScopeEventReportModel.getModel();
        this.hw_model = adScopeEventReportModel.getHw_model();
        this.ram_byte = adScopeEventReportModel.getRam_byte();
        this.storage_byte = adScopeEventReportModel.getStorage_byte();
        this.resolution_width = adScopeEventReportModel.getResolution_width();
        this.resolution_height = adScopeEventReportModel.getResolution_height();
        this.density = adScopeEventReportModel.getDensity();
        this.orientation = adScopeEventReportModel.getOrientation();
        this.os = adScopeEventReportModel.getOs();
        this.os_version = adScopeEventReportModel.getOs_version();
        this.ua = adScopeEventReportModel.getUa();
        this.time_zone = adScopeEventReportModel.getTime_zone();
        this.language = adScopeEventReportModel.getLanguage();
        this.country = adScopeEventReportModel.getCountry();
        this.carrier = adScopeEventReportModel.getCarrier();
        this.system_boot_mark = adScopeEventReportModel.getSystem_boot_mark();
        this.system_update_mark = adScopeEventReportModel.getSystem_update_mark();
        this.system_file_mark = adScopeEventReportModel.getSystem_file_mark();
        this.connect_type = adScopeEventReportModel.getConnect_type();
        this.app_version = adScopeEventReportModel.getApp_version();
        this.app_name = adScopeEventReportModel.getApp_name();
        this.app_bundle = adScopeEventReportModel.getApp_bundle();
        this.app_lmt = adScopeEventReportModel.getApp_lmt();
        this.make = adScopeEventReportModel.getMake();
        this.user_id = adScopeEventReportModel.getUser_id();
        this.user_yob = adScopeEventReportModel.getUser_yob();
        this.sessionId = adScopeEventReportModel.getSessionId();
        this.roundTripTime = adScopeEventReportModel.getRoundTripTime();
        this.eventCustomData = adScopeEventReportModel.getEventCustomData();
        this.eventVersion = adScopeEventReportModel.getEventVersion();
        this.event_id = adScopeEventReportModel.getEvent_id();
        this.event_time = adScopeEventReportModel.getEvent_time();
        this.event_code = adScopeEventReportModel.getEvent_code();
        this.timeout = adScopeEventReportModel.getTimeout();
        this.app_id = adScopeEventReportModel.getApp_id();
        this.ad_space_id = adScopeEventReportModel.getAd_space_id();
        this.ad_space_type = adScopeEventReportModel.getAd_space_type();
        this.dsp_id = adScopeEventReportModel.getDsp_id();
        this.price = adScopeEventReportModel.getPrice();
        this.render_plan_id = adScopeEventReportModel.getRender_plan_id();
        this.interaction_plan_id = adScopeEventReportModel.getInteraction_plan_id();
        this.click_type = adScopeEventReportModel.getClick_type();
        this.click_results = adScopeEventReportModel.getClick_results();
        this.error_code = adScopeEventReportModel.getError_code();
        this.error_info = adScopeEventReportModel.getError_info();
        this.update_md5 = adScopeEventReportModel.getUpdate_md5();
        this.requestUrl_md5 = adScopeEventReportModel.getRequestUrl_md5();
        this.strategy_md5 = adScopeEventReportModel.getStrategy_md5();
        this.template_md5 = adScopeEventReportModel.getTemplate_md5();
        this.preload_md5 = adScopeEventReportModel.getPreload_md5();
        this.statistics_md5 = adScopeEventReportModel.getStatistics_md5();
        this.custom_oaid = adScopeEventReportModel.getCustom_oaid();
        this.custom_gaid = adScopeEventReportModel.getCustom_gaid();
        this.ooaid = adScopeEventReportModel.getOoaid();
        this.ogaid = adScopeEventReportModel.getOgaid();
        this.custom_idfa = adScopeEventReportModel.getCustom_idfa();
        this.affiliated = adScopeEventReportModel.getAffiliated();
        this.exception = adScopeEventReportModel.getException();
        this.logTime = adScopeEventReportModel.getLogTime();
        this.isReport = adScopeEventReportModel.isReport();
        this.orderId = adScopeEventReportModel.getOrderId();
        this.createId = adScopeEventReportModel.getCreateId();
        this.materialId = adScopeEventReportModel.getMaterialId();
        this.keywordArray = adScopeEventReportModel.getKeywordArray();
        this.accessType = adScopeEventReportModel.getAccessType();
        this.adSdkVersion = adScopeEventReportModel.getAdSdkVersion();
        this.maxWaitTime = adScopeEventReportModel.getMaxWaitTime();
        this.adType = adScopeEventReportModel.getAdType();
        this.currency = adScopeEventReportModel.getCurrency();
        this.quantity = adScopeEventReportModel.getQuantity();
        this.isWin = adScopeEventReportModel.getIsWin();
        this.winPrice = adScopeEventReportModel.getWinPrice();
        this.expPrice = adScopeEventReportModel.getExpPrice();
        this.installTime = adScopeEventReportModel.getInstallTime();
        this.updateTime = adScopeEventReportModel.getUpdateTime();
        this.updateMark = adScopeEventReportModel.getUpdateMark();
        this.complain = adScopeEventReportModel.getComplain();
        this.appInstalls = adScopeEventReportModel.getAppInstalls();
    }
}
