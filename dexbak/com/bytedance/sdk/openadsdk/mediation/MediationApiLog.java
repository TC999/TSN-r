package com.bytedance.sdk.openadsdk.mediation;

import android.util.Log;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationApiLog {

    /* renamed from: a */
    private static String f22609a = "MEDIATION_LOG";

    /* renamed from: ok */
    private static boolean f22610ok;

    /* renamed from: e */
    public static void m36299e(String str, String str2) {
        if (f22610ok) {
            Log.e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m36297i(String str, String str2) {
        if (f22610ok) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f22610ok = bool.booleanValue();
    }

    /* renamed from: e */
    public static void m36300e(String str) {
        if (f22610ok) {
            Log.e(f22609a, str);
        }
    }

    /* renamed from: i */
    public static void m36298i(String str) {
        if (f22610ok) {
            Log.i(f22609a, str);
        }
    }
}
