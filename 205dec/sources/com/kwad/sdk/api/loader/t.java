package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.sdk.api.SdkConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class t {
    public static void a(final Context context, final SdkConfig sdkConfig) {
        com.kwad.sdk.api.a.b.a(new com.kwad.sdk.api.a.a() { // from class: com.kwad.sdk.api.loader.t.1
            @Override // com.kwad.sdk.api.a.a
            public final void doTask() {
                t.b(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    @SuppressLint({"ApplySharedPref"})
    public static void b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    public static String c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String getString(Context context, String str) {
        return c(context, str, "");
    }

    public static long x(Context context, String str) {
        return b(context, str, 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, boolean z3) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z3).commit();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, String str, boolean z3) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    public static void a(Context context, String str, long j4) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j4).commit();
        } catch (Throwable unused) {
        }
    }

    private static long b(Context context, String str, long j4) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
