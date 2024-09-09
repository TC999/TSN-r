package com.bykv.vk.component.ttvideo.utils;

import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class AVLogger {
    public static final boolean DEBUG = false;
    public static final String FORMAT = "<%s>%s";
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    public static int LogTurnOn = 112;
    private static final String TAG = "ttmj";

    public static final void d(String str, String str2) {
        if (((LogTurnOn >> 1) & 1) == 1) {
            Log.d(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static void e(String str, String str2) {
        if (((LogTurnOn >> 6) & 1) == 1) {
            Log.e(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void i(String str, String str2) {
        if (((LogTurnOn >> 2) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void k(String str, String str2) {
        if (((LogTurnOn >> 4) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void t(String str, String str2) {
        if (((LogTurnOn >> 3) & 1) == 1) {
            Log.i(TAG, String.format("<%s>%s", str, str2));
        }
    }

    public static final void turnOn(int i4, int i5) {
        LogTurnOn = (i5 << i4) | (((1 << i4) ^ (-1)) & LogTurnOn);
    }

    public static final void w(String str, String str2) {
        if (((LogTurnOn >> 5) & 1) == 1) {
            Log.w(TAG, String.format("<%s>%s", str, str2));
        }
    }
}
