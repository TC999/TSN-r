package com.bytedance.msdk.api;

import android.text.TextUtils;
import java.text.MessageFormat;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdError {
    public static final int ADTYPE_NOT_MATCH_RIT = -13;
    public static final int AD_BIDDING_REQUEST_ERROR = -16;
    public static final int AD_DATA_ERROR = -4;
    public static final String AD_ERROR_INTERNAL_ERROR_MSG = "internal error , maybe server no response .";
    public static final int AD_EXPIRED_ERROR = -15;
    public static final String AD_INTERNAL_ERROR_MSG = "internal error\uff0c server no response !";
    public static final String AD_LOAD_AD_TIME_OUT_ERROR_MSG = "load ad timeout !!!";
    public static final String AD_LOAD_FAIL_MSG = "load fail";
    public static final String AD_LOAD_SUCCESS_MSG = "load success";
    public static final String AD_LOAD_TIMEOUT_MSG = "load ad timeout";
    public static final String AD_NETWORK_ERROR_MSG = "network error!";
    public static final String AD_NO_FILL = "load success, but no ad fill !";
    public static final String AD_SLOTID_ERROR_MSG = "ad slotId error!";
    public static final String AD_THIRD_SDK_ADAPTER_CONFIGURATION_ERROR_MSG = "{0} sdk configuration error or initialization fail ";
    public static final String AD_THIRD_SDK_ADAPTER_INITIALIZATION_SUCCESS_MSG = "{0} sdk initialization success ";
    public static final String AD_THIRD_SDK_AD_BLOCKER_DETECTED_MSG = "{0} sdk ad blocker ";
    public static final String AD_THIRD_SDK_AD_SHOW_ERROR_MSG = "{0} sdk ad show error ";
    public static final String AD_THIRD_SDK_DEVICE_ID_ERROR_MSG = "{0} sdk device id error ";
    public static final String AD_THIRD_SDK_FILE_IO_ERROR_MSG = "{0} sdk file io error ";
    public static final String AD_THIRD_SDK_INIT_FAIL_MSG = "{0} sdk initialized fail !!!!";
    public static final String AD_THIRD_SDK_INTERNAL_ERROR_MSG = "{0} sdk internal error ";
    public static final String AD_THIRD_SDK_NOT_INIT_MSG = "{0} sdk not initialized !!!! ";
    public static final String AD_THIRD_SDK_NO_CACHE_CALLBACK_MSG = "sdk no cache callback ";
    public static final String AD_THIRD_SDK_PARARM_ERROR_MSG = "{0} sdk params error !!";
    public static final String AD_UNKNOWN_ERROR_MSG = "unknown error!";
    public static final int BANNER_AD_LOAD_IMAGE_ERROR = -5;
    public static final int ERROR_CODE_ACCESS_METHOD_API_SDK = 40017;
    public static final int ERROR_CODE_ACCESS_METHOD_PASS = 40012;
    public static final int ERROR_CODE_ADAPTER_CONFIGURATION_ERROR = 30012;
    public static final int ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS = 30011;
    public static final int ERROR_CODE_ADCOUNT_ERROR = 40007;
    public static final int ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL = 40044;
    public static final int ERROR_CODE_ADN_SHOW_FAIL = 40046;
    public static final int ERROR_CODE_ADSLOT_CONFIG_ERROR = 40026;
    public static final int ERROR_CODE_ADSLOT_EMPTY = 40004;
    public static final int ERROR_CODE_ADSLOT_ERROR = 40025;
    public static final int ERROR_CODE_ADSLOT_ID_ERROR = 40006;
    public static final int ERROR_CODE_ADSLOT_SIZE_EMPTY = 40005;
    public static final int ERROR_CODE_ADTYPE_DIFFER = 40019;
    public static final int ERROR_CODE_AD_LOAD_FAIL = 20005;
    public static final int ERROR_CODE_AD_LOAD_SUCCESS = 20000;
    public static final int ERROR_CODE_AD_TYPE = 40011;
    public static final int ERROR_CODE_APK_SIGN_CHECK_ERROR = 40021;
    public static final int ERROR_CODE_APP_EMPTY = 40002;
    public static final int ERROR_CODE_BANNER_MODULE_UNABLE = 40032;
    public static final int ERROR_CODE_CACHE_AD_MATERIAL_FAIL = 70002;
    public static final int ERROR_CODE_CONFIG_ERROR = 41006;
    public static final int ERROR_CODE_CONTENT_TYPE = 40000;
    public static final int ERROR_CODE_CONTEXT_ERROR = 41005;
    public static final int ERROR_CODE_EXCEED_FREQCTL = 40041;
    public static final int ERROR_CODE_EXCEED_PACING = 40042;
    public static final int ERROR_CODE_FEED_MODULE_UNABLE = 40035;
    public static final int ERROR_CODE_FULL_MODULE_UNABLE = 40037;
    public static final int ERROR_CODE_GDT_FULL_VIDEO_RENDER_TYPE_MISMATCH = 41001;
    public static final int ERROR_CODE_GDT_INTERSTITIAL_RENDER_TYPE_MISMATCH = 41002;
    public static final int ERROR_CODE_IMAGE_SIZE = 40008;
    public static final int ERROR_CODE_INTERACTION_MODULE_UNABLE = 40033;
    public static final int ERROR_CODE_INTERNAL_ERROR = 20004;
    public static final int ERROR_CODE_LOAD_AD_TIMEOUT = 4011;
    public static final int ERROR_CODE_LOAD_PANGOLIN = 41007;
    public static final int ERROR_CODE_MEDIA_ID = 40009;
    public static final int ERROR_CODE_MEDIA_TYPE = 40010;
    public static final int ERROR_CODE_MSDK_NOT_INIT = 1;
    public static final int ERROR_CODE_NATIVE_MODULE_UNABLE = 40038;
    public static final int ERROR_CODE_NETWORK_ERROR = 20002;
    public static final int ERROR_CODE_NEW_REGISTER_LIMIT = 40020;
    public static final int ERROR_CODE_NO_AD = 20001;
    public static final int ERROR_CODE_NO_CONFIG = 40040;
    public static final int ERROR_CODE_NO_DEVICE_INFO = 40030;
    public static final int ERROR_CODE_ORIGIN_AD_ERROR = 40022;
    public static final int ERROR_CODE_PACKAGE_NAME = 40018;
    public static final int ERROR_CODE_PANGLE_APPID_NO_SAME = 40028;
    public static final int ERROR_CODE_REDIRECT = 40014;
    public static final int ERROR_CODE_RENDER_TYPE_MISMATCH = 41000;
    public static final int ERROR_CODE_REQUEST_CIRCUIT_BREAKER = 40043;
    public static final int ERROR_CODE_REQUEST_ERROR = 70000;
    public static final int ERROR_CODE_REQUEST_INVALID = 40015;
    public static final int ERROR_CODE_REQUEST_PB_ERROR = 40001;
    public static final int ERROR_CODE_REQUEST_TIME_OUT = 70001;
    public static final int ERROR_CODE_REWARD_MODULE_UNABLE = 40036;
    public static final int ERROR_CODE_RIT_ADTYPE_NO_SAME = 40031;
    public static final int ERROR_CODE_SHOW_FAIL_NO_AD = 40052;
    public static final int ERROR_CODE_SLOT_ID_APP_ID_DIFFER = 40016;
    public static final int ERROR_CODE_SLOT_ID_ERROR = 20003;
    public static final int ERROR_CODE_SPLASH_AD_TYPE = 40013;
    public static final int ERROR_CODE_SPLASH_CARRY_BOTTOM = 40027;
    public static final int ERROR_CODE_SPLASH_MODULE_UNABLE = 40034;
    public static final int ERROR_CODE_SYS_ERROR = 50001;
    public static final int ERROR_CODE_THIRD_SDK_AD_BLOCKER_DETECTED = 30004;
    public static final int ERROR_CODE_THIRD_SDK_AD_SHOW_ERROR = 30006;
    public static final int ERROR_CODE_THIRD_SDK_CONFIG_ERROR = 30009;
    public static final int ERROR_CODE_THIRD_SDK_DEVICE_ID_ERROR = 30005;
    public static final int ERROR_CODE_THIRD_SDK_FILE_IO_ERROR = 30003;
    public static final int ERROR_CODE_THIRD_SDK_INIT_FAIL = 30000;
    public static final int ERROR_CODE_THIRD_SDK_INTERNAL_ERROR = 30007;
    public static final int ERROR_CODE_THIRD_SDK_LOAD_FAIL = 30008;
    public static final int ERROR_CODE_THIRD_SDK_NOT_INIT = 30001;
    public static final int ERROR_CODE_THIRD_SDK_NO_CACHE_CALLBACK = 30010;
    public static final int ERROR_CODE_THIRD_SDK_PARARM_ERROR = 30002;
    public static final int ERROR_CODE_UNION_OS_ERROR = 40023;
    public static final int ERROR_CODE_UNION_SDK_TOO_OLD = 40024;
    public static final int ERROR_CODE_UNKNOWN_ERROR = 0;
    public static final int ERROR_CODE_VERIFY_REWARD = 60007;
    public static final int ERROR_CODE_WAP_EMPTY = 40003;
    public static final int FREQUENT_CALL_ERROE = -8;
    public static final int INSERT_AD_LOAD_IMAGE_ERROR = -6;
    public static final int LOAD_AD_TIME_OUT_ERROR = 10003;
    public static final int NET_ERROR = -2;
    public static final int NET_TYPE_ERROR = -14;
    public static final int NO_AD_PARSE = -3;
    public static final int PARSE_FAIL = -1;
    public static final int REDER_AD_LOAD_TIMEOUT = 108;
    public static final int REDER_MAIN_TEMPLATE_LOAD_ERROR = 109;
    public static final int RENDER_DIFF_TEMPLATE_INVALID = 103;
    public static final int RENDER_FAIL_META_INVALID = 104;
    public static final int RENDER_FAIL_TEMPLATE_PARSE_ERROR = 105;
    public static final int RENDER_FAIL_TIMEOUT = 107;
    public static final int RENDER_FAIL_UNKNOWN = 106;
    public static final int RENDER_MAIN_TEMPLATE_INVALID = 102;
    public static final int RENDER_RENDER_PARSE_ERROR = 101;
    public static final int REQUEST_BODY_ERROR = -9;
    public static final int SPLASH_AD_LOAD_IMAGE_ERROR = -7;
    public static final int SPLASH_CACHE_EXPIRED_ERROR = -11;
    public static final int SPLASH_CACHE_PARSE_ERROR = -10;
    public static final int SPLASH_NOT_HAVE_CACHE_ERROR = -12;
    public int code;
    public String message;
    public int thirdSdkErrorCode;
    public String thirdSdkErrorMessage;

    public AdError(int i4, String str) {
        this.code = i4;
        this.message = str;
    }

    public static AdError errorMsg(int i4, String str) {
        if (i4 != 30011) {
            if (i4 != 30012) {
                return AdErrorUtil.obtainAdError(0, AD_UNKNOWN_ERROR_MSG);
            }
            return AdErrorUtil.obtainAdError(ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, messageFormat(AD_THIRD_SDK_ADAPTER_CONFIGURATION_ERROR_MSG, str, new String[0]));
        }
        return AdErrorUtil.obtainAdError(ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS, messageFormat(AD_THIRD_SDK_ADAPTER_INITIALIZATION_SUCCESS_MSG, str, new String[0]));
    }

    public static String getMessage(int i4) {
        switch (i4) {
            case -16:
                return "Bidding \u8bf7\u6c42\u51fa\u9519";
            case -15:
                return "\u5e7f\u544a\u6570\u636e\u8fc7\u671f";
            case -14:
                return "\u7f51\u7edc\u7c7b\u578b\u9519\u8bef\uff0c\u5f53\u524d\u8bbe\u5907\u7684\u7f51\u7edc\u7c7b\u578b\u4e0d\u7b26\u5408\u5f00\u5c4f\u5e7f\u544a\u7684\u52a0\u8f7d\u6761\u4ef6,\u68c0\u67e5\u7f51\u7edc\u72b6\u6001\u5e76\u91cd\u8bd5";
            case -13:
                return "\u5e7f\u544a\u8bf7\u6c42\u4f7f\u7528\u4e86\u9519\u8bef\u4ee3\u7801\u4f4d";
            case -12:
                return "\u7f13\u5b58\u4e2d\u6ca1\u6709\u5f00\u5c4f\u5e7f\u544a";
            case -11:
                return "\u7f13\u5b58\u8fc7\u671f";
            case -10:
                return "\u7f13\u5b58\u89e3\u6790\u5931\u8d25";
            case -9:
                return "\u8bf7\u6c42\u5b9e\u4f53\u4e3a\u7a7a";
            case -8:
                return "\u5e7f\u544a\u8bf7\u6c42\u9891\u7387\u8fc7\u9ad8";
            case -7:
                return "\u5f00\u5c4f\u5e7f\u544a\u56fe\u7247\u52a0\u8f7d\u5931\u8d25";
            case -6:
                return "\u63d2\u5c4f\u5e7f\u544a\u56fe\u7247\u52a0\u8f7d\u5931\u8d25";
            case -5:
                return "Banner\u5e7f\u544a\u52a0\u8f7d\u56fe\u7247\u5931\u8d25";
            case -4:
                return "\u8fd4\u56de\u6570\u636e\u7f3a\u5c11\u5fc5\u8981\u5b57\u6bb5";
            case -3:
                return "\u6ca1\u6709\u89e3\u6790\u5230\u5e7f\u544a";
            case -2:
                return "\u7f51\u7edc\u8bf7\u6c42\u5931\u8d25";
            case -1:
                return "\u89e3\u6790\u5931\u8d25";
            default:
                switch (i4) {
                    case 1:
                        return "MSDK\u8fd8\u672a\u521d\u59cb\u5316";
                    case 4011:
                        return AD_LOAD_TIMEOUT_MSG;
                    case 10003:
                        return AD_LOAD_AD_TIME_OUT_ERROR_MSG;
                    case ERROR_CODE_ADN_SHOW_FAIL /* 40046 */:
                        return "\u5e7f\u544a\u5c55\u793a\u5931\u8d25";
                    case ERROR_CODE_SHOW_FAIL_NO_AD /* 40052 */:
                        return "\u5e7f\u544a\u5c55\u793a\u5931\u8d25\uff0c\u6682\u65e0\u5e7f\u544a\u53ef\u7528\uff0c\u8bf7\u91cd\u65b0\u52a0\u8f7d";
                    case ERROR_CODE_CONTEXT_ERROR /* 41005 */:
                        return "Context\u4e3anull\uff0c\u8bf7\u68c0\u67e5\u4f20\u5165\u7684Context";
                    case ERROR_CODE_SYS_ERROR /* 50001 */:
                        return "\u670d\u52a1\u5668\u9519\u8bef";
                    case ERROR_CODE_VERIFY_REWARD /* 60007 */:
                        return "\u6fc0\u52b1\u89c6\u9891\u9a8c\u8bc1\u670d\u52a1\u5668\u5f02\u5e38\u6216\u5904\u7406\u5931\u8d25";
                    default:
                        switch (i4) {
                            case 101:
                                return "\u6e32\u67d3\u7ed3\u679c\u6570\u636e\u89e3\u6790\u5931\u8d25";
                            case 102:
                                return "\u4e3b\u6a21\u677f\u65e0\u6548";
                            case 103:
                                return "\u6a21\u677f\u5dee\u91cf\u65e0\u6548";
                            case 104:
                                return "\u6a21\u677f\u7269\u6599\u6570\u636e\u5f02\u5e38";
                            case 105:
                                return "\u6a21\u677f\u6570\u636e\u89e3\u6790\u5f02\u5e38";
                            case 106:
                                return "\u6e32\u67d3\u672a\u77e5\u62a5\u9519";
                            case 107:
                                return "\u6e32\u67d3\u8d85\u65f6\u672a\u56de\u8c03";
                            case 108:
                                return "\u6a21\u677f\u5e7f\u544a\u52a0\u8f7d\u8d85\u65f6\u65e0\u8fd4\u56de";
                            case 109:
                                return "\u6a21\u677f\u4e3b\u5f15\u64ce\u52a0\u8f7d\u5931\u8d25";
                            default:
                                switch (i4) {
                                    case 20000:
                                        return AD_LOAD_SUCCESS_MSG;
                                    case 20001:
                                        return AD_NO_FILL;
                                    case 20002:
                                        return AD_NETWORK_ERROR_MSG;
                                    case 20003:
                                        return AD_SLOTID_ERROR_MSG;
                                    case 20004:
                                        return AD_INTERNAL_ERROR_MSG;
                                    case 20005:
                                        return "\u5168\u90e8\u4ee3\u7801\u4f4d\u8bf7\u6c42\u5931\u8d25";
                                    default:
                                        switch (i4) {
                                            case ERROR_CODE_CONTENT_TYPE /* 40000 */:
                                                return "http conent_type\u9519\u8bef";
                                            case ERROR_CODE_REQUEST_PB_ERROR /* 40001 */:
                                                return "http request pb\u9519\u8bef";
                                            case ERROR_CODE_APP_EMPTY /* 40002 */:
                                                return "\u8bf7\u6c42app\u4e0d\u80fd\u4e3a\u7a7a ";
                                            case ERROR_CODE_WAP_EMPTY /* 40003 */:
                                                return "\u8bf7\u6c42wap\u4e0d\u80fd\u4e3a\u7a7a";
                                            case ERROR_CODE_ADSLOT_EMPTY /* 40004 */:
                                                return "\u5e7f\u544a\u4f4d\u4e0d\u80fd\u4e3a\u7a7a";
                                            case ERROR_CODE_ADSLOT_SIZE_EMPTY /* 40005 */:
                                                return "\u5e7f\u544a\u4f4d\u5c3a\u5bf8\u4e0d\u80fd\u4e3a\u7a7a";
                                            case ERROR_CODE_ADSLOT_ID_ERROR /* 40006 */:
                                                return "\u5e7f\u544a\u4f4dID\u4e0d\u5408\u6cd5\u6216\u8005\u672a\u542f\u7528\uff0c\u8bf7\u68c0\u67e5\u5e7f\u544a\u805a\u5408\u5e73\u53f0\u7684\u76f8\u5173\u914d\u7f6e";
                                            case ERROR_CODE_ADCOUNT_ERROR /* 40007 */:
                                                return "\u5e7f\u544a\u6570\u91cf\u9519\u8bef";
                                            case ERROR_CODE_IMAGE_SIZE /* 40008 */:
                                                return "\u56fe\u7247\u5c3a\u5bf8\u9519\u8bef";
                                            case ERROR_CODE_MEDIA_ID /* 40009 */:
                                                return "\u5a92\u4f53\u5e94\u7528ID\u4e0d\u5408\u6cd5";
                                            case ERROR_CODE_MEDIA_TYPE /* 40010 */:
                                                return "\u5a92\u4f53\u7c7b\u578b\u4e0d\u5408\u6cd5";
                                            case ERROR_CODE_AD_TYPE /* 40011 */:
                                                return "\u5e7f\u544a\u7c7b\u578b\u4e0d\u5408\u6cd5";
                                            case ERROR_CODE_ACCESS_METHOD_PASS /* 40012 */:
                                            case ERROR_CODE_ACCESS_METHOD_API_SDK /* 40017 */:
                                                return "\u5a92\u4f53\u63a5\u5165\u7c7b\u578b\u4e0d\u5408\u6cd5";
                                            case ERROR_CODE_SPLASH_AD_TYPE /* 40013 */:
                                                return "\u5f00\u5c4f\u5e7f\u544a\u7c7b\u578b\u5f02\u5e38";
                                            case ERROR_CODE_REDIRECT /* 40014 */:
                                                return "redirect\u53c2\u6570\u4e0d\u6b63\u786e";
                                            case ERROR_CODE_REQUEST_INVALID /* 40015 */:
                                                return "\u5a92\u4f53\u6574\u6539\u8d85\u8fc7\u671f\u9650\uff0c\u8bf7\u6c42\u975e\u6cd5";
                                            case ERROR_CODE_SLOT_ID_APP_ID_DIFFER /* 40016 */:
                                                return "SlotId\u548cAppId\u5339\u914d\u5f02\u5e38";
                                            case ERROR_CODE_PACKAGE_NAME /* 40018 */:
                                                return "\u5a92\u4f53\u5305\u540d\u5f02\u5e38";
                                            case ERROR_CODE_ADTYPE_DIFFER /* 40019 */:
                                                return "\u5a92\u4f53\u914d\u7f6eadtype\u548c\u8bf7\u6c42\u4e0d\u4e00\u81f4";
                                            case ERROR_CODE_NEW_REGISTER_LIMIT /* 40020 */:
                                                return "\u5f00\u53d1\u6ce8\u518c\u65b0\u4e0a\u7ebf\u5e7f\u544a\u4f4d\u8d85\u51fa\u65e5\u8bf7\u6c42\u91cf\u9650\u5236";
                                            case ERROR_CODE_APK_SIGN_CHECK_ERROR /* 40021 */:
                                                return "apk\u7b7e\u540dsha1\u503c\u4e0e\u5a92\u4f53\u5e73\u53f0\u5f55\u5165\u4e0d\u4e00\u81f4";
                                            case ERROR_CODE_ORIGIN_AD_ERROR /* 40022 */:
                                                return "\u5a92\u4f53\u8bf7\u6c42\u7d20\u6750\u662f\u5426\u539f\u751f\u4e0e\u5a92\u4f53\u5e73\u53f0\u5f55\u5165\u4e0d\u4e00\u81f4";
                                            default:
                                                switch (i4) {
                                                    case ERROR_CODE_UNION_SDK_TOO_OLD /* 40024 */:
                                                        return "sdk \u7248\u672c\u8fc7\u4f4e\u4e0d\u8fd4\u56de\u5e7f\u544a";
                                                    case ERROR_CODE_ADSLOT_ERROR /* 40025 */:
                                                        return "\u5e7f\u544a\u4f4d\u9519\u8bef";
                                                    case ERROR_CODE_ADSLOT_CONFIG_ERROR /* 40026 */:
                                                        return "adSlot \u4e0d\u80fd\u4e3a null";
                                                    case ERROR_CODE_SPLASH_CARRY_BOTTOM /* 40027 */:
                                                        return "\u5f00\u5c4f\u5e7f\u544a\u81ea\u5b9a\u4e49\u515c\u5e95\u53c2\u6570\u4e0d\u6b63\u786e\uff0c\u8bf7\u6821\u9a8c";
                                                    case ERROR_CODE_PANGLE_APPID_NO_SAME /* 40028 */:
                                                        return "\u5f00\u5c4f\u5e7f\u544a\u5f00\u53d1\u8005\u81ea\u5b9a\u4e49\u515c\u5e95\u4e2dpangle appId\uff0c\u4e0epangle sdk\u521d\u59cb\u5316\u7684appId\u4e0d\u4e00\u81f4\uff0c\u8bf7\u68c0\u67e5\u5e76\u4f20\u5165\u4e0e\u521d\u59cb\u5316\u76f8\u540cappId";
                                                    default:
                                                        switch (i4) {
                                                            case ERROR_CODE_NO_DEVICE_INFO /* 40030 */:
                                                                return "\u8bf7\u6c42\u53c2\u6570\u7f3a\u5c11\u8bbe\u5907\u4fe1\u606f\u6216\u8005\u7f3a\u5c11\u8bbe\u5907id\u76f8\u5173\u4fe1\u606f";
                                                            case ERROR_CODE_RIT_ADTYPE_NO_SAME /* 40031 */:
                                                                return "\u805a\u5408\u5e7f\u544a\u4f4d\u5bf9\u5e94\u7684\u5e7f\u544a\u7c7b\u578b\u548c\u5f53\u524d\u5e7f\u544a\u7c7b\u578b\u4e0d\u4e00\u81f4";
                                                            case ERROR_CODE_BANNER_MODULE_UNABLE /* 40032 */:
                                                                return "Banner\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_INTERACTION_MODULE_UNABLE /* 40033 */:
                                                                return "\u63d2\u5c4f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_SPLASH_MODULE_UNABLE /* 40034 */:
                                                                return "\u5f00\u5c4f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_FEED_MODULE_UNABLE /* 40035 */:
                                                                return "\u4fe1\u606f\u6d41\u6a21\u677f\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_REWARD_MODULE_UNABLE /* 40036 */:
                                                                return "\u6fc0\u52b1\u89c6\u9891\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_FULL_MODULE_UNABLE /* 40037 */:
                                                                return "\u5168\u5c4f\u89c6\u9891\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            case ERROR_CODE_NATIVE_MODULE_UNABLE /* 40038 */:
                                                                return "\u4fe1\u606f\u6d41\u81ea\u6e32\u67d3\u5e7f\u544a\u6682\u65e0\u5e7f\u544a\u8fd4\u56de\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                            default:
                                                                switch (i4) {
                                                                    case ERROR_CODE_NO_CONFIG /* 40040 */:
                                                                        return "\u6682\u65e0\u914d\u7f6e\u4fe1\u606f\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff0c\u6216\u8005\u6ce8\u518cconfig\u56de\u8c03\uff0c\u5177\u4f53\u53c2\u8003demo";
                                                                    case ERROR_CODE_EXCEED_FREQCTL /* 40041 */:
                                                                        return "\u8d85\u8fc7waterfall\u5c42\u7ea7\u89c4\u5b9a\u7684\u7528\u6237\u5c55\u793a\u4e0a\u9650\uff0c\u5b9e\u9645\u672a\u53d1\u8d77\u8bf7\u6c42";
                                                                    case ERROR_CODE_EXCEED_PACING /* 40042 */:
                                                                        return "\u672a\u8d85\u8fc7waterfall\u5c42\u7ea7\u89c4\u5b9a\u7684\u5c55\u793a\u95f4\u9694\uff0c\u8bf7\u6c42\u9891\u7e41\uff0c\u5b9e\u9645\u672a\u53d1\u8d77\u8bf7\u6c42";
                                                                    case ERROR_CODE_REQUEST_CIRCUIT_BREAKER /* 40043 */:
                                                                        return "\u5e7f\u544a\u8bf7\u6c42\u8fc7\u4e8e\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
                                                                    case ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL /* 40044 */:
                                                                        return "\u5f53\u524dADN\u9650\u5236\u65f6\u95f4\u5185\u4e0d\u5141\u8bb8\u8bf7\u6c42";
                                                                    default:
                                                                        switch (i4) {
                                                                            case ERROR_CODE_RENDER_TYPE_MISMATCH /* 41000 */:
                                                                                return "\u5728\u5e73\u53f0\u914d\u7f6e\u7684\u5e7f\u544a\u6e32\u67d3\u7c7b\u578b\u662f3\uff0c\u53ea\u6709GDT\u4fe1\u606f\u6d41\u6a21\u72482.0\u7684\u7c7b\u578b\u662f3\uff0c\u5176\u4ed6ADN\u90fd\u4e0d\u662f\u3002";
                                                                            case ERROR_CODE_GDT_FULL_VIDEO_RENDER_TYPE_MISMATCH /* 41001 */:
                                                                            case ERROR_CODE_GDT_INTERSTITIAL_RENDER_TYPE_MISMATCH /* 41002 */:
                                                                                return "\u5f53\u524d\u4ee3\u7801\u4f4d\u7684\u6e32\u67d3\u7c7b\u578b\u914d\u7f6e\u6709\u8bef\uff0c\u8bf7\u524d\u5f80\u5e73\u53f0\u786e\u8ba4\u914d\u7f6e\u6216\u8054\u7cfb\u6280\u672f\u652f\u6301\u8fdb\u884c\u6392\u67e5";
                                                                            default:
                                                                                switch (i4) {
                                                                                    case ERROR_CODE_REQUEST_ERROR /* 70000 */:
                                                                                        return "\u8bf7\u6c42\u65f6\u4f7f\u7528\u4e86\u9519\u8bef\u7684\u53c2\u6570\uff0c\u6bd4\u5982\u4f7f\u7528\u9519\u8bef\u7684\u5e7f\u544a\u4f4dID";
                                                                                    case ERROR_CODE_REQUEST_TIME_OUT /* 70001 */:
                                                                                        return "\u8bf7\u6c42\u8d85\u65f6";
                                                                                    case ERROR_CODE_CACHE_AD_MATERIAL_FAIL /* 70002 */:
                                                                                        return "\u7f13\u5b58\u7269\u6599\u5931\u8d25";
                                                                                    default:
                                                                                        return AD_UNKNOWN_ERROR_MSG;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static String messageFormat(String str, String str2, String... strArr) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return null;
        }
        if (strArr != null && strArr.length > 0) {
            return MessageFormat.format(str, str2, strArr);
        }
        return MessageFormat.format(str, str2);
    }

    public String toString() {
        return "AdError{code=" + this.code + ", message='" + this.message + "', thirdSdkErrorCode=" + this.thirdSdkErrorCode + ", thirdSdkErrorMessage='" + this.thirdSdkErrorMessage + "'}";
    }

    public AdError(int i4, String str, int i5, String str2) {
        this.code = i4;
        this.message = str;
        this.thirdSdkErrorCode = i5;
        this.thirdSdkErrorMessage = str2;
    }
}
