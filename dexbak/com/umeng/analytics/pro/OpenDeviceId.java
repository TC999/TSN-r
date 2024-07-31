package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* renamed from: com.umeng.analytics.pro.aw */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OpenDeviceId {

    /* renamed from: a */
    private static IDeviceIdSupplier f37709a;

    /* renamed from: b */
    private static boolean f37710b;

    /* renamed from: a */
    public static synchronized String m14692a(Context context) {
        synchronized (OpenDeviceId.class) {
            UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>>*** real call OpenDeviceId.getOaid()");
            if (context != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    m14691b(context);
                    IDeviceIdSupplier iDeviceIdSupplier = f37709a;
                    if (iDeviceIdSupplier != null) {
                        try {
                            return iDeviceIdSupplier.mo14666a(context);
                        } catch (Exception unused) {
                        }
                    }
                    return null;
                }
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            throw new RuntimeException("Context is null");
        }
    }

    /* renamed from: b */
    private static void m14691b(Context context) {
        if (f37709a != null || f37710b) {
            return;
        }
        synchronized (OpenDeviceId.class) {
            if (f37709a == null && !f37710b) {
                f37709a = DeviceIdSupplier.m14681a(context);
                f37710b = true;
            }
        }
    }
}
