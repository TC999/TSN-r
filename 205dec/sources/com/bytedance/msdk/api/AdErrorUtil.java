package com.bytedance.msdk.api;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AdErrorUtil {
    public static AdError getAdmobError(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return new AdError(0, AdError.getMessage(0), 0, AdError.getMessage(0));
                    }
                    return new AdError(20001, AdError.getMessage(20001), i4, AdError.getMessage(20001));
                }
                return new AdError(20002, AdError.getMessage(20002), i4, AdError.getMessage(20002));
            }
            return new AdError(20003, AdError.getMessage(20003), i4, AdError.getMessage(20003));
        }
        return new AdError(20004, AdError.getMessage(20004), i4, AdError.AD_ERROR_INTERNAL_ERROR_MSG);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static AdError getGdtError(int i4, String str) {
        if (i4 != 3001) {
            if (i4 != 3003) {
                if (i4 != 4001) {
                    if (i4 != 4003) {
                        if (i4 != 5005) {
                            switch (i4) {
                                case 5001:
                                    return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i4, str);
                                case 5002:
                                case 5003:
                                    break;
                                default:
                                    switch (i4) {
                                        case 5007:
                                        case 5008:
                                            break;
                                        case 5009:
                                            break;
                                        default:
                                            switch (i4) {
                                                case 5011:
                                                    return new AdError(105, AdError.getMessage(105), i4, str);
                                                case 5012:
                                                    return new AdError(-15, AdError.getMessage(-15), i4, str);
                                                case 5013:
                                                    break;
                                                default:
                                                    return new AdError(0, AdError.getMessage(0), i4, str);
                                            }
                                    }
                            }
                            return new AdError(-1, AdError.getMessage(-1), i4, str);
                        }
                        return new AdError(-8, AdError.getMessage(-8), i4, str);
                    }
                    return new AdError(AdError.ERROR_CODE_ADSLOT_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ERROR), i4, str);
                }
                return new AdError(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER, AdError.getMessage(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER), i4, str);
            }
            return new AdError(-14, AdError.getMessage(-14), i4, str);
        }
        return new AdError(-2, AdError.getMessage(-2), i4, str);
    }

    public static AdError getSigmobError(int i4, String str) {
        switch (i4) {
            case 200000:
                return new AdError(20001, AdError.getMessage(20001), i4, str);
            case 500402:
                return new AdError(20001, AdError.getMessage(20001), i4, str);
            case 500420:
                return new AdError(20004, AdError.getMessage(20004), i4, str);
            case 500422:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i4, str);
            case 500424:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i4, str);
            case 500428:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i4, str);
            case 500430:
                return new AdError(AdError.ERROR_CODE_ADSLOT_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ERROR), i4, str);
            case 500432:
                return new AdError(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER, AdError.getMessage(AdError.ERROR_CODE_SLOT_ID_APP_ID_DIFFER), i4, str);
            case 500433:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i4, str);
            case 500435:
                return new AdError(20004, AdError.getMessage(20004), i4, str);
            case 500436:
                return new AdError(-13, AdError.getMessage(-13), i4, str);
            case 500473:
                return new AdError(AdError.ERROR_CODE_APP_EMPTY, AdError.getMessage(AdError.ERROR_CODE_APP_EMPTY), i4, str);
            case 500479:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i4, str);
            case 500482:
                return new AdError(AdError.ERROR_CODE_NO_DEVICE_INFO, AdError.getMessage(AdError.ERROR_CODE_NO_DEVICE_INFO), i4, str);
            case 500701:
                return new AdError(AdError.ERROR_CODE_ADSLOT_ID_ERROR, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_ID_ERROR), i4, str);
            case 600100:
                return new AdError(-2, AdError.getMessage(-2), i4, str);
            case 600101:
                return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i4, str);
            case 600102:
                return new AdError(AdError.ERROR_CODE_SYS_ERROR, AdError.getMessage(AdError.ERROR_CODE_SYS_ERROR), i4, str);
            case 600104:
                return new AdError(AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR, AdError.getMessage(AdError.ERROR_CODE_THIRD_SDK_FILE_IO_ERROR), i4, str);
            case 600105:
                return new AdError(AdError.ERROR_CODE_CACHE_AD_MATERIAL_FAIL, AdError.getMessage(AdError.ERROR_CODE_CACHE_AD_MATERIAL_FAIL), i4, str);
            case 600900:
                return new AdError(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT, AdError.getMessage(AdError.ERROR_CODE_THIRD_SDK_NOT_INIT), i4, str);
            case 600901:
                return new AdError(AdError.ERROR_CODE_ADSLOT_EMPTY, AdError.getMessage(AdError.ERROR_CODE_ADSLOT_EMPTY), i4, str);
            case 600906:
                return new AdError(30000, AdError.getMessage(30000), i4, str);
            default:
                return new AdError(0, AdError.getMessage(0), i4, str);
        }
    }

    public static AdError obtainAdError(int i4, String str) {
        return new AdError(0, AdError.getMessage(0), i4, str);
    }
}
