package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: OpenDeviceId.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static av f52596a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f52597b;

    public static synchronized String a(Context context) {
        synchronized (aw.class) {
            UMRTLog.i("MobclickRT", "--->>>*** real call OpenDeviceId.getOaid()");
            if (context != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    b(context);
                    av avVar = f52596a;
                    if (avVar != null) {
                        try {
                            return avVar.a(context);
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

    private static void b(Context context) {
        if (f52596a != null || f52597b) {
            return;
        }
        synchronized (aw.class) {
            if (f52596a == null && !f52597b) {
                f52596a = ay.a(context);
                f52597b = true;
            }
        }
    }
}
