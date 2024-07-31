package com.kwad.sdk.core.imageloader.utils;

import android.util.Log;
import com.kwad.sdk.core.imageloader.core.ImageLoader;

/* renamed from: com.kwad.sdk.core.imageloader.utils.L */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10400L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    private C10400L() {
    }

    /* renamed from: d */
    public static void m26180d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    /* renamed from: e */
    public static void m26178e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    /* renamed from: i */
    public static void m26176i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th));
            }
            Log.println(i, ImageLoader.TAG, str);
        }
    }

    /* renamed from: w */
    public static void m26175w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    public static void writeDebugLogs(boolean z) {
        writeDebugLogs = z;
    }

    public static void writeLogs(boolean z) {
        writeLogs = z;
    }

    /* renamed from: e */
    public static void m26179e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    /* renamed from: e */
    public static void m26177e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }
}
