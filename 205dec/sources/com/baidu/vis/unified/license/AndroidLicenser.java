package com.baidu.vis.unified.license;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import java.util.concurrent.locks.ReentrantLock;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AndroidLicenser {
    private static String deviceID = "";
    private static ReentrantLock lock_instance = new ReentrantLock();
    private static boolean mAgree = false;
    private static String mIdFlag = "1";
    private static AndroidLicenser mInstance;
    private static boolean mOnline;
    private ReentrantLock lock = new ReentrantLock();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum ErrorCode {
        SUCCESS,
        LICENSE_NOT_INIT_ERROR,
        LICENSE_DECRYPT_ERROR,
        LICENSE_INFO_FORMAT_ERROR,
        LICENSE_KEY_CHECK_ERROR,
        LICENSE_ALGORITHM_CHECK_ERROR,
        LICENSE_MD5_CHECK_ERROR,
        LICENSE_DEVICE_ID_CHECK_ERROR,
        LICENSE_PACKAGE_NAME_CHECK_ERROR,
        LICENSE_EXPIRED_TIME_CHECK_ERROR,
        LICENSE_FUNCTION_CHECK_ERROR,
        LICENSE_TIME_EXPIRED,
        LICENSE_LOCAL_FILE_ERROR,
        LICENSE_REMOTE_DATA_ERROR,
        LICENSE_LOCAL_TIME_ERROR,
        LICENSE_PARAM_ERROR,
        LICENSE_KEY_FILE_ERROR,
        OTHER_ERROR
    }

    private AndroidLicenser() {
    }

    public static synchronized String getDeviceId(Context context) {
        Object obj;
        String str;
        synchronized (AndroidLicenser.class) {
            if ("".equals(deviceID)) {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.baidu.liantian.ac.LH");
                    Class<?> cls = Boolean.TYPE;
                    loadClass.getDeclaredMethod("init", Context.class, cls).invoke(loadClass, context, Boolean.valueOf(mOnline));
                    Log.i("License-SDK", "Load liantian ac succeed");
                    loadClass.getDeclaredMethod("setAgreePolicy", Context.class, cls).invoke(loadClass, context, Boolean.valueOf(mAgree));
                    Pair pair = (Pair) loadClass.getDeclaredMethod("getId", Context.class, String.class).invoke(loadClass, context, mIdFlag);
                    if (pair != null && (obj = pair.second) != null) {
                        deviceID = ((String) obj).toUpperCase();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                    Log.i("License-SDK", "Load liantian ac failed");
                }
            }
            str = deviceID;
        }
        return str;
    }

    public static synchronized AndroidLicenser getInstance() {
        AndroidLicenser androidLicenser;
        synchronized (AndroidLicenser.class) {
            lock_instance.lock();
            if (mInstance == null) {
                mInstance = new AndroidLicenser();
                try {
                    Log.e("License-SDK", "bd_unifylicense load start");
                    System.loadLibrary("bd_unifylicense");
                    Log.e("License-SDK", "bd_unifylicense load end");
                } catch (Exception e4) {
                    Log.e("License-SDK", "bd_unifylicense load Exception");
                    e4.printStackTrace();
                }
            }
            lock_instance.unlock();
            androidLicenser = mInstance;
        }
        return androidLicenser;
    }

    private native void nativeDisableDeviceId(int i4);

    private native int nativeFaceAuthFromFile(Context context, String str, String str2, boolean z3, int i4);

    private native int nativeFaceAuthFromFolder(Context context, String str, boolean z3, int i4);

    private native int nativeFaceAuthFromMemory(Context context, String str, String[] strArr, String str2, int i4);

    private native BDLicenseAuthInfo nativeFaceAuthGetAuthInfo(Context context, int i4);

    private native BDLicenseLocalInfo nativeFaceAuthGetLocalInfo(Context context, int i4);

    private native int nativeFaceGetAuthStatus(int i4);

    private native String nativeFaceGetErrorMsg(int i4);

    private native int nativeFaceIsFunctionAvailable(String str, int i4);

    private native void nativeReleaseAuth(int i4);

    public static void setAgree(boolean z3) {
        mAgree = z3;
    }

    public static void setIdFlag(String str) {
        mIdFlag = str;
    }

    public static void setOnline(boolean z3) {
        mOnline = z3;
    }

    public void authDisableDeviceId(int i4) {
        try {
            nativeDisableDeviceId(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ErrorCode authFromFile(Context context, String str, String str2, boolean z3, int i4) {
        int i5;
        this.lock.lock();
        try {
            i5 = nativeFaceAuthFromFile(context, str, str2, z3, i4);
        } catch (Exception e4) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e4.printStackTrace();
            i5 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i5];
    }

    public ErrorCode authFromFolder(Context context, String str, boolean z3, int i4) {
        int i5;
        this.lock.lock();
        try {
            i5 = nativeFaceAuthFromFolder(context, str, z3, i4);
        } catch (Exception e4) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e4.printStackTrace();
            i5 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i5];
    }

    public ErrorCode authFromMemory(Context context, String str, String[] strArr, String str2, int i4) {
        int i5;
        this.lock.lock();
        try {
            i5 = nativeFaceAuthFromMemory(context, str, strArr, str2, i4);
        } catch (Exception e4) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e4.printStackTrace();
            i5 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i5];
    }

    public BDLicenseAuthInfo authGetAuthInfo(Context context, int i4) {
        BDLicenseAuthInfo bDLicenseAuthInfo;
        this.lock.lock();
        try {
            bDLicenseAuthInfo = nativeFaceAuthGetAuthInfo(context, i4);
        } catch (Exception e4) {
            BDLicenseAuthInfo bDLicenseAuthInfo2 = new BDLicenseAuthInfo("", -1, "", "", "", 0L, "");
            e4.printStackTrace();
            bDLicenseAuthInfo = bDLicenseAuthInfo2;
        }
        this.lock.unlock();
        return bDLicenseAuthInfo;
    }

    public BDLicenseLocalInfo authGetLocalInfo(Context context, int i4) {
        BDLicenseLocalInfo bDLicenseLocalInfo;
        this.lock.lock();
        try {
            bDLicenseLocalInfo = nativeFaceAuthGetLocalInfo(context, i4);
        } catch (Exception e4) {
            BDLicenseLocalInfo bDLicenseLocalInfo2 = new BDLicenseLocalInfo("", -1, "", "", "", "", "");
            e4.printStackTrace();
            bDLicenseLocalInfo = bDLicenseLocalInfo2;
        }
        this.lock.unlock();
        return bDLicenseLocalInfo;
    }

    public ErrorCode authIsFuncAvailable(String str, int i4) {
        int i5;
        try {
            i5 = nativeFaceIsFunctionAvailable(str, i4);
        } catch (Exception e4) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e4.printStackTrace();
            i5 = ordinal;
        }
        return ErrorCode.values()[i5];
    }

    public void authReleaseAuth(int i4) {
        try {
            nativeReleaseAuth(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public ErrorCode getAuthStatus(int i4) {
        int i5;
        try {
            i5 = nativeFaceGetAuthStatus(i4);
        } catch (Exception e4) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e4.printStackTrace();
            i5 = ordinal;
        }
        return ErrorCode.values()[i5];
    }

    public String getErrorMsg(int i4) {
        try {
            return nativeFaceGetErrorMsg(i4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
