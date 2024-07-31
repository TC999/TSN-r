package com.bytedance.msdk.api;

import android.text.TextUtils;
import java.text.MessageFormat;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdError {
    public static final int ADTYPE_NOT_MATCH_RIT = -13;
    public static final int AD_BIDDING_REQUEST_ERROR = -16;
    public static final int AD_DATA_ERROR = -4;
    public static final String AD_ERROR_INTERNAL_ERROR_MSG = "internal error , maybe server no response .";
    public static final int AD_EXPIRED_ERROR = -15;
    public static final String AD_INTERNAL_ERROR_MSG = "internal error， server no response !";
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

    public AdError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public static AdError errorMsg(int i, String str) {
        if (i != 30011) {
            if (i != 30012) {
                return AdErrorUtil.obtainAdError(0, AD_UNKNOWN_ERROR_MSG);
            }
            return AdErrorUtil.obtainAdError(ERROR_CODE_ADAPTER_CONFIGURATION_ERROR, messageFormat(AD_THIRD_SDK_ADAPTER_CONFIGURATION_ERROR_MSG, str, new String[0]));
        }
        return AdErrorUtil.obtainAdError(ERROR_CODE_ADAPTER_INITIALIZATION_SUCCESS, messageFormat(AD_THIRD_SDK_ADAPTER_INITIALIZATION_SUCCESS_MSG, str, new String[0]));
    }

    public static String getMessage(int i) {
        switch (i) {
            case -16:
                return "Bidding 请求出错";
            case -15:
                return "广告数据过期";
            case -14:
                return "网络类型错误，当前设备的网络类型不符合开屏广告的加载条件,检查网络状态并重试";
            case -13:
                return "广告请求使用了错误代码位";
            case -12:
                return "缓存中没有开屏广告";
            case -11:
                return "缓存过期";
            case -10:
                return "缓存解析失败";
            case -9:
                return "请求实体为空";
            case -8:
                return "广告请求频率过高";
            case -7:
                return "开屏广告图片加载失败";
            case -6:
                return "插屏广告图片加载失败";
            case -5:
                return "Banner广告加载图片失败";
            case -4:
                return "返回数据缺少必要字段";
            case -3:
                return "没有解析到广告";
            case -2:
                return "网络请求失败";
            case -1:
                return "解析失败";
            default:
                switch (i) {
                    case 1:
                        return "MSDK还未初始化";
                    case 4011:
                        return AD_LOAD_TIMEOUT_MSG;
                    case 10003:
                        return AD_LOAD_AD_TIME_OUT_ERROR_MSG;
                    case ERROR_CODE_ADN_SHOW_FAIL /* 40046 */:
                        return "广告展示失败";
                    case ERROR_CODE_SHOW_FAIL_NO_AD /* 40052 */:
                        return "广告展示失败，暂无广告可用，请重新加载";
                    case ERROR_CODE_CONTEXT_ERROR /* 41005 */:
                        return "Context为null，请检查传入的Context";
                    case ERROR_CODE_SYS_ERROR /* 50001 */:
                        return "服务器错误";
                    case ERROR_CODE_VERIFY_REWARD /* 60007 */:
                        return "激励视频验证服务器异常或处理失败";
                    default:
                        switch (i) {
                            case 101:
                                return "渲染结果数据解析失败";
                            case 102:
                                return "主模板无效";
                            case 103:
                                return "模板差量无效";
                            case 104:
                                return "模板物料数据异常";
                            case 105:
                                return "模板数据解析异常";
                            case 106:
                                return "渲染未知报错";
                            case 107:
                                return "渲染超时未回调";
                            case 108:
                                return "模板广告加载超时无返回";
                            case 109:
                                return "模板主引擎加载失败";
                            default:
                                switch (i) {
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
                                        return "全部代码位请求失败";
                                    default:
                                        switch (i) {
                                            case ERROR_CODE_CONTENT_TYPE /* 40000 */:
                                                return "http conent_type错误";
                                            case ERROR_CODE_REQUEST_PB_ERROR /* 40001 */:
                                                return "http request pb错误";
                                            case ERROR_CODE_APP_EMPTY /* 40002 */:
                                                return "请求app不能为空 ";
                                            case ERROR_CODE_WAP_EMPTY /* 40003 */:
                                                return "请求wap不能为空";
                                            case ERROR_CODE_ADSLOT_EMPTY /* 40004 */:
                                                return "广告位不能为空";
                                            case ERROR_CODE_ADSLOT_SIZE_EMPTY /* 40005 */:
                                                return "广告位尺寸不能为空";
                                            case ERROR_CODE_ADSLOT_ID_ERROR /* 40006 */:
                                                return "广告位ID不合法或者未启用，请检查广告聚合平台的相关配置";
                                            case ERROR_CODE_ADCOUNT_ERROR /* 40007 */:
                                                return "广告数量错误";
                                            case ERROR_CODE_IMAGE_SIZE /* 40008 */:
                                                return "图片尺寸错误";
                                            case ERROR_CODE_MEDIA_ID /* 40009 */:
                                                return "媒体应用ID不合法";
                                            case ERROR_CODE_MEDIA_TYPE /* 40010 */:
                                                return "媒体类型不合法";
                                            case ERROR_CODE_AD_TYPE /* 40011 */:
                                                return "广告类型不合法";
                                            case ERROR_CODE_ACCESS_METHOD_PASS /* 40012 */:
                                            case ERROR_CODE_ACCESS_METHOD_API_SDK /* 40017 */:
                                                return "媒体接入类型不合法";
                                            case ERROR_CODE_SPLASH_AD_TYPE /* 40013 */:
                                                return "开屏广告类型异常";
                                            case ERROR_CODE_REDIRECT /* 40014 */:
                                                return "redirect参数不正确";
                                            case ERROR_CODE_REQUEST_INVALID /* 40015 */:
                                                return "媒体整改超过期限，请求非法";
                                            case ERROR_CODE_SLOT_ID_APP_ID_DIFFER /* 40016 */:
                                                return "SlotId和AppId匹配异常";
                                            case ERROR_CODE_PACKAGE_NAME /* 40018 */:
                                                return "媒体包名异常";
                                            case ERROR_CODE_ADTYPE_DIFFER /* 40019 */:
                                                return "媒体配置adtype和请求不一致";
                                            case ERROR_CODE_NEW_REGISTER_LIMIT /* 40020 */:
                                                return "开发注册新上线广告位超出日请求量限制";
                                            case ERROR_CODE_APK_SIGN_CHECK_ERROR /* 40021 */:
                                                return "apk签名sha1值与媒体平台录入不一致";
                                            case ERROR_CODE_ORIGIN_AD_ERROR /* 40022 */:
                                                return "媒体请求素材是否原生与媒体平台录入不一致";
                                            default:
                                                switch (i) {
                                                    case ERROR_CODE_UNION_SDK_TOO_OLD /* 40024 */:
                                                        return "sdk 版本过低不返回广告";
                                                    case ERROR_CODE_ADSLOT_ERROR /* 40025 */:
                                                        return "广告位错误";
                                                    case ERROR_CODE_ADSLOT_CONFIG_ERROR /* 40026 */:
                                                        return "adSlot 不能为 null";
                                                    case ERROR_CODE_SPLASH_CARRY_BOTTOM /* 40027 */:
                                                        return "开屏广告自定义兜底参数不正确，请校验";
                                                    case ERROR_CODE_PANGLE_APPID_NO_SAME /* 40028 */:
                                                        return "开屏广告开发者自定义兜底中pangle appId，与pangle sdk初始化的appId不一致，请检查并传入与初始化相同appId";
                                                    default:
                                                        switch (i) {
                                                            case ERROR_CODE_NO_DEVICE_INFO /* 40030 */:
                                                                return "请求参数缺少设备信息或者缺少设备id相关信息";
                                                            case ERROR_CODE_RIT_ADTYPE_NO_SAME /* 40031 */:
                                                                return "聚合广告位对应的广告类型和当前广告类型不一致";
                                                            case ERROR_CODE_BANNER_MODULE_UNABLE /* 40032 */:
                                                                return "Banner广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_INTERACTION_MODULE_UNABLE /* 40033 */:
                                                                return "插屏广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_SPLASH_MODULE_UNABLE /* 40034 */:
                                                                return "开屏广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_FEED_MODULE_UNABLE /* 40035 */:
                                                                return "信息流模板广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_REWARD_MODULE_UNABLE /* 40036 */:
                                                                return "激励视频广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_FULL_MODULE_UNABLE /* 40037 */:
                                                                return "全屏视频广告暂无广告返回，请稍后重试";
                                                            case ERROR_CODE_NATIVE_MODULE_UNABLE /* 40038 */:
                                                                return "信息流自渲染广告暂无广告返回，请稍后重试";
                                                            default:
                                                                switch (i) {
                                                                    case ERROR_CODE_NO_CONFIG /* 40040 */:
                                                                        return "暂无配置信息，请稍后重试，或者注册config回调，具体参考demo";
                                                                    case ERROR_CODE_EXCEED_FREQCTL /* 40041 */:
                                                                        return "超过waterfall层级规定的用户展示上限，实际未发起请求";
                                                                    case ERROR_CODE_EXCEED_PACING /* 40042 */:
                                                                        return "未超过waterfall层级规定的展示间隔，请求频繁，实际未发起请求";
                                                                    case ERROR_CODE_REQUEST_CIRCUIT_BREAKER /* 40043 */:
                                                                        return "广告请求过于频繁，请稍后重试";
                                                                    case ERROR_CODE_ADN_LOAD_FAIL_ERROR_CONTROL /* 40044 */:
                                                                        return "当前ADN限制时间内不允许请求";
                                                                    default:
                                                                        switch (i) {
                                                                            case ERROR_CODE_RENDER_TYPE_MISMATCH /* 41000 */:
                                                                                return "在平台配置的广告渲染类型是3，只有GDT信息流模版2.0的类型是3，其他ADN都不是。";
                                                                            case ERROR_CODE_GDT_FULL_VIDEO_RENDER_TYPE_MISMATCH /* 41001 */:
                                                                            case ERROR_CODE_GDT_INTERSTITIAL_RENDER_TYPE_MISMATCH /* 41002 */:
                                                                                return "当前代码位的渲染类型配置有误，请前往平台确认配置或联系技术支持进行排查";
                                                                            default:
                                                                                switch (i) {
                                                                                    case ERROR_CODE_REQUEST_ERROR /* 70000 */:
                                                                                        return "请求时使用了错误的参数，比如使用错误的广告位ID";
                                                                                    case ERROR_CODE_REQUEST_TIME_OUT /* 70001 */:
                                                                                        return "请求超时";
                                                                                    case ERROR_CODE_CACHE_AD_MATERIAL_FAIL /* 70002 */:
                                                                                        return "缓存物料失败";
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

    public AdError(int i, String str, int i2, String str2) {
        this.code = i;
        this.message = str;
        this.thirdSdkErrorCode = i2;
        this.thirdSdkErrorMessage = str2;
    }
}
