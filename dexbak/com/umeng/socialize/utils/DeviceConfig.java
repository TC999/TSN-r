package com.umeng.socialize.utils;

import android.content.Context;
import android.os.Build;
import com.kuaishou.weapon.p205p0.C7282g;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DeviceConfig {
    public static boolean checkPermission(Context context, String str) {
        return DeviceConfigInternal.checkPermission(context, str);
    }

    public static String getAndroidID(Context context) {
        return DeviceConfigInternal.getAndroidID(context);
    }

    public static String getAppVersion(String str, Context context) {
        return DeviceConfigInternal.getAppVersion(str, context);
    }

    public static String getDeviceId(Context context) {
        return DeviceConfigInternal.getDeviceId(context);
    }

    public static String getDeviceSN() {
        return DeviceConfigInternal.getDeviceSN();
    }

    public static String getMac(Context context) {
        return DeviceConfigInternal.getMac(context);
    }

    public static String[] getNetworkAccessMode(Context context) {
        return DeviceConfigInternal.getNetworkAccessMode(context);
    }

    public static String getOsVersion() {
        return DeviceConfigInternal.getOsVersion();
    }

    public static String getPackageName(Context context) {
        return DeviceConfigInternal.getPackageName(context);
    }

    public static boolean hasFineLocationPermissionInQ(Context context) {
        if (Build.VERSION.SDK_INT > 28) {
            return checkPermission(context, C7282g.f24949g);
        }
        return true;
    }

    public static boolean isAppInstalled(String str, Context context) {
        return DeviceConfigInternal.isAppInstalled(str, context);
    }

    public static boolean isNetworkAvailable(Context context) {
        return DeviceConfigInternal.isNetworkAvailable(context);
    }

    public static boolean isOnline(Context context) {
        return DeviceConfigInternal.isOnline(context);
    }
}
