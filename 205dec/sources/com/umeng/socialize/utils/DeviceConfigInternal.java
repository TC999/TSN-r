package com.umeng.socialize.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DeviceConfigInternal {
    protected static final String LOG_TAG = "DeviceConfig";
    private static final String MOBILE_NETWORK = "2G/3G";
    protected static final String UNKNOW = "Unknown";
    private static final String WIFI = "Wi-Fi";
    public static Context context;
    private static Object object = new Object();

    public static boolean checkPermission(Context context2, String str) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(context2, str);
    }

    public static String getAndroidID(Context context2) {
        String androidId;
        return (context2 == null || (androidId = com.umeng.commonsdk.statistics.common.DeviceConfig.getAndroidId(context2)) == null) ? "" : androidId;
    }

    public static String getAppVersion(String str, Context context2) {
        if (context2 == null) {
            return "";
        }
        try {
            return context2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getDeviceId(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getDeviceId(context2);
    }

    public static String getDeviceSN() {
        String serial = com.umeng.commonsdk.statistics.common.DeviceConfig.getSerial();
        return serial == null ? "unknown" : serial;
    }

    public static String getMac(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getMac(context2);
    }

    public static String[] getNetworkAccessMode(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.getNetworkAccessMode(context2);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getPackageName(Context context2) {
        return context2 == null ? "" : context2.getPackageName();
    }

    public static boolean isAppInstalled(String str, Context context2) {
        boolean z3 = false;
        if (context2 == null) {
            return false;
        }
        synchronized (object) {
            try {
                context2.getPackageManager().getPackageInfo(str, 1);
                z3 = true;
            } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            }
        }
        return z3;
    }

    public static boolean isNetworkAvailable(Context context2) {
        return context2 != null && DeviceConfig.checkPermission(context2, "android.permission.ACCESS_NETWORK_STATE") && DeviceConfig.isOnline(context2);
    }

    public static boolean isOnline(Context context2) {
        return com.umeng.commonsdk.statistics.common.DeviceConfig.isOnline(context2);
    }
}
