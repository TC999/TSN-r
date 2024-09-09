package com.bytedance.sdk.openadsdk.mediation;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationApiLog {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f35972c = false;

    /* renamed from: w  reason: collision with root package name */
    private static String f35973w = "MEDIATION_LOG";

    public static void e(String str, String str2) {
        if (f35972c) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (f35972c) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        f35972c = bool.booleanValue();
    }

    public static void e(String str) {
        if (f35972c) {
            Log.e(f35973w, str);
        }
    }

    public static void i(String str) {
        if (f35972c) {
            Log.i(f35973w, str);
        }
    }
}
