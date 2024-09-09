package com.bykv.vk.component.ttvideo.utils;

import android.os.Build;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class Util {
    public static final String BARND;
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final String HARDWARE;
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;

    static {
        int i4 = Build.VERSION.SDK_INT;
        SDK_INT = i4;
        String str = Build.DEVICE;
        DEVICE = str;
        String str2 = Build.MANUFACTURER;
        MANUFACTURER = str2;
        String str3 = Build.MODEL;
        MODEL = str3;
        HARDWARE = Build.HARDWARE;
        BARND = Build.BRAND;
        DEVICE_DEBUG_INFO = str + ", " + str3 + ", " + str2 + ", " + i4;
    }
}
