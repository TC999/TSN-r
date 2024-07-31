package com.kwad.sdk.core.report;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.p397e.C10331c;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.UUID;

/* renamed from: com.kwad.sdk.core.report.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10472t {
    private static String ayW = m26002EW();
    private static long ayX = 0;
    private static Context ayY;

    /* renamed from: ES */
    public static String m26006ES() {
        C10331c.m26254d("ReportIdManager", ">> updateSessionId");
        String m26002EW = m26002EW();
        ayW = m26002EW;
        return m26002EW;
    }

    /* renamed from: ET */
    public static String m26005ET() {
        return ayW;
    }

    @WorkerThread
    /* renamed from: EU */
    public static long m26004EU() {
        long m26000bg = m26000bg(ayY);
        m26001b(ayY, 1 + m26000bg);
        return m26000bg;
    }

    /* renamed from: EV */
    public static long m26003EV() {
        return ayX;
    }

    /* renamed from: EW */
    private static String m26002EW() {
        return UUID.randomUUID().toString();
    }

    @WorkerThread
    /* renamed from: b */
    private static boolean m26001b(Context context, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("ksadsdk_seq", 0).edit();
            edit.putLong(RtspHeaders.Values.SEQ, j);
            return edit.commit();
        }
        return false;
    }

    @WorkerThread
    /* renamed from: bg */
    private static long m26000bg(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ksadsdk_seq", 0)) == null) {
            return 0L;
        }
        return sharedPreferences.getLong(RtspHeaders.Values.SEQ, 1L);
    }

    public static void init(Context context) {
        ayY = context;
    }
}
