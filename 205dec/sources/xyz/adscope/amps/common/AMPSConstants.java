package xyz.adscope.amps.common;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSConstants {
    public static final String ACCEPT_ENCRYPT = "Accept-Encrypt";
    public static final String ACCEPT_ENCRYPT_DEFAULT = "101,1001";
    public static final String ADAPTER_NAME_PRE = "xyz.adscope.amps.adapter";
    public static final String AMPS_APPID = "amps_appid";
    public static final String AMPS_CHANNEL_LOG_TAG_ASNP = "ASNPSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_BD = "BDSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_BZ = "BZSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_CSJ = "CSJSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_GDT = "GDTSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_GM = "GMSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_HW = "HWSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_KS = "KSSDK";
    public static final String AMPS_CHANNEL_LOG_TAG_QM = "QMSDK";
    public static final String AMPS_CHANNEL_NETWORK_NAME_ASNP = "ASNP";
    public static final String AMPS_CHANNEL_NETWORK_NAME_BD = "BD";
    public static final String AMPS_CHANNEL_NETWORK_NAME_BZ = "BZ";
    public static final String AMPS_CHANNEL_NETWORK_NAME_CSJ = "CSJ";
    public static final String AMPS_CHANNEL_NETWORK_NAME_GDT = "GDT";
    public static final String AMPS_CHANNEL_NETWORK_NAME_GM = "GM";
    public static final String AMPS_CHANNEL_NETWORK_NAME_HW = "HW";
    public static final String AMPS_CHANNEL_NETWORK_NAME_KS = "KS";
    public static final String AMPS_CHANNEL_NETWORK_NAME_QM = "QM";
    public static final String AMPS_CONFIG_URL = "aHR0cDovL3Nkay1hcGkuYmVpemkuYml6L3YxL2FwaS9zZGsvY2Zn";
    public static final String AMPS_CONFIG_URL_TRANSFER_PROTOCOL = "aHR0cHM6Ly9zZGstYXBpLmJlaXppLmJpei92MS9hcGkvc2RrL2NmZw==";
    public static final String AMPS_CRASH_REASON_KEY = "amps_crash_reason_key";
    public static final String AMPS_CRASH_REPORT_KEY = "ampsCrashReport";
    public static final String AMPS_CRASH_REQUEST_SDK_PACKAGENAME = "crash_request_sdk";
    public static final String AMPS_GLOBALCONFIG = "amps_global_config";
    public static final String AMPS_LOG_TAG = "amps_log_tag";
    public static final String AMPS_LOG_TAG_REPORT = "amps_log_report";
    public static int AMPS_SEND_BID_DATA_TYPE_0 = 0;
    public static int AMPS_SEND_BID_DATA_TYPE_1 = 1;
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_ASNP = "xyz.adscope.amps.adapter.asnp.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_BD = "xyz.adscope.amps.adapter.bd.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_BZ = "xyz.adscope.amps.adapter.bz.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_CSJ = "xyz.adscope.amps.adapter.csj.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_GDT = "xyz.adscope.amps.adapter.gdt.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_GM = "xyz.adscope.amps.adapter.gm.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_HW = "xyz.adscope.amps.adapter.hw.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_KS = "xyz.adscope.amps.adapter.ks.ASNPInitMediation";
    public static final String CHANNEL_ADAPTER_INIT_CLASSNAME_QM = "xyz.adscope.amps.adapter.qm.ASNPInitMediation";
    public static final String CHANNEL_SDK_ASNP_CLASSNAME = "xyz.adscope.ad.AdScopeSDK";
    public static final String CHANNEL_SDK_BAIDU_CLASSNAME = "com.baidu.mobads.sdk.api.BDAdConfig";
    public static final String CHANNEL_SDK_BZ_CLASSNAME = "com.beizi.fusion.BeiZis";
    public static final String CHANNEL_SDK_CSJ_CLASSNAME = "com.bytedance.sdk.openadsdk.TTAdSdk";
    public static final String CHANNEL_SDK_GDT_CLASSNAME = "com.qq.e.comm.managers.GDTAdSdk";
    public static final String CHANNEL_SDK_GM_CLASSNAME = "com.bytedance.sdk.openadsdk.TTAdSdk";
    public static final String CHANNEL_SDK_HW_CLASSNAME = "com.huawei.hms.ads.HwAds";
    public static final String CHANNEL_SDK_KS_CLASSNAME = "com.kwad.sdk.api.KsAdSDK";
    public static final String CHANNEL_SDK_QM_CLASSNAME = "com.qumeng.advlib.api.AiClkAdManager";
    public static final String RESOURCE_HEAD = "amps";

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdAutoRefreshSwitchStatus {
        public static final int AD_AUTO_REFRESH_SWITCH_STATUS_CLOSE = 0;
        public static final int AD_AUTO_REFRESH_SWITCH_STATUS_OPEN = 1;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdLoadStatus {
        public static final int AD_LOAD_STATUS_FAIL = 3;
        public static final int AD_LOAD_STATUS_LOADING = 1;
        public static final int AD_LOAD_STATUS_NORMAL = 0;
        public static final int AD_LOAD_STATUS_SUCCESS = 2;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdLoadType {
        public static final int AD_LOAD_TYPE_AUTO_REFRESH = 2;
        public static final int AD_LOAD_TYPE_NORMAL = 0;
        public static final int AD_LOAD_TYPE_PRELOAD = 1;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdRequestType {
        public static final int AD_REQUEST_TYPE_PARALLEL = 0;
        public static final int AD_REQUEST_TYPE_SERIAL = 1;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdResourceStatus {
        public static final int AD_RESOURCE_STATUS_BIDDING = 2;
        public static final int AD_RESOURCE_STATUS_BIDDING_SUCCESS = 3;
        public static final int AD_RESOURCE_STATUS_DISPATCH = 1;
        public static final int AD_RESOURCE_STATUS_FAIL = 6;
        public static final int AD_RESOURCE_STATUS_LOADING = 4;
        public static final int AD_RESOURCE_STATUS_LOADING_SUCCESS = 5;
        public static final int AD_RESOURCE_STATUS_NORMAL = 0;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdSourceComparePriceStatus {
        public static final int AD_SOURCE_COMPARE_PRICE_STATUS_BIDDING_WIN = 2;
        public static final int AD_SOURCE_COMPARE_PRICE_STATUS_LOAD_WIN = 3;
        public static final int AD_SOURCE_COMPARE_PRICE_STATUS_LOSS = 4;
        public static final int AD_SOURCE_COMPARE_PRICE_STATUS_NORMAL = 0;
        public static final int AD_SOURCE_COMPARE_PRICE_STATUS_WAIT = 1;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdSourceFloorType {
        public static final int AD_SOURCE_FLOOR_TYPE_FLOOR = 1;
        public static final int AD_SOURCE_FLOOR_TYPE_NORML = 0;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class AdType {
        public static final String AD_TYPE_NATIVE = "native";
        public static final String AD_TYPE_SPLASH = "splash";
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class BiddingLossReason {
        public static final int BIDDING_LOSS_REASON_LOW_PRICE = 1;
        public static final int BIDDING_LOSS_REASON_NO_PRICE = 2;
        public static final int BIDDING_LOSS_REASON_OTHER = 4;
        public static final int BIDDING_LOSS_REASON_TIME_OUT = 3;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class BiddingType {
        public static final String BIDDING_TYPE_C2S = "C2S";
        public static final String BIDDING_TYPE_OTHER = "other";
        public static final String BIDDING_TYPE_S2S = "S2S";
        public static final String BIDDING_TYPE_WF = "WF";
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class BiddingWinnerSource {
        public static final int OTHER_BIDDING_AD = 4;
        public static final int OTHER_NOT_BIDDING_AD = 1;
        public static final int OTHER_SELF_SALE_AD = 3;
        public static final int OTHER_THE_THIRD_ADN = 2;
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class ChannelName {
        public static final String CHANNEL_NAME_ASNP = "8888";
        public static final String CHANNEL_NAME_BD = "1018";
        public static final String CHANNEL_NAME_BZ = "6666";
        public static final String CHANNEL_NAME_CSJ = "1013";
        public static final String CHANNEL_NAME_GDT = "1012";
        public static final String CHANNEL_NAME_GM = "1022";
        public static final String CHANNEL_NAME_HW = "1020";
        public static final String CHANNEL_NAME_KS = "1019";
        public static final String CHANNEL_NAME_OTHER = "-1";
        public static final String CHANNEL_NAME_QM = "1030";
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class FrequencyEventType {
        public static final String FREQUENCY_EVENT_TYPE_CLICK = "click";
        public static final String FREQUENCY_EVENT_TYPE_REQUEST = "request";
        public static final String FREQUENCY_EVENT_TYPE_SHOW = "show";
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class SpaceAdStatus {
        public static final int SPACE_AD_STATUS_FAIL = 3;
        public static final int SPACE_AD_STATUS_LOAD_SUCCESS = 1;
        public static final int SPACE_AD_STATUS_NORMAL = 0;
        public static final int SPACE_AD_STATUS_SHOW = 2;
    }
}
