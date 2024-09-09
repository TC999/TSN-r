package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private static Context ayY;

    @WorkerThread
    public static long EU() {
        long bg = bg(ayY);
        b(ayY, 1 + bg);
        return bg;
    }

    @WorkerThread
    private static boolean b(Context context, long j4) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j4);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    private static long bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_crashseq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong("crashseq", 1L);
    }

    public static void init(Context context) {
        ayY = context;
    }
}
