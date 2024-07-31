package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.p367a.AbstractRunnableC9699a;
import com.kwad.sdk.api.p367a.C9700b;

/* renamed from: com.kwad.sdk.api.loader.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9757t {
    /* renamed from: a */
    public static void m27847a(final Context context, final SdkConfig sdkConfig) {
        C9700b.m28021a(new AbstractRunnableC9699a() { // from class: com.kwad.sdk.api.loader.t.1
            @Override // com.kwad.sdk.api.p367a.AbstractRunnableC9699a
            public final void doTask() {
                C9757t.m27843b(context, "sdkconfig", sdkConfig.toJson());
            }
        });
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: b */
    public static void m27843b(Context context, String str, String str2) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putString(str, str2).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    public static String m27841c(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String getString(Context context, String str) {
        return m27841c(context, str, "");
    }

    /* renamed from: x */
    public static long m27840x(Context context, String str) {
        return m27844b(context, str, 0L);
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public static void m27845a(Context context, String str, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean(str, z).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static boolean m27842b(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getBoolean(str, false);
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"ApplySharedPref"})
    /* renamed from: a */
    public static void m27846a(Context context, String str, long j) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putLong(str, j).commit();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static long m27844b(Context context, String str, long j) {
        try {
            return context.getSharedPreferences("kssdk_api_pref", 0).getLong(str, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
