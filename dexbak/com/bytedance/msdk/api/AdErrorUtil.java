package com.bytedance.msdk.api;

import com.p518qq.p519e.comm.constants.ErrorCode;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AdErrorUtil {
    public static AdError getAdmobError(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return new AdError(0, AdError.getMessage(0), 0, AdError.getMessage(0));
                    }
                    return new AdError(20001, AdError.getMessage(20001), i, AdError.getMessage(20001));
                }
                return new AdError(20002, AdError.getMessage(20002), i, AdError.getMessage(20002));
            }
            return new AdError(20003, AdError.getMessage(20003), i, AdError.getMessage(20003));
        }
        return new AdError(20004, AdError.getMessage(20004), i, AdError.AD_ERROR_INTERNAL_ERROR_MSG);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static AdError getGdtError(int i, String str) {
        if (i != 3001) {
            if (i != 3003) {
                if (i != 4001) {
                    if (i != 4003) {
                        if (i != 5005) {
                            switch (i) {
                                case 5001:
                                    return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i, str);
                                case 5002:
                                case ErrorCode.VIDEO_PLAY_ERROR /* 5003 */:
                                    break;
                                default:
                                    switch (i) {
                                        case ErrorCode.RESOURCE_LOAD_ERROR /* 5007 */:
                                        case ErrorCode.IMAGE_LOAD_ERROR /* 5008 */:
                                            break;
                                        case ErrorCode.TRAFFIC_CONTROL_HOUR /* 5009 */:
                                            break;
                                        default:
                                            switch (i) {
                                                case ErrorCode.NATIVE_EXPRESS_DATA_AND_TEMPLATE_NOT_MATCHED_ERROR /* 5011 */:
                                                    return new AdError(105, AdError.getMessage(105), i, str);
                                                case ErrorCode.AD_DATA_EXPIRE /* 5012 */:
                                                    return new AdError(-15, AdError.getMessage(-15), i, str);
                                                case ErrorCode.AD_REQUEST_THROTTLING /* 5013 */:
                                                    break;
                                                default:
                                                    return new AdError(0, AdError.getMessage(0), i, str);
                                            }
                                    }
                            }
                            return new AdError(-1, AdError.getMessage(-1), i, str);
                        }
                        return new AdError(-8, AdError.getMessage(-8), i, str);
                    }
                    return new AdError(AdError.ERROR_CODE_ADSLOT_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ERROR), i, str);
                }
                return new AdError(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER, AdError.getMessage(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER), i, str);
            }
            return new AdError(-14, AdError.getMessage(-14), i, str);
        }
        return new AdError(-2, AdError.getMessage(-2), i, str);
    }

    public static AdError getSigmobError(int i, String str) {
        switch (i) {
            case 200000:
                return new AdError(20001, AdError.getMessage(20001), i, str);
            case 500402:
                return new AdError(20001, AdError.getMessage(20001), i, str);
            case 500420:
                return new AdError(20004, AdError.getMessage(20004), i, str);
            case 500422:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i, str);
            case 500424:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i, str);
            case 500428:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i, str);
            case 500430:
                return new AdError(AdError.ERROR_CODE_ADSLOT_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ERROR), i, str);
            case 500432:
                return new AdError(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER, AdError.getMessage(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER), i, str);
            case 500433:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i, str);
            case 500435:
                return new AdError(20004, AdError.getMessage(20004), i, str);
            case 500436:
                return new AdError(-13, AdError.getMessage(-13), i, str);
            case 500473:
                return new AdError(AdError.ERROR_CODE_APP_EMPTY, AdError.getMessage(AdError.ERROR_CODE_APP_EMPTY), i, str);
            case 500479:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i, str);
            case 500482:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i, str);
            case 500701:
                return new AdError(AdError.ERROR_CODE_ADSLOT_ID_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ID_ERROR), i, str);
            case 600100:
                return new AdError(-2, AdError.getMessage(-2), i, str);
            case 600101:
                return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i, str);
            case 600102:
                return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i, str);
            case 600104:
                return new AdError(AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR, AdError.getMessage(AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR), i, str);
            case 600105:
                return new AdError(AdError.ERROR_CODE_CACHE_AD_MATERIAL_FAIL, AdError.getMessage(AdError.ERROR_CODE_CACHE_AD_MATERIAL_FAIL), i, str);
            case 600900:
                return new AdError(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT, AdError.getMessage(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT), i, str);
            case 600901:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i, str);
            case 600906:
                return new AdError(30000, AdError.getMessage(30000), i, str);
            default:
                return new AdError(0, AdError.getMessage(0), i, str);
        }
    }

    public static AdError obtainAdError(int i, String str) {
        return new AdError(0, AdError.getMessage(0), i, str);
    }
}
