package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class t {
    private static String ayW = EW();
    private static long ayX = 0;
    private static Context ayY;

    public static String ES() {
        com.kwad.sdk.core.e.c.d("ReportIdManager", ">> updateSessionId");
        String EW = EW();
        ayW = EW;
        return EW;
    }

    public static String ET() {
        return ayW;
    }

    @WorkerThread
    public static long EU() {
        long bg = bg(ayY);
        b(ayY, 1 + bg);
        return bg;
    }

    public static long EV() {
        return ayX;
    }

    private static String EW() {
        return UUID.randomUUID().toString();
    }

    @WorkerThread
    private static boolean b(Context context, long j4) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong("seq", j4);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    private static long bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("seq", 1L);
    }

    public static void init(Context context) {
        ayY = context;
    }
}
