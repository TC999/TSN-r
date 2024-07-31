package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.crash.utils.C10747h;
import java.io.File;

/* renamed from: com.kwad.sdk.utils.be */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11050be {
    /* renamed from: MI */
    public static boolean m23950MI() {
        return C11137y.m23567m("ksadsdk_pref", "config_data_transfer", false);
    }

    /* renamed from: MJ */
    private static void m23949MJ() {
        C11137y.m23568l("ksadsdk_pref", "config_data_transfer", true);
    }

    /* renamed from: MK */
    public static void m23948MK() {
        C11137y.m23568l("ksadsdk_pref", "splash_daily_transfer", true);
    }

    /* renamed from: ML */
    public static boolean m23947ML() {
        return C11137y.m23567m("ksadsdk_pref", "splash_daily_transfer", false);
    }

    /* renamed from: MM */
    public static void m23946MM() {
        C11137y.m23568l("ksadsdk_pref", "reward_auto_transfer", true);
    }

    /* renamed from: MN */
    public static boolean m23945MN() {
        return C11137y.m23567m("ksadsdk_pref", "reward_auto_transfer", false);
    }

    /* renamed from: MO */
    public static void m23944MO() {
        C11137y.m23568l("ksadsdk_pref", "interstitial_aggregate_transfer", true);
    }

    /* renamed from: MP */
    public static boolean m23943MP() {
        return C11137y.m23567m("ksadsdk_pref", "interstitial_aggregate_transfer", false);
    }

    @Nullable
    @WorkerThread
    /* renamed from: au */
    public static String m23942au(Context context, String str) {
        if (context == null) {
            return "";
        }
        File file = new File(context.getFilesDir(), str);
        if (file.exists()) {
            try {
                String m24957I = C10747h.m24957I(file);
                return TextUtils.isEmpty(m24957I) ? "" : m24957I;
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }

    /* renamed from: i */
    public static void m23941i(final Context context, final String str, final String str2) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.utils.be.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11050be.m23940j(context, str, str2);
            }
        });
    }

    /* renamed from: j */
    public static void m23940j(Context context, String str, String str2) {
        C10747h.m24939k(new File(context.getFilesDir(), str).getAbsolutePath(), str2, false);
        m23949MJ();
    }
}
