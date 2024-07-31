package com.kwad.sdk.crash.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;

/* renamed from: com.kwad.sdk.crash.utils.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10741e {
    private static Context ayY;

    @WorkerThread
    /* renamed from: EU */
    public static long m25003EU() {
        long m25001bg = m25001bg(ayY);
        m25002b(ayY, 1 + m25001bg);
        return m25001bg;
    }

    @WorkerThread
    /* renamed from: b */
    private static boolean m25002b(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_crashseq", 0).edit();
            edit.putLong("crashseq", j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    /* renamed from: bg */
    private static long m25001bg(Context context) {
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
