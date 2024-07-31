package com.baidu.vis.unified.license;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AndroidLicenser {
    private static String deviceID = "";
    private static ReentrantLock lock_instance = new ReentrantLock();
    private static boolean mAgree = false;
    private static String mIdFlag = "1";
    private static AndroidLicenser mInstance;
    private static boolean mOnline;
    private ReentrantLock lock = new ReentrantLock();

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
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
                } catch (Exception e) {
                    e.printStackTrace();
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
                } catch (Exception e) {
                    Log.e("License-SDK", "bd_unifylicense load Exception");
                    e.printStackTrace();
                }
            }
            lock_instance.unlock();
            androidLicenser = mInstance;
        }
        return androidLicenser;
    }

    private native void nativeDisableDeviceId(int i);

    private native int nativeFaceAuthFromFile(Context context, String str, String str2, boolean z, int i);

    private native int nativeFaceAuthFromFolder(Context context, String str, boolean z, int i);

    private native int nativeFaceAuthFromMemory(Context context, String str, String[] strArr, String str2, int i);

    private native BDLicenseAuthInfo nativeFaceAuthGetAuthInfo(Context context, int i);

    private native BDLicenseLocalInfo nativeFaceAuthGetLocalInfo(Context context, int i);

    private native int nativeFaceGetAuthStatus(int i);

    private native String nativeFaceGetErrorMsg(int i);

    private native int nativeFaceIsFunctionAvailable(String str, int i);

    private native void nativeReleaseAuth(int i);

    public static void setAgree(boolean z) {
        mAgree = z;
    }

    public static void setIdFlag(String str) {
        mIdFlag = str;
    }

    public static void setOnline(boolean z) {
        mOnline = z;
    }

    public void authDisableDeviceId(int i) {
        try {
            nativeDisableDeviceId(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ErrorCode authFromFile(Context context, String str, String str2, boolean z, int i) {
        int i2;
        this.lock.lock();
        try {
            i2 = nativeFaceAuthFromFile(context, str, str2, z, i);
        } catch (Exception e) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e.printStackTrace();
            i2 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i2];
    }

    public ErrorCode authFromFolder(Context context, String str, boolean z, int i) {
        int i2;
        this.lock.lock();
        try {
            i2 = nativeFaceAuthFromFolder(context, str, z, i);
        } catch (Exception e) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e.printStackTrace();
            i2 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i2];
    }

    public ErrorCode authFromMemory(Context context, String str, String[] strArr, String str2, int i) {
        int i2;
        this.lock.lock();
        try {
            i2 = nativeFaceAuthFromMemory(context, str, strArr, str2, i);
        } catch (Exception e) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e.printStackTrace();
            i2 = ordinal;
        }
        this.lock.unlock();
        return ErrorCode.values()[i2];
    }

    public BDLicenseAuthInfo authGetAuthInfo(Context context, int i) {
        BDLicenseAuthInfo bDLicenseAuthInfo;
        this.lock.lock();
        try {
            bDLicenseAuthInfo = nativeFaceAuthGetAuthInfo(context, i);
        } catch (Exception e) {
            BDLicenseAuthInfo bDLicenseAuthInfo2 = new BDLicenseAuthInfo("", -1, "", "", "", 0L, "");
            e.printStackTrace();
            bDLicenseAuthInfo = bDLicenseAuthInfo2;
        }
        this.lock.unlock();
        return bDLicenseAuthInfo;
    }

    public BDLicenseLocalInfo authGetLocalInfo(Context context, int i) {
        BDLicenseLocalInfo bDLicenseLocalInfo;
        this.lock.lock();
        try {
            bDLicenseLocalInfo = nativeFaceAuthGetLocalInfo(context, i);
        } catch (Exception e) {
            BDLicenseLocalInfo bDLicenseLocalInfo2 = new BDLicenseLocalInfo("", -1, "", "", "", "", "");
            e.printStackTrace();
            bDLicenseLocalInfo = bDLicenseLocalInfo2;
        }
        this.lock.unlock();
        return bDLicenseLocalInfo;
    }

    public ErrorCode authIsFuncAvailable(String str, int i) {
        int i2;
        try {
            i2 = nativeFaceIsFunctionAvailable(str, i);
        } catch (Exception e) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e.printStackTrace();
            i2 = ordinal;
        }
        return ErrorCode.values()[i2];
    }

    public void authReleaseAuth(int i) {
        try {
            nativeReleaseAuth(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ErrorCode getAuthStatus(int i) {
        int i2;
        try {
            i2 = nativeFaceGetAuthStatus(i);
        } catch (Exception e) {
            int ordinal = ErrorCode.OTHER_ERROR.ordinal();
            e.printStackTrace();
            i2 = ordinal;
        }
        return ErrorCode.values()[i2];
    }

    public String getErrorMsg(int i) {
        try {
            return nativeFaceGetErrorMsg(i);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
